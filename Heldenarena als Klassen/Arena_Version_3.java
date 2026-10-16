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

        Scanner scanner = new Scanner(System.in);

        // Zufall erstellen
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

                for (Held hel : helden) {
                    hel.anzeigen();
                }
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

                Held held1 = helden.get(Helden - 1);

                // Ersten Helden anzeigen
                System.out.println("Erster Held:");
                System.out.println("Name: " + held1.name);
                System.out.println("Rolle: " + held1.rolle);
                System.out.println("Lebenspunkte: " + held1.hp);
                System.out.println("Rüstung: " + held1.ruestung);
                System.out.println("Angriff: " + held1.angriff);

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

                Held held2 = helden.get(Helden2 - 1);

                // Zweiten Helden anzeigen
                System.out.println("Zweiter Held:");
                System.out.println("Name: " + held2.name);
                System.out.println("Rolle: " + held2.rolle);
                System.out.println("Lebenspunkte: " + held2.hp);
                System.out.println("Rüstung: " + held2.ruestung);
                System.out.println("Angriff: " + held2.angriff);

                // Auf Enter warten
                System.out.println("Drücke Enter, um den Kampf zu starten...");
                scanner.nextLine();
                scanner.nextLine();

                // Kampf starten
                System.out.println("=== Kampf beginnt ===");
                System.out.println(held1.name + " kämpft gegen " + held2.name);

                while (held1.hp > 0 && held2.hp > 0) {

                    // Held 1 greift an
                    held1.greiftAn(held2, random);

                    // Prüfen, ob Held 2 besiegt ist
                    if (held2.hp <= 0) {
                        System.out.println("=== Kampf beendet ===");
                        System.out.println("Gewinner: " + held1.name);
                        break;
                    }

                    // Held 2 greift an
                    held2.greiftAn(held1, random);

                    // Prüfen, ob Held 1 besiegt ist
                    if (held1.hp <= 0) {
                        System.out.println("=== Kampf beendet ===");
                        System.out.println("Gewinner: " + held2.name);
                        break;
                    }
                }

                // Lebenspunkte für den nächsten Kampf zurücksetzen
                held1.zuruecksetzen();
                held2.zuruecksetzen();

                System.out.println("Die Lebenspunkte wurden wieder aufgefüllt.");
            }

            // Turnier starten
            if (auswahl == 3) {

                System.out.println();
                System.out.println("=== Turnier startet ===");

                // Kampf 1: Bjorn gegen Mira
                System.out.println();
                System.out.println("=== Kampf 1 ===");
                System.out.println(helden.get(0).name + " gegen " + helden.get(1).name);

                Held siegerKampf1 = kampf(helden.get(0), helden.get(1), random);

                // Kampf 2: Kael gegen Luna
                System.out.println();
                System.out.println("=== Kampf 2 ===");
                System.out.println(helden.get(2).name + " gegen " + helden.get(3).name);

                Held siegerKampf2 = kampf(helden.get(2), helden.get(3), random);

                // Finale
                System.out.println();
                System.out.println("=== Finale ===");
                System.out.println(siegerKampf1.name + " gegen " + siegerKampf2.name);

                Held gesamtSieger = kampf(siegerKampf1, siegerKampf2, random);

                // Turniersieger anzeigen
                System.out.println();
                System.out.println("=== Turnier beendet ===");
                System.out.println("Gesamtsieger: " + gesamtSieger.name);
            }

            // Programm beenden
            if (auswahl == 0) {
                System.out.println();
                System.out.println("Das Programm wurde beendet.");
            }

            // Ungültiger Menüpunkt
            if (auswahl >= 4) {
                System.out.println("Ungültige Auswahl. Wähle 0, 1, 2 oder 3.");
            }


        } while (auswahl != 0);
    }

    // Zwei Helden kämpfen gegeneinander
    public static Held kampf(Held held1, Held held2, Random random) {

        // Kämpfen, solange beide noch Lebenspunkte haben
        while (held1.hp > 0 && held2.hp > 0) {

            // Held 1 greift Held 2 an
            held1.greiftAn(held2, random);

            // Prüfen, ob Held 2 besiegt wurde
            if (held2.hp <= 0) {
                System.out.println("Gewinner: " + held1.name);

                held1.zuruecksetzen();
                held2.zuruecksetzen();

                return held1;
            }

            // Held 2 greift Held 1 an
            held2.greiftAn(held1, random);

            // Prüfen, ob Held 1 besiegt wurde
            if (held1.hp <= 0) {
                System.out.println("Gewinner: " + held2.name);

                held1.zuruecksetzen();
                held2.zuruecksetzen();

                return held2;
            }
        }

        return null;
    }


}
