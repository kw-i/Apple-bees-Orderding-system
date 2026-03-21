import java.util.ArrayList;
import java.util.Scanner;

public class OrderingSystem {

    public void start() {
        Scanner sc = new Scanner(System.in);


        ArrayList<Table> tables = new ArrayList<>();
        //for tables, adds new tables
        for (int i = 1; i <= 5; i++) {
            tables.add(new Table(i));
        }

        // Creating menu categories using the class menu item to be used in the loop
        ArrayList<MenuItem> appetizers = new ArrayList<>();
        appetizers.add(new Appetizer("Mozzarella Sticks", 5.99, 350));
        appetizers.add(new Appetizer("Buffalo Wings", 7.49, 450));
        appetizers.add(new Appetizer("Onion Rings", 6.49, 400));
        //main courses
        ArrayList<MenuItem> mainCourses = new ArrayList<>();
        MainCourse burger = new MainCourse("BBQ Bacon Burger", 900, 12.99);
        burger.setSpicy(false);
        mainCourses.add(burger);
        MainCourse steak = new MainCourse("Grilled Sirloin", 650, 18.99);
        steak.setSpicy(true);
        mainCourses.add(steak);
        mainCourses.add(new MainCourse("Chicken Alfredo Pasta", 700, 14.49));
        //side dishess
        ArrayList<MenuItem> sideDishes = new ArrayList<>();
        sideDishes.add(new SideDish("French Fries", 2.99, 300, true));
        sideDishes.add(new SideDish("Mashed Potatoes", 3.49, 250, false));
        sideDishes.add(new SideDish("Coleslaw", 2.49, 180, false));
        //drinks
        ArrayList<MenuItem> drinks = new ArrayList<>();
        drinks.add(new Drink("Coke", 1.99, 150, false));
        drinks.add(new Drink("Lemonade", 2.49, 120, false));
        drinks.add(new Drink("Iced Tea", 2.29, 100, false));
        //desserts
        ArrayList<MenuItem> desserts = new ArrayList<>();
        desserts.add(new Dessert("Cheesecake", 4.99, 450, true));
        desserts.add(new Dessert("Brownie", 3.99, 500, false));
        desserts.add(new Dessert("Ice Cream Sundae", 4.49, 400, true));
        //meal packages
        ArrayList<MenuItem> mealPackages = new ArrayList<>();
        ArrayList<MenuItem> burgerMealItems = new ArrayList<>();
        burgerMealItems.add(new MainCourse("BBQ Bacon Burger", 900, 12.99));
        burgerMealItems.add(new SideDish("French Fries", 2.99, 300, true));
        burgerMealItems.add(new Drink("Coke", 1.99, 150, false));
        MealPackage burgerMeal = new MealPackage("BBQ Burger Meal", 17.99, 1350, burgerMealItems);
        mealPackages.add(burgerMeal);
        ArrayList<MenuItem> healthyMealItems = new ArrayList<>();
        healthyMealItems.add(new MainCourse("Grilled Chicken Breast", 400, 13.99));
        healthyMealItems.add(new SideDish("Steamed Veggies", 150, 4.99, false));
        Dessert cheesecake = new Dessert("Cheesecake", 4.99, 250, false); // default not sugar-free
        healthyMealItems.add(cheesecake);
        MealPackage healthyMeal = new MealPackage("Healthy Meal", 19.99, 800, healthyMealItems);
        mealPackages.add(healthyMeal);

        boolean running = true;
        //Main menu, outer loop
        while (running) {
            System.out.println("\n--- Applebee's Ordering System ---");
            System.out.println("1. Place Order");
            System.out.println("2. View/Modify Order");
            System.out.println("3. Checkout");
            System.out.println("4. View Table Status"); // new option
            System.out.println("5. Clear Table"); // new option
            System.out.println("6. Exit"); // new option
            System.out.print("Choose an option: ");
            int mainChoice = sc.nextInt();

            switch (mainChoice) {
                case 1:
                    //for selecting which tables
                    System.out.print("\nSelect Table (1-5): ");
                    int tableChoice = sc.nextInt();

                    if (tableChoice < 1 || tableChoice > 5) {
                        System.out.println("Invalid table.");
                        continue;
                    }
                    // gets from the arraylist tables
                    Table currentTable = tables.get(tableChoice - 1);

                    // mark table as occupied
                    if (!currentTable.isOccupied()) {
                        currentTable.setOccupied(true);
                    }

                    // Prevent ordering if checkout finished
                    if (currentTable.isOrderFinished()) {
                        System.out.println("This table has already checked out. Please clear it first.");
                        continue;
                    }

                    boolean ordering = true;
                    while (ordering) {//sub menu,inner loop
                        System.out.println("\nSelect a category to order from:");
                        System.out.println("1. Appetizers");
                        System.out.println("2. Main Courses");
                        System.out.println("3. Side Dishes");
                        System.out.println("4. Drinks");
                        System.out.println("5. Desserts");
                        System.out.println("6. Meal Packages");
                        System.out.println("0. Back to Main Menu");
                        System.out.print("Your choice: ");
                        int category = sc.nextInt();
                        //the variable selectedCategory will point to the same arraylist to be used to display
                        ArrayList<MenuItem> selectedCategory = null;

                        switch (category) {
                            case 1:
                                selectedCategory = appetizers;
                                break;
                            case 2:
                                selectedCategory = mainCourses;
                                break;
                            case 3:
                                selectedCategory = sideDishes;
                                break;
                            case 4:
                                selectedCategory = drinks;
                                break;
                            case 5:
                                selectedCategory = desserts;
                                break;
                            case 6:
                                selectedCategory = mealPackages;
                                break;
                            case 0:
                                ordering = false;
                                continue;
                            default:
                                System.out.println("Invalid category choice.");
                                continue;
                        }

                        // Display items in category using the variable selectedCategory that now points to the arraylist that the user inputted
                        // this runs a loop in the selected category that iterates through the items that was determined at the begginign of the program
                        System.out.println("\nSelect an item to order:");
                        for (int i = 0; i < selectedCategory.size(); i++) {
                            MenuItem item = selectedCategory.get(i);
                            System.out.println((i + 1) + ". " + item.getName() + " (" + item.getType() + ") - $" + item.getPrice() + ", " + (int)item.getCalories() + " cal");
                        }
                        System.out.println("0. Back to Categories");
                        System.out.print("Your choice: ");
                        int itemChoice = sc.nextInt();

                        if (itemChoice == 0) continue;//will loop back and display nothing

                        if (itemChoice < 1 || itemChoice > selectedCategory.size()) {//error trapping
                            System.out.println("Invalid item choice.");
                            continue;
                        }
                        //gets the specific menu item from the selected category that was inputted by the user and then added to the table
                        MenuItem selectedItem = selectedCategory.get(itemChoice - 1); //gets an item from SelectedCategory using user input
                        currentTable.getOrders().add(selectedItem); // add item to specific table

                        //for meal package
                        if (selectedItem instanceof MealPackage) {
                            MealPackage meal = (MealPackage) selectedItem;//meal points to the mealpackage selectedItem
                            System.out.println(meal.getName() + " added as a meal order!");
                            for (MenuItem item : meal.getItems()) {
                                // Handle customizations for Drink, Main Course, Dessert for meal package, item is used to iterate through the meal package's individual items to customize through the variable "meal" which points to it
                                if (item instanceof Drink) {
                                    Drink drink = (Drink) item;
                                    System.out.print("Do you want to upsize the drink " + drink.getName() + "? (yes/no): ");
                                    String upsize = sc.next();
                                    if (upsize.equalsIgnoreCase("yes")) {
                                        drink.setUpsized(true);          // mark as upsized
                                    }
                                    System.out.print("Ice level (Regular/Less/None): ");
                                    String ice = sc.next();
                                    drink.setIceLevel(ice);
                                } else if (item instanceof MainCourse) {
                                    MainCourse main = (MainCourse) item;
                                    System.out.print("Do you want this " + main.getName() + " spicy? (yes/no): ");
                                    String spicy = sc.next();
                                    main.setSpicy(spicy.equalsIgnoreCase("yes"));
                                } else if (item instanceof Dessert) {
                                    Dessert dessert = (Dessert) item;
                                    System.out.print("Sugar free for " + dessert.getName() + "? (yes/no): ");
                                    String sugarFree = sc.next();
                                    dessert.setSugarFree(sugarFree.equalsIgnoreCase("yes"));
                                }
                            }
                        } else {
                            // normal customization for drinks/main/desserts, simply edits the attributes to the user's preference like if they want a drink to be upsized and have no ice
                            if (selectedItem.getType().equals("Drink")) {
                                Drink drink = (Drink) selectedItem;
                                System.out.print("Do you want to upsize? (yes/no): ");
                                String upsize = sc.next();
                                if (upsize.equalsIgnoreCase("yes")) {
                                        drink.setUpsized(true);          // mark as upsized
                                    }
                                System.out.print("Ice level (Regular/Less/None): ");
                                String ice = sc.next();
                                drink.setIceLevel(ice);
                            }
                            if (selectedItem.getType().equals("Main Course")) {
                                MainCourse mainCourseItem = (MainCourse) selectedItem;
                                System.out.print("Do you want this spicy? (yes/no): ");
                                String spicy = sc.next();
                                mainCourseItem.setSpicy(spicy.equalsIgnoreCase("yes"));
                            }
                            if (selectedItem.getType().equals("Dessert")) {
                                Dessert dessertItem = (Dessert) selectedItem;
                                System.out.print("Sugar free? (yes/no): ");
                                String sugarFree = sc.next();
                                dessertItem.setSugarFree(sugarFree.equalsIgnoreCase("yes"));
                            }
                        }

                        System.out.println(selectedItem.getName() + " added to your order!");
                    }
                    break;

                case 2:
                    //for selecting tables
                    System.out.print("\nSelect Table (1-5): ");
                    int viewTableChoice = sc.nextInt();

                    if (viewTableChoice < 1 || viewTableChoice > 5) {
                        System.out.println("Invalid table.");
                        break;
                    }

                    Table currentTable2 = tables.get(viewTableChoice - 1);
                    ArrayList<MenuItem> order = currentTable2.getOrders();

                    if (order.isEmpty()) {
                        System.out.println("\nThis table has no orders yet.");
                    } else {
                        System.out.println("\n--- Current Order (Table " + viewTableChoice + ") ---");

                        for (int i = 0; i < order.size(); i++) {
                            MenuItem item = order.get(i);
                            String details = "";

                            if (item.getType().equals("Drink")) {
                                Drink drink = (Drink) item;
                                details = " [Ice level:" + drink.getIceLevel();
                                if (drink.getUpsized()) details += ", Upsized";
                                details += "]";
                            } else if (item.getType().equals("Main Course")) {
                                MainCourse mainCourse = (MainCourse) item;
                                if (mainCourse.isSpicy()) details = " [Spicy]";
                            } else if (item.getType().equals("Dessert")) {
                                Dessert dessert = (Dessert) item;
                                if (dessert.isSugarFree()) details = " [Sugar Free]";
                            }

                            System.out.println((i + 1) + ". " + item.getName() + " (" + item.getType() + ")" + details + " - $" + item.getPrice());
                        }

                        System.out.print("Enter item number to remove it, or 0 to go back: ");
                        int removeChoice = sc.nextInt();

                        if (removeChoice > 0 && removeChoice <= order.size()) {
                            MenuItem removed = order.remove(removeChoice - 1);
                            System.out.println(removed.getName() + " removed.");
                        }
                    }
                    break;

                case 3:
                    System.out.print("\nSelect Table (1-5): ");
                    int checkoutTableChoice = sc.nextInt();

                    if (checkoutTableChoice < 1 || checkoutTableChoice > 5) {
                        System.out.println("Invalid table.");
                        break;
                    }

                    Table currentTable3 = tables.get(checkoutTableChoice - 1);
                    ArrayList<MenuItem> order3 = currentTable3.getOrders();

                    if (order3.isEmpty()) {
                        System.out.println("This table has no orders.");
                    } else {
                        System.out.println("\n--- Final Order (Table " + checkoutTableChoice + ") ---");
                        double total = 0;

                        for (MenuItem item : order3) {
                            String details = "";

                            if (item.getType().equals("Drink")) {
                                Drink drink = (Drink) item;
                                details = " [Ice level:" + drink.getIceLevel();
                                if (drink.getUpsized()) details += ", Upsized";
                                details += "]";
                            } else if (item.getType().equals("Main Course")) {
                                MainCourse mainCourse = (MainCourse) item;
                                if (mainCourse.isSpicy()) details = " [Spicy]";
                            } else if (item.getType().equals("Dessert")) {
                                Dessert dessert = (Dessert) item;
                                if (dessert.isSugarFree()) details = " [Sugar Free]";
                            }

                            System.out.printf("%s (%s)%s - $%.2f\n", item.getName(), item.getType(), details, item.getPrice());
                            total += item.getPrice();
                        }

                        System.out.printf("Total: $%.2f\n", total);
                        System.out.println("Thank you for ordering!");

                        currentTable3.setOrderFinished(true); 
                    }
                    break;

                case 4: // View table status
                    System.out.println("\n--- Table Status ---");
                    for (Table t : tables) {
                        System.out.print("Table " + t.getTableNumber() + ": ");
                        if (!t.isOccupied()) System.out.println("Empty");
                        else if (t.getOrders().isEmpty()) System.out.println("Occupied (No orders yet)");
                        else if (t.isOrderFinished()) System.out.println("Finished (Ready to clear)");
                        else System.out.println("Ordering in progress");
                    }
                    break;

                case 5: // Clear table
                    System.out.print("Enter table number to clear (1-5): ");
                    int clearChoice = sc.nextInt();
                    if (clearChoice < 1 || clearChoice > 5) { System.out.println("Invalid table."); break; }

                    Table tableToClear = tables.get(clearChoice - 1);
                    if (!tableToClear.isOccupied()) System.out.println("Table is already empty.");
                    else {
                        tableToClear.clearTable();
                        System.out.println("Table " + clearChoice + " has been cleared.");
                    }
                    break;

                case 6:
                    System.out.println("Exiting system...");
                    running = false;
                    break;

                default:
                    System.out.println("Invalid main menu choice.");
                    break;
            }
        }

        sc.close();
    }
}