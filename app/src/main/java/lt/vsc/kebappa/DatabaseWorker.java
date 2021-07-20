package lt.vsc.kebappa;

import android.database.sqlite.SQLiteDatabase;

import androidx.appcompat.app.AppCompatActivity;

import lt.vsc.kebappa.database.DatabaseDataWorker;
import lt.vsc.kebappa.database.OpenHelper;

public class DatabaseWorker {

    public static DatabaseDataWorker worker;

    public static void setupWorker(AppCompatActivity context) {

        if(worker == null) {
            OpenHelper helper = new OpenHelper(context);
            SQLiteDatabase database = helper.getReadableDatabase();
            worker = new DatabaseDataWorker(database);
        }
    }

}
