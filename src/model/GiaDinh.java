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
public class GiaDinh {

    private  String cmnd; 
    private int stt;
    private  String hoten;
    private  String quanhe; 
    private  int tuoi; 
    private  String nghenghiep;
    private  String suckhoe;
    

    public GiaDinh(String cmnd,int stt, String hoten, String quanhe, int tuoi, String nghenghiep, String suckhoe) {
        this.cmnd = cmnd;
        this.stt=stt;
        this.hoten = hoten;
        this.quanhe = quanhe;
        this.tuoi = tuoi;
        this.nghenghiep = nghenghiep;
        this.suckhoe = suckhoe;
        
    }

    public GiaDinh() {
    }

    public String getCmnd() {
        return cmnd;
    }

    public void setCmnd(String cmnd) {
        this.cmnd = cmnd;
    }

    public int getStt() {
        return stt;
    }

    public void setStt(int stt) {
        this.stt = stt;
    }

   

    public String getHoten() {
        return hoten;
    }

    public void setHoten(String hoten) {
        this.hoten = hoten;
    }

    public String getQuanhe() {
        return quanhe;
    }

    public void setQuanhe(String quanhe) {
        this.quanhe = quanhe;
    }

    public int getTuoi() {
        return tuoi;
    }

    public void setTuoi(int tuoi) {
        this.tuoi = tuoi;
    }

    public String getNghenghiep() {
        return nghenghiep;
    }

    public void setNghenghiep(String nghenghiep) {
        this.nghenghiep = nghenghiep;
    }

    public String getSuckhoe() {
        return suckhoe;
    }

    public void setSuckhoe(String suckhoe) {
        this.suckhoe = suckhoe;
    }
    
    
    
}
