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
public class HocVan {
     private  String cmnd; 
    private int cap;
    private  String batdautu;
    private  String ketthuc;
    private  String tentruong; 
    private  String diachi;
    private  String totnghiep;

    public HocVan(String cmnd,int cap, String batdautu, String ketthuc, String tentruong, String diachi, String totnghiep) {
        this.cmnd = cmnd;
        this.cap=cap;
        this.batdautu = batdautu;
        this.ketthuc = ketthuc;
        this.tentruong = tentruong;
        this.diachi = diachi;
        this.totnghiep = totnghiep;
    }

    public HocVan() {
    }

    public String getCmnd() {
        return cmnd;
    }

    public void setCmnd(String cmnd) {
        this.cmnd = cmnd;
    }

    public int getCap() {
        return cap;
    }

    public void setCap(int cap) {
        this.cap = cap;
    }

    
    public String getBatdautu() {
        return batdautu;
    }

    public void setBatdautu(String batdautu) {
        this.batdautu = batdautu;
    }

    public String getKetthuc() {
        return ketthuc;
    }

    public void setKetthuc(String ketthuc) {
        this.ketthuc = ketthuc;
    }

    public String getTentruong() {
        return tentruong;
    }

    public void setTentruong(String tentruong) {
        this.tentruong = tentruong;
    }

    public String getDiachi() {
        return diachi;
    }

    public void setDiachi(String diachi) {
        this.diachi = diachi;
    }

    public String getTotnghiep() {
        return totnghiep;
    }

    public void setTotnghiep(String totnghiep) {
        this.totnghiep = totnghiep;
    }
    
}
