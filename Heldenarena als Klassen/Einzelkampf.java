import java.util.Random;

public class Einzelkampf extends Kampf {

    private Held held1;
    private Held held2;
    private Held gewinner;

    public Einzelkampf(Held held1, Held held2, Random random) {

        super(random);

        this.held1 = held1;
        this.held2 = held2;
    }

    @Override
    public String getName() {
        return "Kampf";
    }

    @Override
    protected void kampfAusfuehren() {

        held1.zuruecksetzen();
        held2.zuruecksetzen();

        Held angreifer = held1;
        Held verteidiger = held2;

        System.out.println(held1.getName() + " kämpft gegen " + held2.getName());

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

        gewinner = angreifer;

        System.out.println("Gewinner: " + gewinner.getName());

        held1.zuruecksetzen();
        held2.zuruecksetzen();
    }

    public Held getGewinner() {
        return gewinner;
    }
}