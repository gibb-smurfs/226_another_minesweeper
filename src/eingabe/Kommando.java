package eingabe;

import spielfeld.Spielfeld;

public class Kommando {
    private char kommandoZeichen;
    public static int zeile;
    public static int spalte;

    public Kommando(char kommandoZeichen, int zeile, int spalte) {
        this.kommandoZeichen = kommandoZeichen;
        Kommando.zeile = zeile;
        Kommando.spalte = spalte;
    }

    public void ausfuehren(Spielfeld spielfeld) {
        switch (kommandoZeichen) {
            case 'M': {
                spielfeld.markieren(zeile, spalte);
                break;
            }
            case 'T': {
                spielfeld.aufdecken(zeile, spalte);
                break;
            }
        }
    }
}
