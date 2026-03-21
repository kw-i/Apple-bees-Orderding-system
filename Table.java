import java.util.ArrayList;

class Table {
    private int tableNumber;
    private boolean occupied;
    private boolean orderFinished;
    private ArrayList<MenuItem> orders;

    public Table(int tableNumber) {
        this.tableNumber = tableNumber;
        this.occupied = false;
        this.orderFinished = false;
        this.orders = new ArrayList<>();
    }

    public int getTableNumber() { return tableNumber; }
    public boolean isOccupied() { return occupied; }
    public void setOccupied(boolean occupied) { this.occupied = occupied; }

    public boolean isOrderFinished() { return orderFinished; }
    public void setOrderFinished(boolean finished) { this.orderFinished = finished; }

    public ArrayList<MenuItem> getOrders() { return orders; }

    public void clearTable() {
        for (MenuItem item : orders) {
            if (item instanceof Drink) {
                ((Drink) item).reset(); // revert upsizing and ice
            }
            if (item instanceof MainCourse) {
                ((MainCourse) item).setSpicy(false); // optional reset
            }
            if (item instanceof Dessert) {
                ((Dessert) item).setSugarFree(false); // optional reset
            }
        }
        orders.clear();
        occupied = false;
        orderFinished = false;
    }
}