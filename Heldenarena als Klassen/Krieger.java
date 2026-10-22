public class Krieger extends Held {

    public Krieger(String name, int lebensPunkte, int angriff, int ruestung) {
        super(name, lebensPunkte, angriff, ruestung, Rolle.KRIEGER);
    }

    @Override
    protected int besonderheitAnwenden(int schaden) {

        // Die höhere Rüstung ist die Besonderheit des Kriegers
        return schaden;
    }
}