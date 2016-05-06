package com.example.terry.mytianqi.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.terry.mytianqi.Api.MyApiClient;
import com.example.terry.mytianqi.R;
import com.example.terry.mytianqi.model.Weather;

import java.util.HashMap;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private static final String key = "e534109c6354b2bd50f7748f29f95afb";
    public EditText city ;
    private String format = "2";
    public TextView textView;
    public TextView wendu;
    public TextView feng;
    public TextView shiyi;
    public TextView s11;
    public Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        city = (EditText) findViewById(R.id.city);
        button = (Button) findViewById(R.id.button);
        textView = (TextView) findViewById(R.id.weather);
        wendu = (TextView) findViewById(R.id.wendu);
        feng = (TextView) findViewById(R.id.feng);
        shiyi = (TextView) findViewById(R.id.shiyi);
        s11 = (TextView) findViewById(R.id.textView);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String C = city.getText().toString();
                Map<String,String> map = new HashMap<String, String>();
                map.put("format", format);
                map.put("cityname",C);
                map.put("key",key);
                MyApiClient Cilient = new MyApiClient();
               Call<Weather> call =Cilient.service.weather(map);
                call.enqueue(new Callback<Weather>() {
                    @Override
                    public void onResponse(Call<Weather> call, Response<Weather> response) {
                        //Log.e("sdfsdfsdfjsdf",response.body().getResult().getToday().getWeather().toString());
                        String s = response.body().getResultcode();
                        if (s.equals("200")){
                            s11.setVisibility(View.VISIBLE);
                            s11.setText("今天的天气情况如下");
                            textView.setVisibility(View.VISIBLE);
                            wendu.setVisibility(View.VISIBLE);
                            feng.setVisibility(View.VISIBLE);
                            shiyi.setVisibility(View.VISIBLE);
                            textView.setText(response.body().getResult().getToday().getWeather());
                            wendu.setText(response.body().getResult().getToday().getTemperature());
                            feng.setText(response.body().getResult().getToday().getWind());
                            shiyi.setText(response.body().getResult().getToday().getWash_index());
                        }
                        else {
                            s11.setVisibility(View.VISIBLE);
                            s11.setText("输入的城市名错误！");
                            textView.setVisibility(View.GONE);
                            wendu.setVisibility(View.GONE);
                            feng.setVisibility(View.GONE);
                            shiyi.setVisibility(View.GONE);

                        }
                    }

                    @Override
                    public void onFailure(Call<Weather> call, Throwable t) {
                        s11.setVisibility(View.VISIBLE);
                        s11.setText("请求错误");
                        textView.setVisibility(View.GONE);
                        wendu.setVisibility(View.GONE);
                        feng.setVisibility(View.GONE);
                        shiyi.setVisibility(View.GONE);

                    }
                });
            }
        });


    }
}
