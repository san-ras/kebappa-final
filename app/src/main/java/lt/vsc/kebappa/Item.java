package lt.vsc.kebappa;

public class Item {

    long itemId;
    public String title;
    public double price;
    public int quantity = 1;

    public Item(String givenTitle, double givenPrice) {
        this.price = givenPrice;
        this.title = givenTitle;
    }

    @Override
    public String toString(){
        String info = title + "\r\nKiekis: " + quantity + "\r\nVieneto kaina: " + price + " €";
        return info;
    }
}
