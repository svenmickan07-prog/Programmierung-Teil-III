import java.util.Random;

public class StandardVerhalten implements Kampfverhalten {

    @Override
    public int berechneSchaden(Held held, Random random) {

        return held.getAngriff() + random.nextInt(5);
    }
}