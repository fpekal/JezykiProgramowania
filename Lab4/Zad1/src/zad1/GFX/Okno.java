/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package zad1.GFX;

import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.GridLayout;
import java.awt.BorderLayout;

/**
 *
 * @author student
 */
public class Okno {
    public Okno() {
        inicjujOkno();

        ustawLewyPanel();
        ustawPrawyPanel();
        
        
        
        frame.setVisible(true);
    }

    public Lista lista;
    public Wykres wykres;
    public PanelPrzyciskow przyciski;

    private void inicjujOkno() {
        frame = new JFrame(NAME);
        frame.setSize(WIDTH, HEIGHT);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.getContentPane().setLayout(new GridLayout(1, 2));
    }

    private void ustawLewyPanel() {
        leftPanel.setLayout(new BorderLayout());
        
        wykres = new Wykres();
        leftPanel.add(wykres);
        
        frame.getContentPane().add(leftPanel);
    }

    private void ustawPrawyPanel() {
        rightPanel.setLayout(new GridLayout(2, 1));

        ustawPanelListy();
        ustawPanelPrzyciskow();

        frame.getContentPane().add(rightPanel);
    }

    private void ustawPanelListy() {
        rightUpPanel.setLayout(new BorderLayout());

        lista = new Lista(rightUpPanel);
        
        rightPanel.add(rightUpPanel);
    }

    private void ustawPanelPrzyciskow() {
        rightDownPanel.setLayout(new GridLayout(3, 1));
        
        przyciski = new PanelPrzyciskow(rightDownPanel);
        
        rightPanel.add(rightDownPanel);
    }

    static public final int WIDTH = 640;
    static public final int HEIGHT = 480;
    static public final String NAME = "Zad1";

    private JPanel leftPanel = new JPanel();
    private JPanel rightPanel = new JPanel();

    private JPanel rightUpPanel = new JPanel();
    private JPanel rightDownPanel = new JPanel();

    private JFrame frame;
}
