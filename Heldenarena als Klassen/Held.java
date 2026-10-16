import java.util.Random;

public class Held {

    // Werte des Helden
    String name;
    int hp;
    int startHp;
    int angriff;
    int ruestung;
    String rolle;
    int angriffe;

    // Konstruktor
    public Held(String name, int hp, int angriff, int ruestung, String rolle) {
        this.name = name;
        this.hp = hp;
        this.startHp = hp;
        this.angriff = angriff;
        this.ruestung = ruestung;
        this.rolle = rolle;
        this.angriffe = 0;
    }

    // Held anzeigen
    public void anzeigen() {
        System.out.println("Name: " + name + " | Lebenspunkte: " + hp + " | Angriff: " + angriff + " | Rüstung: " + ruestung);
    }

    // Held greift einen anderen Helden an
    public void greiftAn(Held ziel, Random random) {

        // Schaden berechnen
        int schaden = angriff + random.nextInt(5);

        // Angriff zählen
        angriffe++;

        // Magier: Jeder 4. Angriff macht doppelten Schaden
        if (rolle.equals("Magier") && angriffe % 4 == 0) {
            schaden = schaden * 2;
            System.out.println("Magier-Bonus! Doppelter Schaden.");
        }

        // Bogenschütze: Jeder 3. Angriff bekommt 8 Schaden dazu
        if (rolle.equals("Bogenschütze") && angriffe % 3 == 0) {
            schaden = schaden + 8;
            System.out.println("Bogenschütze-Bonus! Plus 8 Schaden.");
        }

        // Rüstung des Gegners abziehen
        int echterSchaden = schaden - ziel.ruestung;

        // Schaden darf nicht negativ werden
        if (echterSchaden < 0) {
            echterSchaden = 0;
        }

        // Lebenspunkte des Gegners reduzieren
        ziel.hp = ziel.hp - echterSchaden;

        // Angriff anzeigen
        System.out.println(name + " hat " + ziel.name + " " + schaden + " Schaden zugefügt. " + ziel.name + " hat noch " + ziel.hp + " Lebenspunkte.");
    }

    // Lebenspunkte zurücksetzen
    public void zuruecksetzen() {
        hp = startHp;
        angriffe = 0;
    }


}
