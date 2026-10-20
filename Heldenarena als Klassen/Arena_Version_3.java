import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Arena_Version_3 {
    public static void main(String[] args) {

        // Liste für alle Helden erstellen
        ArrayList<Held> helden = new ArrayList<>();

        // Bjorn als normalen Helden erstellen
        helden.add(new Held("Bjorn", 120, 10, 3, "Krieger"));
        // Mira als echtes Magier-Objekt erstellen
        helden.add(new Magier("Mira", 80, 14, 0));
        // Kael als normalen Helden mit Bogenschützen-Rolle erstellen
        helden.add(new Held("Kael", 100, 12, 0, "Bogenschütze"));
        // Luna als normalen Helden erstellen
        helden.add(new Held("Luna", 90, 13, 3, "Krieger"));

        // Scanner für Benutzereingaben erstellen
        Scanner scanner = new Scanner(System.in);

        // Einen gemeinsamen Random mit Seed 42 erstellen
        Random random = new Random(42);

        int auswahl = -1;

        // Menü läuft, solange nicht 0 eingegeben wurde
        while (auswahl != 0) {

            System.out.println();
            System.out.println("=== Arena Version 3 ===");
            System.out.println("1 - Helden anzeigen");
            System.out.println("2 - Kampf starten");
            System.out.println("3 - Turnier starten");
            System.out.println("0 - Programm beenden");
            System.out.print("Wähle einen Menüpunkt: ");

            // Prüfen, ob eine Zahl eingegeben wurde
            if (scanner.hasNextInt()) {
                auswahl = scanner.nextInt();

            } else {
                System.out.println("Bitte nur Zahlen eingeben.");

                // Falsche Eingabe entfernen
                scanner.next();
                auswahl = -1;
            }

            // Menüpunkt 1: Helden anzeigen
            if (auswahl == 1) {
                System.out.println();
                System.out.println("=== Verfügbare Helden ===");

                for (Held held : helden) {
                    held.anzeigen();
                }
            }

            // Menüpunkt 2: Einzelkampf starten
            if (auswahl == 2) {
                System.out.println();
                System.out.println("=== Verfügbare Helden ==="
                );

                // Helden mit Nummer anzeigen
                for (int i = 0;
                     i < helden.size();
                     i++) {

                    System.out.println((i + 1) + " - " + helden.get(i).getName());
                }

                // Ersten Helden auswählen
                Held held1 = heldAuswaehlen(scanner, helden, null, "Wähle den ersten Helden: ");

                // Zweiten Helden auswählen
                Held held2 = heldAuswaehlen(scanner, helden, held1, "Wähle den zweiten Helden: ");

                System.out.println();
                System.out.println("Erster Held:");

                held1.anzeigen();

                System.out.println();
                System.out.println("Zweiter Held:");

                held2.anzeigen();

                // Restlichen Zeilenumbruch nach nextInt entfernen
                scanner.nextLine();

                // Auf das Drücken von Enter warten
                System.out.println();
                System.out.println("Drücke Enter, um den Kampf zu starten...");
                scanner.nextLine();

                System.out.println();
                System.out.println("=== Kampf beginnt ===");

                System.out.println(held1.getName() + " kämpft gegen " + held2.getName());

                // Einzelkampf starten
                Kampf.starten(held1, held2, random);

                System.out.println("Die Lebenspunkte und Angriffszähler " + "wurden zurückgesetzt.");
            }

            // Menüpunkt 3: Turnier starten
            if (auswahl == 3) {
                Turnier.starten(helden, random);
            }

            // Menüpunkt 0: Programm beenden
            if (auswahl == 0) {
                System.out.println();
                System.out.println("Das Programm wurde beendet.");
            }

            // Ungültige Menüauswahl
            if (auswahl < 0 || auswahl > 3) {
                System.out.println("Ungültige Auswahl. " + "Wähle 0, 1, 2 oder 3.");
            }
        }

        // Scanner am Programmende schließen
        scanner.close();
    }

    // Einen Helden sicher auswählen
    public static Held heldAuswaehlen(
            Scanner scanner,
            ArrayList<Held> helden,
            Held ausgeschlossenerHeld,
            String aufforderung) {

        Held ausgewaehlterHeld = null;

        // Schleife läuft, bis ein gültiger Held gewählt wurde
        while (ausgewaehlterHeld == null) {

            System.out.print(aufforderung);

            // Prüfen, ob eine Zahl eingegeben wurde
            if (scanner.hasNextInt()) {

                int heldNummer = scanner.nextInt();
                // Prüfen, ob die Nummer im erlaubten Bereich liegt
                if (heldNummer < 1 || heldNummer > helden.size()) {

                    System.out.println("Ungültige Nummer.");

                    continue;
                }

                // Gewählten Helden aus der Liste holen
                Held moeglicherHeld = helden.get(heldNummer - 1);

                // Prüfen, ob dieser Held bereits gewählt wurde
                if (moeglicherHeld == ausgeschlossenerHeld) {

                    System.out.println("Dieser Held wurde bereits gewählt.");

                    continue;
                }

                // Gültigen Helden speichern
                ausgewaehlterHeld = moeglicherHeld;

            } else {

                System.out.println("Bitte nur Zahlen eingeben.");

                // Ungültige Eingabe entfernen
                scanner.next();
            }
        }

        // Ausgewählten Helden zurückgeben
        return ausgewaehlterHeld;
    }
}