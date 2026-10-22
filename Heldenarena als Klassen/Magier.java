public class Magier extends Held {

    public Magier(String name, int hp, int angriff, int ruestung) {
        super(name, hp, angriff, ruestung, Rolle.MAGIER);
    }

    @Override
    protected int besonderheitAnwenden(int schaden) {

        // Jeder vierte Angriff macht doppelten Schaden
        if (getAngriffsZaehler() % 4 == 0) {
            System.out.println("Magier-Bonus! Doppelter Schaden.");
            return schaden * 2;
        }

        return schaden;
    }
}