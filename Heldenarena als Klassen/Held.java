import java.util.Random;

public class Held {

    // Eigenschaften des Helden
    private String name;
    private int hp;
    private int startHp;
    private int angriff;
    private int ruestung;
    private String rolle;
    private int angriffsZaehler;

    // Konstruktor
    public Held(
            String name,
            int hp,
            int angriff,
            int ruestung,
            String rolle) {

        this.name = name;
        this.hp = hp;
        this.startHp = hp;
        this.angriff = angriff;
        this.ruestung = ruestung;
        this.rolle = rolle;
        this.angriffsZaehler = 0;
    }

    // Name zurückgeben
    public String getName() {
        return name;
    }

    // Lebenspunkte zurückgeben
    public int getHp() {
        return hp;
    }

    // Angriffswert zurückgeben
    public int getAngriff() {
        return angriff;
    }

    // Rüstung zurückgeben
    public int getRuestung() {
        return ruestung;
    }

    // Rolle zurückgeben
    public String getRolle() {
        return rolle;
    }

    // Angriffszähler für Unterklassen zurückgeben
    protected int getAngriffsZaehler() {
        return angriffsZaehler;
    }

    // Schaden von den Lebenspunkten abziehen
    public void nimmSchaden(int schaden) {
        hp = hp - schaden;
    }

    // Prüfen, ob der Held besiegt wurde
    public boolean istBesiegt() {
        return hp <= 0;
    }

    // Informationen zum Helden anzeigen
    public void anzeigen() {
        System.out.println("Name: " + name + " | Rolle: " + rolle + " | Lebenspunkte: " + hp + " | Angriff: " + angriff + " | Rüstung: " + ruestung);
    }

    // Einen anderen Helden angreifen
    public void greiftAn(Held ziel, Random random) {

        // Angriffszähler zuerst erhöhen
        angriffsZaehler++;

        // Basisschaden mit genau einem Zufallsaufruf
        int schaden = angriff + random.nextInt(5);

        // Bogenschütze bekommt bei jedem dritten Angriff 8 Schaden dazu
        if (rolle.equals("Bogenschütze") && angriffsZaehler % 3 == 0) {
            schaden = schaden + 8;
            System.out.println("Bogenschützen-Bonus! Plus 8 Schaden.");
        }

        // Unterklassen können eine eigene Sonderregel anwenden
        schaden = sonderregelAnwenden(schaden);

        // Rüstung des Verteidigers vom Schaden abziehen
        int echterSchaden = schaden - ziel.getRuestung();

        // Schaden darf nicht negativ werden
        if (echterSchaden < 0) {
            echterSchaden = 0;
        }

        // Tatsächlichen Schaden von den HP abziehen
        ziel.nimmSchaden(echterSchaden);

        // Tatsächlich abgezogenen Schaden ausgeben
        System.out.println(name + " hat " + ziel.getName() + " " + echterSchaden + " Schaden zugefügt. " + ziel.getName() + " hat noch " + ziel.getHp() + " Lebenspunkte.");
    }

    // Normale Helden verändern den Schaden nicht
    protected int sonderregelAnwenden(int schaden) {
        return schaden;
    }

    // Lebenspunkte und Angriffszähler zurücksetzen
    public void zuruecksetzen() {
        hp = startHp;
        angriffsZaehler = 0;
    }
}