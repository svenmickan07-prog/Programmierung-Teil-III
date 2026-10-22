import java.util.Random;

public class Einzelkampf extends Kampf {

    private Held ersterHeld;
    private Held zweiterHeld;
    private Held gewinner;

    public Einzelkampf(Held ersterHeld, Held zweiterHeld, Random zufall) {

        super(zufall);

        this.ersterHeld = ersterHeld;
        this.zweiterHeld = zweiterHeld;
    }

    @Override
    protected String getName() {
        return "Kampf";
    }

    @Override
    protected void ausfuehren() {

        kampfVorbereiten();

        Held angreifer = ersterHeld;
        Held verteidiger = zweiterHeld;

        while (!verteidiger.istBesiegt()) {

            angreifer.greiftAn(verteidiger, zufall);

            // Nach jedem Angriff wechseln die beiden ihre Rollen
            if (!verteidiger.istBesiegt()) {
                Held alterAngreifer = angreifer;
                angreifer = verteidiger;
                verteidiger = alterAngreifer;
            }
        }

        kampfBeenden(angreifer);
    }

    private void kampfVorbereiten() {

        // Jeder Kampf beginnt wieder mit den Startwerten
        ersterHeld.zuruecksetzen();
        zweiterHeld.zuruecksetzen();

        System.out.println(ersterHeld.getName() + " kämpft gegen " + zweiterHeld.getName());
    }

    private void kampfBeenden(Held sieger) {

        gewinner = sieger;

        System.out.println("Gewinner: " + gewinner.getName());

        // Die Helden sind danach direkt für den nächsten Kampf bereit
        ersterHeld.zuruecksetzen();
        zweiterHeld.zuruecksetzen();
    }

    public Held getGewinner() {
        return gewinner;
    }
}