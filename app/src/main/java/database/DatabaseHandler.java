package database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import models.*;
import utils.Utilities;

public class DatabaseHandler extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;

    // Database Name
    private static final String DATABASE_NAME = "weathercomapp";

    // table names
    private static final String TABLE_CITY = "city";
    private static final String TABLE_FORECAST = "forecast";
    private static final String TABLE_WEATHER = "weather";
    private static final String TABLE_QUERY = "query";

    // Common table col names
    private static final String COLUMN_ID = "id";
    private static final String COLUMN_CITY_ID = "city_id";

    // City Table col names
    private static final String COLUMN_NAME = "name";
    private static final String COLUMN_COUNTRY = "country";
    private static final String COLUMN_LATITUDE = "latitude";
    private static final String COLUMN_LONGITUDE = "longitude";


    // Query Table col names
    private static final String COLUMN_TIMESTAMP_LAST = "timestamp_last";


    // Forecast Table col names
    private static final String COLUMN_TEMP = "temp";
    private static final String COLUMN_TEMP_MIN = "temp_min";
    private static final String COLUMN_TEMP_MAX = "temp_max";
    private static final String COLUMN_PRESSURE = "pressure";
    private static final String COLUMN_HUMIDITY = "humidity";
    private static final String COLUMN_TIMESTAMP = "timestamp";
    private static final String COLUMN_WEATHER_ID = "weather_id";


    // Weather Table col names
    private static final String COLUMN_MAIN_PARAMS = "main_params";
    private static final String COLUMN_DESCRIPTION = "description";
    private static final String COLUMN_ICON = "icon";

    // Create City table script
    private static final String CREATE_CITY_SCRIPT= "CREATE TABLE IF NOT EXISTS " +
            TABLE_CITY + " (" +
            COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "+
            COLUMN_NAME + " TEXT, "+
            COLUMN_COUNTRY + " TEXT, "+
            COLUMN_LATITUDE + " REAL, "+
            COLUMN_LONGITUDE + " REAL)"
            ;

    // Create Query table script
    private static final String CREATE_QUERY_SCRIPT= "CREATE TABLE IF NOT EXISTS " +
            TABLE_QUERY + " (" +
            COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "+
            COLUMN_TIMESTAMP + " REAL, "+
            COLUMN_CITY_ID + " INTEGER)"
            ;


    // Create Forecast table script
    private static final String CREATE_FORECAST_SCRIPT= "CREATE TABLE IF NOT EXISTS " +
            TABLE_FORECAST + " (" +
            COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "+
            COLUMN_TEMP + " REAL, "+
            COLUMN_TEMP_MIN + " REAL, "+
            COLUMN_TEMP_MAX + " REAL, "+
            COLUMN_PRESSURE + " REAL, "+
            COLUMN_HUMIDITY + " INTEGER, "+
            COLUMN_TIMESTAMP + " INTEGER "+
            COLUMN_WEATHER_ID + "INTEGER "+
            COLUMN_CITY_ID + "INTEGER)"
            ;


    // Create Weather table script
    private static final String CREATE_WEATHER_SCRIPT= "CREATE TABLE IF NOT EXISTS " +
            TABLE_WEATHER + " (" +
            COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "+
            COLUMN_MAIN_PARAMS + " TEXT, "+
            COLUMN_DESCRIPTION+ " REAL, "+
            COLUMN_ICON + " TEXT)"
            ;

    // Drop table City
    private static final String DROP_TABLE_CITY = "DROP TABLE IF EXISTS "+TABLE_CITY;
    private static final String DROP_TABLE_QUERY = "DROP TABLE IF EXISTS "+TABLE_QUERY;
    private static final String DROP_TABLE_FORECAST = "DROP TABLE IF EXISTS "+ TABLE_FORECAST;
    private static final String DROP_TABLE_WEATHER = "DROP TABLE IF EXISTS "+TABLE_WEATHER;


    public DatabaseHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        Log.d("DATABASEHANDLER", "Entrei no construtor");
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        Log.d("DATABASEHANDLER", "Entrei no oncreate");
        //Criar Schema e tabelas base de dados
        db.execSQL(CREATE_CITY_SCRIPT);
        db.execSQL(CREATE_QUERY_SCRIPT);
        db.execSQL(CREATE_FORECAST_SCRIPT);
        db.execSQL(CREATE_WEATHER_SCRIPT);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        //Drop tables and create new tables
        db.execSQL(DROP_TABLE_CITY);
        db.execSQL(DROP_TABLE_QUERY);
        db.execSQL(DROP_TABLE_FORECAST);
        db.execSQL(DROP_TABLE_WEATHER);

        //Create tables
        onCreate(db);
    }


    /******************************** CRUD Operations *********************************************/

    /* --------------------------------- CITY TABLE --------------------------------------------- */

    // Insert a city
    public long create_city(City city){

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues content = new ContentValues();

        content.put(COLUMN_NAME,city.getname());
        content.put(COLUMN_COUNTRY,city.getCountry());
        content.put(COLUMN_LATITUDE,city.getLatitude());
        content.put(COLUMN_LONGITUDE,city.getLongitude());
        return db.insert(TABLE_CITY, null, content);

    }

    //Get cities by name
    public List<City> get_cities_by_name(String name){

        List<City> cities = new ArrayList<City>();

        SQLiteDatabase db = this.getReadableDatabase();
        String query = "SELECT * FROM " + TABLE_CITY + " WHERE " + COLUMN_NAME + " = '" +name + "'";

        Cursor c = db.rawQuery(query,null);

        // if there are cities, then continue reading
        if(c.moveToFirst()){

            //While there are cities, loop through them and add them to the arrayList
            do{

                City city = new City();
                city.setId(c.getInt(c.getColumnIndex(COLUMN_ID)));
                city.setname(c.getString(c.getColumnIndex(COLUMN_NAME)));
                city.setCountry(c.getString(c.getColumnIndex(COLUMN_COUNTRY)));
                city.setLatitude(c.getFloat(c.getColumnIndex(COLUMN_LATITUDE)));
                city.setLongitude(c.getFloat(c.getColumnIndex(COLUMN_LONGITUDE)));

                // Add to arraylist
                cities.add(city);

            }while(c.moveToNext());
        }

        return cities;

    }

    public City get_city_by_id(int id) {

        SQLiteDatabase db = this.getReadableDatabase();

        //Query
        String query = "SELECT * FROM " + TABLE_CITY + " WHERE " + COLUMN_ID + " = " + id;

        //Inicialize cursor with the results of the query to the database
        Cursor c = db.rawQuery(query, null);

        //Declare city object and initialize as null
        City city = null;

        //If there is a city
        if (c != null) {

            //Initialize city
            city = new City();

            //Add data
            city.setId(c.getInt(c.getColumnIndex(COLUMN_ID)));
            city.setname(c.getString(c.getColumnIndex(COLUMN_NAME)));
            city.setCountry(c.getString(c.getColumnIndex(COLUMN_COUNTRY)));
            city.setLatitude(c.getFloat(c.getColumnIndex(COLUMN_LATITUDE)));
            city.setLongitude(c.getFloat(c.getColumnIndex(COLUMN_LONGITUDE)));

        }

        //Return city object, either null or defined
        return city;
    }

    //Update city by name
    public long update_city(City city){

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues content = new ContentValues();

        //Populate content
        content.put(COLUMN_NAME,city.getname());
        content.put(COLUMN_COUNTRY,city.getCountry());
        content.put(COLUMN_COUNTRY,city.getLatitude());
        content.put(COLUMN_COUNTRY,city.getLongitude());

        //Update resource in database
        return db.update(TABLE_CITY, content,COLUMN_ID + " = ?", new String[]{ String.valueOf(city.getId())} );

    }

    /* --------------------------------- FORECAST TABLE --------------------------------------------- */

    //Insert forecast
    public long create_forecast(Forecast forecast,int city_id,int weather_id){

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues content = new ContentValues();

        content.put(COLUMN_TEMP,forecast.getTemp());
        content.put(COLUMN_TEMP_MIN,forecast.getTemp_min());
        content.put(COLUMN_TEMP_MAX,forecast.getTemp_max());
        content.put(COLUMN_PRESSURE,forecast.getPressure());
        content.put(COLUMN_HUMIDITY,forecast.getHumidity());
        content.put(COLUMN_TIMESTAMP,forecast.getTimestamp());
        content.put(COLUMN_CITY_ID,city_id);
        content.put(COLUMN_WEATHER_ID,weather_id);

        return db.insert(TABLE_FORECAST, null, content);

    }

    //Get forecast by city
    public List<Forecast> get_forecast_by_city_id(int city_id){

        List<Forecast> forecast = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();

        //Query
        String query = "SELECT * FROM FORECAST WHERE "+COLUMN_CITY_ID+ " = "+city_id;

        Cursor c = db.rawQuery(query,null);

        if( c.moveToFirst()){

            do{

                Forecast f = new Forecast();
                f.setTemp(c.getInt(c.getColumnIndex(COLUMN_TEMP)));
                f.setTemp_min(c.getInt(c.getColumnIndex(COLUMN_TEMP_MIN)));
                f.setTemp_max(c.getInt(c.getColumnIndex(COLUMN_TEMP_MAX)));
                f.setPressure(c.getInt(c.getColumnIndex(COLUMN_PRESSURE)));
                f.setHumidity(c.getInt(c.getColumnIndex(COLUMN_HUMIDITY)));
                f.setTimestamp(c.getLong(c.getColumnIndex(COLUMN_TIMESTAMP)));

                forecast.add(f);

            }while(c.moveToNext());
        }

        return forecast;
    }

    //Update forecast
    public long update_forecast(Forecast forecast){

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues content = new ContentValues();

        //Populate content
        content.put(COLUMN_TEMP,forecast.getTemp());
        content.put(COLUMN_TEMP_MIN,forecast.getTemp_min());
        content.put(COLUMN_TEMP_MAX,forecast.getTemp_max());
        content.put(COLUMN_PRESSURE,forecast.getPressure());
        content.put(COLUMN_HUMIDITY,forecast.getHumidity());
        content.put(COLUMN_TIMESTAMP,forecast.getTimestamp());

        //Update resource in database
        return db.update(TABLE_FORECAST, content,COLUMN_ID + " = ?", new String[]{String.valueOf(forecast.getId())} );

    }

    //Delete forescast related to a city. Returns number of delete records.
    public long delete_forecast_by_city_id(int id){

        SQLiteDatabase db = this.getWritableDatabase();

        return db.delete(TABLE_FORECAST,COLUMN_CITY_ID + " = ?", new String[]{String.valueOf(id)});
    }


    /* --------------------------------- WEATHER TABLE --------------------------------------------- */

    //Insert Weather
    public long create_weather(Weather weather){

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues content = new ContentValues();

        content.put(COLUMN_MAIN_PARAMS,weather.getMain_params());
        content.put(COLUMN_DESCRIPTION,weather.getDescription());
        content.put(COLUMN_ICON,weather.getId());

        return db.insert(TABLE_FORECAST, null, content);

    }

    //Get Weather by forecast id
