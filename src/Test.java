import java.util.Scanner;
import java.util.ArrayList;
import java.util.Random;

public class Test {
    public static void main(String[] args) {

        // Helden anlegen
        ArrayList<String> Carakter = new ArrayList<>();

        Carakter.add("Bjorn");
        Carakter.add("Mira");
        Carakter.add("Kael");
        Carakter.add("Luna");

        // Lebenspunkte anlegen
        ArrayList<Integer> Lebenspunkte = new ArrayList<>();

        Lebenspunkte.add(120);
        Lebenspunkte.add(80);
        Lebenspunkte.add(100);
        Lebenspunkte.add(90);

        // Angriffswerte anlegen
        ArrayList<Integer> Angriff = new ArrayList<>();

        Angriff.add(10);
        Angriff.add(14);
        Angriff.add(12);
        Angriff.add(13);

        // Rollen der Helden anlegen
        ArrayList<String> Rollen = new ArrayList<>();

        Rollen.add("Krieger");
        Rollen.add("Magier");
        Rollen.add("Bogenschütze");
        Rollen.add("Krieger");

        Scanner scanner = new Scanner(System.in);

        // Zufall erstellen
        Random random = new Random(42);

        int auswahl;

        // Menü starten
        do {
            System.out.println();
            System.out.println("=== Arena Version 1 ===");
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
            for (int i = 0; i < Carakter.size(); i++) {
                System.out.println((i + 1) + " - " + Carakter.get(i) + " | Rolle: " + Rollen.get(i) + " | Lebenspunkte: " + Lebenspunkte.get(i) + " | Angriff: " + Angriff.get(i));
            }

            // Kampf starten
            if (auswahl == 2) {

                System.out.println();
                System.out.println("=== Verfügbare Helden ===");
                System.out.println("1 - Bjorn");
                System.out.println("2 - Mira");
                System.out.println("3 - Kael");
                System.out.println("4 - Luna");

                // Ersten Helden auswählen
                int Helden;

                do {
                    System.out.print("Wähle den ersten Helden: ");


                    if (scanner.hasNextInt()) {
                        Helden = scanner.nextInt();

                        if (Helden < 1 || Helden > 4) {
                            System.out.println("Ungültige Nummer.");
                        }

                    } else {
                        System.out.println("Bitte nur Zahlen eingeben.");
                        scanner.next();
                        Helden = 0;
                    }

                } while (Helden < 1 || Helden > 4);

                String str = Carakter.get(Helden - 1);
                int punkte = Lebenspunkte.get(Helden - 1);
                int angriff = Angriff.get(Helden - 1);

                // Ersten Helden anzeigen
                System.out.println("Erster Held:");
                System.out.println("Name: " + str);
                System.out.println("Lebenspunkte: " + punkte);
                System.out.println("Angriff: " + angriff);

                // Zweiten Helden auswählen
                int Helden2;

                do {
                    System.out.print("Wähle den zweiten Helden: ");

                    if (scanner.hasNextInt()) {
                        Helden2 = scanner.nextInt();

                        if (Helden2 < 1 || Helden2 > 4) {
                            System.out.println("Ungültige Nummer.");
                        }

                        if (Helden2 == Helden) {
                            System.out.println(
                                    "Dieser Held wurde bereits gewählt."
                            );
                        }

                    } else {
                        System.out.println("Bitte nur Zahlen eingeben.");
                        scanner.next();
                        Helden2 = 0;
                    }

                } while (Helden2 == Helden || Helden2 < 1 || Helden2 > 4);

                String str2 = Carakter.get(Helden2 - 1);
                int punkte2 = Lebenspunkte.get(Helden2 - 1);
                int angriff2 = Angriff.get(Helden2 - 1);

                // Zweiten Helden anzeigen
                System.out.println("Zweiter Held:");
                System.out.println("Name: " + str2);
                System.out.println("Lebenspunkte: " + punkte2);
                System.out.println("Angriff: " + angriff2);

                // Auf Enter warten
                System.out.println("Drücke Enter, um den Kampf zu starten...");
                scanner.nextLine();
                scanner.nextLine();

                // Kampf starten
                System.out.println("=== Kampf beginnt ===");
                System.out.println(str + " kämpft gegen " + str2);

                while (punkte > 0 && punkte2 > 0) {

                    // Angriff Held 1
                    int schaden = angriff + random.nextInt(5);

                    punkte2 = punkte2 - schaden;

                    System.out.println(str + " hat " + str2 + " " + schaden + " hat zugefügt. " + str2 + " hat noch " + punkte2 + "Lebenspunkte.");

                    if (punkte2 <= 0) {
                        System.out.println("=== Kampf beendet ===");
                        System.out.println("Gewinner: " + str);
                        break;
                    }

                    // Angriff Held 2
                    schaden = angriff2 + random.nextInt(5);

                    punkte = punkte - schaden;

                    System.out.println(str2 + " hat " + str + " " + schaden + " hat zugefügt. " + str + " hat noch " + punkte + "Lebenspunkte.");

                    if (punkte2 <= 0) {
                        System.out.println("=== Kampf beendet ===");
                        System.out.println("Gewinner: " + str2);
                        break;
                    }
                }

                // Lebenspunkte werden beim nächsten Kampf
                // wieder neu aus der Liste geladen
                System.out.println(
                        "Die Lebenspunkte wurden wieder aufgefüllt.");
            }

            // Turnier starten
            if (auswahl == 3) {
                System.out.println();
                System.out.println("Geht noch nicht geh woanders spielen");
            }

            // Programm beenden
            if (auswahl == 0) {
                System.out.println();
                System.out.println("Das Programm wurde beendet.");
            }

            // Ungültiger Menüpunkt
            else {
                System.out.println("Ungültige Auswahl. Wähle 0, 1, 2 oder 3.");
            }

        } while (auswahl != 0);
    }
}