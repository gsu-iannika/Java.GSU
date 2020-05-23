package by.gsu.pms;

public enum Materials {
    STEEL("steel", 7850), COOPER("cooper", 8500);

    private String name;
    private double density;

    Materials(String name, double density) {
        this.name = name;
        this.density = density;
    }

    public double getDensity() {
        return density;
    }

    public String getName() {
        return name;
    }

    public String toString() {

        return name + ";" + String.format("%.1f", density);
    }
}
