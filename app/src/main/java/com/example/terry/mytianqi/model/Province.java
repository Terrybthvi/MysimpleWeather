package com.example.terry.mytianqi.model;

/**
 * Created by Terry on 2016/5/6.
 */
public class Province {
    private int id;
    private String provincename;
    private String provinceCode;


    public int getId(){
        return id;
    }
    public  void setId(int id)
    {
        this.id = id;
    }
    public String getProvincename(){
        return provincename;
    }
    public void setProvincename(String provincename){
        this.provincename = provincename;
    }
    public String getProvinceCode(){
        return provinceCode;
    }

    public void setProvinceCode(String provinceCode) {
        this.provinceCode = provinceCode;
    }
}
