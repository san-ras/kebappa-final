package lt.vsc.kebappa;

import java.time.LocalDateTime;
import java.util.List;

public class Order {

    public long orderId;
    public double totalAmount = 0;
    public LocalDateTime dateCreated;
    public List<Item> allItemsInThisOrder;


    public Order(List<Item> list) {
        this.allItemsInThisOrder = list;
        this.dateCreated = LocalDateTime.now();
    }

    public double calculateTotalAmount() {
        for (Item item : allItemsInThisOrder) {
            double oneKindPrice = item.price * item.quantity;
            totalAmount += oneKindPrice;
        }
        return totalAmount;
    }

    public long getOrderId() {
        return orderId;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public LocalDateTime getDateCreated() {
        return dateCreated;
    }

    public List<Item> getAllItemsInThisOrder() {
        return allItemsInThisOrder;
    }

    public void setOrderId(long insertedOrderId) {
        orderId = insertedOrderId;
    }
}
