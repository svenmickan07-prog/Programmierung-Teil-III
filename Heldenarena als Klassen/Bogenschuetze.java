public class Bogenschuetze extends Held {

    public Bogenschuetze(String name, int hp, int angriff, int ruestung) {
        super(name, hp, angriff, ruestung, Rolle.BOGENSCHUETZE);
    }

    @Override
    protected int besonderheitAnwenden(int schaden) {

        // Jeder dritte Angriff macht 8 Schaden mehr
        if (getAngriffsZaehler() % 3 == 0) {
            System.out.println("Bogenschützen-Bonus! Plus 8 Schaden.");
            return schaden + 8;
        }

        return schaden;
    }
}
