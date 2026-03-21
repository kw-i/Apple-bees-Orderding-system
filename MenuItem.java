class MenuItem {
    private String name;
    private double price;
    private String type;
    private double calories;

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
}