class Drink extends MenuItem {
    private boolean upsized;
    private String iceLevel;

    public Drink(String name, double price, double calories, boolean upsized) {
        super(name, price, calories); // price comes from MenuItem
        this.upsized = upsized;
        setType("Drink");
        iceLevel = "Regular Ice";
    }

    public void setIceLevel(String level) {
        iceLevel = level;
    }

    public void setUpsized(boolean upsized) {
        this.upsized = upsized;
    }

    public String getIceLevel() {
        return iceLevel;
    }

    public boolean getUpsized() {
        return upsized;
    }

    public void reset() {
        upsized = false;
        iceLevel = "Regular Ice";
    }
}