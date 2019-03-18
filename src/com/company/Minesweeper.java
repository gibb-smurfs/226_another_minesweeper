
package com.company;

import eingabe.Kommando;
import eingabe.Benutzerschnittstelle;
import spielfeld.Spielfeld;


public class Minesweeper {
    private spielfeld.Spielfeld Spielfeld = new Spielfeld();
    private Benutzerschnittstelle Benutzerschnittstelle = new Benutzerschnittstelle();


    public static void main(String[] args) {
        Minesweeper minesweeper = new Minesweeper();
        minesweeper.spielen();
    }

    private void spielen() {
        do {
            Benutzerschnittstelle.zeigeSpielfeld(Spielfeld.SpielfeldArray);
            Benutzerschnittstelle.zeigeEingabeaufforderung();
            Kommando kommando = Benutzerschnittstelle.liesEingabe();
            kommando.ausfuehren(Spielfeld);
        } while (spielLaeuft());
        Benutzerschnittstelle.zeigeSpielfeld(Spielfeld.SpielfeldArray);
        if (!Spielfeld.UeberpruefenSpielGewonnen()) {
            Benutzerschnittstelle.zeigeGewinnermeldung();
        } else {
            Benutzerschnittstelle.zeigeSchlussmeldung();
        }
    }

    private boolean spielLaeuft() {
        return Spielfeld.ZelleAufBombeUeberpruefen(Kommando.zeile, Kommando.spalte) && Spielfeld.UeberpruefenSpielGewonnen();
    }

}
