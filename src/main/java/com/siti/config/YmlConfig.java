package com.siti.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Created by ht on 2018/1/24.
 */
@Configuration
public class YmlConfig extends WebMvcConfigurerAdapter {

    /**
     * 保留N小时内的无效文件
     */
    @Value("${filePath.invalidFileDelete}")
    private Integer invalidFileDelete;
    /**
     * 文件服务器地址
     */
    @Value("${filePath.bikeClean}")
    private String bikeCleanPath;
    /**
     * 用户头像
     */
    @Value("${filePath.head}")
    private String headPath;
    /**
     * 用户反馈
     */
    @Value("${filePath.feedback}")
    private String feedbackPath;


    /**
     * 版本号
     */
    @Value("${version.pcversion}")
    private String pcversion;

    /**
     * 小版本号
     */
    @Value("${version.build}")
    private String build;

//    @Value("${filePath.uploadFiles}")
//    private String filePath;

    @Value("${APK.addr}")
    private String apkAddr;

    @Value("${AK.password}")
    private String password;

    @Value("${nettyServer.ip}")
    private String ip;

    @Value("${nettyServer.nettyServerPort}")
    private Integer nettyServerPort;
    @Value("${nettyServer.webSocketPort}")
    private Integer webSocketPort;
    @Value("${nettyServer.workOrderServerPort}")
    private Integer workOrderServerPort;
    @Value("${nettyServer.wocClient}")
    private String wocClient;

    public void setInvalidFileDelete(Integer invalidFileDelete) {
        this.invalidFileDelete = invalidFileDelete;
    }

    public void setBikeCleanPath(String bikeCleanPath) {
        this.bikeCleanPath = bikeCleanPath;
    }

    public void setHeadPath(String headPath) {
        this.headPath = headPath;
    }

    public void setFeedbackPath(String feedbackPath) {
        this.feedbackPath = feedbackPath;
    }


    public void setPcversion(String pcversion) {
        this.pcversion = pcversion;
    }


    public void setBuild(String build) {
        this.build = build;
    }

//    public String getFilePath() {
//        return filePath;
//    }
//
//    public void setFilePath(String filePath) {
//        this.filePath = filePath;
//    }

    public void setApkAddr(String apkAddr) {
        this.apkAddr = apkAddr;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getInvalidFileDelete() {
        return invalidFileDelete;
    }

    public String getApkAddr() {
        return apkAddr;
    }

    public String getPassword() {
        return password;
    }

    public String getBikeCleanPath() {
        return bikeCleanPath;
    }

    public String getHeadPath() {
        return headPath;
    }

    public String getFeedbackPath() {
        return feedbackPath;
    }



    public String getPcversion() {
        return pcversion;
    }


    public String getBuild() {
        return build;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public Integer getNettyServerPort() {
        return nettyServerPort;
    }

    public void setNettyServerPort(Integer nettyServerPort) {
        this.nettyServerPort = nettyServerPort;
    }

    public Integer getWebSocketPort() {
        return webSocketPort;
    }

    public void setWebSocketPort(Integer webSocketPort) {
        this.webSocketPort = webSocketPort;
    }

    public Integer getWorkOrderServerPort() {
        return workOrderServerPort;
    }

    public void setWorkOrderServerPort(Integer workOrderServerPort) {
        this.workOrderServerPort = workOrderServerPort;
    }

    public String getWocClient() {
        return wocClient;
    }

    public void setWocClient(String wocClient) {
        this.wocClient = wocClient;
    }
}
