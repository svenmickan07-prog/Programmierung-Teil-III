public class Main {

    public static void main(String[] args) {

        // Testheld erstellen
        Held bjorn = new Held("Bjorn", 120, 10, 3, "Krieger");
        Held mira = new Held("Mira", 80, 14, 0, "Magier");

        // Held anzeigen
        bjorn.anzeigen();
        mira.anzeigen();
    }
}