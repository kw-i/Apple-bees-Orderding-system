import java.util.ArrayList;
class MealPackage extends MenuItem {
    private ArrayList<MenuItem> items; // Items in the fixed meal

    public MealPackage(String name, double price, double calories, ArrayList<MenuItem> items) {
        super(name, price, calories);
        setType("Meal Package");
        this.items = items;
    }

    public ArrayList<MenuItem> getItems() {
        return items;
    }
}