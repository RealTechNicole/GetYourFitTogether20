package database;

import android.content.ContentValues;
import android.media.Image;

public class ClientDbSchema {

    private ClientDbSchema() {}

    public static final class ClientTable {
        public static final String KEY_TABLE_NAME = "clients";
        public static final String KEY_COLUMN_NAME = "name";
        public static final String KEY_COLUMN_PHONE = "phone";
        public static final String KEY_COLUMN_EMAIL = "email";
    }


}
