/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package zad1;

import java.awt.Color;
import javax.swing.JPanel;

import javax.swing.JSlider;

import java.awt.GridLayout;
import java.awt.Dimension;

/**
 *
 * @author proxy_lb
 */
public class Suwak extends JPanel {
    public Suwak(Kolko k) {
        setLayout(new GridLayout(1, 1));
        
        JSlider slider = new JSlider(JSlider.HORIZONTAL, 0, 99, 0);
        slider.setBackground(k.kolor);
        add(slider);
        
        slider.setValue((int)k.szybkosc);
        
        slider.addChangeListener((e) -> {
            float value = slider.getValue();
            
            k.zmienSzybkosc(value);
        });
    }
}