//    public Weather get_weather_by_forecast_id(int forecast_id){
//
//        SQLiteDatabase db = this.getReadableDatabase();
//
//        //Query
//        String query = "SELECT * FROM WEATHER WHERE "+COLUMN_WEATHER_ID+ " = "+forecast_id;
//
//        Cursor c = db.rawQuery(query,null);
//
//        if( c.moveToFirst()){
//
//            do{
//
//                Weather w = new Weather();
//                f.setTemp(c.getInt(c.getColumnIndex(COLUMN_TEMP)));
//                f.setTemp_min(c.getInt(c.getColumnIndex(COLUMN_TEMP_MIN)));
//                f.setTemp_max(c.getInt(c.getColumnIndex(COLUMN_TEM    P_MAX)));
//                f.setPressure(c.getInt(c.getColumnIndex(COLUMN_PRESSURE)));
//                f.setHumidity(c.getInt(c.getColumnIndex(COLUMN_HUMIDITY)));
//                f.setTimestamp(c.getLong(c.getColumnIndex(COLUMN_TIMESTAMP)));
//
//                forecast.add(f);
//
//            }while(c.moveToNext());
//        }
//
//        return forecast;
//    }

    //Update weather
    public long update_weather(Forecast forecast){

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues content = new ContentValues();

        //Populate content
        content.put(COLUMN_TEMP,forecast.getTemp());
        content.put(COLUMN_TEMP_MIN,forecast.getTemp_min());
        content.put(COLUMN_TEMP_MAX,forecast.getTemp_max());
        content.put(COLUMN_PRESSURE,forecast.getPressure());
        content.put(COLUMN_HUMIDITY,forecast.getHumidity());
        content.put(COLUMN_TIMESTAMP,forecast.getTimestamp());

        //Update resource in database
        return db.update(TABLE_FORECAST, content,COLUMN_ID + " = ?", new String[]{String.valueOf(forecast.getId())} );

    }
}
