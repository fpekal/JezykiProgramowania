/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package zad1;

import java.awt.Color;
import java.awt.Graphics;

import java.util.concurrent.TimeUnit;
import java.util.Random;

/**
 *
 * @author student
 */
public class Kolko {
    public double kat = 0;
    public Color kolor = new Color(new Random().nextInt(0xFFFFFF));

    public double szybkosc = 1;

    public Kolko() {
        obracacz = new Thread(new Runnable(){
            @Override
            public void run() {
                while(true) {
                    ruch();
                    try {
                        TimeUnit.MILLISECONDS.sleep(1);
                    }
                    catch(InterruptedException e) {
                    
                    }
                }
            }
        });
        
        kat = new Random().nextDouble() * 3.1415 * 2;
        zmienSzybkosc(new Random().nextDouble() * 50);

        obracacz.start();
    }
    
    final public synchronized void zmienSzybkosc(double szybkosc) {
        this.szybkosc = szybkosc;
    }
    
    final public synchronized void zmienKat(double kat) {
        this.kat = kat;
        this.kat %= 3.14159265 * 2;
    }
    
    final public synchronized void dodajKat(double kat) {
        this.kat += kat;
        this.kat %= 3.14159265 * 2;
    }

    public void wyswietl(Graphics g) {
        int x = (int)(Math.cos(kat) * ODLEGLOSC + 480/2);
        int y = (int)(-Math.sin(kat) * ODLEGLOSC + 480/2);

        g.setColor(kolor);
        g.fillOval(x - WIELKOSC / 2, y - WIELKOSC / 2, WIELKOSC, WIELKOSC);
    }

    public void ruch() {
        dodajKat(szybkosc / 10000);
    }

    public Thread obracacz = null;

    public static final int WIELKOSC = 50;
    public static final int ODLEGLOSC = 200;
}
