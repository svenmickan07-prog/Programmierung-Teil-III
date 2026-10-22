import java.util.Random;

public abstract class Held {

    private static final int SCHADENS_SPIELRAUM = 5;

    private String name;
    private int lebensPunkte;
    private int startLebensPunkte;
    private int angriff;
    private int ruestung;
    private Rolle rolle;
    private int angriffsZaehler;

    public Held(String name, int lebensPunkte, int angriff, int ruestung, Rolle rolle) {

        this.name = name;
        this.lebensPunkte = lebensPunkte;
        this.startLebensPunkte = lebensPunkte;
        this.angriff = angriff;
        this.ruestung = ruestung;
        this.rolle = rolle;
        this.angriffsZaehler = 0;
    }

    public String getName() {
        return name;
    }

    public int getLebensPunkte() {
        return lebensPunkte;
    }

    public int getAngriff() {
        return angriff;
    }

    public int getRuestung() {
        return ruestung;
    }

    public Rolle getRolle() {
        return rolle;
    }

    protected int getAngriffsZaehler() {
        return angriffsZaehler;
    }

    public boolean istBesiegt() {
        return lebensPunkte <= 0;
    }

    public void nimmSchaden(int schaden) {
        lebensPunkte = lebensPunkte - schaden;
    }

    public void anzeigen() {
        System.out.println("Name: " + name + " | Rolle: " + rolle.getName()
                + " | Lebenspunkte: " + lebensPunkte + " | Angriff: "
                + angriff + " | Rüstung: " + ruestung);
    }

    public void greiftAn(Held ziel, Random zufall) {

        angriffsZaehler++;

        // Pro Angriff wird genau ein Zufallswert erzeugt
        int schaden = angriff + zufall.nextInt(SCHADENS_SPIELRAUM);

        // Die konkrete Heldenart kümmert sich um ihren eigenen Bonus
        schaden = besonderheitAnwenden(schaden);

        // Die Rüstung wirkt erst nach der Besonderheit
        int echterSchaden = schaden - ziel.getRuestung();

        // Schaden darf einem Helden keine Lebenspunkte geben
        if (echterSchaden < 0) {
            echterSchaden = 0;
        }

        ziel.nimmSchaden(echterSchaden);

        System.out.println(name + " hat " + ziel.getName() + " "
                + echterSchaden + " Schaden zugefügt. " + ziel.getName()
                + " hat noch " + ziel.getLebensPunkte() + " Lebenspunkte.");
    }

    protected abstract int besonderheitAnwenden(int schaden);

    public void zuruecksetzen() {
        lebensPunkte = startLebensPunkte;
        angriffsZaehler = 0;
    }

    @Override
    public boolean equals(Object objekt) {

        // Dasselbe Objekt ist immer gleich
        if (this == objekt) {
            return true;
        }

        // Nur Helden werden miteinander verglichen
        if (!(objekt instanceof Held)) {
            return false;
        }

        Held andererHeld = (Held) objekt;

        return name.equals(andererHeld.name) && rolle == andererHeld.rolle;
    }

    @Override
    public int hashCode() {

        // equals und hashCode benutzen dieselben Werte
        int ergebnis = name.hashCode();
        ergebnis = 31 * ergebnis + rolle.hashCode();

        return ergebnis;
    }
}