/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package zad1;

import edu.colorado.io.EasyReader;
import com.skylit.io.EasyWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author proxy_lb
 */
public class Zapis {
    public Zapis(String nazwaPliku) {
       this.nazwaPliku = nazwaPliku;
    }
    
    public void odczyt(HashMap<String, GrupaProduktow> mapa) {
        EasyReader er = new EasyReader(nazwaPliku);
        
        while (!er.isEOF()) {
            String kod = er.stringInput();
            
            if (kod.equals("")) break;
            
            String nazwa = er.stringInput();
            int cena = er.intInput();
            int ilosc = er.intInput();
            
            er.ignore();
            
            mapa.put(kod, new GrupaProduktow(new WpisKatalogu(new Produkt(nazwa, cena), kod), ilosc));
        }
        
        try {
            er.close();
        }
        catch(IOException e) {
            System.out.println(e.toString());
        }
    }
    
    public void zapis(HashMap<String, GrupaProduktow> mapa) {
        EasyWriter ew = new EasyWriter(nazwaPliku);
        
        for (Map.Entry<String, GrupaProduktow> entry : mapa.entrySet()) {
            ew.print(entry.getValue().wpis.kod);
            ew.print(" ");
            ew.print(entry.getValue().wpis.produkt.nazwa);
            ew.print(" ");
            ew.print(entry.getValue().wpis.produkt.cena);
            ew.print(" ");
            ew.println(entry.getValue().ilosc);
        }
        
        ew.close();
    }
    
    private String nazwaPliku;
}
