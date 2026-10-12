import java.util.Scanner;
import java.util.ArrayList;


public class Arena_Version_1 {
    public static void main(String[] args) {

        //create Integer type arraylist
        ArrayList<String> Carakter = new ArrayList<>();

        // Add elelemts type arraylist
        // add() methode whitout the index paraemter
        Carakter.add("Bjorn");
        Carakter.add("Mira");
        Carakter.add("Kael");
        Carakter.add("Luna");
        // System.out.println("Carakter: "+Carakter);

        //create Integer type arraylist
        ArrayList<Integer> Lebenspunkte = new ArrayList<>();

        // Add elelemts type arraylist
        // add() methode whitout the index paraemter
        Lebenspunkte.add(120);
        Lebenspunkte.add(80);
        Lebenspunkte.add(100);
        Lebenspunkte.add(90);
        // System.out.println("Lebenspunkte: "+Lebenspunkte);

        //create Integer type arraylist
        ArrayList<Integer> Angriff = new ArrayList<>();

        // Add elelemts type arraylist
        // add() methode whitout the index paraemter
        Angriff.add(120);
        Angriff.add(80);
        Angriff.add(100);
        Angriff.add(90);
        // System.out.println("Angriff: "+Angriff);

        System.out.println("Held 0 ist Bjorn");
        System.out.println("Held 1 ist Mira");
        System.out.println("Held 2 ist Kael");
        System.out.println("Held 3 ist Luna");

        Scanner scanner = new Scanner(System.in);

        // Helden wählen
        System.out.print("Wähle eine Helden!");
        int Helden = scanner.nextInt();

        String str = Carakter.get(Helden);
        System.out.println("Carakter:"+str);

        int punkte = Lebenspunkte.get(Helden);
        System.out.println("Lebenspunkte:"+ punkte);

        int angriff = Angriff.get(Helden);
        System.out.println("Angriff:"+ angriff);

        // 2. Helden wählen
        int Helden2;

        do {
            System.out.print("Wähle eine 2. Helden!");
            Helden2 = scanner.nextInt();

            if (Helden2 == Helden) {
                System.out.println("Dieser Held wurde bereits gewählt! Bitte wähle einen anderen.");
            }

        } while (Helden2 == Helden);

        String str2 = Carakter.get(Helden2);
        System.out.println("Carakter:"+str2);

        int punkte2 = Lebenspunkte.get(Helden2);
        System.out.println("Lebenspunkte:"+ punkte2);

        int angriff2 = Angriff.get(Helden2);
        System.out.println("Angriff:"+ angriff2);














        System.out.printf("Leck mich am Arsch");


    }
}
