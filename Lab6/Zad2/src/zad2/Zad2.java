/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package zad2;

import javax.swing.JFrame;

/**
 *
 * @author proxy_lb
 */
public class Zad2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        if (args.length != 3) {
            System.out.println("Zła ilość argumentów: szerokość wysokość ilość");
            return;
        }
        
        int w = Integer.parseInt(args[0]);
        int h = Integer.parseInt(args[1]);
        int c = Integer.parseInt(args[2]);
        
        JFrame frame = new JFrame("Ślimaki");
        frame.setSize(640, 640 + 32);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        
        
        Lisc l = new Lisc(w, h);
        
        for (int i = 0; i < c; ++i) {
           l.dodajSlimaka(); 
        }
        
        l.odpal();
        
        frame.getContentPane().add(l);
        frame.setVisible(true);
    }
    
}
