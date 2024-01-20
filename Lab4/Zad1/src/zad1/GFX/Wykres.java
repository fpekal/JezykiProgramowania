/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package zad1.GFX;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.JFrame;

/**
 *
 * @author proxy_lb
 */
public class Wykres extends JPanel {
    @Override
    public void paint(Graphics g) {
        g.clearRect(0, 0, getBounds().width, getBounds().height);
        
        if (lista == null)
            return;
        
        int suma = 0;
        
        for (Integer liczba : lista) {
            suma += liczba;
        }
        
        float poprzednie = 0;
        
        int i = 0;
        
        for (Integer liczba : lista) {
            g.setColor(colors.get(i%6));
            float wielkosc = (float)liczba / (float)suma * 360;
            g.fillArc(0, 0, this.getBounds().width, this.getBounds().height, (int)poprzednie, (int)wielkosc + 1);
            poprzednie += wielkosc;
            ++i;
        }
    }
    
    public void setLista(ArrayList<Integer> lista) {
        this.lista = lista;
    }
    
    private ArrayList<Integer> lista = null;
    
    private ArrayList<Color> colors = new ArrayList<Color>() {
        {
            add(Color.red);
            add(Color.green);
            add(Color.blue);
            add(Color.yellow);
            add(Color.cyan);
            add(Color.magenta);
        }
    };
}
