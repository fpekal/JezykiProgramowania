/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package zad2;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.event.ActionEvent;

import java.util.function.Consumer;

/**
 *
 * @author proxy_lb
 */
public class Kalkulator extends JPanel {
    public Kalkulator() {
        //this.setPreferredSize(new Dimension(640, 480));
        this.setLayout(new GridBagLayout());
        
        GridBagConstraints gbc = new GridBagConstraints();
        
        input.setEditable(false);
        gbc.fill = GridBagConstraints.BOTH;
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 4;
        this.add(input, gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        this.add(abc, gbc);
        
        gbc.gridx = 1;
        gbc.gridy = 1;
        this.add(def, gbc);
        
        gbc.gridx = 2;
        gbc.gridy = 1;
        this.add(ghi, gbc);
        
        gbc.gridx = 3;
        gbc.gridy = 1;
        this.add(jkl, gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 2;
        this.add(mno, gbc);
        
        gbc.gridx = 1;
        gbc.gridy = 2;
        this.add(pqr, gbc);
        
        gbc.gridx = 2;
        gbc.gridy = 2;
        this.add(stuv, gbc);
        
        gbc.gridx = 3;
        gbc.gridy = 2;
        this.add(wxyz, gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 3;
        this.add(c, gbc);
        
        gbc.gridx = 1;
        gbc.gridy = 3;
        this.add(ce, gbc);
        
        gbc.gridx = 2;
        gbc.gridy = 3;
        this.add(dm, gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 4;
        this.add(plus, gbc);
        
        gbc.gridx = 1;
        gbc.gridy = 4;
        this.add(minus, gbc);
        
        gbc.gridx = 2;
        gbc.gridy = 4;
        this.add(division, gbc);
        
        gbc.gridx = 3;
        gbc.gridy = 3;
        gbc.gridheight = 2;
        this.add(equals, gbc);
        
        
        dm.addActionListener((ActionEvent e) -> {
            wielka_litera = !wielka_litera;
        });
        
        c.addActionListener((ActionEvent e) -> {
            input.setText("");
            arg1 = null;
            arg2 = null;
            operacja = null;
        });
        
        ce.addActionListener((ActionEvent e) -> {
            if (input.getText().length() > 0)
                input.setText(input.getText().substring(0, input.getText().length() - 1));
        });
        
        plus.addActionListener((ActionEvent e) -> {
            arg1 = input.getText();
            input.setText("");
            operacja = operacja_plus;
        });
        
        minus.addActionListener((ActionEvent e) -> {
            arg1 = input.getText();
            input.setText("");
            operacja = operacja_minus;
        });
        
        division.addActionListener((ActionEvent e) -> {
            arg1 = input.getText();
            input.setText("");
            operacja = operacja_dzielenie;
        });
        
        equals.addActionListener((ActionEvent e) -> {
            if (arg1 == null || operacja == null)
                return;
            
            arg2 = input.getText();
            
            Argumenty arg = new Argumenty(arg1, arg2);
            operacja.accept(arg);
            
            input.setText(arg.ret);
            
            operacja = null;
            arg1 = null;
            arg2 = null;
        });
    }
    
    Consumer<Argumenty> operacja_plus = (Argumenty arg) -> {
        arg.ret = arg.arg1.concat(arg.arg2);
    };
    
    Consumer<Argumenty> operacja_minus = (Argumenty arg) -> {
        arg.ret = arg.arg1;
        
        while(true) {
            int index = arg.ret.indexOf(arg.arg2);
            if (index == -1) break;
            
            String left = arg.ret.substring(0, index);
            String right = arg.ret.substring(index + arg.arg2.length());
            
            arg.ret = left + right;
        }
    };
    
    Consumer<Argumenty> operacja_dzielenie = (Argumenty arg) -> {
        String najwiekszy_substr = "";
        int wielkosc_najwiekszego = -1;
        
        for (int begin = 0; begin < arg.arg2.length() - 1; ++begin) {
            for (int end = begin + 1; end <= arg.arg2.length(); ++end) {
                String substr = arg.arg2.substring(begin, end);
                
                int index = arg.arg1.indexOf(substr);
                if (index == -1) continue;
                if (wielkosc_najwiekszego >= substr.length()) continue;
                
                wielkosc_najwiekszego = substr.length();
                najwiekszy_substr = substr;
            }
        }
        
        arg.ret = najwiekszy_substr;
    };
    
    boolean wielka_litera = false;
    
    Consumer<Argumenty> operacja = null;
    String arg1;
    String arg2;
    
    JTextField input = new JTextField();
    
    PrzyciskLiterowy abc = new PrzyciskLiterowy(this, "abc");
    PrzyciskLiterowy def = new PrzyciskLiterowy(this, "def");
    PrzyciskLiterowy ghi = new PrzyciskLiterowy(this, "ghi");
    PrzyciskLiterowy jkl = new PrzyciskLiterowy(this, "jkl");
    PrzyciskLiterowy mno = new PrzyciskLiterowy(this, "mno");
    PrzyciskLiterowy pqr = new PrzyciskLiterowy(this, "pqr");
    PrzyciskLiterowy stuv = new PrzyciskLiterowy(this, "stuv");
    PrzyciskLiterowy wxyz = new PrzyciskLiterowy(this, "wxyz");
    
    PrzyciskLiterowy aktualnie_uzywany_przycisk = null;
    
    JButton c = new JButton("C");
    JButton ce = new JButton("CE");
    JButton dm = new JButton("D/M");
    JButton plus = new JButton("+");
    JButton minus = new JButton("-");
    JButton division = new JButton("/");
    
    JButton equals = new JButton("=");
}
