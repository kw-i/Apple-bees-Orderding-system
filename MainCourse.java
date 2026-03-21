class MainCourse extends MenuItem {
    private boolean spicy;

    public MainCourse(String name, double calories, double price) {
        super(name, price, calories);
        setType("Main Course");
        spicy = false;
    }
    public void setSpicy(boolean s) {
        spicy = s;
    }
    public boolean isSpicy() {
        return spicy;
    }
}