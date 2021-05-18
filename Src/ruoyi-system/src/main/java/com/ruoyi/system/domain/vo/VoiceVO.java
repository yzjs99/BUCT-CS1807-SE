package com.ruoyi.system.domain.vo;

public class VoiceVO {
    private long id;
    private byte[] voice;
    public VoiceVO(long id, byte[] voice) {
        this.id = id;
        this.voice = voice;
    }
    public byte[] getVoice() {
        return voice;
    }

    public void setVoice(byte[] voice) {
        this.voice = voice;
    }

    public VoiceVO(byte[] voice) {
        this.voice = voice;
    }
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}




