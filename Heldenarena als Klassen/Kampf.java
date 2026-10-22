import java.util.Random;

public abstract class Kampf {

    protected Random random;

    public Kampf(Random random) {
        this.random = random;
    }

    // Der gemeinsame Start für jede Kampfart
    public void starten() {

        System.out.println();
        System.out.println("=== " + getName() + " ===");

        kampfAusfuehren();
    }

    // Jede Kampfart muss einen eigenen Namen haben
    public abstract String getName();

    // Jede Kampfart muss festlegen, wie sie abläuft
    protected abstract void kampfAusfuehren();
}