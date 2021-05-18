package com.ruoyi.system.domain.vo;

public class ImageVO {

    private long id;
    private byte[] image;

    public ImageVO(long id, byte[] image) {
        this.id = id;
        this.image = image;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
    public ImageVO(byte[] image) {
        this.image = image;
    }
    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }
}
