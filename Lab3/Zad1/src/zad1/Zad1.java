/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package zad1;

import java.io.IOException;

import java.util.List;

/**
 *
 * @author student
 */
public class Zad1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        KatalogSklepowy ks = new KatalogSklepowy();

        Interfejs interfejs = new Interfejs(ks);

        interfejs.odpal();
    }

}
