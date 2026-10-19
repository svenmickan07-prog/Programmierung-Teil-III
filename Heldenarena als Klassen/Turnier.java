import java.util.ArrayList;
import java.util.Random;

public class Turnier {

    public static void starten(ArrayList<Held> helden, Random random) {

        System.out.println();
        System.out.println("=== Turnier startet ===");

        // Kampf 1
        // Bjorn gegen Mira
        System.out.println();
        System.out.println("=== Kampf 1 ===");

        System.out.println(helden.get(0).getName() + " gegen " + helden.get(1).getName());

        Held siegerKampf1 = Kampf.starten(helden.get(0), helden.get(1), random);

        // Kampf 2
        // Kael gegen Luna-

        System.out.println();
        System.out.println("=== Kampf 2 ===");

        System.out.println(helden.get(2).getName() + " gegen " + helden.get(3).getName());

        Held siegerKampf2 = Kampf.starten(helden.get(2), helden.get(3), random);


        // Finale
        System.out.println();
        System.out.println("=== Finale ===");

        System.out.println(siegerKampf1.getName() + " gegen " + siegerKampf2.getName());

        Held gesamtSieger = Kampf.starten(siegerKampf1, siegerKampf2, random);

        // Gesamtsieger
        System.out.println();
        System.out.println("=== Turnier beendet ===");

        System.out.println("Gesamtsieger: " + gesamtSieger.getName());
    }
}
