import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Arena_Version_3 {

    public static void main(String[] args) {

        // Helden erstellen
        ArrayList<Held> helden = HeldenFactory.erzeugeStandardHelden();

        // Test für equals
        Held bjorn = helden.get(0);

        Held bjorn1 = new Krieger ("Bjorn", 120, 10, 3);

        System.out.println("=== equals Test ===");
        System.out.println("Gleiches Objekt: " + bjorn.equals(bjorn));
        System.out.println("Zwei gleiche Helden: " + bjorn.equals(bjorn1));
        System.out.println("Held gegen Text: " + bjorn.equals("Hallo"));
        System.out.println();


        Scanner scanner = new Scanner(System.in);

        // Ein Random für das gesamte Programm
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

                for (int i = 0; i < helden.size(); i++) {
                    System.out.print((i + 1) + " - ");
                    helden.get(i).anzeigen();
                }
            }

            // Einzelkampf starten
            if (auswahl == 2) {

                System.out.println();
                System.out.println("=== Verfügbare Helden ===");

                for (int i = 0; i < helden.size(); i++) {
                    System.out.println((i + 1) + " - " + helden.get(i).getName());
                }

                Held held1 = heldAuswaehlen(scanner, helden, null, "Wähle den ersten Helden: ");
                Held held2 = heldAuswaehlen(scanner, helden, held1, "Wähle den zweiten Helden: ");

                // Kleinere Nummer greift zuerst an
                if (helden.indexOf(held1) > helden.indexOf(held2)) {

                    Held zwischenSpeicher = held1;
                    held1 = held2;
                    held2 = zwischenSpeicher;
                }

                Einzelkampf kampf = new Einzelkampf(held1, held2, random);

                kampf.starten();
            }

            // Turnier starten
            if (auswahl == 3) {

                Turnier turnier = new Turnier(helden, random);

                turnier.starten();
            }

            // Programm beenden
            if (auswahl == 0) {
                System.out.println();
                System.out.println("Das Programm wurde beendet.");
            }

            // Ungültiger Menüpunkt
            if (auswahl < 0 || auswahl > 3) {
                System.out.println("Ungültige Auswahl. Wähle 0, 1, 2 oder 3.");
            }
        }

        scanner.close();
    }

    // Methode wird für beide Helden verwendet
    public static Held heldAuswaehlen(Scanner scanner, ArrayList<Held> helden, Held ausgeschlossenerHeld, String text) {

        Held ausgewaehlterHeld = null;

        while (ausgewaehlterHeld == null) {

            System.out.print(text);

            if (!scanner.hasNextInt()) {
                System.out.println("Bitte nur Zahlen eingeben.");
                scanner.next();
                continue;
            }

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
        }

        return ausgewaehlterHeld;
    }
}