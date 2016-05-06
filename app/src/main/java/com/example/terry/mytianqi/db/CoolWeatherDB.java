package com.example.terry.mytianqi.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.terry.mytianqi.model.City;
import com.example.terry.mytianqi.model.County;
import com.example.terry.mytianqi.model.Province;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Terry on 2016/5/6.
 */
public class CoolWeatherDB {
    /*
    * 数据库名
    * */
    public static final String DB_NAME = "cool_weather";
    /*
    * 数据库版本
    * */
    public static final int VERSION = 1;
    private static CoolWeatherDB coolWeatherDB;
    private SQLiteDatabase db;
    /*
    * 将构造方法私有化
    * */
    private CoolWeatherDB(Context context){
        CoolWeatherOpenHelper dbHelper = new CoolWeatherOpenHelper(context,DB_NAME,null,VERSION);
        db = dbHelper.getWritableDatabase();
    }
    /*
    *
    * 获取CoolWeatherDB的实例
    *
    * */
    public synchronized static CoolWeatherDB getInstance(Context context){
        if (coolWeatherDB == null){
            coolWeatherDB  = new CoolWeatherDB(context);
        }
        return coolWeatherDB;
    }
    /*
    * 将Province实例存储到数据库
    * */
    public void saveProcvicne(Province province){
        if (province != null) {
            ContentValues values = new ContentValues();
            values.put("province_name", province.getProvincename());
            values.put("province_code", province.getProvinceCode());
            db.insert("Province", null, values);
        }
    }
    /**
     * 从数据库读取全国所有的省份信息
     */
    public List<Province> loadProvince() {
        List<Province> list = new ArrayList<Province>();
        Cursor cursor = db.query("Province", null, null, null, null, null, null, null);
        if (cursor.moveToFirst()) {
            do {
                Province province = new Province();
                province.setId(cursor.getInt(cursor.getColumnIndex("id")));
                province.setProvincename(cursor.getString(cursor.getColumnIndex("province_name")));
                province.setProvinceCode(cursor.getString(cursor.getColumnIndex("province_code")));
                list.add(province);
            } while (cursor.moveToNext());
            if (cursor != null) {
                cursor.close();
            }

        }
        return list;
    }
    /**
     * 将City实例存储到数据库
     */
    public void saveCity(City city) {
        if (city != null) {
            ContentValues values = new ContentValues();
            values.put("city_name", city.getCityname());
            values.put("city_code", city.getCityCode());
            db.insert("City", null, values);
        }
    }
        /**
         * 从数据库读取某省下所有城市
         */
        public List<City> loadCity(int provinceId) {
            List<City> list1 = new ArrayList<City>();
            Cursor cursor = db.query("City", null,"province_id = ?",new String[] {
                    String.valueOf(provinceId)},null,null,null);

            if (cursor.moveToFirst()) {
                do {
                    City city1 = new City();
                    city1.setId(cursor.getInt(cursor.getColumnIndex("id")));
                    city1.setCityname(cursor.getString(cursor.getColumnIndex("city_name")));
                    city1.setCityCode(cursor.getString(cursor.getColumnIndex("city_code")));
                    city1.setProvinceId(provinceId);
                    list1.add(city1);
                } while (cursor.moveToNext());
            }
            if (cursor != null) {
                cursor.close();
            }
            return list1;
        }
    /**
     * 将County 实例存储到数据库
     */
    public void saveCounty(County county){
        ContentValues values = new ContentValues();
        values.put("county_name",county.getCountyname());
        values.put("county_code",county.getCountyCode());
        values.put("city_Id",county.getCityId());
        db.insert("County",null,values);
    }
    /**
     * 从数据库读取某市所有县的信息
     */
    public List<County> loadcounty(int Cityid111){
        List<County> countyList = new ArrayList<County>();
        Cursor cursor = db.query("County",null,"city_id = ?",new String[]{String.valueOf(Cityid111)},null,null,null);
        if (cursor.moveToFirst()){
            do {
                County county = new County();
                county.setId(cursor.getInt(cursor.getColumnIndex("id")));
                county.setCountyame(cursor.getString(cursor.getColumnIndex("city_name")));
                county.setCountyCode(cursor.getString(cursor.getColumnIndex("city_code")));
                county.setCityId(Cityid111);
                countyList.add(county);
            }while (cursor.moveToNext());
        }
        if (cursor != null){
            cursor.close();
        }
        return countyList;
    }
}
