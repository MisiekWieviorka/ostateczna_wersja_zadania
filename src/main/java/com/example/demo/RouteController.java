package com.example.demo;

import java.util.HashMap;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class RouteController {
    static HashMap<Integer, Pracownik> pracownikHashMap = new HashMap();
    static MenadzerPracownikow menadzerPracownikow = new MenadzerPracownikow(pracownikHashMap);

    public static void dodajDoMenadzera() {
        menadzerPracownikow.dodajPracownika("updated ArjunCodes", "updated arjun", "Programista", 20000);
        menadzerPracownikow.dodajPracownika("Code With Arjun", "codewitarjun", "Youtuber", 6000);
        menadzerPracownikow.dodajPracownika("New User", "newuser", "Gimnastyk", 10000);
        menadzerPracownikow.dodajPracownika("Arjun", "Demouser", "Polityk", 100000);
    }

    @GetMapping({"/wejscie"})
    public String formularz(Model model) {
        model.addAttribute("Pracownik", new Pracownik());
        return "wejscie";
    }

    @GetMapping({"/"})
    public String wyswietlPracownikow(Model model) {
        model.addAttribute("menadzerUzytkownikow", menadzerPracownikow);
        return "index";
    }

    @GetMapping({"/edytuj/{id}"})
    public String edycjaFormularzu(@PathVariable("id") int id, Model model) {
        Pracownik pracownik = menadzerPracownikow.znajdzPracownikaPrzezId(id);
        model.addAttribute("pracownik", pracownik);
        return "edytuj";
    }

    @PostMapping({"/usun/{id}"})
    public String usunUzytkownika(@PathVariable("id") int id) {
        System.out.println(id);
        menadzerPracownikow.usunPracownika(menadzerPracownikow.znajdzPracownikaPrzezId(id));
        return "redirect:/";
    }

    @PostMapping({"/zaktualizuj/{id}"})
    public String zaktualizujPracownika(@PathVariable("id") String id, @ModelAttribute("pracownik") Pracownik zaktualizowanyPracownik) {
        menadzerPracownikow.zaktualizujPracownika(Integer.parseInt(id), zaktualizowanyPracownik.getPozycja(), zaktualizowanyPracownik.getPensja());
        return "redirect:/";
    }

    @PostMapping({"/szukajnazwiskiem/szukaj"})
    public String szukajPracownika(@RequestParam("nazwisko") String nazwisko, Model model) {
        model.addAttribute("nazwisko", nazwisko);
        model.addAttribute("menadzerPracownikow", menadzerPracownikow);
        return "szukajnazwiskiem";
    }

    @PostMapping({"/pracownik/zapisz"})
    public String dodajPracownikaDoHashMap(@RequestParam("imie") String imie,@RequestParam("nazwisko") String nazwisko,@RequestParam("pozycja") String pozycja,@RequestParam("pensja") int pensja) {
        System.out.println(imie+ " "+imie+ " "+nazwisko+ " "+pozycja+ " "+ pensja);
        menadzerPracownikow.dodajPracownika(imie, nazwisko, pozycja, pensja);
        return "redirect:/wejscie";
    }
}