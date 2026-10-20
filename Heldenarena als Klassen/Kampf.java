import java.util.Random;

public class Kampf {

    // Zwei Helden kämpfen gegeneinander
    public static Held starten(Held held1, Held held2, Random random) {

        // Beide Helden vor dem Kampf zurücksetzen
        held1.zuruecksetzen();
        held2.zuruecksetzen();

        // Held 1 greift zuerst an
        Held angreifer = held1;
        Held verteidiger = held2;

        // Kämpfen, bis der Verteidiger besiegt wurde
        while (!verteidiger.istBesiegt()) {

            // Aktueller Angreifer greift an
            angreifer.greiftAn(verteidiger, random);

            // Kampf beenden, wenn der Verteidiger besiegt wurde
            if (verteidiger.istBesiegt()) {
                break;
            }

            // Angreifer vor dem Tauschen zwischenspeichern
            Held zwischenSpeicher = angreifer;

            // Der bisherige Verteidiger wird zum Angreifer
            angreifer = verteidiger;

            // Der bisherige Angreifer wird zum Verteidiger
            verteidiger = zwischenSpeicher;
        }

        // Der Angreifer hat den letzten Treffer ausgeführt
        Held gewinner = angreifer;

        System.out.println("Gewinner: " + gewinner.getName());

        // Beide Helden nach dem Kampf zurücksetzen
        held1.zuruecksetzen();
        held2.zuruecksetzen();

        // Gewinner an Einzelkampf oder Turnier zurückgeben
        return gewinner;
    }
}