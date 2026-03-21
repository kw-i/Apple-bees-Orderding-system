class Appetizer extends MenuItem {
    private String servingTemp;

    public Appetizer(String name, double price, double calories) {
        super(name, price, calories);
        setType("Appetizer");
        servingTemp = "Hot";
    }
    public void setServingTemp(String temp) {
        servingTemp = temp;
    }
    public String getServingTemp() {
        return servingTemp;
    }
}