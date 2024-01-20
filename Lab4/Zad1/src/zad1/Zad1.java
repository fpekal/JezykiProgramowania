/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package zad1;

/**
 *
 * @author student
 */
public class Zad1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        zad1.GFX.Okno okno = new zad1.GFX.Okno();

        Lista lista = new Lista(okno.lista, okno.wykres, okno.przyciski);

        for (int i = 0; i < 5; i++) {
            lista.dodajElement(i);
        }
    }

}
