//package it.davidenastri.clouddrive.model;
//
//import lombok.Getter;
//import lombok.Setter;
//
//@Getter
//@Setter
//public class File {
//
//    private Integer fileid;
//    private String filename;
//    private String contenttype;
//    private String filesize;
//    private Integer userid;
//    private byte[] filedata;
//
//    public File() {
//    }
//
//    public File(Integer fileid, String filename, String contenttype, String filesize, Integer userid, byte[] filedata) {
//        this.fileid = fileid;
//        this.filename = filename;
//        this.contenttype = contenttype;
//        this.filesize = filesize;
//        this.userid = userid;
//        this.filedata = filedata;
//    }
//
//}
package it.davidenastri.clouddrive.model;

import java.sql.Timestamp;

public class File {
    private Integer fileId;
    private String filePath;  // Thêm trường này

    private String fileName;
    private String contentType;
    private Integer fileSize;
    private String fileHash;
    private Integer userId;
    private Integer folderId;
    private Timestamp createdAt;

    // Getters and Setters
    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }
    public Integer getFileId() {
        return fileId;
    }

    public void setFileId(Integer fileId) {
        this.fileId = fileId;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public Integer getFileSize() {
        return fileSize;
    }

    public void setFileSize(Integer fileSize) {
        this.fileSize = fileSize;
    }

    public String getFileHash() {
        return fileHash;
    }

    public void setFileHash(String fileHash) {
        this.fileHash = fileHash;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getFolderId() {
        return folderId;
    }

    public void setFolderId(Integer folderId) {
        this.folderId = folderId;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }
}
