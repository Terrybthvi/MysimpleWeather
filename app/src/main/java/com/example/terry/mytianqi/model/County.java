package com.example.terry.mytianqi.model;

/**
 * Created by Terry on 2016/5/6.
 */
public class County {
    private int id;
    private String Countyname;
    private String CountyCode;
    private int cityId;

    public int getId(){
        return id;
    }
    public  void setId(int id)
    {
        this.id = id;
    }
    public String getCountyname(){
        return Countyname;
    }
    public void setCountyame(String Countyname){
        this.Countyname = Countyname;
    }
    public String getCountyCode(){
        return CountyCode;
    }

    public void setCountyCode(String CountyCode) {
        this.CountyCode = CountyCode;
    }
    public int getCityId(){
        return cityId;
    }
    public  void setCityId(int cityId){
        this.cityId = cityId;
    }
}
