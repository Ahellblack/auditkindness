package com.siti.broadcast.vo;

public class DockingMissionVo {
    private Integer id;
    private String title; // 接收方信息
    private String body; // 物資名稱
    private Integer status; // 狀態
    private String links; // 附件路徑(多個附件用;隔開)
    private String updateTime; // 更新時間
    private String[] attachment; // 附件List

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getLinks() {
        return links;
    }

    public void setLinks(String links) {
        this.links = links;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    public String[] getAttachment() {
        if (links != null && !"".equals(links)) {
            return links.split(";");
        } else {
            return attachment;
        }
    }

    public void setAttachment(String[] attachment) {
        this.attachment = attachment;
    }
}
