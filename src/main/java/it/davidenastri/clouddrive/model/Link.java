package it.davidenastri.clouddrive.model;

import java.sql.Timestamp;

public class Link {
    private Integer linkId;
    private String linkUrl;
    private Integer fileId;
    private Integer folderId;
    private Timestamp expiresAt;
    private Integer createdBy;
    private Timestamp createdAt;

    // Getters and Setters
    public Integer getLinkId() {
        return linkId;
    }

    public void setLinkId(Integer linkId) {
        this.linkId = linkId;
    }

    public String getLinkUrl() {
        return linkUrl;
    }

    public void setLinkUrl(String linkUrl) {
        this.linkUrl = linkUrl;
    }

    public Integer getFileId() {
        return fileId;
    }

    public void setFileId(Integer fileId) {
        this.fileId = fileId;
    }

    public Integer getFolderId() {
        return folderId;
    }

    public void setFolderId(Integer folderId) {
        this.folderId = folderId;
    }

    public Timestamp getExpiresAt() {
        return expiresAt;
    }

    public void setExpiresAt(Timestamp expiresAt) {
        this.expiresAt = expiresAt;
    }

    public Integer getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(Integer createdBy) {
        this.createdBy = createdBy;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }
    @Override
    public String toString() {
        return "Link{" +
                "linkId=" + linkId +
                ", linkUrl='" + linkUrl + '\'' +
                ", fileId=" + fileId +
                ", folderId=" + folderId +
                ", expiresAt=" + expiresAt +
                ", createdBy=" + createdBy +
                ", createdAt=" + createdAt +
                '}';
    }

}
