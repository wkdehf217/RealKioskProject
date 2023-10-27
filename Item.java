
public class Item extends Menu {
    long price;
    String id;

    public Item(String name, String description, long price, String id) {
        super(name, description);
        this.price = price;
        this.id = id;
    }
}