public class Magier extends Held {

    private static final int BONUS_ALLE_N_ANGRIFFE = 4;
    private static final int SCHADENS_FAKTOR = 2;

    public Magier(String name, int lebensPunkte, int angriff, int ruestung) {
        super(name, lebensPunkte, angriff, ruestung, Rolle.MAGIER);
    }

    @Override
    protected int besonderheitAnwenden(int schaden) {

        // Jeder vierte eigene Angriff macht doppelten Schaden
        if (getAngriffsZaehler() % BONUS_ALLE_N_ANGRIFFE == 0) {
            System.out.println("Magier-Bonus! Doppelter Schaden.");
            return schaden * SCHADENS_FAKTOR;
        }

        return schaden;
    }
}