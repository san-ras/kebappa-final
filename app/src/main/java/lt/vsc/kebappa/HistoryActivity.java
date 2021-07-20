package lt.vsc.kebappa;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
import java.util.List;

import lt.vsc.kebappa.database.DatabaseDataWorker;

public class HistoryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent redirectedIntent = getIntent();
        Bundle extras = redirectedIntent.getExtras();

        if(extras != null){

            String orderId = extras.get("OrderId").toString();

            AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
            alertDialogBuilder.setMessage("Užsakymas nr. " + orderId + " pateiktas!");

            alertDialogBuilder.setPositiveButton("Ok", null);
            alertDialogBuilder.show();
        }

        setContentView(R.layout.activity_history);

        List<List> allOrders = new ArrayList();

        ListView orderList = findViewById(R.id.orderHistoryList);

        ArrayAdapter<List> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, allOrders);

        orderList.setAdapter(adapter);


    }

    @Override
    protected void onPause() {
        super.onPause();

        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
