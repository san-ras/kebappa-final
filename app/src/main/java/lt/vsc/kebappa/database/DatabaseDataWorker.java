package lt.vsc.kebappa.database;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.google.type.DateTime;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

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

    public List<Order> getAllOrders() {
        List<Order> allOrders = new ArrayList<>();
        String[] columns = new String[] {orderEntry.COLUMN_ORDERID, orderEntry.COLUMN_TOTALPRICE, orderEntry.COLUMN_DATECREATED};
        Cursor cursor = db.query(orderEntry.TABLE_NAME, columns, null, null, null, null, null);

        while (cursor.moveToNext()) {
            Order retrievedOrder = retrieveOrderInfo(cursor);
            allOrders.add(retrievedOrder);
        }

        return allOrders;
    }

    private Order retrieveOrderInfo(Cursor cursor) {

        int idIndex = cursor.getColumnIndex(orderEntry.COLUMN_ORDERID);
        int orderId = cursor.getInt(idIndex);

        int priceIndex = cursor.getColumnIndex(orderEntry.COLUMN_TOTALPRICE);
        double totalPrice = cursor.getDouble(priceIndex);

        int dateIndex = cursor.getColumnIndex(orderEntry.COLUMN_DATECREATED);
        String dateCreatedString = cursor.getString(dateIndex);

        return new Order (orderId, totalPrice, dateCreatedString);
    }
}
