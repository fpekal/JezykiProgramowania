/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package zad2;

import java.util.List;
import edu.colorado.io.EasyReader;

/**
 *
 * @author proxy_lb
 */
public class Odczyt {
    static public void odczytaj(String nazwaPliku, List<Litera> litery) {
        EasyReader er = new EasyReader(nazwaPliku);
        
        while (!er.isEOF()) {
            String imie = er.stringInput();
            
            char litera = imie.charAt(0);
            
            System.out.println(litera);
            
            boolean znaleziono = false;
            
            for (Wystapienie wys : litery.get(litera - 'A').imiona) {
                if (wys.imie.equals(Imiona.parse(imie))) {
                    znaleziono = true;
                    wys.ile++;
                    break;
                }
            }
            
            if (!znaleziono) {
                Wystapienie wys = new Wystapienie();
                wys.ile = 1;
                wys.imie = Imiona.parse(imie);
                
                if (wys.imie == null) continue;
                
                litery.get(litera - 'A').imiona.add(wys);
            }
        }
    }
}
