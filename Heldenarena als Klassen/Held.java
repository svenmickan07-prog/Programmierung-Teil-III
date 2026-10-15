import java.util.Random;

public class Held {

    // Werte des Helden
    String name;
    int hp;
    int startHp;
    int angriff;
    int ruestung;

    // Konstruktor
    public Held(String name, int hp, int angriff, int ruestung) {
        this.name = name;
        this.hp = hp;
        this.startHp = hp;
        this.angriff = angriff;
        this.ruestung = ruestung;
    }

    // Held anzeigen
    public void anzeigen() {
        System.out.println("Name: " + name + " | Lebenspunkte: " + hp + " | Angriff: " + angriff + " | Rüstung: " + ruestung);
    }

    // Held greift einen anderen Helden an
    public void greiftAn(Held ziel, Random random) {

        // Schaden berechnen
        int schaden = angriff + random.nextInt(5);

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
    }


}
