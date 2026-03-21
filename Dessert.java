class Dessert extends MenuItem {
    private boolean servedCold;
    private boolean sugarFree;

    public Dessert(String name, double price, double calories, boolean servedCold) {
        super(name, price, calories);
        setType("Dessert");
        this.servedCold = servedCold;
        sugarFree = false;
    }
    public void setSugarFree(boolean sf) {
        sugarFree = sf;
    }
    public boolean isServedCold() {
        return servedCold;
    }
    public boolean isSugarFree() {
        return sugarFree;
    }
}