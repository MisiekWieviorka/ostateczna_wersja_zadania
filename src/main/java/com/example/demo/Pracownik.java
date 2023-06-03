package com.example.demo;
public class Pracownik {
    public static int dodajId = 0;
    public String imie;
    public String nazwisko;
    public String pozycja;
    public int idPracownika;
    public int pensja;

    public Pracownik(){
    }

    public Pracownik(String imie, String nazwisko, String pozycja, int pensja) {
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.pozycja = pozycja;
        this.idPracownika = dodajId++;
        this.pensja = pensja;
    }

    public String getPozycja() {
        return pozycja;
    }

    public int getIdPracownika() {
        return idPracownika;
    }

    public String getImie() {
        return imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public int getPensja() {
        return pensja;
    }
    @Override
    public String toString() {
        return "Pracownik: " +
                "imie = '" + imie + '\'' +
                ", nazwisko = '" + nazwisko + '\'' +
                ", pozycja = '" + pozycja + '\'' +
                ", idPracownika = " + idPracownika +
                ", pensja = " + pensja;
    }

    public void setPensja(int pensja) {
        this.pensja = pensja;
    }

    public void setPozycja(String pozycja) {
        this.pozycja = pozycja;
    }
}
