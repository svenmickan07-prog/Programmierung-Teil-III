public class Held {

    // Werte des Helden
    String name;
    int hp;
    int angriff;
    int ruestung;

    // Konstruktor
    public Held(String name, int hp, int angriff, int ruestung) {
        this.name = name;
        this.hp = hp;
        this.angriff = angriff;
        this.ruestung = ruestung;
    }

    // Held anzeigen
    public void anzeigen() {
        System.out.println("Name: " + name + " | Lebenspunkte: " + hp + " | Angriff: " + angriff + " | Rüstung: " + ruestung);
    }
}
