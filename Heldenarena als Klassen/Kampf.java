import java.util.Random;

public class Kampf {

    public static Held starten(Held held1, Held held2, Random random) {

        // Beide Helden vor dem Kampf zurücksetzen
        held1.zuruecksetzen();
        held2.zuruecksetzen();

        // Held 1 greift zuerst an
        Held angreifer = held1;
        Held verteidiger = held2;

        while (!verteidiger.istBesiegt()) {

            angreifer.greiftAn(verteidiger, random);

            // Wenn der Verteidiger besiegt ist, ist der Kampf vorbei
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

        // Helden wieder zurücksetzen
        held1.zuruecksetzen();
        held2.zuruecksetzen();

        return gewinner;
    }
}