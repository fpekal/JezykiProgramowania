/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package zad2;

import java.util.List;
import java.util.ArrayList;

/**
 *
 * @author proxy_lb
 */
public class Zad2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        List<Litera> litery = new ArrayList<>();
        for (int i = 0; i < 26; ++i) {
            litery.add(new Litera((char) ('a' + i)));
        }
        
        Odczyt.odczytaj(args[0], litery);
        Odczyt.odczytaj(args[1], litery);
        Odczyt.odczytaj(args[2], litery);
        
        for (Litera litera : litery) {
            litera.sort();
        }
        
        for (Litera litera : litery) {
            litera.sort();
            litera.wyswietl();
        }
        
        
    }
    
}
