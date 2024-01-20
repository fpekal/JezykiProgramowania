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
        if (args.length != 1) {
            System.out.println("Złe argumenty");
            return;
        }
        
        Okno okno = new Okno(Integer.parseInt(args[0]));
    }

}
