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

        // Helden anzeigen
        System.out.println("=== Verfügbare Helden ===");
        System.out.println("1 - Bjorn");
        System.out.println("2 - Mira");
        System.out.println("3 - Kael");
        System.out.println("4 - Luna");

        Scanner scanner = new Scanner(System.in);

        // Ersten Helden auswählen
        System.out.print("\nWähle den ersten Helden: ");
        int Helden = scanner.nextInt();

        while (Helden < 1 || Helden > 4) {
            System.out.println("Ungültige Nummer.");
            System.out.print("Bitte erneut wählen: ");
            Helden = scanner.nextInt();
        }

        String str = Carakter.get(Helden - 1);
        int punkte = Lebenspunkte.get(Helden - 1);
        int angriff = Angriff.get(Helden - 1);

        // Ersten Helden anzeigen
        System.out.println("\nErster Held:");
        System.out.println("Name: " + str);
        System.out.println("Lebenspunkte: " + punkte);
        System.out.println("Angriff: " + angriff);

        // Zweiten Helden auswählen
        int Helden2;

        do {
            System.out.print("\nWähle den zweiten Helden: ");
            Helden2 = scanner.nextInt();

            if (Helden2 < 1 || Helden2 > 4) {
                System.out.println("Ungültige Nummer.");
            }

            if (Helden2 == Helden) {
                System.out.println("Dieser Held wurde bereits gewählt.");
            }

        } while (Helden2 == Helden || Helden2 < 1 || Helden2 > 4);

        String str2 = Carakter.get(Helden2 - 1);
        int punkte2 = Lebenspunkte.get(Helden2 - 1);
        int angriff2 = Angriff.get(Helden2 - 1);

        // Zweiten Helden anzeigen
        System.out.println("\nZweiter Held:");
        System.out.println("Name: " + str2);
        System.out.println("Lebenspunkte: " + punkte2);
        System.out.println("Angriff: " + angriff2);

    }
}