package com.company;

import eingabe.Kommando;

/**
 *  Die Klasse Validator prüft die Validität von Eingaben. Die Kondition ist, dass der erste char ein M oder T ist,
 *  der zweite und dritte char zu einem Integer konvertiert werden kann.
 *  @author M. Mustermann
 *  @version 1.0, 18.03.2019
 */

public class Validator {
    private String[] eingabeTeile;
    private boolean istGueltig;

    /**
     * Diese Methode validiert den Parameter eingabe. Die Kondition ist, dass der erste char ein M oder T ist,
     * der zweite und dritte char zu einem Integer konvertiert werden kann.
     * @param eingabe ist ein String der auf gewisse Konditionen überprüft wird.
     */
    public Validator(String eingabe) {
        eingabeTeile = eingabe.split(" ");
        if (eingabeTeile.length == 3) {
            istGueltig = true;
        }
        if (!eingabeTeile[0].equals("T") && !eingabeTeile[0].equals("M")) {
            istGueltig = false;
        }

        try {
            Integer.valueOf(eingabeTeile[1]);
            Integer.valueOf(eingabeTeile[2]);
        } catch (ArrayIndexOutOfBoundsException | NumberFormatException e) {
            System.out.println("Fehler!");
            istGueltig = false;
        }
    }

    /**
     * Die Methode istGueltig ist ein getter für die private Klassenvariable istGueltig.
     * @return ist ein boolean der der Klassenvariable istGueltig entspricht.
     */
    public boolean istGueltig() {
        return istGueltig;
    }

    /**
     * Die Methode erzeugeKommando erzeugt eine Kommando Klasse mit den Parametern aus der Benutzereingabe.
     * @return eine Kommando Klassen instanz, instanziert mit der Benutzereingabe.
     */
    public Kommando erzeugeKommando() {
        char kommandoZeichen = eingabeTeile[0].charAt(0);
        int zeile = Integer.valueOf(eingabeTeile[1]);
        int spalte = Integer.valueOf(eingabeTeile[2]);
        return new Kommando(kommandoZeichen, zeile, spalte);
    }
}
