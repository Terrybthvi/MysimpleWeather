package com.example.terry.mytianqi.model;

/**
 * Created by Terry on 2016/5/6.
 */
public class City {
    private int id;
    private String cityname;
    private String cityCode;
    private int provinceId;

    public int getId(){
        return id;
    }
    public  void setId(int id)
    {
        this.id = id;
    }
    public String getCityname(){
        return cityname;
    }
    public void setCityname(String cityname){
        this.cityname = cityname;
    }
    public String getCityCode(){
        return cityCode;
    }

    public void setCityCode(String CityCode) {
        this.cityCode = CityCode;
    }
    public int getProvinceId()
    {
        return provinceId;
    }
    public void setProvinceId(int provinceId){
        this.provinceId = provinceId;
    }
}
