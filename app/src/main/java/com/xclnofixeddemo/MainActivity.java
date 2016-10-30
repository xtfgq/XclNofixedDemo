package com.xclnofixeddemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.xclcharts.chart.PointD;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements ITemperatureView {
    private List<TemperatureBean> mList = null;
    private TemperatureView tv;
    private LinkedList<String> labels = new LinkedList<String>();
    private TemperatureDataPresenter mTemperatureDataPresenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mList = new ArrayList<TemperatureBean>();
        setContentView(R.layout.activity_main);
        mTemperatureDataPresenter=new TemperatureDataPresenter(this);
        tv = (TemperatureView) findViewById(R.id.chart);
        mTemperatureDataPresenter.getCheckInfoMessage();
    }

    @Override
    public <T> void onMessageSuccess(T t) {
        try {

            JSONArray myJsonArray = new JSONArray((String) t);
            for (int i = 0; i < myJsonArray.length(); i++) {
                TemperatureBean bean = new TemperatureBean();
                JSONObject jsonObject=(JSONObject) myJsonArray.get(i);
                String MonitorTime = jsonObject.getString("MonitorTime");
                bean.setMonitorTime(MonitorTime);
                String Value = jsonObject.getString("Value");
                bean.setValue(Value);
                mList.add(bean);
            }
            labels = CommonUtils.getDayLables();
            tv.setX(labels, 24);
            setDayChat(tv, mList);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    private void setDayChat(TemperatureView mChart, List<TemperatureBean> list) {
        List<PointD> linePoint = new ArrayList<PointD>();
        for (TemperatureBean temperatureBean : list) {
            Double xd = Double.valueOf(temperatureBean.getMonitorTime().split("\\ ")[1]);
            Double ydH = Double.valueOf(temperatureBean.getValue());
            linePoint.add(new PointD(xd, ydH));
        }
        mChart.refresh(linePoint);

    }
}
