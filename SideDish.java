class SideDish extends MenuItem {
    private boolean refillable;

    public SideDish(String name, double price, double calories, boolean refillable) {
        super(name, price, calories);
        setType("Side Dish");
        this.refillable = refillable;
    }
    public boolean isRefillable() {
        return refillable;
    }
}