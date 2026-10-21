import java.util.Random;

public class Kampf {

    public static Held starten(Held held1, Held held2, Random random) {

        // Beide Helden starten mit ihren Anfangswerten
        held1.zuruecksetzen();
        held2.zuruecksetzen();

        Held angreifer = held1;
        Held verteidiger = held2;

        while (!verteidiger.istBesiegt()) {

            angreifer.greiftAn(verteidiger, random);

            if (verteidiger.istBesiegt()) {
                break;
            }

            // Angreifer und Verteidiger tauschen
            Held zwischenSpeicher = angreifer;
            angreifer = verteidiger;
            verteidiger = zwischenSpeicher;
        }

        Held gewinner = angreifer;

        System.out.println("Gewinner: " + gewinner.getName());

        // Helden für den nächsten Kampf zurücksetzen
        held1.zuruecksetzen();
        held2.zuruecksetzen();

        return gewinner;
    }
}