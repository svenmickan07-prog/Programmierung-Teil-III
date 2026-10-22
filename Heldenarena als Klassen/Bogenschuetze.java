public class Bogenschuetze extends Held {

    private static final int BONUS_ALLE_N_ANGRIFFE = 3;
    private static final int BONUS_SCHADEN = 8;

    public Bogenschuetze(String name, int lebensPunkte, int angriff, int ruestung) {
        super(name, lebensPunkte, angriff, ruestung, Rolle.BOGENSCHUETZE);
    }

    @Override
    protected int besonderheitAnwenden(int schaden) {

        // Jeder dritte eigene Angriff bekommt 8 Schaden dazu
        if (getAngriffsZaehler() % BONUS_ALLE_N_ANGRIFFE == 0) {
            System.out.println("Bogenschützen-Bonus! Plus 8 Schaden.");
            return schaden + BONUS_SCHADEN;
        }

        return schaden;
    }
}

