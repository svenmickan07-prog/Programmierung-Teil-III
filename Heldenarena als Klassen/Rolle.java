public enum Rolle {

    KRIEGER("Krieger"),
    MAGIER("Magier"),
    BOGENSCHUETZE("Bogenschütze");

    private String name;

    Rolle(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}