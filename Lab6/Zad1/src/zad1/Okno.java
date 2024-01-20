/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package zad1;

import javax.swing.JFrame;
import javax.swing.BoxLayout;

/**
 *
 * @author student
 */
public class Okno extends JFrame {
    public Okno(int ilosc) {
        super("Kółka");
        
        getContentPane().setLayout(new BoxLayout(getContentPane(), BoxLayout.X_AXIS));
        
        kolka = new Canva(ilosc);
        suwaki = new Suwaki(kolka.kolka);
        
        getContentPane().add(kolka);
        getContentPane().add(suwaki);

        setSize(640,480 + 32);
        setResizable(false);


        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    Canva kolka;
    Suwaki suwaki;
}
