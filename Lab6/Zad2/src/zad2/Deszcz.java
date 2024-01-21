/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package zad2;

import java.util.concurrent.TimeUnit;

/**
 *
 * @author proxy_lb
 */
// Produkuje jedzenie na liściu
public class Deszcz {
    public Deszcz(Lisc l) {
        lisc = l;
    }
    
    public void odpal() {
        watek = new Thread(() -> {
            while (true) {
                try {
                    TimeUnit.MILLISECONDS.sleep(interwalMS);
                }
                catch(InterruptedException e) {

                }

                synchronized(lisc) {
                    for (Komorka k : lisc.komorki) {
                        k.jedzenie++;
                        if (k.jedzenie > 10)
                            k.jedzenie = 10;
                    }
                }
            }
        });
        
        watek.start();
        
        
    }
    
    
    final int interwalMS = 2500;
    
    Lisc lisc;
    Thread watek;
}
