class MenuItem {
    private String name;
    private double price;
    private String type;
    private double calories;

    // Fixed rates
    private static final double VAT_RATE = 0.12;        // 12% VAT
    private static final double SERVICE_FEE_RATE = 0.10; // 10% service fee

    public MenuItem(String name, double price, double calories) {
        this.name = name;
        this.price = price;
        this.calories = calories;
    }

    public void setType(String t) {
        type = t;
    }

    public void setPrice(double p){
        this.price = p;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public String getType() {
        return type;
    }

    public double getCalories(){
        return calories;
    }

    // --- New Methods ---

    public double computeVAT() {
        return price * VAT_RATE;
    }

    public double computeServiceFee() {
        return price * SERVICE_FEE_RATE;
    }

    public double computeGratuity(double gratuityRate) {
        return price * gratuityRate;
    }

    public double computeTotal(double gratuityRate) {
        return price + computeVAT() + computeServiceFee() + computeGratuity(gratuityRate);
    }
}