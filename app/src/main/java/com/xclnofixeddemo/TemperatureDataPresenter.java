package com.xclnofixeddemo;

/**
 * Created by Administrator on 2016/10/29.
 */

public class TemperatureDataPresenter {
    private ITemperatureData mITemperatureData;
    private ITemperatureView mITemperatureView;

    public TemperatureDataPresenter(ITemperatureView temperatureView) {
        this.mITemperatureView = temperatureView;
        mITemperatureData = new ITemperatureDataImpl();
    }

    public void getCheckInfoMessage() {
        mITemperatureData.getData(new OnCommonResultListener() {
            @Override
            public <T> void onSuccess(T t) {
                mITemperatureView.onMessageSuccess(t);
            }
        });
    }

}
