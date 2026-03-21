import java.util.ArrayList;
//The purpose of this file sir is just for simple use of the classes
//Disregard this as this was just for testing
public class SimpleMenuDisplay {
    public static void main(String[] args) {
        //Appetizers
        ArrayList<MenuItem> appetizers = new ArrayList<>();
        appetizers.add(new Appetizer("Mozzarella Sticks", 5.99, 350));
        appetizers.add(new Appetizer("Buffalo Wings", 7.49, 450));
        appetizers.add(new Appetizer("Onion Rings", 6.49, 400));
        //Main Courses
        ArrayList<MenuItem> mainCourses = new ArrayList<>();
        MainCourse burger = new MainCourse("BBQ Bacon Burger", 900, 12.99);
        burger.setSpicy(false);
        mainCourses.add(burger);
        MainCourse steak = new MainCourse("Grilled Sirloin", 650, 18.99);
        steak.setSpicy(true);
        mainCourses.add(steak);
        mainCourses.add(new MainCourse("Chicken Alfredo Pasta", 700, 14.49));
        //Side Dishes
        ArrayList<MenuItem> sideDishes = new ArrayList<>();
        sideDishes.add(new SideDish("French Fries", 2.99, 300, true));
        sideDishes.add(new SideDish("Mashed Potatoes", 3.49, 250, false));
        sideDishes.add(new SideDish("Coleslaw", 2.49, 180, false));
        //Drinks
        ArrayList<MenuItem> drinks = new ArrayList<>();
        drinks.add(new Drink("Coke", 1.99, 150, false));
        drinks.add(new Drink("Lemonade", 2.49, 120, true));
        drinks.add(new Drink("Iced Tea", 2.29, 100, false));
        //Desserts
        ArrayList<MenuItem> desserts = new ArrayList<>();
        desserts.add(new Dessert("Cheesecake", 4.99, 450, true));
        desserts.add(new Dessert("Brownie", 3.99, 500, false));
        desserts.add(new Dessert("Ice Cream Sundae", 4.49, 400, true));
        //Display all menu items
        System.out.println("--- Appetizers ---");
        for (MenuItem item : appetizers) {
            System.out.println(item.getName() + " - $" + item.getPrice() + ", " + (int)item.getCalories() + " cal");
        }
        System.out.println("\n--- Main Courses ---");
        for (MenuItem item : mainCourses) {
            MainCourse main = (MainCourse) item;
            String spicyText = main.isSpicy() ? " (Spicy)" : "";
            System.out.println(main.getName() + spicyText + " - $" + main.getPrice() + ", " + (int)main.getCalories() + " cal");
        }
        System.out.println("\n--- Side Dishes ---");
        for (MenuItem item : sideDishes) {
            SideDish side = (SideDish) item;
            String refillText = side.isRefillable() ? " (Refillable)" : "";
            System.out.println(side.getName() + refillText + " - $" + side.getPrice() + ", " + (int)side.getCalories() + " cal");
        }
        System.out.println("\n--- Drinks ---");
        for (MenuItem item : drinks) {
            Drink drink = (Drink) item;
            String upsizedText = drink.getUpsized() ? ", Upsized" : "";
            System.out.println(drink.getName() + " - $" + drink.getPrice() + ", " + (int)drink.getCalories() + " cal, Ice: " + drink.getIceLevel() + upsizedText);
        }
        System.out.println("\n--- Desserts ---");
        for (MenuItem item : desserts) {
            Dessert dessert = (Dessert) item;
            String sugarText = dessert.isSugarFree() ? " (Sugar Free)" : "";
            System.out.println(dessert.getName() + " - $" + dessert.getPrice() + ", " + (int)dessert.getCalories() + " cal" + sugarText);
        }
    }
}