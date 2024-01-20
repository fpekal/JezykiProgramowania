/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package zad2;

/**
 *
 * @author proxy_lb
 */
public class Wystapienie implements Comparable<Wystapienie> {
    public Imiona imie = null;
    public int ile = 0;
    
    
    @Override
    public int compareTo(Wystapienie other) {
        return imie.order - other.imie.order;
    }
}
