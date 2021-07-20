package lt.vsc.kebappa.database;

public class DatabaseContract {

    private DatabaseContract() {
    }

 /*   public static class MenuEntry {

        public static String TABLE_NAME = "menu";
        public static String COLUMN_MENUID = "menuId";
        public static String COLUMN_TITLE = "title";
        public static String COLUMN_PRICE = "price";

        public static String CREATE_TABLE_SQL =
                "CREATE TABLE " + TABLE_NAME + " (			                        " +
                        "" + COLUMN_MENUID + "         INTEGER  PRIMARY KEY NOT NULL,   " +
                        "" + COLUMN_TITLE + "       TEXT     NOT NULL,               " +
                        "" + COLUMN_PRICE + "    DECIMAL     NOT NULL               " +
                        ");                                                         ";

        public static String DROP_TABLE_SQL = "DROP TABLE " + TABLE_NAME;
    }*/

    public static class OrderEntry {

        public static String TABLE_NAME = "[order]";
        public static String COLUMN_ORDERID = "orderId";
        //public static String COLUMN_USERID = "user";
        public static String COLUMN_TOTALPRICE = "totalPrice";
        public static String COLUMN_DATECREATED = "dateCreated";

        public static String CREATE_TABLE_SQL =
                "CREATE TABLE " + TABLE_NAME + " (			                        " +
                        "" + COLUMN_ORDERID + "         INTEGER  PRIMARY KEY NOT NULL,   " +
                        //   "" + COLUMN_USERID + "       INTEGER     NOT NULL  REFERENCES user (userId),                    " +
                        "" + COLUMN_TOTALPRICE + "    DECIMAL     NOT NULL,               " +
                        "" + COLUMN_DATECREATED + "    DATE     NOT NULL               " +
                        ");                                                         ";

        public static String DROP_TABLE_SQL = "DROP TABLE " + TABLE_NAME;
    }

    public static class ItemEntry {

        public static String TABLE_NAME = "orderItem";
        public static String COLUMN_ITEMID = "itemId";
        public static String COLUMN_ORDERID = "orderId";
        //   public static String COLUMN_MENUID = "menuId";
        public static String COLUMN_QUANTITY = "quantity";
        public static String COLUMN_PRICEPERITEM = "pricePerItem";

        public static String CREATE_TABLE_SQL =
                "CREATE TABLE " + TABLE_NAME + " (			                        " +
                        "" + COLUMN_ITEMID + "         INTEGER  PRIMARY KEY NOT NULL,   " +
                        "" + COLUMN_ORDERID + "       INTEGER  REFERENCES [order] (orderId)   NOT NULL,               " +
                        //                 "" + COLUMN_MENUID + "       INTEGER     NOT NULL,               " +
                        "" + COLUMN_QUANTITY + "       INTEGER     NOT NULL,               " +
                        "" + COLUMN_PRICEPERITEM + "    DECIMAL     NOT NULL               " +
                        ");                                                         ";

        public static String DROP_TABLE_SQL = "DROP TABLE " + TABLE_NAME;
    }
}

/*

    public static class UserEntry {

        public static String TABLE_NAME = "orderItem";
        public static String COLUMN_USERID = "userId";
        public static String COLUMN_EMAIL = "orderId";
        public static String COLUMN_PASSWORD = "menuId";
        public static String COLUMN_NAME = "quantity";
        public static String COLUMN_PHONE = "pricePerItem";

        public static String CREATE_TABLE_SQL =
                "CREATE TABLE " + TABLE_NAME + " (			                        " +
                        "" + COLUMN_USERID + "         INTEGER  PRIMARY KEY NOT NULL,   " +
                        "" + COLUMN_EMAIL + "       TEXT    NOT NULL,               " +
                        "" + COLUMN_PASSWORD + "       TEXT     NOT NULL,               " +
                        "" + COLUMN_NAME + "       TEXT     NOT NULL,               " +
                        "" + COLUMN_PHONE + "    TEXT     NOT NULL               " +
                        ");                                                         ";

        public static String DROP_TABLE_SQL = "DROP TABLE " + TABLE_NAME;
    }
}*/
