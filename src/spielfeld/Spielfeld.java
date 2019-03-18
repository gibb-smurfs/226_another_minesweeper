package spielfeld;

public class Spielfeld {
    public Zelle[][] SpielfeldArray = new Zelle[8][8];

    public Spielfeld() {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                SpielfeldArray[i][j] = new Zelle();
                if (Math.random() < 0.07) {
                    SpielfeldArray[i][j].BombeSetzen();
                }
            }
        }
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                SpielfeldArray[i][j].AnzahlAngrenzendeBombe = AngrenzendeBombenErmitteln(i, j);
            }
        }
    }

    public void markieren(int yPosition, int xPosition) {
        SpielfeldArray[yPosition][xPosition].Zustand = 'M';
    }

    public void aufdecken(int yPosition, int xPosition) {
        SpielfeldArray[yPosition][xPosition].Zustand = 'T';
        if (SpielfeldArray[yPosition][xPosition].AnzahlAngrenzendeBombe == 0) {
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    if (SpielfeldArray[i][j].Zustand == 'Z' && SpielfeldArray[i][j].AnzahlAngrenzendeBombe == 0 && !SpielfeldArray[i][j].bombe) {
                        SpielfeldArray[i][j].Zustand = 'T';
                    }
                }
            }
        }
    }

    private int AngrenzendeBombenErmitteln(int yPosition, int xPosition) {
        int anzahl = 0;
        for (int i = yPosition - 1; i <= yPosition + 1; ++i) {
            if (i >= 0 && i <= 7) {
                for (int j = xPosition - 1; j <= xPosition + 1; ++j) {
                    if (j >= 0 && j <= 7) {
                        if (SpielfeldArray[i][j].bombe) {
                            anzahl += 1;
                        }
                    }
                }
            }
        }
        if (SpielfeldArray[yPosition][xPosition].bombe) {
            anzahl = -1;
        }
        return anzahl;
    }

    public boolean ZelleAufBombeUeberpruefen(int yPosition, int xPosition) {
        return !SpielfeldArray[yPosition][xPosition].bombe || SpielfeldArray[yPosition][xPosition].Zustand != 'T';
    }

    public boolean UeberpruefenSpielGewonnen() {
        int anzahl = 0;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (SpielfeldArray[i][j].bombe) {
                    if (SpielfeldArray[i][j].Zustand == 'M') {
                        anzahl += 1;
                    }
                } else if (SpielfeldArray[i][j].Zustand == 'T') {
                    anzahl += 1;
                }
            }
        }
        return anzahl != 64;
    }
}