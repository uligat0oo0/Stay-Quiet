package androides.stayquiet;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by developer on 13/09/17.
 */

public class DBConnect extends SQLiteOpenHelper {
    private static final String DB_NAME = "StayQuiet";
    private static final int DB_VERSION = 1;

    private String TABLE_USER = "user";
    private String COLUMN_USER_ID = "id";
    private String COLUMN_USER_NAME = "name";
    private String COLUMN_USER_EMAIL = "email";
    private String COLUMN_USER_PASSWORD = "password";

    private String CREATE_USER_TABLE = "CREATE TABLE " + TABLE_USER +" (" +
            COLUMN_USER_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
            COLUMN_USER_NAME + " TEXT," +
            COLUMN_USER_EMAIL + " TEXT," +
            COLUMN_USER_PASSWORD + " TEXT" +
            ")";
    private String DROP_USER_TABLE = "DROP TABLE IF EXIST " + TABLE_USER;

    public DBConnect(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(CREATE_USER_TABLE);
        addUser("Fernando", "user1@email.com", "pass1");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL(DROP_USER_TABLE);
        onCreate(sqLiteDatabase);
    }

    public void addUser(String name, String email, String pass) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(COLUMN_USER_NAME, name);
        values.put(COLUMN_USER_EMAIL, email);
        values.put(COLUMN_USER_PASSWORD, pass);

        db.insert(TABLE_USER, null, values);
        db.close();
    }

    public boolean checkUser(String email, String pass) {
        String[] columns = { COLUMN_USER_ID };
        String[] selectionArgs = { email, pass };
        String selection = COLUMN_USER_EMAIL + " = ? AND " + COLUMN_USER_PASSWORD + " = ?";
        int countResult;

        if (1 > 0){
            return true;
        }

        return false;
    }
}
