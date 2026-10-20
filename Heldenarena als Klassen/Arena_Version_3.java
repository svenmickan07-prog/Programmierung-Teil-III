import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Arena_Version_3 {

    public static void main(String[] args) {

        // Helden erstellen
        ArrayList<Held> helden = HeldenFactory.erzeugeStandardHelden();

        Scanner scanner = new Scanner(System.in);

        // Ein Random für das ganze Programm
        Random random = new Random(42);

        int auswahl = -1;

        while (auswahl != 0) {

            System.out.println();
            System.out.println("=== Arena Version 3 ===");
            System.out.println("1 - Helden anzeigen");
            System.out.println("2 - Kampf starten");
            System.out.println("3 - Turnier starten");
            System.out.println("0 - Programm beenden");
            System.out.print("Wähle einen Menüpunkt: ");

            // Menüeingabe prüfen
            if (scanner.hasNextInt()) {

                auswahl = scanner.nextInt();

            } else {

                System.out.println("Bitte nur Zahlen eingeben.");

                scanner.next();

                auswahl = -1;
            }

            // Helden anzeigen
            if (auswahl == 1) {

                System.out.println();
                System.out.println("=== Verfügbare Helden ===");

                for (Held held : helden) {

                    held.anzeigen();
                }
            }

            // Einzelkampf
            if (auswahl == 2) {

                System.out.println();
                System.out.println("=== Verfügbare Helden ===");

                for (int i = 0; i < helden.size(); i++) {

                    System.out.println((i + 1) + " - " + helden.get(i).getName());
                }

                Held held1 = heldAuswaehlen(scanner, helden, null, "Wähle den ersten Helden: ");

                Held held2 = heldAuswaehlen(scanner, helden, held1, "Wähle den zweiten Helden: ");

                System.out.println();
                System.out.println("Erster Held:");

                held1.anzeigen();

                System.out.println();
                System.out.println("Zweiter Held:");

                held2.anzeigen();

                // Rest von nextInt entfernen
                scanner.nextLine();

                System.out.println();
                System.out.println("Drücke Enter, um den Kampf zu starten...");

                scanner.nextLine();

                System.out.println();
                System.out.println("=== Kampf beginnt ===");

                System.out.println(held1.getName() + " kämpft gegen " + held2.getName());

                Kampf.starten(held1, held2, random);

                System.out.println("Die Helden wurden zurückgesetzt.");
            }

            // Turnier
            if (auswahl == 3) {

                Turnier.starten(helden, random);
            }

            // Programm beenden
            if (auswahl == 0) {

                System.out.println();
                System.out.println("Das Programm wurde beendet.");
            }

            // Falsche Auswahl
            if (auswahl < 0 || auswahl > 3) {

                System.out.println("Ungültige Auswahl. Wähle 0, 1, 2 oder 3.");
            }
        }

        scanner.close();
    }

    // Wird für Held 1 und Held 2 benutzt
    public static Held heldAuswaehlen(Scanner scanner, ArrayList<Held> helden, Held ausgeschlossenerHeld, String text) {

        Held ausgewaehlterHeld = null;

        while (ausgewaehlterHeld == null) {

            System.out.print(text);

            if (scanner.hasNextInt()) {

                int nummer = scanner.nextInt();

                if (nummer < 1 || nummer > helden.size()) {

                    System.out.println("Ungültige Nummer.");

                    continue;
                }

                Held held = helden.get(nummer - 1);

                if (held == ausgeschlossenerHeld) {

                    System.out.println("Dieser Held wurde bereits gewählt.");

                    continue;
                }

                ausgewaehlterHeld = held;

            } else {

                System.out.println("Bitte nur Zahlen eingeben.");

                scanner.next();
            }
        }

        return ausgewaehlterHeld;
    }
}