package lt.vsc.kebappa;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
import java.util.List;

import lt.vsc.kebappa.database.DatabaseDataWorker;
import lt.vsc.kebappa.database.OpenHelper;

public class CartActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        DatabaseWorker.setupWorker(CartActivity.this);

        ArrayList<Item> cartItems = CartInProgress.getCartItems();

        Button orderButton = findViewById(R.id.orderButtonFinal);

        orderButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (CartInProgress.getCartItems().size() > 0) {

                    Order order = new Order(cartItems);

                    DatabaseWorker.worker.insertOrder(order);

                    CartInProgress.clear();

                    Intent intent = new Intent(CartActivity.this, HistoryActivity.class);
                    intent.putExtra("OrderId", order.getOrderId());
                    startActivity(intent);
                }
            }
        });

        setupListView(cartItems);



        Button cancelButton = findViewById(R.id.cancelButton);

        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                    CartInProgress.clear();


                Intent intent = new Intent(CartActivity.this, MainActivity.class);
                startActivity(intent);

            }
        });


    }




    private void setupListView(List<Item> items) {
        ListView cartList = findViewById(R.id.cartList);

        ArrayAdapter<Item> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, items);
        cartList.setAdapter(adapter);
    }
}