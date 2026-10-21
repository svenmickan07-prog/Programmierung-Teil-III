import java.util.ArrayList;

public class HeldenFactory {

    public static Held erstellen(Rolle rolle, String name, int hp, int angriff, int ruestung) {

        if (rolle == Rolle.KRIEGER) {
            return new Krieger(name, hp, angriff, ruestung);
        }

        if (rolle == Rolle.MAGIER) {
            return new Magier(name, hp, angriff, ruestung);
        }

        if (rolle == Rolle.BOGENSCHUETZE) {
            return new Bogenschuetze(name, hp, angriff, ruestung);
        }

        throw new IllegalArgumentException("Unbekannte Rolle.");
    }

    public static ArrayList<Held> erzeugeStandardHelden() {

        ArrayList<Held> helden = new ArrayList<>();

        helden.add(erstellen(Rolle.KRIEGER, "Bjorn", 120, 10, 3));
        helden.add(erstellen(Rolle.MAGIER, "Mira", 80, 14, 0));
        helden.add(erstellen(Rolle.BOGENSCHUETZE, "Kael", 100, 12, 0));
        helden.add(erstellen(Rolle.KRIEGER, "Luna", 90, 13, 3));

        return helden;
    }
}