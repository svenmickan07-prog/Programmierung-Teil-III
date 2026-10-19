import java.util.Random;

public class Held {

    // Werte des Helden
    private String name;
    private int hp;
    private int startHp;
    private int angriff;
    private int ruestung;
    private String rolle;
    private int angriffsZaehler;

    // Konstruktor
    public Held(String name, int hp, int angriff, int ruestung, String rolle) {
        this.name = name;
        this.hp = hp;
        this.startHp = hp;
        this.angriff = angriff;
        this.ruestung = ruestung;
        this.rolle = rolle;
        this.angriffsZaehler = 0;
    }

    // Getter
    public String getName() {
        return name;
    }

    public String getRolle() {
        return rolle;
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

    // Schaden bekommen
    public void nimmSchaden(int schaden) {
        hp = hp - schaden;
    }

    // Prüfen, ob der Held besiegt wurde
    public boolean istBesiegt() {
        return hp <= 0;
    }

    // Informationen des Helden anzeigen
    public void anzeigen() {
        System.out.println("Name: " + name + " | Rolle: " + rolle + " | Lebenspunkte: " + hp + " | Angriff: " + angriff + " | Rüstung: " + ruestung);
    }

    // Einen anderen Helden angreifen
    public void greiftAn(Held ziel, Random random) {

        // Angriff zählen
        angriffsZaehler++;

        // Basisschaden
        int schaden = angriff + random.nextInt(5);

        // Magier: Jeder 4. Angriff macht doppelten Schaden
        if (rolle.equals("Magier") && angriffsZaehler % 4 == 0) {
            schaden = schaden * 2;
            System.out.println("Magier-Bonus! Doppelter Schaden.");
        }

        // Bogenschütze: Jeder 3. Angriff macht 8 Schaden mehr
        if (rolle.equals("Bogenschütze") && angriffsZaehler % 3 == 0) {
            schaden = schaden + 8;
            System.out.println("Bogenschütze-Bonus! Plus 8 Schaden.");
        }

        // Rüstung des Gegners berücksichtigen
        int echterSchaden = schaden - ziel.getRuestung();

        // Schaden darf nicht negativ sein
        if (echterSchaden < 0) {
            echterSchaden = 0;
        }

        // Gegner bekommt Schaden
        ziel.nimmSchaden(echterSchaden);

        // Angriff ausgeben
        System.out.println(name + " hat " + ziel.getName() + " " + schaden + " Schaden zugefügt. " + ziel.getName() + " hat noch " + ziel.getHp() + " Lebenspunkte.");
    }

    // Held zurücksetzen
    public void zuruecksetzen() {
        hp = startHp;
        angriffsZaehler = 0;
    }
}