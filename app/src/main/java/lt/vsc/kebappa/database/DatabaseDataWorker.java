package lt.vsc.kebappa.database;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import lt.vsc.kebappa.Item;
import lt.vsc.kebappa.Order;

public class DatabaseDataWorker {

    private SQLiteDatabase db;
    private DatabaseContract.OrderEntry orderEntry = new DatabaseContract.OrderEntry();
    private DatabaseContract.ItemEntry itemEntry = new DatabaseContract.ItemEntry();

    public DatabaseDataWorker(SQLiteDatabase db) {
        this.db = db;
    }

    public long insertOrder(Order order) {

        Double totalAmount = order.calculateTotalAmount();
        LocalDateTime dateCreated = order.getDateCreated();

        ContentValues values = new ContentValues();
        values.put(orderEntry.COLUMN_TOTALPRICE, totalAmount);
        values.put(orderEntry.COLUMN_DATECREATED, String.valueOf(dateCreated));

        long insertedOrderId = db.insert(orderEntry.TABLE_NAME, null, values);

        order.setOrderId(insertedOrderId);

        for (Item item : order.getAllItemsInThisOrder()) {
            insertItem(item, insertedOrderId);
        }

        return insertedOrderId;
    }

    public long insertItem(Item item, long orderId) {

        ContentValues values = new ContentValues();
        values.put(itemEntry.COLUMN_ORDERID, orderId);
        values.put(itemEntry.COLUMN_PRICEPERITEM, item.price);
        values.put(itemEntry.COLUMN_QUANTITY, item.quantity);

        long insertedId = db.insert(itemEntry.TABLE_NAME, null, values);

        return insertedId;
    }
}
