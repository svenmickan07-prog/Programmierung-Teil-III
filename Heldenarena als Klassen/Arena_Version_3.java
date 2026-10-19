import java.util.Scanner;
import java.util.ArrayList;
import java.util.Random;

public class Arena_Version_3 {

    public static void main(String[] args) {

        // Helden als Objekte anlegen
        ArrayList<Held> helden = new ArrayList<>();

        helden.add(new Held("Bjorn", 120, 10, 3, "Krieger"));
        helden.add(new Held("Mira", 80, 14, 0, "Magier"));
        helden.add(new Held("Kael", 100, 12, 0, "Bogenschütze"));
        helden.add(new Held("Luna", 90, 13, 3, "Krieger"));

        // Scanner erstellen
        Scanner scanner = new Scanner(System.in);

        // Ein Random für das gesamte Programm
        Random random = new Random(42);

        int auswahl;

        // Menü starten
        do {

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

            // Einzelkampf starten
            if (auswahl == 2) {

                System.out.println();
                System.out.println("=== Verfügbare Helden ===");

                for (int i = 0; i < helden.size(); i++) {
                    System.out.println((i + 1) + " - " + helden.get(i).getName());
                }


                // Held 1 auswählen
                int heldNummer1 = 0;

                while (heldNummer1 < 1 || heldNummer1 > helden.size()) {

                    System.out.print("Wähle den ersten Helden: ");

                    if (scanner.hasNextInt()) {

                        heldNummer1 = scanner.nextInt();

                        if (heldNummer1 < 1 || heldNummer1 > helden.size()) {
                            System.out.println("Ungültige Nummer.");
                        }

                    } else {

                        System.out.println("Bitte nur Zahlen eingeben.");
                        scanner.next();
                        heldNummer1 = 0;
                    }
                }

                Held held1 = helden.get(heldNummer1 - 1);

                System.out.println();
                System.out.println("Erster Held:");

                held1.anzeigen();

                // Held 2 auswählen
                int heldNummer2 = 0;

                while (heldNummer2 == heldNummer1 || heldNummer2 < 1 || heldNummer2 > helden.size()) {

                    System.out.print("Wähle den zweiten Helden: ");

                    if (scanner.hasNextInt()) {

                        heldNummer2 = scanner.nextInt();

                        if (heldNummer2 < 1 || heldNummer2 > helden.size()) {
                            System.out.println("Ungültige Nummer.");
                        }

                        if (heldNummer2 == heldNummer1) {
                            System.out.println("Dieser Held wurde bereits gewählt.");
                        }

                    } else {

                        System.out.println("Bitte nur Zahlen eingeben.");
                        scanner.next();
                        heldNummer2 = 0;
                    }
                }

                Held held2 = helden.get(heldNummer2 - 1);

                System.out.println();
                System.out.println("Zweiter Held:");

                held2.anzeigen();

                // Auf Enter warten
                System.out.println();
                System.out.println("Drücke Enter, um den Kampf zu starten...");
                scanner.nextLine();
                scanner.nextLine();


                // Kampf starten
                System.out.println();
                System.out.println("=== Kampf beginnt ===");
                System.out.println(held1.getName() + " kämpft gegen " + held2.getName());

                Kampf.starten(held1, held2, random);

                System.out.println("Die Lebenspunkte wurden wieder aufgefüllt.");
            }


            // Turnier starten
            if (auswahl == 3) {

                Turnier.starten(helden, random);
            }

            // Programm beenden
            if (auswahl == 0) {
                System.out.println();
                System.out.println("Das Programm wurde beendet.");
            }

            // Ungültiger Menüpunkt
            if (auswahl < 0 || auswahl > 3) {
                System.out.println("Ungültige Auswahl. " + "Wähle 0, 1, 2 oder 3.");
            }
            

        } while (auswahl != 0);
        scanner.close();
    }
}