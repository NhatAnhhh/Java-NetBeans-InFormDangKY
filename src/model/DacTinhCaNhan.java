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
public class DacTinhCaNhan {
    private  String cmnd; 
    private  String mucdich; 
    private  String diemmanh;
    private  String diemyeu; 
    private  String sothich; 
    private  String venuoclamgi;
    private  String venuocnhat;
    private  String sotien3nam;
    private  String guiveque;

    public DacTinhCaNhan(String cmnd, String mucdich, String diemmanh, String diemyeu, String sothich, String venuoclamgi, String venuocnhat, String sotien3nam, String guiveque) {
        this.cmnd = cmnd;
        this.mucdich = mucdich;
        this.diemmanh = diemmanh;
        this.diemyeu = diemyeu;
        this.sothich = sothich;
        this.venuoclamgi = venuoclamgi;
        this.venuocnhat = venuocnhat;
        this.sotien3nam = sotien3nam;
        this.guiveque = guiveque;
    }

    public DacTinhCaNhan() {
    }

    public String getCmnd() {
        return cmnd;
    }

    public void setCmnd(String cmnd) {
        this.cmnd = cmnd;
    }

    public String getMucdich() {
        return mucdich;
    }

    public void setMucdich(String mucdich) {
        this.mucdich = mucdich;
    }

    public String getDiemmanh() {
        return diemmanh;
    }

    public void setDiemmanh(String diemmanh) {
        this.diemmanh = diemmanh;
    }

    public String getDiemyeu() {
        return diemyeu;
    }

    public void setDiemyeu(String diemyeu) {
        this.diemyeu = diemyeu;
    }

    public String getSothich() {
        return sothich;
    }

    public void setSothich(String sothich) {
        this.sothich = sothich;
    }

    public String getVenuoclamgi() {
        return venuoclamgi;
    }

    public void setVenuoclamgi(String venuoclamgi) {
        this.venuoclamgi = venuoclamgi;
    }

    public String getVenuocnhat() {
        return venuocnhat;
    }

    public void setVenuocnhat(String venuocnhat) {
        this.venuocnhat = venuocnhat;
    }

    public String getSotien3nam() {
        return sotien3nam;
    }

    public void setSotien3nam(String sotien3nam) {
        this.sotien3nam = sotien3nam;
    }

    public String getGuiveque() {
        return guiveque;
    }

    public void setGuiveque(String guiveque) {
        this.guiveque = guiveque;
    }

 
    
}