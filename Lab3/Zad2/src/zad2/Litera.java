/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package zad2;

import java.util.LinkedList;
import java.util.Collections;

/**
 *
 * @author proxy_lb
 */
public class Litera {
    public LinkedList<Wystapienie> imiona;
    public char litera;
    
    public Litera(char litera) {
        this.litera = litera;
        imiona = new LinkedList<>();
    }
    
    public void sort() {
        Collections.sort(imiona);
    }
    
    public void wyswietl() {
        for (Wystapienie wys : imiona) {
            System.out.println(wys.imie.toString() + ": " + Integer.toString(wys.ile) + "x");
        }
    }
}
