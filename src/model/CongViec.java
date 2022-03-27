/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Nhat Anh
 */
public class CongViec {
     private String cmnd;	
     private String stt;
     private String batdau;
     private String ketthuc;
     private String tencongty;
     private String diachi;
     private String congviec;
     private String luong;

    public CongViec(String cmnd, String stt, String batdau, String ketthuc, String tencongty, String diachi, String congviec, String luong) {
        this.cmnd = cmnd;
        this.stt = stt;
        this.batdau = batdau;
        this.ketthuc = ketthuc;
        this.tencongty = tencongty;
        this.diachi = diachi;
        this.congviec = congviec;
        this.luong = luong;
    }

    public CongViec() {
    }

    public String getCmnd() {
        return cmnd;
    }

    public void setCmnd(String cmnd) {
        this.cmnd = cmnd;
    }

    public String getStt() {
        return stt;
    }

    public void setStt(String stt) {
        this.stt = stt;
    }

    public String getBatdau() {
        return batdau;
    }

    public void setBatdau(String batdau) {
        this.batdau = batdau;
    }

    public String getKetthuc() {
        return ketthuc;
    }

    public void setKetthuc(String ketthuc) {
        this.ketthuc = ketthuc;
    }

    public String getTencongty() {
        return tencongty;
    }

    public void setTencongty(String tencongty) {
        this.tencongty = tencongty;
    }

    public String getDiachi() {
        return diachi;
    }

    public void setDiachi(String diachi) {
        this.diachi = diachi;
    }

    public String getCongviec() {
        return congviec;
    }

    public void setCongviec(String congviec) {
        this.congviec = congviec;
    }

    public String getLuong() {
        return luong;
    }

    public void setLuong(String luong) {
        this.luong = luong;
    }
     
}
