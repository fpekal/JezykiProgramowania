/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package zad1;

import java.util.ArrayList;
import javax.swing.SwingUtilities;

/**
 *
 * @author student
 */
public class Lista {
    public Lista(zad1.GFX.Lista lista_gfx, zad1.GFX.Wykres wykres_gfx, zad1.GFX.PanelPrzyciskow przyciski) {
        this.lista_gfx = lista_gfx;
        this.wykres_gfx = wykres_gfx;
        przyciski.addLista(this);
        wykres_gfx.setLista(liczby);
    }
    
    public void dodajElement(int liczba) {
        if (liczba <= 0) return;

        liczby.add(liczba);
        lista_gfx.dodajElement(liczba);
        
        wykres_gfx.repaint();
    }
    
    public void usunElement() {
        int usuniety = lista_gfx.usunElement();
        if (usuniety == -1) return;
        
        liczby.remove(usuniety);
        
        wykres_gfx.repaint();
    }

    public ArrayList<Integer> liczby = new ArrayList<>();

    private zad1.GFX.Wykres wykres_gfx;
    private zad1.GFX.Lista lista_gfx;
}
