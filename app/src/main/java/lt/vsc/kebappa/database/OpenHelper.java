package lt.vsc.kebappa.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class OpenHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "kebappaDB";
    private static final int DATABASE_VERSION = 2;

    public OpenHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
//        db.execSQL(DatabaseContract.MenuEntry.CREATE_TABLE_SQL);
        db.execSQL(DatabaseContract.OrderEntry.CREATE_TABLE_SQL);
        db.execSQL(DatabaseContract.ItemEntry.CREATE_TABLE_SQL);
//        db.execSQL(DatabaseContract.UserEntry.CREATE_TABLE_SQL);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
/*        db.execSQL(DatabaseContract.MenuEntry.DROP_TABLE_SQL);
        db.execSQL(DatabaseContract.MenuEntry.CREATE_TABLE_SQL);*/

        db.execSQL(DatabaseContract.OrderEntry.DROP_TABLE_SQL);
        db.execSQL(DatabaseContract.OrderEntry.CREATE_TABLE_SQL);

        db.execSQL(DatabaseContract.ItemEntry.DROP_TABLE_SQL);
        db.execSQL(DatabaseContract.ItemEntry.CREATE_TABLE_SQL);

/*        db.execSQL(DatabaseContract.UserEntry.DROP_TABLE_SQL);
        db.execSQL(DatabaseContract.UserEntry.CREATE_TABLE_SQL);*/

    }
}
