/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package zad1;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author student
 */
public class Koszyk {
    public Koszyk(KatalogSklepowy ks) {
        this.ks = ks;
    }

    public boolean dodajProdukt(String kod, int ilosc) {
        GrupaProduktow gp = ks.pobierzProdukt(kod);
        if (gp == null) return false;

        if (gp.ilosc < ilosc) return false;

        GrupaProduktow gp_koszyk = produkty.get(kod);
        if (gp_koszyk == null) {
            produkty.put(kod, new GrupaProduktow(gp.wpis, ilosc));
        }
        else {
            gp_koszyk.ilosc += ilosc;
        }
        return true;
    }

    public void usunProdukt(String kod) {
        produkty.remove(kod);
    }

    public void wyczysc() {
        produkty.clear();
    }

    public void kup() {
        for (Map.Entry<String, GrupaProduktow> entry : produkty.entrySet()) {
            ks.kupProdukty(entry.getKey(), entry.getValue().ilosc);
        }
        
        wyczysc();
    }
    
    public int zsumujCeny() {
        int cena = 0;
        
        for (Map.Entry<String, GrupaProduktow> entry : produkty.entrySet()) {
            cena += entry.getValue().wpis.produkt.cena * entry.getValue().ilosc;
        }
        
        return cena;
    }

    private KatalogSklepowy ks;
    private HashMap<String, GrupaProduktow> produkty = new HashMap<>();
}
