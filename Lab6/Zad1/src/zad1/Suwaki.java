/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package zad1;

import javax.swing.JPanel;

import java.awt.Dimension;
import java.awt.GridLayout;

import java.util.ArrayList;
import javax.swing.BoxLayout;

/**
 *
 * @author proxy_lb
 */
public class Suwaki extends JPanel {
    public Suwaki(ArrayList<Kolko> kolka) {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setPreferredSize(new Dimension(160, 480));
        
        for (Kolko k : kolka) {
            Suwak suwak = new Suwak(k);
            this.add(suwak);
        }
    }
}
