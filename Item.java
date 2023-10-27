
public class Item extends Menu {
    long price;

    public Item(String name, String description, long price) {
        super(name, description);
        this.price = price;
    }
}