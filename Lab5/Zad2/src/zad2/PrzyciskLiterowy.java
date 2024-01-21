/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package zad2;

import javax.swing.JButton;
import java.awt.event.ActionEvent;

import java.time.temporal.ChronoUnit;
import java.time.Instant;

/**
 *
 * @author proxy_lb
 */
public class PrzyciskLiterowy extends JButton {
    public PrzyciskLiterowy(Kalkulator k, String str) {
        super(str);
        
        this.addActionListener((ActionEvent e) -> {
            boolean nowa = czy_nowa_litera();
            
            if (nowa) {
                pozycja = 0;
                String input = kalkulator.input.getText();
                kalkulator.input.setText(input + zmien_na_wielka_litere(text.charAt(pozycja), kalkulator.wielka_litera));
            }
            else {
                ++pozycja;
                String input = kalkulator.input.getText();
                input = input.substring(0, input.length() - 1);
                
                kalkulator.input.setText(input + zmien_na_wielka_litere(text.charAt(pozycja), kalkulator.wielka_litera));
            }
            
            kalkulator.aktualnie_uzywany_przycisk = this;
            ostatnie_uzycie = Instant.now();
        });
        
        kalkulator = k;
        text = str;
    }
    
    private boolean czy_nowa_litera() {
        if (kalkulator.aktualnie_uzywany_przycisk != this)
            return true;
        if (pozycja == text.length() - 1)
            return true;
        if (ostatnie_uzycie.plus(500, ChronoUnit.MILLIS).isBefore(Instant.now()))
            return true;
        
        return false;
    }
    
    private char zmien_na_wielka_litere(char c, boolean czy_zmieniac) {
        if (czy_zmieniac)
            c += 'A' - 'a';
        
        return c;
    }
    
    Instant ostatnie_uzycie = Instant.now().minus(1, ChronoUnit.MINUTES);
    
    int pozycja = 0;
    
    Kalkulator kalkulator;
    String text;
}
