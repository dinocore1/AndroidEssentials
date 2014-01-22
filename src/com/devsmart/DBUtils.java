package com.devsmart;


import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class DBUtils {

    public static String lookupSingleStringValue(SQLiteDatabase db, String columnName, String table, String selection, String[] selectionArgs, String defaultValue) {
        String retval = defaultValue;
        Cursor c = db.query(table, new String[]{columnName}, selection, selectionArgs, null, null, null);
        try {
            if(c.moveToFirst()){
                retval = c.getString(0);
            }
        } finally {
            c.close();
        }
        return retval;
    }
}
