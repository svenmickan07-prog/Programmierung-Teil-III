public class Magier extends Held {

    public Magier(String name, int hp, int angriff, int ruestung, Kampfverhalten verhalten) {

        super(name, hp, angriff, ruestung, Rolle.MAGIER, verhalten);
    }

    @Override
    protected int besonderheitAnwenden(int schaden) {

        // Jeder 4. Angriff macht doppelten Schaden
        if (getAngriffsZaehler() % 4 == 0) {

            System.out.println("Magier-Bonus! Doppelter Schaden.");

            return schaden * 2;
        }

        return schaden;
    }
}
