package spielfeld;


public class Zelle implements ZelleSchnittstelle {
    public boolean bombe = ZelleSchnittstelle.bombe;
    public char Zustand = ZelleSchnittstelle.Zustand;
    public int AnzahlAngrenzendeBombe = ZelleSchnittstelle.AnzahlAngrenzendeBombe;

    void BombeSetzen() {
        bombe = true;
    }
}
