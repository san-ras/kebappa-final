package lt.vsc.kebappa;

import java.util.ArrayList;

public class CartInProgress {

    private static ArrayList<Item> cartItems = new ArrayList<>();

    public static void clear(){
        cartItems.clear();
    }

    public static void add(ArrayList<Item> items) {

        for (Item item : items) {
            cartItems.add(item);
        }
    }

    public static void add(Item item){

        if (cartItems.contains(item)) {
            item.quantity++;
        } else {
            cartItems.add(item);
        }
    }

    public static void remove(Item item){
        cartItems.remove(item);
    }

    public static ArrayList<Item> getCartItems(){
        return cartItems;
    }
}
