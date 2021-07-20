package lt.vsc.kebappa;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TableLayout;

import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        ArrayList<Item> pickedItems = new ArrayList<>();
/*        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        appBarConfiguration = new AppBarConfiguration.Builder(navController.getGraph()).build();
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);*/

      //  FirebaseFirestore db = FirebaseFirestore.getInstance();

        CartInProgress.clear();

        ImageView cartImage = findViewById(R.id.imgCart);
        View.OnClickListener listenerCart = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("Cart image clicked");

                Intent intent = new Intent(MainActivity.this, CartActivity.class);
                startActivity(intent);
            }
        };
        cartImage.setOnClickListener(listenerCart);

        ImageView historyImage = findViewById(R.id.imgHistory);
        View.OnClickListener listenerHistory = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("History image clicked");

                Intent intent = new Intent(MainActivity.this, HistoryActivity.class);
                startActivity(intent);
            }
        };
        historyImage.setOnClickListener(listenerHistory);


        Button buttonRegistration = findViewById(R.id.registrationButton);
        View.OnClickListener listenerRegistration = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("Registration button clicked");

                Intent intent = new Intent(MainActivity.this, Registration.class);
                startActivity(intent);
            }
        };
        buttonRegistration.setOnClickListener(listenerRegistration);

        Button buttonOrder = findViewById(R.id.orderButton1);
        View.OnClickListener listenerOrderButton = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("Order button clicked");

                if(CartInProgress.getCartItems().size() > 0) {
                    Intent intent = new Intent(MainActivity.this, CartActivity.class);
                    startActivity(intent);
                } else {
                    Snackbar.make(v, "Išsirinkite -_-", Snackbar.LENGTH_LONG).show();
                }



            }
        };
        buttonOrder.setOnClickListener(listenerOrderButton);

        Item itemSmallBeef = new Item ("Mažas kebabas su jautiena", 3.5);
        Item itemBigBeef = new Item ("Didelis kebabas su jautiena", 4);
        Item itemXxlBeef = new Item ("XXL kebabas su jautiena", 5.0);
        Item itemPlateBeef = new Item ("Kebabas su jautiena lėkštėje", 5.0);

        Item itemSmallChicken = new Item ("Mažas kebabas su vištiena", 3.5);
        Item itemBigChicken = new Item ("Didelis kebabas su vištiena", 4);
        Item itemXxlChicken = new Item ("XXL kebabas su vištiena", 5.0);
        Item itemPlateChicken = new Item ("Kebabas su vištiena lėkštėje", 5.0);

        Item itemSmallVeg = new Item ("Mažas vegetariškas kebabas", 3.5);
        Item itemBigVeg = new Item ("Didelis vegetariškas kebabas", 4);
        Item itemXxlVeg = new Item ("XXL vegetariškas kebabas", 5.0);
        Item itemPlateVeg = new Item ("Vegetariškas kebabas lėkštėje", 5.0);

        Item itemFries = new Item ("Bulvytės", 2);
        Item itemCola = new Item ("Coca-cola", 1.1);
        Item itemFanta = new Item ("Fanta", 1.1);
        Item itemSprite = new Item ("Sprite", 1.1);



        CreateAddButton(itemSmallBeef, pickedItems, R.id.plusSmallBeefButton);
        CreateAddButton(itemBigBeef, pickedItems, R.id.plusBigBeefButton);
        CreateAddButton(itemXxlBeef, pickedItems, R.id.plusXxlBeefButton);
        CreateAddButton(itemPlateBeef, pickedItems, R.id.plusPlateBeefButton);
        CreateAddButton(itemSmallChicken, pickedItems, R.id.plusSmallChickenButton);
        CreateAddButton(itemBigChicken, pickedItems, R.id.plusBigChickenButton);
        CreateAddButton(itemXxlChicken, pickedItems, R.id.plusXxlChickenButton);
        CreateAddButton(itemPlateChicken, pickedItems, R.id.plusPlateChickenButton);
        CreateAddButton(itemSmallVeg, pickedItems, R.id.plusSmallVegButton);
        CreateAddButton(itemBigVeg, pickedItems, R.id.plusBigVegButton);
        CreateAddButton(itemXxlVeg, pickedItems, R.id.plusXxlVegButton);
        CreateAddButton(itemPlateVeg, pickedItems, R.id.plusPlateVegButton);
        CreateAddButton(itemFries, pickedItems, R.id.plusFriesButton);
        CreateAddButton(itemCola, pickedItems, R.id.plusColaButton);
        CreateAddButton(itemFanta, pickedItems, R.id.plusFantaButton);
        CreateAddButton(itemSprite, pickedItems, R.id.plusSpriteButton);

        //   DatabaseDataWorker worker = new DatabaseDataWorker();


    }

    private void CreateAddButton(Item item, ArrayList<Item> cartItems, int id) {
        ImageButton button = findViewById(id);
        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // item.increaseQuantity(cartItems);

                CartInProgress.add(item);

                System.out.println("Item " + item.title + " added to the cart.");

                View view = findViewById(android.R.id.content).getRootView();
                Snackbar.make(view, item.title + " pridėta(s) į krepšelį", Snackbar.LENGTH_LONG).show();

            }
        };
        button.setOnClickListener(listener);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }












}