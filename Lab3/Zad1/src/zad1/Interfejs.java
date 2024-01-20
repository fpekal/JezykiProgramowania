/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package zad1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.List;

/**
 *
 * @author student
 */
public class Interfejs {
    public Interfejs(KatalogSklepowy ks) {
        this.ks = ks;
    }

    public void odpal() throws IOException {
        System.out.println("Tryb: [pracownik, klient]");
        
        String tryb = reader.readLine();
        
        if (tryb.equals("klient"))
            tryb_klient();
        else if (tryb.equals("pracownik"))
            tryb_pracownik();
    }
    
    private void tryb_pracownik() throws IOException {
        while (true) {
            System.out.println("wyswietl - wyświetla wszystkie produkty");
            System.out.println("szukaj nazwa - szuka produktów w katalogu. ? oznacza dowolny znak, * oznacza dowolną ilość dowolnych znaków");
            System.out.println("dodaj kod ilość - dodaje daną ilość produktów do katalogu");
            System.out.println("pobierz kod ilość - usuwa daną ilość produktów z katalogu");
            System.out.println("wyjscie - wychodzi z programu");
            
            String komenda = reader.readLine();
            
            if (komenda.matches("dodaj .+")) dodajArtykul(komenda.substring(6));
            else if (komenda.matches("pobierz .+")) pobierzArtykul(komenda.substring(8));
            else if (komenda.equals("wyswietl")) wyswietl_pracownik();
            else if (komenda.matches("szukaj .+")) znajdzArtykul(komenda.substring(7));
            else if (komenda.equals("wyjscie")) break;
        }
    }
    
    private void pobierzArtykul(String polecenie) {
        int rozdzielacz = polecenie.indexOf(' ');
        
        String kod = polecenie.substring(0, rozdzielacz);
        
        int ilosc = -1;
        
        try {
            ilosc = Integer.parseInt(polecenie.substring(rozdzielacz + 1));
        }
        catch(NumberFormatException e) {
            throw new RuntimeException("Ilość produktów podana w nieprawidłowym formacie.");
        }
        
        ks.kupProdukty(kod, ilosc);
    }
    
    private void dodajArtykul(String polecenie) {
        int rozdzielacz = polecenie.indexOf(' ');
        
        String kod = polecenie.substring(0, rozdzielacz);
        
        int ilosc = -1;
        
        try {
            ilosc = Integer.parseInt(polecenie.substring(rozdzielacz + 1));
        }
        catch(NumberFormatException e) {
            throw new RuntimeException("Ilość produktów podana w nieprawidłowym formacie.");
        }
        
        ks.dodajProdukty(kod, ilosc);
    }
    
    private void tryb_klient() throws IOException {
        Koszyk koszyk = new Koszyk(ks);
        
        while (true) {
            System.out.println("wyswietl - wyświetla dostępne produkty");
            System.out.println("szukaj nazwa - szuka produktów w katalogu. ? oznacza dowolny znak, * oznacza dowolną ilość dowolnych znaków");
            System.out.println("dodaj kod ilość - dodaje daną ilość produktów do koszyka");
            System.out.println("usun kod - usuwa produktó z koszyka");
            System.out.println("wyczysc - czyści koszyk");
            System.out.println("wycena - sumuje ceny produków z koszyka");
            System.out.println("kup - kupuje produktu, usuwa je z katalogu");
            System.out.println("wyjscie - wychodzi z programu");
            
            String komenda = reader.readLine();

            if (komenda.equals("wyswietl")) wyswietl_klient();
            else if (komenda.matches("szukaj .+")) znajdzArtykul(komenda.substring(7));
            else if (komenda.matches("dodaj .+")) dodaj(koszyk, komenda.substring(6));
            else if (komenda.matches("usun .+")) usun(koszyk, komenda.substring(5));
            else if (komenda.equals("wyczysc")) wyczysc(koszyk);
            else if (komenda.equals("wycena")) wycena(koszyk);
            else if (komenda.equals("kup")) kup(koszyk);
            else if (komenda.equals("wyjscie")) break;
        }
    }
    
    private void kup(Koszyk koszyk) {
        koszyk.kup();
    }
    
    private void wycena(Koszyk koszyk) {
        float cena = koszyk.zsumujCeny();
        
        System.out.println("Do zapłaty: " + Float.toString(cena / 100) + "zł");
    }
    
    private void wyczysc(Koszyk koszyk) {
        koszyk.wyczysc();
    }
    
    private void usun(Koszyk koszyk, String kod) {
        koszyk.usunProdukt(kod);
    }
    
    private void dodaj(Koszyk koszyk, String polecenie) {
        int rozdzielacz = polecenie.indexOf(' ');
        
        String kod = polecenie.substring(0, rozdzielacz);
        
        int ilosc = -1;
        
        try {
            ilosc = Integer.parseInt(polecenie.substring(rozdzielacz + 1));
        }
        catch(NumberFormatException e) {
            throw new RuntimeException("Ilość produktów podana w nieprawidłowym formacie.");
        }
        
        koszyk.dodajProdukt(kod, ilosc);
    }

    private void wyswietl_klient() {
        List<GrupaProduktow> gpList = ks.znajdzProdukty("*");

        System.out.println("Lista Produktow:");

        for (GrupaProduktow gp : gpList) {
            if (gp.ilosc <= 0) continue;
            
            wyswietlGrupe(gp);
        }
    }
    
    private void wyswietl_pracownik() {
        List<GrupaProduktow> gpList = ks.znajdzProdukty("*");

        System.out.println("Lista Produktow:");

        for (GrupaProduktow gp : gpList) {
            wyswietlGrupe(gp);
        }
    }

    private void znajdzArtykul(String nazwa) {
        List<GrupaProduktow> gpList = ks.znajdzProdukty(nazwa);

        System.out.println("Lista Produktow:");

        for (GrupaProduktow gp : gpList) {
            wyswietlGrupe(gp);
        }
    }
    
    private void wyswietlGrupe(GrupaProduktow gp) {
        float cena = gp.wpis.produkt.cena;
        System.out.println(gp.wpis.kod);
        System.out.println(gp.wpis.produkt.nazwa + " x" + gp.ilosc + " - " + Float.toString(cena / 100) + "zł");
        System.out.println();
    }

    private KatalogSklepowy ks;

    private BufferedReader reader = new BufferedReader(
            new InputStreamReader(System.in));
}
