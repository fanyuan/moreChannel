package com.example.network;

public class VersionBean {
    private String appVersionTitle;//": "接口新增测试版本",
    private String appVersionContent;//";: "内容内容",;
    private String appVersionNo;//": "v1.1.0",
    private String downloadUrl;//": "https://app.mi.com/details?id=com.xiaoniu.hulumusic&ref=search",
    private String isForce;//": "1",
    private String lastAppVersionNo;//": "v1.00.1"

    public String getAppVersionTitle() {
        return appVersionTitle;
    }

    @Override
    public String toString() {
        return "VersionBean{" +
                "appVersionTitle='" + appVersionTitle + '\'' +
                ", appVersionContent='" + appVersionContent + '\'' +
                ", appVersionNo='" + appVersionNo + '\'' +
                ", downloadUrl='" + downloadUrl + '\'' +
                ", isForce='" + isForce + '\'' +
                ", lastAppVersionNo='" + lastAppVersionNo + '\'' +
                '}';
    }

    public String getAppVersionContent() {
        return appVersionContent;
    }

    public String getAppVersionNo() {
        return appVersionNo;
    }

    public String getDownloadUrl() {
        return downloadUrl;
    }

    public String getIsForce() {
        return isForce;
    }

    public String getLastAppVersionNo() {
        return lastAppVersionNo;
    }

    public void setAppVersionTitle(String appVersionTitle) {
        this.appVersionTitle = appVersionTitle;
    }

    public void setAppVersionContent(String appVersionContent) {
        this.appVersionContent = appVersionContent;
    }

    public void setAppVersionNo(String appVersionNo) {
        this.appVersionNo = appVersionNo;
    }

    public void setDownloadUrl(String downloadUrl) {
        this.downloadUrl = downloadUrl;
    }

    public void setIsForce(String isForce) {
        this.isForce = isForce;
    }

    public void setLastAppVersionNo(String lastAppVersionNo) {
        this.lastAppVersionNo = lastAppVersionNo;
    }
}
