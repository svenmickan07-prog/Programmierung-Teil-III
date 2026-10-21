public class Krieger extends Held {

    public Krieger(String name, int hp, int angriff, int ruestung) {
        super(name, hp, angriff, ruestung, Rolle.KRIEGER);
    }

    @Override
    protected int besonderheitAnwenden(int schaden) {

        // Die Besonderheit des Kriegers ist seine höhere Rüstung
        return schaden;
    }
}
