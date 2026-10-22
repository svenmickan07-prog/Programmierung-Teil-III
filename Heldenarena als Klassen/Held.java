import java.util.Random;

public abstract class Held {

    private String name;
    private int hp;
    private int startHp;
    private int angriff;
    private int ruestung;
    private Rolle rolle;
    private int angriffsZaehler;

    public Held(String name, int hp, int angriff, int ruestung, Rolle rolle) {

        this.name = name;
        this.hp = hp;
        this.startHp = hp;
        this.angriff = angriff;
        this.ruestung = ruestung;
        this.rolle = rolle;
        this.angriffsZaehler = 0;
    }

    public String getName() {
        return name;
    }

    public int getHp() {
        return hp;
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

    public void nimmSchaden(int schaden) {
        hp = hp - schaden;
    }

    public boolean istBesiegt() {
        return hp <= 0;
    }

    public void anzeigen() {
        System.out.println("Name: " + name + " | Rolle: " + rolle.getName() + " | Lebenspunkte: " + hp + " | Angriff: " + angriff + " | Rüstung: " + ruestung);
    }

    public void greiftAn(Held ziel, Random random) {

        // Angriff zuerst zählen
        angriffsZaehler++;

        // Angriff plus ein Zufallswert von 0 bis 4
        int schaden = angriff + random.nextInt(5);

        // Besonderheit der Heldenart anwenden
        schaden = besonderheitAnwenden(schaden);

        // Rüstung des Gegners abziehen
        int echterSchaden = schaden - ziel.getRuestung();

        if (echterSchaden < 0) {
            echterSchaden = 0;
        }

        ziel.nimmSchaden(echterSchaden);

        // Ausgabe zeigt den Schaden nach der Rüstung
        System.out.println(name + " hat " + ziel.getName() + " " + echterSchaden + " Schaden zugefügt. " + ziel.getName() + " hat noch " + ziel.getHp() + " Lebenspunkte.");
    }

    // Jede Heldenart legt ihre eigene Besonderheit fest
    protected abstract int besonderheitAnwenden(int schaden);

    public void zuruecksetzen() {
        hp = startHp;
        angriffsZaehler = 0;
    }

    @Override
    public boolean equals(Object obj) {

        // Prüfen, ob es genau dasselbe Objekt ist
        if (this == obj) {
            return true;
        }

        // Prüfen, ob das andere Objekt überhaupt ein Held ist
        if (!(obj instanceof Held)) {
            return false;
        }

        // Object zu Held machen
        Held andererHeld = (Held) obj;

        // Name und Rolle vergleichen
        return name.equals(andererHeld.name)
                && rolle == andererHeld.rolle;
    }

    @Override
    public int hashCode() {

        int ergebnis = name.hashCode();

        ergebnis = 31 * ergebnis + rolle.hashCode();

        return ergebnis;
    }
}