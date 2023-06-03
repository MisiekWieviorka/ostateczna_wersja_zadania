package com.example.demo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

public class MenadzerPracownikow {

    private final HashMap<Integer,Pracownik> pracownicy;

    public HashMap<Integer, Pracownik> getPracownicy() {
        return pracownicy;
    }

    public MenadzerPracownikow(HashMap<Integer, Pracownik> pracownicy) {
        this.pracownicy = pracownicy;
    }

    public  void dodajPracownika(String imie, String nazwisko, String pozycja, int pensja){
        Pracownik pracownik = new Pracownik(imie, nazwisko, pozycja, pensja);
        Integer keyPracownik = pracownik.getIdPracownika();
        this.pracownicy.put(keyPracownik,pracownik);
    }

    public void usunPracownika(Pracownik pracownik){
        if(pracownicy.containsKey(pracownik.getIdPracownika()))
            pracownicy.remove(pracownik.getIdPracownika());
        else
            System.out.println("Pracownik o takim ID nie istnieje");
    }

    public void zaktualizujPracownika(int idPracownika, String nowaPozycja, int nowaPensja){
        if(pracownicy.containsKey(idPracownika))
        {
            Pracownik pracownik = znajdzPracownikaPrzezId(idPracownika);
            pracownik.setPozycja(nowaPozycja);
            pracownik.setPensja(nowaPensja);
        }
        else
            System.out.println("Pracownik o takim ID nie istnieje");
    }

    public Pracownik znajdzPracownikaPrzezId(int idPracownika) {
        if(pracownicy.containsKey(idPracownika)){
            return pracownicy.get(idPracownika);
        }
        else
            System.out.println("Nie znaleziono pracownika o danym ID");
        return null;
    }

    public void listaWszystkichPracownikow(){
        ArrayList<Pracownik> listaPracownikow = new ArrayList<>(pracownicy.values());
        for (Pracownik pracownik: listaPracownikow
        ) {
            System.out.println(pracownik);
        }
    }

    public HashSet<Pracownik> szukajPracownikowPrzezNazwisko(String nazwisko){
        HashSet<Pracownik> listaPracownikow = new HashSet<>(pracownicy.values());
        Iterator<Pracownik> pracownicyIterator = listaPracownikow.iterator();
        while(pracownicyIterator.hasNext())
        {
            Pracownik pracownik = pracownicyIterator.next();
            if(!pracownik.getNazwisko().equals(nazwisko))
                pracownicyIterator.remove();
        }
        return listaPracownikow;
    }
}
