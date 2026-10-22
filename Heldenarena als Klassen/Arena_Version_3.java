import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Arena_Version_3 {

    private static final int ZUFALLS_SEED = 42;

    public static void main(String[] args) {

        ArrayList<Held> helden = HeldenFactory.erzeugeStandardHelden();
        Scanner scanner = new Scanner(System.in);

        // Der feste Seed sorgt bei jedem Start für dieselbe Zufallsfolge
        Random zufall = new Random(ZUFALLS_SEED);

        int auswahl = -1;

        while (auswahl != 0) {

            menueAnzeigen();

            if (scanner.hasNextInt()) {
                auswahl = scanner.nextInt();
            } else {
                System.out.println("Bitte nur Zahlen eingeben.");
                scanner.next();
                auswahl = -1;
            }

            if (auswahl == 1) {
                heldenAnzeigen(helden);
            }

            if (auswahl == 2) {
                einzelkampfStarten(scanner, helden, zufall);
            }

            if (auswahl == 3) {
                Turnier turnier = new Turnier(helden, zufall);
                turnier.starten();
            }

            if (auswahl == 0) {
                System.out.println("Das Programm wurde beendet.");
            }

            if (auswahl < 0 || auswahl > 3) {
                System.out.println("Ungültige Auswahl. Wähle 0, 1, 2 oder 3.");
            }
        }

        scanner.close();
    }

    private static void menueAnzeigen() {

        System.out.println();
        System.out.println("=== Arena Version 3 ===");
        System.out.println("1 - Helden anzeigen");
        System.out.println("2 - Kampf starten");
        System.out.println("3 - Turnier starten");
        System.out.println("0 - Programm beenden");
        System.out.print("Wähle einen Menüpunkt: ");
    }

    private static void heldenAnzeigen(ArrayList<Held> helden) {

        System.out.println();
        System.out.println("=== Verfügbare Helden ===");

        for (int i = 0; i < helden.size(); i++) {
            System.out.print((i + 1) + " - ");
            helden.get(i).anzeigen();
        }
    }

    private static void einzelkampfStarten(Scanner scanner, ArrayList<Held> helden, Random zufall) {

        heldenAnzeigen(helden);

        Held ersterHeld = heldAuswaehlen(scanner, helden, null, "Wähle den ersten Helden: ");
        Held zweiterHeld = heldAuswaehlen(scanner, helden, ersterHeld, "Wähle den zweiten Helden: ");

        // Der Held mit der kleineren Nummer beginnt
        if (helden.indexOf(ersterHeld) > helden.indexOf(zweiterHeld)) {
            Held zwischenSpeicher = ersterHeld;
            ersterHeld = zweiterHeld;
            zweiterHeld = zwischenSpeicher;
        }

        Einzelkampf kampf = new Einzelkampf(ersterHeld, zweiterHeld, zufall);
        kampf.starten();
    }

    private static Held heldAuswaehlen(Scanner scanner, ArrayList<Held> helden,
                                       Held ausgeschlossenerHeld, String text) {

        Held ausgewaehlterHeld = null;

        while (ausgewaehlterHeld == null) {

            System.out.print(text);

            if (!scanner.hasNextInt()) {
                System.out.println("Bitte nur Zahlen eingeben.");
                scanner.next();
                continue;
            }

            int heldNummer = scanner.nextInt();

            if (heldNummer < 1 || heldNummer > helden.size()) {
                System.out.println("Ungültige Nummer.");
                continue;
            }

            Held held = helden.get(heldNummer - 1);

            // Derselbe Held darf nicht gegen sich selbst kämpfen
            if (held == ausgeschlossenerHeld) {
                System.out.println("Dieser Held wurde bereits gewählt.");
                continue;
            }

            ausgewaehlterHeld = held;
        }

        return ausgewaehlterHeld;
    }
}