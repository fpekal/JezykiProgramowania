/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package zad1.GFX;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.GridLayout;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;



/**
 *
 * @author student
 */
public class PanelPrzyciskow {
    public PanelPrzyciskow(JPanel panel) {
        nowaLiczba.setHorizontalAlignment(JTextField.CENTER);
        panel.add(nowaLiczba);
        
        dodajLiczbe.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                lista.dodajElement(Integer.valueOf(nowaLiczba.getText()));
            }
        });
        panel.add(dodajLiczbe);
        
        usunLiczbe.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                lista.usunElement();
            }
        });
        panel.add(usunLiczbe);
    }
    
    public void addLista(zad1.Lista lista) {
        this.lista = lista;
    }
    
    private zad1.Lista lista = null;
    
    private JButton usunLiczbe = new JButton("Usuń liczbę");
    private JButton dodajLiczbe = new JButton("Dodaj liczbę");
    private JTextField nowaLiczba = new JTextField();
}
