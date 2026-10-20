public class Magier extends Held {

    // Konstruktor des Magiers
    public Magier(
            String name,
            int hp,
            int angriff,
            int ruestung) {

        // Konstruktor der Oberklasse Held aufrufen
        super(name, hp, angriff, ruestung, "Magier");
    }

    // Eigene Sonderregel des Magiers
    @Override
    protected int sonderregelAnwenden(int schaden) {

        // Jeder vierte Angriff macht doppelten Schaden
        if (getAngriffsZaehler() % 4 == 0) {
            System.out.println("Magier-Bonus! Doppelter Schaden.");
            return schaden * 2;
        }

        // Bei allen anderen Angriffen bleibt der Schaden normal
        return schaden;
    }
}