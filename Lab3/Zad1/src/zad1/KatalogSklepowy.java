/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package zad1;

import java.util.HashMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import java.util.regex.Pattern;
import java.util.regex.Matcher;

/**
 *
 * @author student
 */
public class KatalogSklepowy {
    public KatalogSklepowy() {
        zapis.odczyt(katalog);
    }
    
    public void zarejestrujProdukt(Produkt produkt, int ilosc) {
        String kod = String.format("%03d", nastepny_kod);
        nastepny_kod++;

        GrupaProduktow gp = new GrupaProduktow(new WpisKatalogu(produkt, kod), ilosc);

        katalog.put(kod, gp);
        
        zapis.zapis(katalog);
    }

    public void dodajProdukty(String kod, int ilosc) {
        GrupaProduktow gp = katalog.get(kod);
        if (gp == null) return;

        gp.ilosc += ilosc;
        
        zapis.zapis(katalog);
    }

    public List<GrupaProduktow> znajdzProdukty(String nazwa) {
        nazwa = nazwa.toLowerCase();
        
        ArrayList<GrupaProduktow> out = new ArrayList<>();

        nazwa = nazwa.replace("?", ".");
        nazwa = nazwa.replace("*", ".*");

        Pattern regex_pattern = Pattern.compile(nazwa);

        for (Map.Entry<String, GrupaProduktow> entry : katalog.entrySet()) {
            String nazwa_produktu = entry.getValue().wpis.produkt.nazwa.toLowerCase();
            
            
            Matcher m = regex_pattern.matcher(nazwa_produktu);
            if (m.matches()) {
                out.add(entry.getValue());
            }
        }

        return out;
    }

    public boolean kupProdukty(String kod, int ilosc) {
        GrupaProduktow gp = katalog.get(kod);
        if (gp == null) return false;

        if (gp.ilosc < ilosc) return false;

        gp.ilosc -= ilosc;
        
        zapis.zapis(katalog);
        return true;
    }

    public GrupaProduktow pobierzProdukt(String kod) {
        return katalog.get(kod);
    }
    
    final private Zapis zapis = new Zapis("produkty.dat");

    private HashMap<String, GrupaProduktow> katalog = new HashMap<>();
    private int nastepny_kod;
}
