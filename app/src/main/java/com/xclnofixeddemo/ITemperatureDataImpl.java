package com.xclnofixeddemo;

/**
 * Created by Administrator on 2016/10/29.
 */

public class ITemperatureDataImpl implements ITemperatureData{

    @Override
    public void getData(final OnCommonResultListener listener) {
        String result="[{\"MonitorTime\":\"2016-10-29 06\"," +
                "\"Value\":\"36.1\"},{\"MonitorTime\":\"2016-10-29 08\",\"Value\":\"33.9\"}," +
                "{\"MonitorTime\":\"2016-10-29 14\",\"Value\":\"38.9\"}]";
        listener.onSuccess(result);
    }
}
