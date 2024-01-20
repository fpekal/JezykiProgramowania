/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package zad1;

import javax.swing.JPanel;

import java.awt.Graphics;
import java.awt.Color;
import java.awt.Dimension;

import java.util.ArrayList;

import java.util.concurrent.TimeUnit;


/**
 *
 * @author student
 */
public class Canva extends JPanel {
    public Canva(int ilosc) {
        kolka = new ArrayList<>();
        setPreferredSize(new Dimension(480, 480));

        for (int i = 0; i < ilosc; ++i) {
            dodajKolko();
        }


        rysowanie = new Thread(new Runnable(){
            @Override
            public void run() {
                while(true) {
                    repaint();
                    try {
                        TimeUnit.MILLISECONDS.sleep(16);
                    }
                    catch(InterruptedException e) {
                    
                    }
                }
            }
        });

        rysowanie.start();
        
        
        // Nie wiem, działa
        minimalny_kat = Math.asin((double)Kolko.WIELKOSC/2/Kolko.ODLEGLOSC) * 2;
        
        
        kolizje = new Thread(() -> {
            while(true) {
                for (Kolko k1 : kolka) {
                    for (Kolko k2 : kolka) {
                        if (k1 == k2) continue;
                        
                        if (Math.abs(k1.kat - k2.kat) < minimalny_kat) {
                            if (k1.kat < k2.kat) {
                                k1.zmienKat(k2.kat - minimalny_kat);
                            }
                            else {
                                k2.zmienKat(k1.kat - minimalny_kat);
                            }
                        }
                        
                        else if (Math.abs(k1.kat - k2.kat + Math.TAU) < minimalny_kat) {
                            k2.zmienKat(k1.kat - minimalny_kat);
                        }
                        
                        else if (Math.abs(k1.kat - k2.kat - Math.TAU) < minimalny_kat) {
                            k1.zmienKat(k2.kat - minimalny_kat);
                        }
                    }
                }
                
                try {
                    TimeUnit.MILLISECONDS.sleep(1);
                }
                catch(InterruptedException e) {
                    
                }
            }
        });
        
        kolizje.start();
    }

    public final void dodajKolko() {
        Kolko tmp = new Kolko();
        kolka.add(tmp);
    }

    @Override
    public void paint(Graphics g) {
        g.clearRect(0, 0, 480, 480);

        g.drawOval(240 - Kolko.ODLEGLOSC, 240 - Kolko.ODLEGLOSC, Kolko.ODLEGLOSC * 2, Kolko.ODLEGLOSC * 2);

        for (Kolko k : kolka) {
            k.wyswietl(g);
        }
    }
    
    double minimalny_kat = 0;
    
    Thread kolizje = null;
    Thread rysowanie = null;
    public ArrayList<Kolko> kolka;
}
