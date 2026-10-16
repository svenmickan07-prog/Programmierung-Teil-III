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

        // Rüstung der Helden anlegen
        ArrayList<Integer> Ruestung = new ArrayList<>();

        Ruestung.add(3); // Bjorn
        Ruestung.add(0); // Mira
        Ruestung.add(0); // Kael
        Ruestung.add(3); // Luna

        // Rollen der Helden anlegen
        ArrayList<String> Rollen = new ArrayList<>();

        Rollen.add("Krieger");
        Rollen.add("Magier");
        Rollen.add("Bogenschütze");
        Rollen.add("Krieger");

        // Anzahl der Angriffe zählen
        ArrayList<Integer> angriffe = new ArrayList<>();

        angriffe.add(0); // Bjorn
        angriffe.add(0); // Mira
        angriffe.add(0); // Kael
        angriffe.add(0); // Luna

        Scanner scanner = new Scanner(System.in);

        // Zufall erstellen
        Random random = new Random(42);

        int auswahl;

        // Menü starten
        do {
            System.out.println();
            System.out.println("=== Arena Version 2 ===");
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
                for (int i = 0; i < Carakter.size(); i++) {
                    System.out.println((i + 1) + " - " + Carakter.get(i) + " | Rolle: " + Rollen.get(i) + " | Lebenspunkte: " + Lebenspunkte.get(i) + " | Angriff: " + Angriff.get(i) + " | Rüstung: " + Ruestung.get(i));
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

                String str = Carakter.get(Helden - 1);
                String rol = Rollen.get(Helden - 1);
                int punkte = Lebenspunkte.get(Helden - 1);
                int ruestung = Ruestung.get(Helden -1);
                int angriff = Angriff.get(Helden - 1);

                // Ersten Helden anzeigen
                System.out.println("Erster Held:");
                System.out.println("Name: " + str);
                System.out.println("Rolle: " + rol);
                System.out.println("Lebenspunkte: " + punkte);
                System.out.println("Rüstung: " + ruestung);
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
                String rol2 = Rollen.get(Helden2 - 1);
                int punkte2 = Lebenspunkte.get(Helden2 - 1);
                int ruestung2 = Ruestung.get(Helden2 -1);
                int angriff2 = Angriff.get(Helden2 - 1);


                // Zweiten Helden anzeigen
                System.out.println("Zweiter Held:");
                System.out.println("Name: " + str2);
                System.out.println("Rolle: " + rol2);
                System.out.println("Lebenspunkte: " + punkte2);
                System.out.println("Rüstung: " + ruestung2);
                System.out.println("Angriff: " + angriff2);

                // Auf Enter warten
                System.out.println("Drücke Enter, um den Kampf zu starten...");
                scanner.nextLine();
                scanner.nextLine();

                // Angriffszähler zurücksetzen
                angriffe.set(Helden - 1, 0);
                angriffe.set(Helden2 - 1, 0);

                // Kampf starten
                System.out.println("=== Kampf beginnt ===");
                System.out.println(str + " kämpft gegen " + str2);

                while (punkte > 0 && punkte2 > 0) {

                    // Angriff von Held 1 zählen
                    angriffe.set(Helden - 1, angriffe.get(Helden - 1) + 1);

                    // Angriff Held 1
                    int schaden = angriff + random.nextInt(5);

                    // Besonderheit Magier: Jeder 4. Angriff macht doppelten Schaden
                    if (Rollen.get(Helden - 1).equals("Magier")
                            && angriffe.get(Helden - 1) % 4 == 0) {

                        schaden = schaden * 2;
                        System.out.println("Magier-Bonus! Doppelter Schaden.");
                    }

                    // Besonderheit Bogenschütze: Jeder 3. Angriff macht 3 Schaden mehr
                    if (Rollen.get(Helden - 1).equals("Bogenschütze")
                            && angriffe.get(Helden - 1) % 3 == 0) {

                        schaden = schaden + 8;
                        System.out.println("Bogenschütze-Bonus! Plus 8 Schaden.");
                    }

                    // Rüstung wird vom Schaden abgezogen
                    int echterSchaden = schaden - ruestung2;

                    // Schaden darf nicht negativ werden
                    if (echterSchaden < 0) {
                        echterSchaden = 0;
                    }

                    // Lebenspunkte abziehen
                    punkte2 = punkte2 - echterSchaden;


                    System.out.println(str + " hat " + str2 + " " + schaden + " hat zugefügt. " + str2 + " hat noch " + punkte2 + " Lebenspunkte.");

                    if (punkte2 <= 0) {
                        System.out.println("=== Kampf beendet ===");
                        System.out.println("Gewinner: " + str);
                        break;
                    }

                    // Angriff von Held 2 zählen
                    angriffe.set(Helden2 - 1, angriffe.get(Helden2 - 1) + 1);

                    // Angriff Held 2
                    schaden = angriff2 + random.nextInt(5);

                    // Besonderheit Magier: Jeder 4. Angriff macht doppelten Schaden
                    if (Rollen.get(Helden2 - 1).equals("Magier")
                            && angriffe.get(Helden2 - 1) % 4 == 0) {

                        schaden = schaden * 2;
                        System.out.println("Magier-Bonus! Doppelter Schaden.");
                    }

                    // Besonderheit Bogenschütze: Jeder 3. Angriff macht 3 Schaden mehr
                    if (Rollen.get(Helden2 - 1).equals("Bogenschütze")
                            && angriffe.get(Helden2 - 1) % 3 == 0) {

                        schaden = schaden + 8;
                        System.out.println("Bogenschütze-Bonus! Plus 3 Schaden.");
                    }

                    // Rüstung wird vom Schaden abgezogen
                    echterSchaden = schaden - ruestung;

                    if (echterSchaden < 0) {
                        echterSchaden = 0;
                    }

                    // Lebenspunkte abziehen
                    punkte = punkte - echterSchaden;

                    System.out.println(str2 + " hat " + str + " " + schaden + " hat zugefügt. " + str + " hat noch " + punkte + " Lebenspunkte.");

                    if (punkte <= 0) {
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
                System.out.println("=== Turnier startet ===");

                int siegerKampf1 = -1;
                int siegerKampf2 = -1;
                int gesamtSieger = -1;

                System.out.println("Kampf 1: " + Carakter.get(0) + " gegen " + Carakter.get(1));

                System.out.println();
                System.out.println("=== Kampf 1 ===");

                // Kampf 1: Bjorn gegen Mira
                int held1 = 0;
                int held2 = 1;

                // Lebenspunkte neu laden
                int hp1 = Lebenspunkte.get(held1);
                int hp2 = Lebenspunkte.get(held2);

                // Angriffszähler zurücksetzen
                angriffe.set(held1, 0);
                angriffe.set(held2, 0);

                // Auf Enter warten
                System.out.println("Drücke Enter, um den Kampf zu starten...");
                scanner.nextLine();
                scanner.nextLine();

                while (hp1 > 0 && hp2 > 0) {

                    // Bjorn greift an
                    angriffe.set(held1, angriffe.get(held1) + 1);

                    int schaden = Angriff.get(held1) + random.nextInt(5);

                    // Tatsächlicher Schaden nach Rüstung
                    int echterSchaden = schaden - Ruestung.get(held2);

                    if (echterSchaden < 0) {
                        echterSchaden = 0;
                    }

                    hp2 = hp2 - echterSchaden;

                    System.out.println(Carakter.get(held1) + " hat " + Carakter.get(held2) + " " + schaden + " Schaden zugefügt. " + Carakter.get(held2) + " hat noch " + hp2 + " Lebenspunkte.");

                    // Prüfen, ob Bjorn gewonnen hat
                    if (hp2 <= 0) {
                        siegerKampf1 = held1;
                        break;
                    }

                    // Mira greift an
                    angriffe.set(held2, angriffe.get(held2) + 1);

                    schaden = Angriff.get(held2) + random.nextInt(5);

                    // Miras Magier-Bonus
                    if (Rollen.get(held2).equals("Magier")
                            && angriffe.get(held2) % 4 == 0) {

                        schaden = schaden * 2;
                        System.out.println("Magier-Bonus! Doppelter Schaden.");
                    }

                    // Tatsächlicher Schaden nach Rüstung
                    echterSchaden = schaden - Ruestung.get(held1);

                    if (echterSchaden < 0) {
                        echterSchaden = 0;
                    }

                    hp1 = hp1 - echterSchaden;

                    System.out.println(Carakter.get(held2) + " hat " + Carakter.get(held1) + " " + schaden + " Schaden zugefügt. " + Carakter.get(held1) + " hat noch " + hp1 + " Lebenspunkte.");

                    // Prüfen, ob Mira gewonnen hat
                    if (hp1 <= 0) {
                        siegerKampf1 = held2;
                        break;
                    }
                }

                System.out.println("Sieger Kampf 1: " + Carakter.get(siegerKampf1));

                System.out.println();

                System.out.println("Kampf 2: " + Carakter.get(2) + " gegen " + Carakter.get(3));

                System.out.println();
                System.out.println("=== Kampf 2 ===");

                int held3 = 2; // Kael
                int held4 = 3; // Luna

                int hp3 = Lebenspunkte.get(held3);
                int hp4 = Lebenspunkte.get(held4);

                // Angriffszähler zurücksetzen
                angriffe.set(held3, 0);
                angriffe.set(held4, 0);

                // Auf Enter warten
                System.out.println("Drücke Enter, um den Kampf zu starten...");
                scanner.nextLine();
                scanner.nextLine();

                while (hp3 > 0 && hp4 > 0) {

                    // Kael greift an
                    angriffe.set(held3, angriffe.get(held3) + 1);

                    int schaden = Angriff.get(held3) + random.nextInt(5);

                    // Bogenschützen-Bonus
                    if (Rollen.get(held3).equals("Bogenschütze")
                            && angriffe.get(held3) % 3 == 0) {

                        schaden = schaden + 8;
                        System.out.println("Bogenschützen-Bonus! +8 Schaden.");
                    }

                    // Lunas Rüstung berücksichtigen
                    int echterSchaden = schaden - Ruestung.get(held4);

                    if (echterSchaden < 0) {
                        echterSchaden = 0;
                    }

                    hp4 = hp4 - echterSchaden;

                    System.out.println(Carakter.get(held3) + " hat " + Carakter.get(held4) + " " + schaden + " Schaden zugefügt. " + Carakter.get(held4) + " hat noch " + hp4 + " Lebenspunkte.");

                    // Prüfen, ob Kael gewonnen hat
                    if (hp4 <= 0) {
                        siegerKampf2 = held3;
                        break;
                    }


                    // Luna greift an
                    angriffe.set(held4, angriffe.get(held4) + 1);

                    schaden = Angriff.get(held4) + random.nextInt(5);

                    // Kaels Rüstung berücksichtigen
                    echterSchaden = schaden - Ruestung.get(held3);

                    if (echterSchaden < 0) {
                        echterSchaden = 0;
                    }

                    hp3 = hp3 - echterSchaden;

                    System.out.println(Carakter.get(held4) + " hat " + Carakter.get(held3) + " " + schaden + " Schaden zugefügt. " + Carakter.get(held3) + " hat noch " + hp3 + " Lebenspunkte.");

                    // Prüfen, ob Luna gewonnen hat
                    if (hp3 <= 0) {
                        siegerKampf2 = held4;
                        break;
                    }
                }

                System.out.println("Sieger Kampf 2: " + Carakter.get(siegerKampf2));

                // Finale vorbereiten
                System.out.println();
                System.out.println("=== Finale ===");

                int finalist1 = siegerKampf1;
                int finalist2 = siegerKampf2;

                // Lebenspunkte für das Finale zurücksetzen
                int hpFinale1 = Lebenspunkte.get(finalist1);
                int hpFinale2 = Lebenspunkte.get(finalist2);

                // Angriffszähler zurücksetzen
                angriffe.set(finalist1, 0);
                angriffe.set(finalist2, 0);

                System.out.println(Carakter.get(finalist1) + " gegen " + Carakter.get(finalist2));

                // Auf Enter warten
                System.out.println("Drücke Enter, um den Kampf zu starten...");
                scanner.nextLine();
                scanner.nextLine();

                while (hpFinale1 > 0 && hpFinale2 > 0) {

                    // Angriff Finalist 1 zählen
                    angriffe.set(finalist1, angriffe.get(finalist1) + 1);

                    // Schaden berechnen
                    int schaden = Angriff.get(finalist1) + random.nextInt(5);

                    // Magier Bonus
                    if (Rollen.get(finalist1).equals("Magier")
                            && angriffe.get(finalist1) % 4 == 0) {

                        schaden = schaden * 2;
                        System.out.println("Magier-Bonus! Doppelter Schaden.");
                    }

                    // Bogenschützen Bonus
                    if (Rollen.get(finalist1).equals("Bogenschütze")
                            && angriffe.get(finalist1) % 3 == 0) {

                        schaden = schaden + 8;
                        System.out.println("Bogenschützen-Bonus! +8 Schaden.");
                    }

                    // Rüstung von Finalist 2
                    int echterSchaden = schaden - Ruestung.get(finalist2);

                    if (echterSchaden < 0) {
                        echterSchaden = 0;
                    }

                    hpFinale2 = hpFinale2 - echterSchaden;

                    System.out.println(Carakter.get(finalist1) + " hat " + Carakter.get(finalist2) + " " + schaden + " Schaden zugefügt. " + Carakter.get(finalist2) + " hat noch " + hpFinale2 + " Lebenspunkte.");

                    // Hat Finalist 1 gewonnen?
                    if (hpFinale2 <= 0) {
                        gesamtSieger = finalist1;
                        break;
                    }

                    // Angriff Finalist 2 zählen
                    angriffe.set(finalist2, angriffe.get(finalist2) + 1);

                    // Schaden berechnen
                    schaden = Angriff.get(finalist2) + random.nextInt(5);

                    // Magier-Bonus
                    if (Rollen.get(finalist2).equals("Magier")
                            && angriffe.get(finalist2) % 4 == 0) {

                        schaden = schaden * 2;
                        System.out.println("Magier-Bonus! Doppelter Schaden.");
                    }

                    // Bogenschützen-Bonus
                    if (Rollen.get(finalist2).equals("Bogenschütze")
                            && angriffe.get(finalist2) % 3 == 0) {

                        schaden = schaden + 8;
                        System.out.println("Bogenschützen-Bonus! +8 Schaden.");
                    }

                    // Rüstung von Finalist 1 abziehen
                    echterSchaden = schaden - Ruestung.get(finalist1);

                    if (echterSchaden < 0) {
                        echterSchaden = 0;
                    }

                    // Lebenspunkte abziehen
                    hpFinale1 = hpFinale1 - echterSchaden;

                    System.out.println(Carakter.get(finalist2) + " hat " + Carakter.get(finalist1) + " " + schaden + " Schaden zugefügt. " + Carakter.get(finalist1) + " hat noch " + hpFinale1 + " Lebenspunkte.");

                    // Hat Finalist 2 gewonnen?
                    if (hpFinale1 <= 0) {
                        gesamtSieger = finalist2;
                        break;
                    }

                }

                System.out.println();
                System.out.println("=== Turnier beendet ===");
                System.out.println("Gesamtsieger: " + Carakter.get(gesamtSieger));

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
}