/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package zad2;

import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author proxy_lb
 */
public class Slimak {
    public Slimak(Lisc l) {
        Random r = new Random();
        
        lisc = l;
        
        v = 5;
        
        interwalMS = r.nextInt(100, 300);
        x = r.nextInt(l.w);
        y = r.nextInt(l.h);
    }
    
    public void odpal() {
        thread = new Thread(() -> {
            while(true) {
                try {
                    TimeUnit.MILLISECONDS.sleep(interwalMS);
                }
                catch(InterruptedException e) {

                }

                ruch();
                if (czekaj) {
                    try {
                        TimeUnit.MILLISECONDS.sleep(t);
                    }
                    catch(InterruptedException e) {

                    }
                    czekaj = false;
                }
            }
        });
        
        thread.start();
    }
    
    public void ruch() {
        synchronized(lisc) {
            ArrayList<DostepnaPozycja> dostepnePozycje = new ArrayList<>();
            
            for (int dx = -1; dx <= 1; ++dx) {
                for (int dy = -1; dy <= 1; ++dy) {
                    if (dx == 0 && dy == 0) continue;
                    
                    int noweX = x + dx;
                    int noweY = y + dy;
                    
                    if (noweX < 0 || noweX >= lisc.w) continue;
                    if (noweY < 0 || noweY >= lisc.h) continue;
                    
                    
                    boolean zajete = false;
                    
                    for (Slimak s : lisc.slimaki) {
                        if (s.x == noweX && s.y == noweY) {
                            zajete = true;
                            break;
                        }
                    }
                    
                    if (!zajete)
                        dostepnePozycje.add(new DostepnaPozycja(noweX, noweY,
                            lisc.komorki.get(noweY * lisc.w + noweX).jedzenie
                            ));
                }
            }
            
            if (dostepnePozycje.isEmpty()) {
                nieMaMiejsca();
                return;
            }
            
            ArrayList<DostepnaPozycja> najlepszePozycje = new ArrayList<>();
            int maxJedzenia = lisc.komorki.get(this.y * lisc.w + this.x).jedzenie + 1;
            
            for (DostepnaPozycja p : dostepnePozycje) {
                if (p.jedzenie == maxJedzenia) najlepszePozycje.add(p);
                else if (p.jedzenie > maxJedzenia) {
                    maxJedzenia = p.jedzenie;
                    najlepszePozycje.clear();
                    najlepszePozycje.add(p);
                }
            }
            
            if (najlepszePozycje.isEmpty()) {
                nieMaMiejsca();
                return;
            }
            
            Random r = new Random();
            DostepnaPozycja wybranaPozycja = najlepszePozycje.get(r.nextInt(najlepszePozycje.size()));
            
            this.x = wybranaPozycja.x;
            this.y = wybranaPozycja.y;
            
            zjedzJedzenie();
        }
    }
    
    private void zjedzJedzenie() {
        synchronized(lisc) {
            Komorka k = lisc.komorki.get(y * lisc.w + x);
            k.jedzenie -= v;
            if (k.jedzenie < 0) k.jedzenie = 0;
        }
    }
    
    private void nieMaMiejsca() {
        czekaj = true;
        zjedzJedzenie();
    }
    
    public int x;
    public int y;
    
    public int v;
    
    Lisc lisc;
    
    boolean czekaj = false;
    
    int t = 5000;
    int interwalMS = 500;
    Thread thread;
}
