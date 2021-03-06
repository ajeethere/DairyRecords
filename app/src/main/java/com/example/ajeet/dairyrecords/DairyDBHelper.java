package com.example.ajeet.dairyrecords;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.ScrollView;

public class DairyDBHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME="GathalaDairy.db";
    public static final String TABLE_BUYERS="BuyersList";
    public static final String Col_SerialNo="SerialNumber";
    public static final String Col_Name="Name";
    public static final String Col_SurName="SurName";
    public static final String Col_Fathers_Name="FathersName";
    public static final String Col_Add="Address";
    public static final String Col_Phone="Phone";


    public static final String TABLE_SOLED_ITEMS="SoldItemList";
    public static final String Col_Product_Serial_No="ProductSerialNumber";
    public static final String Col_Buyer_Name="Buyer";
    public static final String Col_Product_Name="ProductName";
    public static final String Col_Price="Price";
    public static final String Col_Quantity="ProductsQuantity";
    public static final String Col_Total_Amount="TotalAmount";
    public static final String Col_Total_Due_Amount="TotalDueAmount";
    public static final String Col_Payment_Date="DueAmountDate";
    SQLiteDatabase db;


    public DairyDBHelper(Context context) {
        super(context, DATABASE_NAME, null, 5);
        db = this.getWritableDatabase();

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + TABLE_BUYERS + "( " + Col_SerialNo + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + Col_Name + " TEXT,"+ Col_SurName + " TEXT,"
                + Col_Fathers_Name +" TEXT, "+Col_Add+" TEXT, "+ Col_Phone + " INTEGER )"
                );

        db.execSQL("create table " + TABLE_SOLED_ITEMS + "( " + Col_Product_Serial_No + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + Col_Buyer_Name + " TEXT,"+ Col_Product_Name + " TEXT,"
                + Col_Price +" DOUBLE, "+Col_Quantity+" DOUBLE, "+ Col_Total_Amount + " DOUBLE,"+ Col_Total_Due_Amount + " DOUBLE,"
                + Col_Payment_Date + " TEXT)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_BUYERS);
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_SOLED_ITEMS);
        onCreate(db);
    }
    public boolean insertData(String name, String surname, String fathersname, String address, String phone) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(Col_Name, name);
        contentValues.put(Col_SurName, surname);
        contentValues.put(Col_Fathers_Name, fathersname);
        contentValues.put(Col_Add, address);
        contentValues.put(Col_Phone, phone);
        long result=db.insert(TABLE_BUYERS,null,contentValues);
        if (result==-1){
            return false;
        }else
        return true;
    }
    public boolean insertProductData(String buyerName , String productName, double productPrice
            , double productQuantity, double totalAmount, double totalDueAmoount, String paymentDate){
        ContentValues contentValues=new ContentValues();
        contentValues.put(Col_Buyer_Name,buyerName);
        contentValues.put(Col_Product_Name,productName);
        contentValues.put(Col_Price,productPrice);
        contentValues.put(Col_Quantity,productQuantity);
        contentValues.put(Col_Total_Amount,totalAmount);
        contentValues.put(Col_Total_Due_Amount,totalDueAmoount);
        contentValues.put(Col_Payment_Date,paymentDate);
        long result=db.insert(TABLE_SOLED_ITEMS,null,contentValues);
        if (result==-1){
            return false;
        }else
        return true;
    }
    public Cursor getAllData() {
        Cursor res = db.rawQuery("select * from " + TABLE_BUYERS, null);
        return res;
    }
    public Cursor getAllDataSoldItems(){
        Cursor res1 = db.rawQuery("select * from " + TABLE_SOLED_ITEMS, null);
        return res1;
    }
}
