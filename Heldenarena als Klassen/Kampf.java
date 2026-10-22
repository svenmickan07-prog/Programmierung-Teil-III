import java.util.Random;

public abstract class Kampf {

    protected Random zufall;

    public Kampf(Random zufall) {
        this.zufall = zufall;
    }

    public void starten() {

        System.out.println();
        System.out.println("=== " + getName() + " ===");

        ausfuehren();
    }

    // Die konkrete Kampfart füllt diese beiden Lücken selbst
    protected abstract String getName();

    protected abstract void ausfuehren();
}