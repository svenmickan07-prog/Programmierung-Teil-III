import java.util.Random;

public class Held {

    private String name;
    private int hp;
    private int startHp;
    private int angriff;
    private int ruestung;
    private Rolle rolle;
    private int angriffsZaehler;

    // Jeder Held hat ein Kampfverhalten
    private Kampfverhalten verhalten;

    public Held(String name, int hp, int angriff, int ruestung, Rolle rolle, Kampfverhalten verhalten) {

        this.name = name;
        this.hp = hp;
        this.startHp = hp;
        this.angriff = angriff;
        this.ruestung = ruestung;
        this.rolle = rolle;
        this.verhalten = verhalten;
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

    // Verhalten kann später geändert werden
    public void setVerhalten(Kampfverhalten verhalten) {
        this.verhalten = verhalten;
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

        // Angriff zählen
        angriffsZaehler++;

        // Verhalten berechnet erstmal den normalen Schaden
        int schaden = verhalten.berechneSchaden(this, random);

        // Besonderheit der Heldenart anwenden
        schaden = besonderheitAnwenden(schaden);

        // Rüstung abziehen
        int echterSchaden = schaden - ziel.getRuestung();

        if (echterSchaden < 0) {
            echterSchaden = 0;
        }

        // Schaden vom Gegner abziehen
        ziel.nimmSchaden(echterSchaden);

        System.out.println(name + " hat " + ziel.getName() + " " + echterSchaden + " Schaden zugefügt. " + ziel.getName() + " hat noch " + ziel.getHp() + " Lebenspunkte.");
    }

    // Normalerweise gibt es keine weitere Besonderheit
    protected int besonderheitAnwenden(int schaden) {

        // Bogenschütze bleibt erstmal hier
        if (rolle == Rolle.BOGENSCHUETZE && angriffsZaehler % 3 == 0) {

            System.out.println("Bogenschützen-Bonus! Plus 8 Schaden.");

            return schaden + 8;
        }

        return schaden;
    }

    public void zuruecksetzen() {

        hp = startHp;
        angriffsZaehler = 0;
    }
}