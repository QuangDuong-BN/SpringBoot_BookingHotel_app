package com.example.hotel_api.entities;

public class ImageData {
    private String id;
    private String id_khoa_ngoai;
    private String file_path;

    public ImageData() {
    }

    public ImageData(String id, String id_khoa_ngoai, String file_path) {
        this.id = id;
        this.id_khoa_ngoai = id_khoa_ngoai;
        this.file_path = file_path;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId_khoa_ngoai() {
        return id_khoa_ngoai;
    }

    public void setId_khoa_ngoai(String id_khoa_ngoai) {
        this.id_khoa_ngoai = id_khoa_ngoai;
    }

    public String getFile_path() {
        return file_path;
    }

    public void setFile_path(String file_path) {
        this.file_path = file_path;
    }
}
