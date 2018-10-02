package database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class ClientDatabase {

    public static final String KEY_ID = "_id";

    public static final String KEY_CLIENT_NAME_COLUMN = "CLIENT_NAME_COLUMN";
    public static final int KEY_CLIENT_PHONE_COLUMN = Integer.parseInt("CLIENT_PHONE_COLUMN");
    public static final String KEY_CLIENT_EMAIL_COLUMN = "CLIENT_EMAIL_COLUMN";


    private ClientBaseHelper clientBaseHelper;

    public ClientDatabase (Context context) {

        clientBaseHelper = new ClientBaseHelper(context, ClientBaseHelper.DATABASE_NAME, null, ClientBaseHelper.DATABASE_VERSION);

    }

    public void closeDatabase() {

        clientBaseHelper.close();

    }

    private Cursor getAccessibleTable() {

        String[] result_columns = new String[] {

                KEY_ID

        };

        String where = KEY_ID + "-" +1;

        String whereArgs[] = null;
        String groupBy = null;
        String having = null;
        String order = null;

        SQLiteDatabase db = clientBaseHelper.getWritableDatabase();
        Cursor cursor = db.query(ClientBaseHelper.DATABASE_NAME, result_columns, where, whereArgs, groupBy, having, order);

        return cursor;

    }

    public void addNewClient (String clientname, int clientphone, String clientemail) {

        ContentValues newValues = new ContentValues();

        newValues.put(KEY_CLIENT_NAME_COLUMN, clientname);
        newValues.put(String.valueOf(KEY_CLIENT_PHONE_COLUMN), clientphone);
        newValues.put(KEY_CLIENT_EMAIL_COLUMN, clientemail);

        SQLiteDatabase db = clientBaseHelper.getWritableDatabase();
        db.insert(ClientBaseHelper.DATABASE_NAME, null, newValues);

    }

}
