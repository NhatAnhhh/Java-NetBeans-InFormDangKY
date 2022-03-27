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
public class ThongTinKhac {
    private  String cmnd; 
    
    private  String nguoithan;
    private  String dennhat;
    private  String dinhatgd; 
    private  String lolang;//
    private  String conguoiquendk; //
    private  String bietdgquadau;//
    private  String hotennguoiquen;//
    private  String kytucxa;//
    private  String nganh;//
   

    public ThongTinKhac(String cmnd,String nguoithan,String dennhat,String dinhatgd, String lolang, String conguoiquendk, String bietdgquadau, String hotennguoiquen, String kytucxa, String nganh) {
        this.cmnd = cmnd;
        
        this.nguoithan = nguoithan;
        this.dennhat = dennhat;
        this.dinhatgd = dinhatgd;
        this.lolang = lolang;
        this.conguoiquendk = conguoiquendk;
        this.bietdgquadau = bietdgquadau;
        this.hotennguoiquen = hotennguoiquen;
        this.kytucxa = kytucxa;
        this.nganh = nganh;
    }

    public ThongTinKhac() {
    }

    public String getCmnd() {
        return cmnd;
    }

    public void setCmnd(String cmnd) {
        this.cmnd = cmnd;
    }

   
    public String getLolang() {
        return lolang;
    }

    public void setLolang(String lolang) {
        this.lolang = lolang;
    }

    public String getConguoiquendk() {
        return conguoiquendk;
    }

    public void setConguoiquendk(String conguoiquendk) {
        this.conguoiquendk = conguoiquendk;
    }

    public String getBietdgquadau() {
        return bietdgquadau;
    }

    public void setBietdgquadau(String bietdgquadau) {
        this.bietdgquadau = bietdgquadau;
    }

    public String getHotennguoiquen() {
        return hotennguoiquen;
    }

    public void setHotennguoiquen(String hotennguoiquen) {
        this.hotennguoiquen = hotennguoiquen;
    }

    public String getKytucxa() {
        return kytucxa;
    }

    public void setKytucxa(String kytucxa) {
        this.kytucxa = kytucxa;
    }

    public String getNganh() {
        return nganh;
    }

    public void setNganh(String nganh) {
        this.nganh = nganh;
    }
    
    public String getNguoithan() {
        return nguoithan;
    }

    public void setNguoithan(String nguoithan) {
        this.nguoithan = nguoithan;
    } 
    
    public String getDennhat() {
        return dennhat;
    }

    public void setDennhat(String dennhat) {
        this.dennhat = dennhat;
    }
   
    public String getDinhatgd() {
        return dinhatgd;
    }

    public void setDinhatgd(String dinhatgd) {
        this.dinhatgd = dinhatgd;
    } 
}
