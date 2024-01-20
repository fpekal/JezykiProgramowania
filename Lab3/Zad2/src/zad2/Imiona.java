/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package zad2;

/**
 *
 * @author proxy_lb
 */
public enum Imiona {
    Bogdan(0),
    Ewaryst(1),
    Klaudia(2),
    Marcel(3),
    Tobiasz(4),
    Tomek(5);
    
    
    public int order;
    
    private Imiona(int order) {
        this.order = order;
    }
    
    static public Imiona parse(String imie) {
        if (imie.equals("Bogdan")) return Imiona.Bogdan;
        if (imie.equals("Ewaryst")) return Imiona.Ewaryst;
        if (imie.equals("Klaudia")) return Imiona.Klaudia;
        if (imie.equals("Marcel")) return Imiona.Marcel;
        if (imie.equals("Tobiasz")) return Imiona.Tobiasz;
        if (imie.equals("Tomek")) return Imiona.Tomek;
        
        return null;
    }
    
    @Override
    public String toString() {
        switch(this) {
            case Bogdan -> {
                return "Bogdan";
            }
            case Ewaryst -> {
                return "Ewaryst";
            }
            case Klaudia -> {
                return "Klaudia";
            }
            case Marcel -> {
                return "Marcel";
            }
            case Tobiasz -> {
                return "Tobiasz";
            }
            case Tomek -> {
                return "Tomek";
            }
        }
        
        return "";
    }
}