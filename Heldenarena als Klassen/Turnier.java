import java.util.ArrayList;
import java.util.Random;

public class Turnier extends Kampf {

    private static final int MINDESTENS_HELDEN = 2;

    private ArrayList<Held> helden;

    public Turnier(ArrayList<Held> helden, Random zufall) {

        super(zufall);

        this.helden = helden;
    }

    @Override
    protected String getName() {
        return "Turnier";
    }

    @Override
    protected void ausfuehren() {

        if (helden.size() < MINDESTENS_HELDEN) {
            System.out.println("Für ein Turnier werden mindestens zwei Helden benötigt.");
            return;
        }

        // Die originale Heldenliste soll beim Turnier erhalten bleiben
        ArrayList<Held> aktuelleRunde = new ArrayList<>(helden);

        int rundenNummer = 1;

        while (aktuelleRunde.size() > 1) {

            System.out.println();
            System.out.println("=== Turnierrunde " + rundenNummer + " ===");

            aktuelleRunde = rundeSpielen(aktuelleRunde);

            rundenNummer++;
        }

        System.out.println("Gesamtsieger: " + aktuelleRunde.get(0).getName());
    }

    private ArrayList<Held> rundeSpielen(ArrayList<Held> aktuelleRunde) {

        ArrayList<Held> naechsteRunde = new ArrayList<>();

        for (int i = 0; i < aktuelleRunde.size(); i = i + 2) {

            // Bei ungerader Anzahl kommt der letzte Held ohne Kampf weiter
            if (i + 1 >= aktuelleRunde.size()) {

                Held freilos = aktuelleRunde.get(i);

                System.out.println(freilos.getName() + " hat ein Freilos und kommt weiter.");

                naechsteRunde.add(freilos);

                continue;
            }

            Held ersterHeld = aktuelleRunde.get(i);
            Held zweiterHeld = aktuelleRunde.get(i + 1);

            Einzelkampf kampf = new Einzelkampf(ersterHeld, zweiterHeld, zufall);

            kampf.starten();

            // Nur der Gewinner kommt in die nächste Runde
            naechsteRunde.add(kampf.getGewinner());
        }

        return naechsteRunde;
    }
}