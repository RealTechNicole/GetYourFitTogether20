package database;

import android.media.Image;

public class ClientDbSchema {

    private ClientDbSchema() {}

    public static final class ClientTable {
        public static final String TABLE_NAME = "clients";
        public static final String COLUMN_NAME = "name";
        public static final String COLUMN_PHONE = "phone";
        public static final String COLUMN_EMAIL = "email";
    }

}
