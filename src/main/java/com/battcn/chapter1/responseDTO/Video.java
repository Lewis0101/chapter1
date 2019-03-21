package com.battcn.chapter1.responseDTO;

import java.io.Serializable;

/**
 * @author : 00222 [liu.yang@unisinsight.com]
 * @description:
 * @date : 2019/3/20 14:01
 * @since: 1.0
 */

public class Video implements Serializable {

    private static final long serialVersionUID = 8655851615465363473L;

    private String videoId;
    private String videoName;
    private String fileFormat;
    private String contentDescription;
    private String deviceId;

    public String getVideoId() {
        return videoId;
    }

    public void setVideoId(String videoId) {
        this.videoId = videoId;
    }

    public String getVideoName() {
        return videoName;
    }

    public void setVideoName(String videoName) {
        this.videoName = videoName;
    }

    public String getFileFormat() {
        return fileFormat;
    }

    public void setFileFormat(String fileFormat) {
        this.fileFormat = fileFormat;
    }

    public String getContentDescription() {
        return contentDescription;
    }

    public void setContentDescription(String contentDescription) {
        this.contentDescription = contentDescription;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }
}
