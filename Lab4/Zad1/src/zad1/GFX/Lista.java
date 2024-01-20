/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package zad1.GFX;

import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.DefaultListModel;
import javax.swing.JScrollPane;

/**
 *
 * @author student
 */
public class Lista {
    public Lista(JPanel panel) {
        scrollPane.setViewportView(list);

        panel.add(scrollPane);
    }

    public void dodajElement(int liczba) {
        model.addElement(liczba);
    }
    
    public int usunElement() {
        int selected = list.getSelectedIndex();
        if (selected == -1) return -1;
        
        model.remove(selected);
        
        return selected;
    }

    private JScrollPane scrollPane = new JScrollPane();
    private DefaultListModel<Integer> model = new DefaultListModel<>();
    private JList list = new JList(model);
}
