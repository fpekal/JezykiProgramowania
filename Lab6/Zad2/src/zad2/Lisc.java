/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package zad2;

import java.util.ArrayList;

import javax.swing.JPanel;

import java.awt.Graphics;
import java.awt.Dimension;
import java.awt.Color;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author proxy_lb
 */
public class Lisc extends JPanel {
    public Lisc(int w, int h) {
        this.setPreferredSize(new Dimension(640, 640));
        
        
        this.w = w;
        this.h = h;
        
        for (int i = 0; i < w; ++i) {
            for (int j = 0; j < h; ++j) {
                komorki.add(new Komorka());
            }
        }
    }
    
    public void odpal() {
        deszcz.odpal();
        
        for (Slimak s : slimaki) {
            s.odpal();
        }
        
        thread = new Thread(() -> {
            while(true) {
                this.repaint();
                
                try {
                    TimeUnit.MILLISECONDS.sleep(16);
                }
                catch(InterruptedException e) {

                }
            }
        });
        
        thread.start();
    }
    
    public void dodajSlimaka() {
        Slimak nowy = new Slimak(this);
        slimaki.add(nowy);
    }
    
    
    @Override
    public void paint(Graphics g) {
        g.clearRect(0, 0, 640, 640);
        
        int komorkaSzer = 640 / w;
        int komorkaWys = 640 / h;
        
        int wielkoscSlimaka = komorkaSzer / 2;
        
        for (int x = 0; x < w; ++x) {
            for (int y = 0; y < h; ++y) {
                Komorka k = komorki.get(y * w + x);
                g.setColor(blend(new Color(255, 255, 255), new Color(0, 100, 0), (float)k.jedzenie / 10));
                g.fillRect(x * komorkaSzer, y * komorkaWys, komorkaSzer, komorkaWys);
            }
        }
        
        for (Slimak s : slimaki) {
            g.setColor(Color.red);
            g.fillOval(s.x * komorkaSzer + komorkaSzer / 2 - wielkoscSlimaka / 2, s.y * komorkaWys + komorkaWys / 2 - wielkoscSlimaka / 2, wielkoscSlimaka, wielkoscSlimaka);
        }
    }
    
    private Color blend(Color c1, Color c2, float blending) {
        float invBlending = 1 - blending;
        
        float red = c2.getRed() * blending + c1.getRed() * invBlending;
        float green = c2.getGreen() * blending + c1.getGreen() * invBlending;
        float blue = c2.getBlue() * blending + c1.getBlue() * invBlending;
        
        return new Color(red / 255, green / 255, blue / 255);
    }
    
    
    public int w;
    public int h;
    
    Deszcz deszcz = new Deszcz(this);
    
    ArrayList<Slimak> slimaki = new ArrayList<>();
    ArrayList<Komorka> komorki = new ArrayList<>();
    
    Thread thread;
}
