import java.util.ArrayList;
import java.util.Random;

public class Turnier {

    public static void starten(ArrayList<Held> helden, Random random) {

        if (helden.size() < 2) {

            System.out.println("Für ein Turnier werden mindestens zwei Helden benötigt.");

            return;
        }

        System.out.println();
        System.out.println("=== Turnier startet ===");

        // Kopie der Heldenliste
        ArrayList<Held> aktuelleRunde = new ArrayList<>(helden);

        int runde = 1;

        // Spielen bis nur noch ein Held übrig ist
        while (aktuelleRunde.size() > 1) {

            System.out.println();
            System.out.println("=== Turnierrunde " + runde + " ===");

            ArrayList<Held> naechsteRunde = new ArrayList<>();

            // Immer zwei Helden kämpfen gegeneinander
            for (int i = 0; i < aktuelleRunde.size(); i = i + 2) {

                // Wenn kein Gegner mehr vorhanden ist, gibt es ein Freilos
                if (i + 1 >= aktuelleRunde.size()) {

                    Held freilos = aktuelleRunde.get(i);

                    System.out.println(freilos.getName() + " hat ein Freilos und kommt weiter.");

                    naechsteRunde.add(freilos);

                    continue;
                }

                Held held1 = aktuelleRunde.get(i);
                Held held2 = aktuelleRunde.get(i + 1);

                System.out.println();
                System.out.println(held1.getName() + " gegen " + held2.getName());

                Held sieger = Kampf.starten(held1, held2, random);

                // Gewinner kommt eine Runde weiter
                naechsteRunde.add(sieger);
            }

            aktuelleRunde = naechsteRunde;

            runde++;
        }

        Held gesamtSieger = aktuelleRunde.get(0);

        System.out.println();
        System.out.println("=== Turnier beendet ===");
        System.out.println("Gesamtsieger: " + gesamtSieger.getName());
    }
}