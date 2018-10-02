package database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class ClientBaseHelper extends SQLiteOpenHelper {

    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "clientBase.db";

    public ClientBaseHelper(Context context1, String databaseName, Context context, int databaseVersion) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        final String SQL_CREATE_CLIENTBASE_TABLE = "CREATE TABLE " +
                ClientDbSchema.ClientTable.KEY_TABLE_NAME + " (" +
                ClientDbSchema.ClientTable.KEY_COLUMN_NAME + " TEXT NOT NULL, " +
                ClientDbSchema.ClientTable.KEY_COLUMN_PHONE + " INTEGER NOT NULL, " +
                ClientDbSchema.ClientTable.KEY_COLUMN_EMAIL + " TEXT NOT NULL" +
                ");";

        db.execSQL(SQL_CREATE_CLIENTBASE_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS " + ClientDbSchema.ClientTable.KEY_TABLE_NAME);
        onCreate(db);

    }

}
