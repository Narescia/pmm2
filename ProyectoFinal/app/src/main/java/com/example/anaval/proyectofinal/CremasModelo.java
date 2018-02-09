package com.example.anaval.proyectofinal;

import android.provider.BaseColumns;

/**
 * Created by anaval on 9/02/18.
 */

public class CremasModelo {
    private static final String PRIMARY_KEY = " PRIMARY KEY";
    private static final String FOREIGN_KEY = " FOREIGN KEY";
    private static final String ON_DELETE = " ON DELETE";
    private static final String ON_UPDATE = " ON UPDATE";
    private static final String CASCADE = " CASCADE";
    private static final String UNIQUE = " UNIQUE ";
    private static final String REFERENCES = " REFERENCES ";
    private static final String INTEGER_TYPE = " INTEGER";
    private static final String REAL_TYPE = " REAL";
    private static final String TEXT_TYPE = " TEXT";
    private static final String NOT_NULL = " NOT NULL";

    private CremasModelo() {}

    public static final class Crema implements BaseColumns {
        public static final String TABLE_NAME = "crema";
        public static final String KEY_NAME = "name";
        public static final String KEY_TIPO_ID = "tipo_id";

        private Crema() {}

        public static final String[] KEY_ARRAY = {
                KEY_NAME,
                KEY_TIPO_ID
        };

        public static final String CREATE_TABLE =
                "CREATE TABLE " + TABLE_NAME + "("
                + _ID + INTEGER_TYPE + PRIMARY_KEY + ", "
                + KEY_NAME + TEXT_TYPE + NOT_NULL + ", "
                + KEY_TIPO_ID + TEXT_TYPE + ", " + UNIQUE +
                "(" + KEY_NAME + ")"
                + ")";

        public static final String DROP_TABLE = "DROP TABLE IF EXISTS " + TABLE_NAME;
    }

    public static final class Tipo implements BaseColumns {
        public static final String TABLE_NAME = "tipo";
        public static final String KEY_NAME = "name";
        public static final String KEY_DESCRIPTION = "description";

        private Tipo() {}

        public static final String[] KEY_ARRAY = {
                KEY_NAME,
                KEY_DESCRIPTION
        };

        public static final String CREATE_TABLE = "CREATE TABLE" + TABLE_NAME + "("
                + _ID + INTEGER_TYPE + PRIMARY_KEY + ", "
                + KEY_NAME + TEXT_TYPE + NOT_NULL + ", "
                + KEY_DESCRIPTION + TEXT_TYPE + ", "
                + TEXT_TYPE + ", " + UNIQUE +
                "(" + KEY_NAME + ")"
                + ")";

        public static final String DROP_TABLE = "DROP TABLE IF EXISTS " + TABLE_NAME;
    }

    public static final class Pedido implements BaseColumns {
        public static final String TABLE_NAME = "pedido";
        public static final String KEY_NAME = "name";
        public static final String KEY_CREMA_ID = "crema_id";
        public static final String KEY_TIPO_ID = "tipo_id";
        public static final String KEY_PRECIO = "precio";

        private Pedido() {}

        public static final String[] KEY_ARRAY = {
                KEY_NAME,
                KEY_CREMA_ID,
                KEY_TIPO_ID,
                KEY_PRECIO,
        };

        public static final String CREATE_TABLE =
                "CREATE TABLE " + TABLE_NAME + "("
                + _ID + INTEGER_TYPE + PRIMARY_KEY + ", "
                + KEY_NAME + TEXT_TYPE + NOT_NULL + ", "
                + KEY_CREMA_ID + INTEGER_TYPE + NOT_NULL
                + FOREIGN_KEY + "(" + KEY_CREMA_ID + ")"
                + REFERENCES + Crema.TABLE_NAME + "(" + Crema._ID + ")"
                + ON_DELETE + CASCADE + ", "
                + KEY_TIPO_ID + INTEGER_TYPE + NOT_NULL
                + FOREIGN_KEY + "(" + KEY_TIPO_ID + ")"
                + REFERENCES + Tipo.TABLE_NAME + "(" + Tipo._ID + ")"
                + ON_DELETE + CASCADE + ", "
                + KEY_PRECIO + REAL_TYPE + NOT_NULL + ", "
                + TEXT_TYPE
                + ")";

        public static final String DROP_TABLE = "DROP TABLE IF EXISTS " + TABLE_NAME;
    }

}
