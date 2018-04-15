package com.nero.liveshow.util;

import java.time.Instant;
import java.time.LocalTime;
import java.util.UUID;

public class TencentCloudUtil {

    private static final String bizId = "22456";

    private String streamId;

    public TencentCloudUtil() {
        streamId = UUID.randomUUID().toString().replaceAll("\\-", "").substring(0,8);
        System.out.println(streamId);
    }

    public static void main(String[] args) {

        System.out.println(new TencentCloudUtil().getPushStream());
    }

    public String getPushStream() {
        StringBuilder s = new StringBuilder("rtmp://");
        s.append(bizId);
        s.append(".livepush.myqcloud.com/live/");
        s.append(bizId).append("_");
        s.append(streamId);
        s.append("?bizid=").append(bizId).append("&");
        long now = System.currentTimeMillis()/1000L;
        long endTime = now + 15*24*3600;
        s.append(Test.getSafeUrl("4df2023704df8da1d730732ee0923e73",streamId,endTime));
        return s.toString();
    }

    public String getLiveStream() {
        StringBuilder s = new StringBuilder("http://");
        s.append(bizId);
        s.append(".livepush.myqcloud.com/live/");
        s.append(bizId).append("_");
        s.append(streamId);
        s.append(".m3u8");
        return s.toString();
    }
}
