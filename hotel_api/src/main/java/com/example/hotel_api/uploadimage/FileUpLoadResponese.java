package com.example.hotel_api.uploadimage;

public class FileUpLoadResponese {
    private String filename;
    private String dowloadUri;
    private long size;

    public FileUpLoadResponese(String filename, String dowloadUri, long size) {
        this.filename = filename;
        this.dowloadUri = dowloadUri;
        this.size = size;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public String getDowloadUri() {
        return dowloadUri;
    }

    public void setDowloadUri(String dowloadUri) {
        this.dowloadUri = dowloadUri;
    }

    public long getSize() {
        return size;
    }

    public void setSize(long size) {
        this.size = size;
    }
}
