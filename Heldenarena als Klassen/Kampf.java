import java.util.Random;

public class Kampf {

    public static Held starten(Held held1, Held held2, Random random) {

        // Vor jedem Kampf zurücksetzen
        held1.zuruecksetzen();
        held2.zuruecksetzen();

        // Kämpfen, solange beide Helden leben
        while (!held1.istBesiegt() && !held2.istBesiegt()) {

            // Held 1 greift an
            held1.greiftAn(held2, random);

            // Hat Held 1 gewonnen?
            if (held2.istBesiegt()) {

                System.out.println("Gewinner: " + held1.getName());

                // Gewinner merken
                Held gewinner = held1;

                // Beide für später zurücksetzen
                held1.zuruecksetzen();
                held2.zuruecksetzen();

                return gewinner;
            }

            // Held 2 greift an
            held2.greiftAn(held1, random);

            // Hat Held 2 gewonnen?
            if (held1.istBesiegt()) {

                System.out.println("Gewinner: " + held2.getName());

                // Gewinner merken
                Held gewinner = held2;

                // Beide für später zurücksetzen
                held1.zuruecksetzen();
                held2.zuruecksetzen();

                return gewinner;
            }
        }

        return null;
    }
}