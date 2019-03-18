package eingabe;

import com.company.Validator;
import spielfeld.Zelle;

import java.util.Scanner;


public class Benutzerschnittstelle {
    private Scanner scanner = new Scanner(System.in);

    public Kommando liesEingabe() {
        do {
            String eingabe = scanner.nextLine();
            Validator validator = new Validator(eingabe);
            if (validator.istGueltig()) {
                return validator.erzeugeKommando();
            } else {
                zeigeFehlermeldung();
            }
        } while (true);
    }

    public void zeigeSpielfeld(Zelle[][] spielfeld) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (i == 0 && j == 0) {
                    System.out.print(" " + "\t");
                } else if (i == 0) {
                    System.out.print(j - 1 + "\t");
                } else if (j == 0) {
                    System.out.print(i - 1 + "\t");
                } else if (spielfeld[i - 1][j - 1].Zustand == 'Z') {
                    System.out.print("" + "\t");
                } else if (spielfeld[i - 1][j - 1].Zustand == 'M') {
                    System.out.print("!" + "\t");
                } else if (spielfeld[i - 1][j - 1].Zustand == 'T' && !spielfeld[i - 1][j - 1].bombe) {
                    System.out.print(spielfeld[i - 1][j - 1].AnzahlAngrenzendeBombe + "\t");
                } else if (spielfeld[i - 1][j - 1].bombe) {
                    System.out.print("*" + "\t");
                }
            }
            System.out.println();
        }
    }

    public void zeigeEingabeaufforderung() {
        System.out.println("Geben Sie ein Kommando ein:");
    }

    private void zeigeFehlermeldung() {
        System.out.println("Ungueltige Eingabe!");
    }

    public void zeigeSchlussmeldung() {
        System.out.println("GAME OVER");
        System.out.println("You stepped on a mine!");
    }

    public void zeigeGewinnermeldung() {
        System.out.println("GRATULATION");
        System.out.println("Sie haben gewonnen!");
    }
}
