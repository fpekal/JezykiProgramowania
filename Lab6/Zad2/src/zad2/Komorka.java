/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package zad2;

import java.util.Random;

/**
 *
 * @author proxy_lb
 */
public class Komorka {
    public Komorka() {
        Random r = new Random();
        jedzenie = r.nextInt(11);
    }
    
    public int jedzenie;
}
