import java.util.ArrayList;
import java.util.Random;

public class Turnier {

    // Turnier mit den vorhandenen Helden starten
    public static void starten(ArrayList<Held> helden, Random random) {

        // Prüfen, ob genug Helden vorhanden sind
        if (helden.size() < 2) {
            System.out.println("Für ein Turnier werden mindestens " + "zwei Helden benötigt.");

            return;
        }

        System.out.println();
        System.out.println("=== Turnier startet ===");

        // Kopie der ursprünglichen Heldenliste erstellen
        ArrayList<Held> aktuelleRunde = new ArrayList<>(helden);

        int rundenNummer = 1;

        // Spielen, bis nur noch ein Held übrig ist
        while (aktuelleRunde.size() > 1) {

            System.out.println();

            System.out.println("=== Turnierrunde " + rundenNummer + " ===");

            // Hier werden die Sieger der Runde gespeichert
            ArrayList<Held> naechsteRunde = new ArrayList<>();

            // Immer zwei Helden zu einer Paarung zusammenfassen
            for (int i = 0;
                 i < aktuelleRunde.size();
                 i = i + 2) {

                // Prüfen, ob der letzte Held keinen Gegner mehr hat
                if (i + 1 >= aktuelleRunde.size()) {

                    Held freilos = aktuelleRunde.get(i);

                    System.out.println();
                    System.out.println(freilos.getName() + " hat ein Freilos " + "und kommt weiter.");

                    // Held ohne Gegner kommt direkt weiter
                    naechsteRunde.add(freilos);

                    // Mit dem nächsten Schleifendurchlauf weitermachen
                    continue;
                }

                // Zwei Gegner aus der aktuellen Runde holen
                Held held1 = aktuelleRunde.get(i);

                Held held2 = aktuelleRunde.get(i + 1);

                System.out.println();
                System.out.println(held1.getName() + " gegen " + held2.getName());

                // Kampf starten und Gewinner speichern
                Held sieger = Kampf.starten(held1, held2, random);

                // Sieger kommt in die nächste Runde
                naechsteRunde.add(sieger);
            }

            // Siegerliste wird zur neuen aktuellen Runde
            aktuelleRunde = naechsteRunde;

            // Nummer der Turnierrunde erhöhen
            rundenNummer++;
        }

        // Der letzte verbliebene Held ist der Gesamtsieger
        Held gesamtSieger = aktuelleRunde.get(0);

        System.out.println();
        System.out.println("=== Turnier beendet ===");
        System.out.println("Gesamtsieger: " + gesamtSieger.getName());
    }
}