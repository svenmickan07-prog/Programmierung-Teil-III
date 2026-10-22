import java.util.ArrayList;
import java.util.Random;

public class Turnier extends Kampf {

    private ArrayList<Held> helden;

    public Turnier(ArrayList<Held> helden, Random random) {

        super(random);

        this.helden = helden;
    }

    @Override
    public String getName() {
        return "Turnier";
    }

    @Override
    protected void kampfAusfuehren() {

        if (helden.size() < 2) {
            System.out.println("Für ein Turnier werden mindestens zwei Helden benötigt.");
            return;
        }

        ArrayList<Held> aktuelleRunde = new ArrayList<>(helden);

        int runde = 1;

        while (aktuelleRunde.size() > 1) {

            System.out.println();
            System.out.println("=== Turnierrunde " + runde + " ===");

            ArrayList<Held> naechsteRunde = new ArrayList<>();

            for (int i = 0; i < aktuelleRunde.size(); i = i + 2) {

                if (i + 1 >= aktuelleRunde.size()) {

                    Held freilos = aktuelleRunde.get(i);

                    System.out.println(freilos.getName() + " hat ein Freilos und kommt weiter.");

                    naechsteRunde.add(freilos);

                    continue;
                }

                Held held1 = aktuelleRunde.get(i);
                Held held2 = aktuelleRunde.get(i + 1);

                Einzelkampf kampf = new Einzelkampf(held1, held2, random);

                kampf.starten();

                naechsteRunde.add(kampf.getGewinner());
            }

            aktuelleRunde = naechsteRunde;

            runde++;
        }

        Held gesamtSieger = aktuelleRunde.get(0);

        System.out.println();
        System.out.println("Gesamtsieger: " + gesamtSieger.getName());
    }
}