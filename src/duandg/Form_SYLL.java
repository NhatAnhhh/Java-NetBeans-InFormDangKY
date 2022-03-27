/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package duandg;

import Access.CongViecUser;
import Access.DacTinhCaNhanUser;
import Access.GiaDinhUser;
import Access.HocVanUser;
import Access.ThongTinCaNhanDAO;
import Access.ThongTinKhacUser;
import Access.TinhTrangSucKhoeUser;
import java.util.List;
import model.CongViec;
import model.DacTinhCaNhan;
import model.GiaDinh;
import model.HocVan;
import model.ThongTinCaNhan;
import model.ThongTinKhac;
import model.TinhTrangSucKhoe;

/**
 *
 * @author Nhat Anh
 */
public class Form_SYLL extends javax.swing.JFrame {
     ThongTinCaNhanDAO ttcn;
     TinhTrangSucKhoeUser sk;
     DacTinhCaNhanUser dt;
     ThongTinKhacUser ttk;
     GiaDinhUser gd;
     HocVanUser hv;
     CongViecUser cv;
     
     private void getdl(){
       ttcn=new ThongTinCaNhanDAO();
       sk=new TinhTrangSucKhoeUser();
       dt=new DacTinhCaNhanUser();
       ttk= new ThongTinKhacUser();
       gd= new GiaDinhUser();
       hv= new HocVanUser();
       cv= new CongViecUser();
       
       TinhTrangSucKhoe suckhoe= sk.getAllUsers(cmnd);
       ThongTinCaNhan thongtin= ttcn.getUsers(cmnd);
       DacTinhCaNhan dtcn= dt.getAllUsers(cmnd);
       ThongTinKhac ttkhac= ttk.getAllUsers(cmnd);
       List<GiaDinh> listgd= gd.getAllUsers(cmnd);
       List<HocVan> listhv= hv.getAllUsers(cmnd);
       List<CongViec> listcv= cv.getAllUsers(cmnd);
       
       jhoten.setText(thongtin.getHoten());
       
       jgioitinh.setText(thongtin.getGioitinh());      
       jngaysinh.setText(thongtin.getNgaysinh());
       jhonnhan.setText(thongtin.getHonnhan());
       jtuoi.setText(thongtin.getTuoi());
       
        jchieucao.setText(suckhoe.getChieucao());
        jcannang.setText(suckhoe.getCannang());
        jnhommau.setText(suckhoe.getNhommau());
        
        jmattrai.setText(suckhoe.getMattrai());
        jmatphai.setText(suckhoe.getMatphai());
        jdeokinh.setText(suckhoe.getDeokinh());
        jmumau.setText(suckhoe.getMumau());
        
        
        jdinhat.setText(dtcn.getMucdich());
        jdiemyeu.setText(dtcn.getDiemyeu());
        jsothich.setText(dtcn.getSothich());
        jvevn.setText(dtcn.getVenuoclamgi());
        jbietgi.setText(dtcn.getVenuocnhat());
        jgiadinh.setText(ttkhac.getDinhatgd());
        jdiachi.setText(thongtin.getHokhau());
        
        insertgiadinh(listgd);
        insertcongviec(listcv);
        insethocvan(listhv);
       
    /**
     * Creates new form Form_SYLL
     */
     }
      public Form_SYLL() {
        initComponents();
    }
    public Form_SYLL(String cmnd) {
        initComponents();
        this.cmnd=cmnd;
        
        getdl();
        
    }
      private String cmnd;
    private void insertgiadinh(List<GiaDinh> ls){
        GiaDinh g= new GiaDinh();
        if(ls.size()==2){
            ls.add(g);
            ls.add(g);
            System.out.println("2");
        }
        else if(ls.size()==3){
            ls.add(g);
            System.out.println("3");
        }
        GiaDinh gd1= ls.get(0);
        GiaDinh gd2= ls.get(1);
        GiaDinh gd3= ls.get(2);
        GiaDinh gd4= ls.get(3);
        
        jtengd1.setText(gd1.getHoten());
        jtuoigd1.setText(String.valueOf(gd1.getTuoi()));
        jnghegd1.setText(gd1.getNghenghiep());
        jquanhe1.setText(gd1.getQuanhe());
        jttskgd1.setText(gd1.getSuckhoe());
        
        jtengd2.setText(gd2.getHoten());
        jtuoigd2.setText(String.valueOf(gd2.getTuoi()));
        jnghegd2.setText(gd2.getNghenghiep());
        jquanhe2.setText(gd2.getQuanhe());
        jttskgd2.setText(gd2.getSuckhoe());
        if(gd3.getHoten()!=null)
        {
            jtengd3.setText(gd3.getHoten());
            jtuoigd3.setText(String.valueOf(gd3.getTuoi()));
            jnghegd3.setText(gd3.getNghenghiep());
            jquanhe3.setText(gd3.getQuanhe());
            jttskgd3.setText(gd3.getSuckhoe());
        }
        if(gd4.getHoten()!=null)
        {
            jtengd4.setText(gd4.getHoten());
            jtuoigd4.setText(String.valueOf(gd4.getTuoi()));
            jnghegd4.setText(gd4.getNghenghiep());
            jquanhe4.setText(gd4.getQuanhe());
            jttskgd4.setText(gd4.getSuckhoe());
        }
    }
    private void insertcongviec(List<CongViec> ls){
        CongViec c= new CongViec();
        if(ls.size()==0){
            ls.add(c);
            ls.add(c);
            ls.add(c);
        }
        else if(ls.size()==1){
            ls.add(c);
            ls.add(c);
        }
        else if(ls.size()==2){
            ls.add(c);
        }
        CongViec cv1= ls.get(0);
        CongViec cv2= ls.get(1);
        CongViec cv3= ls.get(2);
        
        if(cv1.getLuong()!=null){
            jngayvao1.setText(cv1.getBatdau());
            jktlv1.setText(cv1.getKetthuc());
            jtenct1.setText(cv1.getTencongty());
            jctdl1.setText(cv1.getCongviec());
            
        }
        if(cv2.getLuong()!=null){
            jngayvao2.setText(cv2.getBatdau());
            jktlv2.setText(cv2.getKetthuc());
            jtenct2.setText(cv2.getTencongty());
            jctdl2.setText(cv2.getCongviec());
        }
        if(cv3.getLuong()!=null){
            jngayvao3.setText(cv3.getBatdau());
            jktlv3.setText(cv3.getKetthuc());
            jtenct3.setText(cv3.getTencongty());
            jctdl3.setText(cv3.getCongviec());
        }
    }
    private void insethocvan(List<HocVan> ls){
        HocVan h= new HocVan();
        if(ls.size()==0){
            ls.add(h);
            ls.add(h);
            ls.add(h);
            ls.add(h);
        }else if(ls.size()==1){
            ls.add(h);
            ls.add(h);
            ls.add(h);
        }else if(ls.size()==2){
            ls.add(h);
            ls.add(h);
        }else if(ls.size()==3) ls.add(h);
        HocVan hv1=ls.get(0);
        HocVan hv2=ls.get(1);
        HocVan hv3=ls.get(2);
        HocVan hv4=ls.get(3);
        if(hv1.getTotnghiep()!=null){
           jnhaphoc1.setText(hv1.getBatdautu());
           jketthucht1.setText(hv1.getKetthuc());
           jtentruong1.setText(hv1.getTentruong());
           jdatn1.setText(hv1.getTotnghiep());
           jchuatn1.setText(hv1.getTotnghiep());
           jktht1.setText(hv1.getKetthuc());
        }
        if(hv2.getTotnghiep()!=null){
            jnhaphoc2.setText(hv2.getBatdautu());
           jketthucht2.setText(hv2.getKetthuc());
           jtentruong2.setText(hv2.getTentruong());
           jdatn2.setText(hv2.getTotnghiep());
           jchuatn2.setText(hv2.getTotnghiep());
           jktht2.setText(hv2.getKetthuc());
        }
        if(hv3.getTotnghiep()!=null){
            jnhaphoc3.setText(hv3.getBatdautu());
           jketthucht3.setText(hv3.getKetthuc());
           jtentruong3.setText(hv3.getTentruong());
           jdatn3.setText(hv3.getTotnghiep());
           jchuatn3.setText(hv3.getTotnghiep());
           jktht3.setText(hv3.getKetthuc());
        }
        if(hv4.getTotnghiep()!=null){
            jnhaphoc4.setText(hv4.getBatdautu());
           jketthucht4.setText(hv4.getKetthuc());
           jtentruong4.setText(hv4.getTentruong());
           jdatn4.setText(hv4.getTotnghiep());
           jchuatn4.setText(hv4.getTotnghiep());
           jktht4.setText(hv4.getKetthuc());
        }
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSYLL = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel46 = new javax.swing.JLabel();
        jLabel47 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jLabel48 = new javax.swing.JLabel();
        jLabel42 = new javax.swing.JLabel();
        jLabel67 = new javax.swing.JLabel();
        jLabel68 = new javax.swing.JLabel();
        jPanel51 = new javax.swing.JPanel();
        jLabel52 = new javax.swing.JLabel();
        jLabel59 = new javax.swing.JLabel();
        jPanel53 = new javax.swing.JPanel();
        jLabel44 = new javax.swing.JLabel();
        jLabel54 = new javax.swing.JLabel();
        jPanel54 = new javax.swing.JPanel();
        jLabel45 = new javax.swing.JLabel();
        jLabel55 = new javax.swing.JLabel();
        jPanel55 = new javax.swing.JPanel();
        jLabel49 = new javax.swing.JLabel();
        jLabel56 = new javax.swing.JLabel();
        jPanel32 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel56 = new javax.swing.JPanel();
        jLabel50 = new javax.swing.JLabel();
        jLabel57 = new javax.swing.JLabel();
        jPanel57 = new javax.swing.JPanel();
        jLabel51 = new javax.swing.JLabel();
        jLabel58 = new javax.swing.JLabel();
        jPanel58 = new javax.swing.JPanel();
        jLabel43 = new javax.swing.JLabel();
        jLabel53 = new javax.swing.JLabel();
        jPanel60 = new javax.swing.JPanel();
        jgiadinh = new javax.swing.JLabel();
        jTextField113 = new javax.swing.JTextField();
        jPanel62 = new javax.swing.JPanel();
        jPanel63 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jPanel12 = new javax.swing.JPanel();
        jgioitinh1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jPanel14 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jPanel18 = new javax.swing.JPanel();
        jPanel242 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel156 = new javax.swing.JLabel();
        jLabel157 = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        jhoten = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        jPanel15 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jPanel17 = new javax.swing.JPanel();
        jhonnhan = new javax.swing.JLabel();
        jTextField5 = new javax.swing.JTextField();
        jPanel16 = new javax.swing.JPanel();
        jngaysinh = new javax.swing.JLabel();
        jTextField6 = new javax.swing.JTextField();
        jPanel9 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jPanel13 = new javax.swing.JPanel();
        jtuoi = new javax.swing.JLabel();
        jTextField7 = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jPanel262 = new javax.swing.JPanel();
        jLabel152 = new javax.swing.JLabel();
        jLabel153 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jTextField8 = new javax.swing.JTextField();
        jTextField9 = new javax.swing.JTextField();
        jTextField10 = new javax.swing.JTextField();
        jTextField11 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jgioitinh = new javax.swing.JLabel();
        jPanel34 = new javax.swing.JPanel();
        jLabel38 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        jPanel35 = new javax.swing.JPanel();
        jLabel81 = new javax.swing.JLabel();
        jLabel98 = new javax.swing.JLabel();
        jPanel36 = new javax.swing.JPanel();
        jnhommau = new javax.swing.JLabel();
        jPanel37 = new javax.swing.JPanel();
        jLabel70 = new javax.swing.JLabel();
        jLabel72 = new javax.swing.JLabel();
        jPanel38 = new javax.swing.JPanel();
        jchieucao = new javax.swing.JLabel();
        jPanel39 = new javax.swing.JPanel();
        jLabel34 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        jPanel40 = new javax.swing.JPanel();
        jLabel36 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        jPanel41 = new javax.swing.JPanel();
        jLabel73 = new javax.swing.JLabel();
        jLabel74 = new javax.swing.JLabel();
        jPanel42 = new javax.swing.JPanel();
        jLabel69 = new javax.swing.JLabel();
        jLabel71 = new javax.swing.JLabel();
        jPanel43 = new javax.swing.JPanel();
        jdeokinh = new javax.swing.JLabel();
        jPanel44 = new javax.swing.JPanel();
        jmumau = new javax.swing.JLabel();
        jPanel45 = new javax.swing.JPanel();
        jcannang = new javax.swing.JLabel();
        jPanel46 = new javax.swing.JPanel();
        jLabel75 = new javax.swing.JLabel();
        jLabel76 = new javax.swing.JLabel();
        jPanel47 = new javax.swing.JPanel();
        jLabel77 = new javax.swing.JLabel();
        jLabel94 = new javax.swing.JLabel();
        jPanel48 = new javax.swing.JPanel();
        jLabel78 = new javax.swing.JLabel();
        jLabel95 = new javax.swing.JLabel();
        jPanel49 = new javax.swing.JPanel();
        jCheckBox5 = new javax.swing.JCheckBox();
        jPanel33 = new javax.swing.JPanel();
        jmatphai = new javax.swing.JLabel();
        jmattrai = new javax.swing.JLabel();
        jPanel50 = new javax.swing.JPanel();
        jLabel80 = new javax.swing.JLabel();
        jLabel97 = new javax.swing.JLabel();
        jPanel52 = new javax.swing.JPanel();
        jLabel79 = new javax.swing.JLabel();
        jLabel96 = new javax.swing.JLabel();
        jPanel80 = new javax.swing.JPanel();
        jLabel110 = new javax.swing.JLabel();
        jLabel93 = new javax.swing.JLabel();
        jPanel81 = new javax.swing.JPanel();
        jLabel85 = new javax.swing.JLabel();
        jLabel102 = new javax.swing.JLabel();
        jPanel82 = new javax.swing.JPanel();
        jLabel86 = new javax.swing.JLabel();
        jLabel103 = new javax.swing.JLabel();
        jPanel83 = new javax.swing.JPanel();
        jLabel87 = new javax.swing.JLabel();
        jLabel104 = new javax.swing.JLabel();
        jPanel84 = new javax.swing.JPanel();
        jLabel88 = new javax.swing.JLabel();
        jLabel105 = new javax.swing.JLabel();
        jPanel85 = new javax.swing.JPanel();
        jPanel86 = new javax.swing.JPanel();
        jLabel82 = new javax.swing.JLabel();
        jLabel99 = new javax.swing.JLabel();
        jPanel87 = new javax.swing.JPanel();
        jLabel83 = new javax.swing.JLabel();
        jLabel100 = new javax.swing.JLabel();
        jPanel88 = new javax.swing.JPanel();
        jCheckBox12 = new javax.swing.JCheckBox();
        jPanel89 = new javax.swing.JPanel();
        jCheckBox11 = new javax.swing.JCheckBox();
        jPanel90 = new javax.swing.JPanel();
        jPanel31 = new javax.swing.JPanel();
        jPanel103 = new javax.swing.JPanel();
        jCheckBox6 = new javax.swing.JCheckBox();
        jPanel91 = new javax.swing.JPanel();
        jCheckBox2 = new javax.swing.JCheckBox();
        jPanel92 = new javax.swing.JPanel();
        jCheckBox3 = new javax.swing.JCheckBox();
        jPanel93 = new javax.swing.JPanel();
        jCheckBox4 = new javax.swing.JCheckBox();
        jPanel94 = new javax.swing.JPanel();
        jLabel84 = new javax.swing.JLabel();
        jLabel101 = new javax.swing.JLabel();
        jPanel95 = new javax.swing.JPanel();
        jLabel89 = new javax.swing.JLabel();
        jLabel106 = new javax.swing.JLabel();
        jPanel96 = new javax.swing.JPanel();
        jLabel90 = new javax.swing.JLabel();
        jLabel107 = new javax.swing.JLabel();
        jPanel97 = new javax.swing.JPanel();
        jLabel108 = new javax.swing.JLabel();
        jLabel91 = new javax.swing.JLabel();
        jPanel98 = new javax.swing.JPanel();
        jLabel109 = new javax.swing.JLabel();
        jLabel92 = new javax.swing.JLabel();
        jPanel99 = new javax.swing.JPanel();
        jCheckBox1 = new javax.swing.JCheckBox();
        jPanel100 = new javax.swing.JPanel();
        jCheckBox10 = new javax.swing.JCheckBox();
        jPanel101 = new javax.swing.JPanel();
        jCheckBox9 = new javax.swing.JCheckBox();
        jPanel102 = new javax.swing.JPanel();
        jCheckBox8 = new javax.swing.JCheckBox();
        jPanel105 = new javax.swing.JPanel();
        jLabel130 = new javax.swing.JLabel();
        jLabel136 = new javax.swing.JLabel();
        jPanel106 = new javax.swing.JPanel();
        jTextField123 = new javax.swing.JTextField();
        jnhaphoc1 = new javax.swing.JLabel();
        jPanel107 = new javax.swing.JPanel();
        jTextField126 = new javax.swing.JTextField();
        jnhaphoc2 = new javax.swing.JLabel();
        jPanel108 = new javax.swing.JPanel();
        jTextField127 = new javax.swing.JTextField();
        jnhaphoc3 = new javax.swing.JLabel();
        jPanel109 = new javax.swing.JPanel();
        jTextField135 = new javax.swing.JTextField();
        jnhaphoc4 = new javax.swing.JLabel();
        jPanel110 = new javax.swing.JPanel();
        jTextField136 = new javax.swing.JTextField();
        jnhaphoc5 = new javax.swing.JLabel();
        jPanel111 = new javax.swing.JPanel();
        jLabel111 = new javax.swing.JLabel();
        jLabel117 = new javax.swing.JLabel();
        jPanel112 = new javax.swing.JPanel();
        jchuatn6 = new javax.swing.JLabel();
        jTextField28 = new javax.swing.JTextField();
        jPanel113 = new javax.swing.JPanel();
        jTextField124 = new javax.swing.JTextField();
        jketthucht1 = new javax.swing.JLabel();
        jPanel114 = new javax.swing.JPanel();
        jTextField125 = new javax.swing.JTextField();
        jketthucht2 = new javax.swing.JLabel();
        jPanel115 = new javax.swing.JPanel();
        jTextField133 = new javax.swing.JTextField();
        jketthucht3 = new javax.swing.JLabel();
        jPanel116 = new javax.swing.JPanel();
        jTextField134 = new javax.swing.JTextField();
        jketthucht4 = new javax.swing.JLabel();
        jPanel117 = new javax.swing.JPanel();
        jTextField137 = new javax.swing.JTextField();
        jketthucht5 = new javax.swing.JLabel();
        jPanel119 = new javax.swing.JPanel();
        jLabel113 = new javax.swing.JLabel();
        jLabel119 = new javax.swing.JLabel();
        jPanel120 = new javax.swing.JPanel();
        jTextField117 = new javax.swing.JTextField();
        jtentruong6 = new javax.swing.JLabel();
        jPanel121 = new javax.swing.JPanel();
        jLabel126 = new javax.swing.JLabel();
        jLabel132 = new javax.swing.JLabel();
        jPanel122 = new javax.swing.JPanel();
        jLabel127 = new javax.swing.JLabel();
        jLabel133 = new javax.swing.JLabel();
        jPanel123 = new javax.swing.JPanel();
        jLabel128 = new javax.swing.JLabel();
        jLabel134 = new javax.swing.JLabel();
        jPanel124 = new javax.swing.JPanel();
        jLabel129 = new javax.swing.JLabel();
        jLabel135 = new javax.swing.JLabel();
        jPanel125 = new javax.swing.JPanel();
        jLabel112 = new javax.swing.JLabel();
        jLabel118 = new javax.swing.JLabel();
        jPanel126 = new javax.swing.JPanel();
        jktht6 = new javax.swing.JLabel();
        jTextField33 = new javax.swing.JTextField();
        jPanel128 = new javax.swing.JPanel();
        jTextField118 = new javax.swing.JTextField();
        jdatn2 = new javax.swing.JLabel();
        jPanel129 = new javax.swing.JPanel();
        jTextField119 = new javax.swing.JTextField();
        jdatn3 = new javax.swing.JLabel();
        jPanel130 = new javax.swing.JPanel();
        jTextField120 = new javax.swing.JTextField();
        jdatn4 = new javax.swing.JLabel();
        jPanel131 = new javax.swing.JPanel();
        jTextField121 = new javax.swing.JTextField();
        jdatn5 = new javax.swing.JLabel();
        jPanel132 = new javax.swing.JPanel();
        jTextField122 = new javax.swing.JTextField();
        jdatn6 = new javax.swing.JLabel();
        jPanel133 = new javax.swing.JPanel();
        jLabel115 = new javax.swing.JLabel();
        jLabel121 = new javax.swing.JLabel();
        jPanel135 = new javax.swing.JPanel();
        jchuatn2 = new javax.swing.JLabel();
        jTextField24 = new javax.swing.JTextField();
        jPanel136 = new javax.swing.JPanel();
        jchuatn3 = new javax.swing.JLabel();
        jTextField25 = new javax.swing.JTextField();
        jPanel137 = new javax.swing.JPanel();
        jchuatn4 = new javax.swing.JLabel();
        jTextField26 = new javax.swing.JTextField();
        jPanel138 = new javax.swing.JPanel();
        jchuatn5 = new javax.swing.JLabel();
        jTextField27 = new javax.swing.JTextField();
        jPanel139 = new javax.swing.JPanel();
        jLabel114 = new javax.swing.JLabel();
        jLabel120 = new javax.swing.JLabel();
        jPanel140 = new javax.swing.JPanel();
        jLabel116 = new javax.swing.JLabel();
        jLabel122 = new javax.swing.JLabel();
        jPanel141 = new javax.swing.JPanel();
        jktht1 = new javax.swing.JLabel();
        jTextField22 = new javax.swing.JTextField();
        jPanel142 = new javax.swing.JPanel();
        jktht2 = new javax.swing.JLabel();
        jTextField29 = new javax.swing.JTextField();
        jPanel143 = new javax.swing.JPanel();
        jktht3 = new javax.swing.JLabel();
        jTextField30 = new javax.swing.JTextField();
        jPanel144 = new javax.swing.JPanel();
        jktht4 = new javax.swing.JLabel();
        jTextField31 = new javax.swing.JTextField();
        jPanel145 = new javax.swing.JPanel();
        jktht5 = new javax.swing.JLabel();
        jTextField32 = new javax.swing.JTextField();
        jPanel146 = new javax.swing.JPanel();
        jLabel125 = new javax.swing.JLabel();
        jLabel131 = new javax.swing.JLabel();
        jPanel147 = new javax.swing.JPanel();
        jLabel123 = new javax.swing.JLabel();
        jLabel124 = new javax.swing.JLabel();
        jPanel148 = new javax.swing.JPanel();
        jtentruong1 = new javax.swing.JLabel();
        jTextField19 = new javax.swing.JTextField();
        jPanel149 = new javax.swing.JPanel();
        jTextField23 = new javax.swing.JTextField();
        jtentruong2 = new javax.swing.JLabel();
        jPanel150 = new javax.swing.JPanel();
        jTextField114 = new javax.swing.JTextField();
        jtentruong3 = new javax.swing.JLabel();
        jPanel151 = new javax.swing.JPanel();
        jTextField116 = new javax.swing.JTextField();
        jtentruong5 = new javax.swing.JLabel();
        jPanel260 = new javax.swing.JPanel();
        jTextField115 = new javax.swing.JTextField();
        jtentruong4 = new javax.swing.JLabel();
        jPanel261 = new javax.swing.JPanel();
        jCheckBox7 = new javax.swing.JCheckBox();
        jPanel30 = new javax.swing.JPanel();
        jPanel127 = new javax.swing.JPanel();
        jdatn1 = new javax.swing.JLabel();
        jTextField109 = new javax.swing.JTextField();
        jPanel134 = new javax.swing.JPanel();
        jchuatn1 = new javax.swing.JLabel();
        jTextField21 = new javax.swing.JTextField();
        jPanel104 = new javax.swing.JPanel();
        jTextField138 = new javax.swing.JTextField();
        jnhaphoc6 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jTextField139 = new javax.swing.JTextField();
        jketthucht6 = new javax.swing.JLabel();
        jLabel137 = new javax.swing.JLabel();
        jLabel138 = new javax.swing.JLabel();
        jPanel155 = new javax.swing.JPanel();
        jLabel139 = new javax.swing.JLabel();
        jLabel140 = new javax.swing.JLabel();
        jPanel157 = new javax.swing.JPanel();
        jTextField128 = new javax.swing.JTextField();
        jngayvao1 = new javax.swing.JLabel();
        jPanel158 = new javax.swing.JPanel();
        jTextField129 = new javax.swing.JTextField();
        jngayvao2 = new javax.swing.JLabel();
        jPanel161 = new javax.swing.JPanel();
        jLabel149 = new javax.swing.JLabel();
        jLabel150 = new javax.swing.JLabel();
        jPanel162 = new javax.swing.JPanel();
        jktlv1 = new javax.swing.JLabel();
        jTextField132 = new javax.swing.JTextField();
        jPanel166 = new javax.swing.JPanel();
        jLabel147 = new javax.swing.JLabel();
        jLabel148 = new javax.swing.JLabel();
        jPanel170 = new javax.swing.JPanel();
        jLabel141 = new javax.swing.JLabel();
        jLabel142 = new javax.swing.JLabel();
        jPanel174 = new javax.swing.JPanel();
        jTextField34 = new javax.swing.JTextField();
        jTextField193 = new javax.swing.JTextField();
        jPanel175 = new javax.swing.JPanel();
        jLabel143 = new javax.swing.JLabel();
        jLabel144 = new javax.swing.JLabel();
        jPanel179 = new javax.swing.JPanel();
        jTextField147 = new javax.swing.JTextField();
        jctdl1 = new javax.swing.JLabel();
        jPanel180 = new javax.swing.JPanel();
        jLabel145 = new javax.swing.JLabel();
        jLabel146 = new javax.swing.JLabel();
        jPanel181 = new javax.swing.JPanel();
        jTextField143 = new javax.swing.JTextField();
        jTextField192 = new javax.swing.JTextField();
        jPanel154 = new javax.swing.JPanel();
        jPanel159 = new javax.swing.JPanel();
        jTextField130 = new javax.swing.JTextField();
        jngayvao3 = new javax.swing.JLabel();
        jPanel164 = new javax.swing.JPanel();
        jktlv3 = new javax.swing.JLabel();
        jTextField141 = new javax.swing.JTextField();
        jPanel163 = new javax.swing.JPanel();
        jktlv2 = new javax.swing.JLabel();
        jTextField140 = new javax.swing.JTextField();
        jPanel169 = new javax.swing.JPanel();
        jtenct3 = new javax.swing.JLabel();
        jTextField40 = new javax.swing.JTextField();
        jPanel168 = new javax.swing.JPanel();
        jtenct2 = new javax.swing.JLabel();
        jTextField39 = new javax.swing.JTextField();
        jPanel167 = new javax.swing.JPanel();
        jtenct1 = new javax.swing.JLabel();
        jTextField38 = new javax.swing.JTextField();
        jPanel172 = new javax.swing.JPanel();
        jTextField36 = new javax.swing.JTextField();
        jTextField195 = new javax.swing.JTextField();
        jPanel171 = new javax.swing.JPanel();
        jTextField194 = new javax.swing.JTextField();
        jlvhdct2 = new javax.swing.JTextField();
        jPanel177 = new javax.swing.JPanel();
        jTextField149 = new javax.swing.JTextField();
        jctdl3 = new javax.swing.JLabel();
        jPanel176 = new javax.swing.JPanel();
        jTextField148 = new javax.swing.JTextField();
        jctdl2 = new javax.swing.JLabel();
        jPanel182 = new javax.swing.JPanel();
        jTextField145 = new javax.swing.JTextField();
        jTextField150 = new javax.swing.JTextField();
        jPanel184 = new javax.swing.JPanel();
        jTextField144 = new javax.swing.JTextField();
        jTextField146 = new javax.swing.JTextField();
        jLabel151 = new javax.swing.JLabel();
        jPanel186 = new javax.swing.JPanel();
        jLabel184 = new javax.swing.JLabel();
        jPanel187 = new javax.swing.JPanel();
        jTextField155 = new javax.swing.JTextField();
        jtengd6 = new javax.swing.JLabel();
        jPanel188 = new javax.swing.JPanel();
        jLabel176 = new javax.swing.JLabel();
        jPanel189 = new javax.swing.JPanel();
        jLabel177 = new javax.swing.JLabel();
        jPanel190 = new javax.swing.JPanel();
        jLabel180 = new javax.swing.JLabel();
        jPanel191 = new javax.swing.JPanel();
        jLabel181 = new javax.swing.JLabel();
        jPanel192 = new javax.swing.JPanel();
        jLabel182 = new javax.swing.JLabel();
        jPanel193 = new javax.swing.JPanel();
        jLabel183 = new javax.swing.JLabel();
        jPanel194 = new javax.swing.JPanel();
        jLabel154 = new javax.swing.JLabel();
        jLabel155 = new javax.swing.JLabel();
        jPanel195 = new javax.swing.JPanel();
        jTextField161 = new javax.swing.JTextField();
        jquanhe6 = new javax.swing.JLabel();
        jPanel196 = new javax.swing.JPanel();
        jTextField167 = new javax.swing.JTextField();
        jtuoigd6 = new javax.swing.JLabel();
        jPanel197 = new javax.swing.JPanel();
        jTextField173 = new javax.swing.JTextField();
        jttskgd6 = new javax.swing.JLabel();
        jPanel198 = new javax.swing.JPanel();
        jTextField179 = new javax.swing.JTextField();
        jnghegd6 = new javax.swing.JLabel();
        jPanel199 = new javax.swing.JPanel();
        jTextField185 = new javax.swing.JTextField();
        jTextField205 = new javax.swing.JTextField();
        jPanel200 = new javax.swing.JPanel();
        jLabel166 = new javax.swing.JLabel();
        jLabel167 = new javax.swing.JLabel();
        jPanel201 = new javax.swing.JPanel();
        jTextField42 = new javax.swing.JTextField();
        jtengd1 = new javax.swing.JLabel();
        jPanel202 = new javax.swing.JPanel();
        jTextField151 = new javax.swing.JTextField();
        jtengd2 = new javax.swing.JLabel();
        jPanel203 = new javax.swing.JPanel();
        jTextField152 = new javax.swing.JTextField();
        jtengd3 = new javax.swing.JLabel();
        jPanel204 = new javax.swing.JPanel();
        jTextField153 = new javax.swing.JTextField();
        jtengd4 = new javax.swing.JLabel();
        jPanel205 = new javax.swing.JPanel();
        jTextField154 = new javax.swing.JTextField();
        jtengd5 = new javax.swing.JLabel();
        jPanel206 = new javax.swing.JPanel();
        jLabel168 = new javax.swing.JLabel();
        jLabel169 = new javax.swing.JLabel();
        jPanel207 = new javax.swing.JPanel();
        jTextField156 = new javax.swing.JTextField();
        jquanhe1 = new javax.swing.JLabel();
        jPanel208 = new javax.swing.JPanel();
        jTextField157 = new javax.swing.JTextField();
        jquanhe2 = new javax.swing.JLabel();
        jPanel209 = new javax.swing.JPanel();
        jTextField158 = new javax.swing.JTextField();
        jquanhe3 = new javax.swing.JLabel();
        jPanel210 = new javax.swing.JPanel();
        jTextField159 = new javax.swing.JTextField();
        jquanhe4 = new javax.swing.JLabel();
        jPanel211 = new javax.swing.JPanel();
        jTextField160 = new javax.swing.JTextField();
        jquanhe5 = new javax.swing.JLabel();
        jPanel212 = new javax.swing.JPanel();
        jLabel170 = new javax.swing.JLabel();
        jLabel171 = new javax.swing.JLabel();
        jPanel213 = new javax.swing.JPanel();
        jTextField162 = new javax.swing.JTextField();
        jtuoigd1 = new javax.swing.JLabel();
        jPanel214 = new javax.swing.JPanel();
        jTextField163 = new javax.swing.JTextField();
        jtuoigd2 = new javax.swing.JLabel();
        jPanel215 = new javax.swing.JPanel();
        jTextField164 = new javax.swing.JTextField();
        jtuoigd3 = new javax.swing.JLabel();
        jPanel216 = new javax.swing.JPanel();
        jTextField165 = new javax.swing.JTextField();
        jtuoigd4 = new javax.swing.JLabel();
        jPanel217 = new javax.swing.JPanel();
        jTextField166 = new javax.swing.JTextField();
        jtuoigd5 = new javax.swing.JLabel();
        jPanel218 = new javax.swing.JPanel();
        jLabel172 = new javax.swing.JLabel();
        jLabel173 = new javax.swing.JLabel();
        jPanel219 = new javax.swing.JPanel();
        jTextField168 = new javax.swing.JTextField();
        jttskgd1 = new javax.swing.JLabel();
        jPanel220 = new javax.swing.JPanel();
        jTextField169 = new javax.swing.JTextField();
        jttskgd2 = new javax.swing.JLabel();
        jPanel221 = new javax.swing.JPanel();
        jTextField170 = new javax.swing.JTextField();
        jttskgd3 = new javax.swing.JLabel();
        jPanel222 = new javax.swing.JPanel();
        jTextField171 = new javax.swing.JTextField();
        jttskgd4 = new javax.swing.JLabel();
        jPanel223 = new javax.swing.JPanel();
        jTextField172 = new javax.swing.JTextField();
        jttskgd5 = new javax.swing.JLabel();
        jPanel224 = new javax.swing.JPanel();
        jLabel174 = new javax.swing.JLabel();
        jLabel175 = new javax.swing.JLabel();
        jPanel225 = new javax.swing.JPanel();
        jTextField174 = new javax.swing.JTextField();
        jnghegd1 = new javax.swing.JLabel();
        jPanel226 = new javax.swing.JPanel();
        jTextField175 = new javax.swing.JTextField();
        jnghegd2 = new javax.swing.JLabel();
        jPanel227 = new javax.swing.JPanel();
        jTextField176 = new javax.swing.JTextField();
        jnghegd3 = new javax.swing.JLabel();
        jPanel228 = new javax.swing.JPanel();
        jTextField177 = new javax.swing.JTextField();
        jnghegd4 = new javax.swing.JLabel();
        jPanel229 = new javax.swing.JPanel();
        jTextField178 = new javax.swing.JTextField();
        jnghegd5 = new javax.swing.JLabel();
        jPanel230 = new javax.swing.JPanel();
        jTextField181 = new javax.swing.JTextField();
        jTextField201 = new javax.swing.JTextField();
        jPanel231 = new javax.swing.JPanel();
        jLabel178 = new javax.swing.JLabel();
        jLabel179 = new javax.swing.JLabel();
        jPanel232 = new javax.swing.JPanel();
        jTextField191 = new javax.swing.JTextField();
        jTextField211 = new javax.swing.JTextField();
        jPanel233 = new javax.swing.JPanel();
        jTextField182 = new javax.swing.JTextField();
        jTextField202 = new javax.swing.JTextField();
        jPanel234 = new javax.swing.JPanel();
        jTextField183 = new javax.swing.JTextField();
        jTextField203 = new javax.swing.JTextField();
        jPanel235 = new javax.swing.JPanel();
        jTextField184 = new javax.swing.JTextField();
        jTextField204 = new javax.swing.JTextField();
        jPanel236 = new javax.swing.JPanel();
        jTextField187 = new javax.swing.JTextField();
        jTextField207 = new javax.swing.JTextField();
        jPanel237 = new javax.swing.JPanel();
        jTextField180 = new javax.swing.JTextField();
        jTextField200 = new javax.swing.JTextField();
        jPanel238 = new javax.swing.JPanel();
        jTextField186 = new javax.swing.JTextField();
        jTextField206 = new javax.swing.JTextField();
        jPanel239 = new javax.swing.JPanel();
        jTextField188 = new javax.swing.JTextField();
        jTextField208 = new javax.swing.JTextField();
        jPanel240 = new javax.swing.JPanel();
        jTextField189 = new javax.swing.JTextField();
        jTextField209 = new javax.swing.JTextField();
        jPanel241 = new javax.swing.JPanel();
        jTextField190 = new javax.swing.JTextField();
        jTextField210 = new javax.swing.JTextField();
        jPanel61 = new javax.swing.JPanel();
        jdiemyeu = new javax.swing.JLabel();
        jTextField18 = new javax.swing.JTextField();
        jPanel67 = new javax.swing.JPanel();
        jPanel68 = new javax.swing.JPanel();
        jdiachi = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jPanel69 = new javax.swing.JPanel();
        jdinhat = new javax.swing.JLabel();
        jTextField20 = new javax.swing.JTextField();
        jPanel70 = new javax.swing.JPanel();
        jsothich = new javax.swing.JLabel();
        jTextField110 = new javax.swing.JTextField();
        jPanel71 = new javax.swing.JPanel();
        jvevn = new javax.swing.JLabel();
        jTextField111 = new javax.swing.JTextField();
        jPanel72 = new javax.swing.JPanel();
        jbietgi = new javax.swing.JLabel();
        jTextField112 = new javax.swing.JTextField();
        jMenuBar1 = new javax.swing.JMenuBar();
        tuychon = new javax.swing.JMenu();
        printRecord = new javax.swing.JMenuItem();
        QL = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addMouseWheelListener(new java.awt.event.MouseWheelListener() {
            public void mouseWheelMoved(java.awt.event.MouseWheelEvent evt) {
                formMouseWheelMoved(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jSYLL.setBackground(new java.awt.Color(153, 153, 153));
        jSYLL.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.setPreferredSize(new java.awt.Dimension(1190, 1680));
        jPanel1.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
                jPanel1CaretPositionChanged(evt);
            }
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
            }
        });
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 0, 0));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("履歴書 ");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 1120, 60));

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("SƠ YẾU LÝ LỊCH");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 100, 1120, 60));

        jLabel46.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 18)); // NOI18N
        jLabel46.setText("D.  学歴 /");
        jPanel1.add(jLabel46, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 880, 100, 30));

        jLabel47.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 18)); // NOI18N
        jLabel47.setText("A. 基本情報 / THÔNG TIN CÁ NHÂN");
        jPanel1.add(jLabel47, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 150, -1, 30));

        jLabel33.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel33.setText("QUÁ TRÌNH HỌC TẬP");
        jPanel1.add(jLabel33, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 870, -1, 50));

        jLabel48.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 18)); // NOI18N
        jLabel48.setText("B. 健康情報 /");
        jPanel1.add(jLabel48, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 340, 130, 30));

        jLabel42.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel42.setText(" TÌNH TRẠNG SỨC KHỎE");
        jPanel1.add(jLabel42, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 330, -1, 50));

        jLabel67.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 18)); // NOI18N
        jLabel67.setText("C. 個人的な特徴 /");
        jPanel1.add(jLabel67, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 570, 170, 30));

        jLabel68.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel68.setText("ĐẶC TÍNH CÁ NHÂN");
        jPanel1.add(jLabel68, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 560, -1, 50));

        jPanel51.setBackground(new java.awt.Color(255, 255, 255));
        jPanel51.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel51.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel52.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 18)); // NOI18N
        jLabel52.setForeground(new java.awt.Color(255, 0, 0));
        jLabel52.setText("日本へ行く事に家族は");
        jPanel51.add(jLabel52, new org.netbeans.lib.awtextra.AbsoluteConstraints(13, 1, 200, 20));

        jLabel59.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel59.setText("Đi Nhật làm việc gia đình có đồng ý không?");
        jPanel51.add(jLabel59, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 290, -1));

        jPanel1.add(jPanel51, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 840, -1, 40));

        jPanel53.setBackground(new java.awt.Color(255, 255, 255));
        jPanel53.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel53.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel44.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 18)); // NOI18N
        jLabel44.setForeground(new java.awt.Color(255, 0, 0));
        jLabel44.setText("短所：");
        jPanel53.add(jLabel44, new org.netbeans.lib.awtextra.AbsoluteConstraints(13, 1, 140, 20));

        jLabel54.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel54.setText("Điểm yếu :");
        jPanel53.add(jLabel54, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 100, -1));

        jPanel1.add(jPanel53, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 640, 300, 40));

        jPanel54.setBackground(new java.awt.Color(255, 255, 255));
        jPanel54.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel54.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel45.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 18)); // NOI18N
        jLabel45.setForeground(new java.awt.Color(255, 0, 0));
        jLabel45.setText("日本に行く理由：");
        jPanel54.add(jLabel45, new org.netbeans.lib.awtextra.AbsoluteConstraints(13, 1, 140, 20));

        jLabel55.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel55.setText("Lý do muốn đi Nhật :");
        jPanel54.add(jLabel55, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 150, -1));

        jPanel1.add(jPanel54, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 680, 300, 40));

        jPanel55.setBackground(new java.awt.Color(255, 255, 255));
        jPanel55.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel55.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel49.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 18)); // NOI18N
        jLabel49.setForeground(new java.awt.Color(255, 0, 0));
        jLabel49.setText("趣味：");
        jPanel55.add(jLabel49, new org.netbeans.lib.awtextra.AbsoluteConstraints(13, 1, 140, 20));

        jLabel56.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel56.setText("Sở thích :");
        jPanel55.add(jLabel56, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 100, -1));

        jPanel32.setBackground(new java.awt.Color(255, 255, 255));
        jPanel32.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel32.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel32.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 120, 300, 40));

        jPanel55.add(jPanel32, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -120, 1140, 280));

        jPanel1.add(jPanel55, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 720, 300, 40));

        jPanel56.setBackground(new java.awt.Color(255, 255, 255));
        jPanel56.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel56.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel50.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 18)); // NOI18N
        jLabel50.setForeground(new java.awt.Color(255, 0, 0));
        jLabel50.setText("帰国後の仕事の予定は？");
        jPanel56.add(jLabel50, new org.netbeans.lib.awtextra.AbsoluteConstraints(13, 1, 250, 20));

        jLabel57.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel57.setText("Sau khi về Việt Nam làm gì :");
        jPanel56.add(jLabel57, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 200, -1));

        jPanel1.add(jPanel56, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 760, 300, 40));

        jPanel57.setBackground(new java.awt.Color(255, 255, 255));
        jPanel57.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel57.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel51.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 18)); // NOI18N
        jLabel51.setForeground(new java.awt.Color(255, 0, 0));
        jLabel51.setText("日本について知っている事");
        jPanel57.add(jLabel51, new org.netbeans.lib.awtextra.AbsoluteConstraints(13, 1, 250, 20));

        jLabel58.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel58.setText("Biết những gì về nước Nhật ?");
        jPanel57.add(jLabel58, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 200, -1));

        jPanel1.add(jPanel57, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 800, 300, 40));

        jPanel58.setBackground(new java.awt.Color(255, 255, 255));
        jPanel58.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel58.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel43.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 18)); // NOI18N
        jLabel43.setForeground(new java.awt.Color(255, 0, 0));
        jLabel43.setText("長所：");
        jPanel58.add(jLabel43, new org.netbeans.lib.awtextra.AbsoluteConstraints(13, 1, 140, 20));

        jLabel53.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel53.setText("Địa chỉ hiện tại :");
        jPanel58.add(jLabel53, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 120, -1));

        jPanel1.add(jPanel58, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 600, 300, 40));

        jPanel60.setBackground(new java.awt.Color(255, 255, 255));
        jPanel60.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel60.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jgiadinh.setText("hoten");
        jPanel60.add(jgiadinh, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 830, 20));

        jTextField113.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 10)); // NOI18N
        jTextField113.setForeground(new java.awt.Color(255, 0, 51));
        jPanel60.add(jTextField113, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 840, 20));

        jPanel1.add(jPanel60, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 840, 840, 40));

        jPanel62.setBackground(new java.awt.Color(255, 255, 255));
        jPanel62.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel62.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel1.add(jPanel62, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 720, -1, -1));

        jPanel63.setBackground(new java.awt.Color(255, 255, 255));
        jPanel63.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel63.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel1.add(jPanel63, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 760, -1, -1));

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 0, 0));
        jLabel1.setText("フリガナ");
        jPanel5.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(13, 1, 50, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Họ và tên phiên âm");
        jPanel5.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 130, 20));

        jPanel1.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 180, 160, 40));

        jPanel8.setBackground(new java.awt.Color(255, 255, 255));
        jPanel8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel12.setBackground(new java.awt.Color(255, 255, 255));
        jPanel12.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel12.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel12.add(jgioitinh1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 400, 20));

        jTextField1.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 10)); // NOI18N
        jTextField1.setForeground(new java.awt.Color(255, 0, 51));
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });
        jPanel12.add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 420, -1));

        jPanel8.add(jPanel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 420, 40));

        jPanel1.add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 180, -1, -1));

        jPanel14.setBackground(new java.awt.Color(255, 255, 255));
        jPanel14.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel14.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel12.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 0, 0));
        jLabel12.setText("性別 ");
        jPanel14.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(13, 1, 190, 20));

        jLabel15.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel15.setText("Giới tính");
        jPanel14.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 180, 30));

        jPanel1.add(jPanel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 180, 210, -1));

        jPanel18.setBackground(new java.awt.Color(255, 255, 255));
        jPanel18.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel18.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel1.add(jPanel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 180, -1, -1));

        jPanel242.setBackground(new java.awt.Color(255, 255, 255));
        jPanel242.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel242.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 0, 0));
        jLabel5.setText("氏名");
        jPanel6.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(13, 1, 140, 20));

        jLabel156.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 14)); // NOI18N
        jLabel156.setForeground(new java.awt.Color(255, 0, 0));
        jLabel156.setText("生年月日");
        jPanel6.add(jLabel156, new org.netbeans.lib.awtextra.AbsoluteConstraints(13, 1, 90, 20));

        jLabel157.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel157.setText("Ngày,Tháng,Năm sinh");
        jPanel6.add(jLabel157, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 150, -1));

        jPanel242.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 80, 160, -1));

        jPanel10.setBackground(new java.awt.Color(255, 255, 255));
        jPanel10.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel10.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel10.add(jhoten, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 400, 20));

        jTextField4.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 10)); // NOI18N
        jTextField4.setForeground(new java.awt.Color(255, 0, 51));
        jTextField4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField4ActionPerformed(evt);
            }
        });
        jPanel10.add(jTextField4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 420, -1));

        jPanel242.add(jPanel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 40, 420, 40));

        jPanel15.setBackground(new java.awt.Color(255, 255, 255));
        jPanel15.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel15.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel13.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 0, 0));
        jLabel13.setText("婚姻");
        jPanel15.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(13, 1, 190, -1));

        jLabel16.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel16.setText("Tình trạng hôn nhân");
        jPanel15.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, 170, 20));

        jPanel242.add(jPanel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 40, 210, -1));

        jPanel17.setBackground(new java.awt.Color(255, 255, 255));
        jPanel17.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel17.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel17.add(jhonnhan, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 340, 20));

        jTextField5.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 10)); // NOI18N
        jTextField5.setForeground(new java.awt.Color(255, 0, 51));
        jTextField5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField5ActionPerformed(evt);
            }
        });
        jPanel17.add(jTextField5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 350, -1));

        jPanel242.add(jPanel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 40, 350, 40));

        jPanel16.setBackground(new java.awt.Color(255, 255, 255));
        jPanel16.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel16.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel16.add(jngaysinh, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 410, 20));

        jTextField6.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 10)); // NOI18N
        jTextField6.setForeground(new java.awt.Color(255, 0, 51));
        jTextField6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField6ActionPerformed(evt);
            }
        });
        jPanel16.add(jTextField6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 420, -1));

        jPanel242.add(jPanel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 80, 420, 40));

        jPanel9.setBackground(new java.awt.Color(255, 255, 255));
        jPanel9.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel9.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel14.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 0, 0));
        jLabel14.setText("年齢");
        jPanel9.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(13, 1, 150, 30));

        jLabel17.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel17.setText("Tuổi");
        jPanel9.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 180, 20));

        jPanel242.add(jPanel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 80, 210, 40));

        jPanel13.setBackground(new java.awt.Color(255, 255, 255));
        jPanel13.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel13.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel13.add(jtuoi, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 330, 20));

        jTextField7.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 10)); // NOI18N
        jTextField7.setForeground(new java.awt.Color(255, 0, 51));
        jTextField7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField7ActionPerformed(evt);
            }
        });
        jPanel13.add(jTextField7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 350, -1));

        jPanel242.add(jPanel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 80, 350, 40));

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel9.setText("  Địa chỉ hiện tại");
        jPanel4.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, 120, 20));

        jLabel10.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 0, 0));
        jLabel10.setText("   出身地 ");
        jPanel4.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 140, -1));

        jPanel242.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 120, 160, 40));

        jPanel262.setBackground(new java.awt.Color(255, 255, 255));
        jPanel262.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel262.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel152.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 14)); // NOI18N
        jLabel152.setForeground(new java.awt.Color(255, 0, 0));
        jLabel152.setText("氏名");
        jPanel262.add(jLabel152, new org.netbeans.lib.awtextra.AbsoluteConstraints(13, 1, 140, 20));

        jLabel153.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel153.setText("Họ và tên ");
        jPanel262.add(jLabel153, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 70, 20));

        jPanel242.add(jPanel262, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 160, -1));

        jLabel21.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel21.setText("Số nhà-Tên đường");
        jPanel242.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 120, -1, 40));

        jLabel23.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel23.setText(" Phường(xã)");
        jPanel242.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 120, 90, 40));

        jLabel28.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel28.setText("Quận(Huyện)");
        jPanel242.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 120, 90, 40));

        jLabel19.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel19.setText("Quận(Huyện)");
        jPanel242.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 120, 90, 40));

        jTextField8.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 11)); // NOI18N
        jTextField8.setForeground(new java.awt.Color(255, 0, 51));
        jTextField8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField8ActionPerformed(evt);
            }
        });
        jPanel242.add(jTextField8, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 120, 190, 40));

        jTextField9.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 11)); // NOI18N
        jTextField9.setForeground(new java.awt.Color(255, 0, 51));
        jTextField9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField9ActionPerformed(evt);
            }
        });
        jPanel242.add(jTextField9, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 120, 130, 40));

        jTextField10.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 11)); // NOI18N
        jTextField10.setForeground(new java.awt.Color(255, 0, 51));
        jTextField10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField10ActionPerformed(evt);
            }
        });
        jPanel242.add(jTextField10, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 120, 130, 40));

        jTextField11.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 11)); // NOI18N
        jTextField11.setForeground(new java.awt.Color(255, 0, 51));
        jTextField11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField11ActionPerformed(evt);
            }
        });
        jPanel242.add(jTextField11, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 120, 130, 40));

        jTextField2.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 10)); // NOI18N
        jTextField2.setForeground(new java.awt.Color(255, 0, 51));
        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });
        jPanel242.add(jTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 0, 350, -1));
        jPanel242.add(jgioitinh, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 20, 340, 20));

        jPanel1.add(jPanel242, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 180, 1140, 160));

        jPanel34.setBackground(new java.awt.Color(255, 255, 255));
        jPanel34.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel34.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel38.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 15)); // NOI18N
        jLabel38.setForeground(new java.awt.Color(255, 0, 51));
        jLabel38.setText("右");
        jPanel34.add(jLabel38, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, -1, -1));

        jLabel39.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel39.setText("Phải");
        jPanel34.add(jLabel39, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, -1, 20));

        jLabel40.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 15)); // NOI18N
        jLabel40.setForeground(new java.awt.Color(255, 0, 51));
        jLabel40.setText("左 ");
        jPanel34.add(jLabel40, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jLabel41.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel41.setText("Trái");
        jPanel34.add(jLabel41, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, -1, 20));

        jPanel1.add(jPanel34, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 370, 90, 90));

        jPanel35.setBackground(new java.awt.Color(255, 255, 255));
        jPanel35.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel35.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel81.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 18)); // NOI18N
        jLabel81.setForeground(new java.awt.Color(255, 0, 0));
        jLabel81.setText("お酒を飲む");
        jPanel35.add(jLabel81, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 100, 20));

        jLabel98.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel98.setText(" Uống Rượu Bia :");
        jPanel35.add(jLabel98, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, 120, 20));

        jPanel1.add(jPanel35, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 530, -1, -1));

        jPanel36.setBackground(new java.awt.Color(255, 255, 255));
        jPanel36.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel36.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jnhommau.setText("hoten");
        jPanel36.add(jnhommau, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, -1, 20));

        jPanel1.add(jPanel36, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 510, 100, 60));

        jPanel37.setBackground(new java.awt.Color(255, 255, 255));
        jPanel37.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel37.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel70.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 18)); // NOI18N
        jLabel70.setForeground(new java.awt.Color(255, 0, 0));
        jLabel70.setText("    身長");
        jPanel37.add(jLabel70, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, 100, 30));

        jLabel72.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel72.setText("  Chiều cao");
        jPanel37.add(jLabel72, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 100, 30));

        jPanel1.add(jPanel37, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 460, 100, 110));

        jPanel38.setBackground(new java.awt.Color(255, 255, 255));
        jPanel38.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel38.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jchieucao.setText("hoten");
        jPanel38.add(jchieucao, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 50, -1, 20));

        jPanel1.add(jPanel38, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 460, 170, 110));

        jPanel39.setBackground(new java.awt.Color(255, 255, 255));
        jPanel39.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel39.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel34.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 18)); // NOI18N
        jLabel34.setForeground(new java.awt.Color(255, 0, 0));
        jLabel34.setText(" メガネ　 ．コンタクトレンズ");
        jPanel39.add(jLabel34, new org.netbeans.lib.awtextra.AbsoluteConstraints(3, 1, 200, 30));

        jLabel35.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel35.setText(" Đeo kính :");
        jPanel39.add(jLabel35, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 80, 30));

        jPanel1.add(jPanel39, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 370, 210, -1));

        jPanel40.setBackground(new java.awt.Color(255, 255, 255));
        jPanel40.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel40.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel36.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel36.setText("Mù màu :");
        jPanel40.add(jLabel36, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, -1, 20));

        jLabel37.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 18)); // NOI18N
        jLabel37.setForeground(new java.awt.Color(255, 0, 0));
        jLabel37.setText("色覚異常");
        jPanel40.add(jLabel37, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 140, 20));

        jPanel1.add(jPanel40, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 430, 210, -1));

        jPanel41.setBackground(new java.awt.Color(255, 255, 255));
        jPanel41.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel41.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel73.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 18)); // NOI18N
        jLabel73.setForeground(new java.awt.Color(255, 0, 0));
        jLabel73.setText("体重");
        jPanel41.add(jLabel73, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 140, 20));

        jLabel74.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel74.setText("Cân nặng :");
        jPanel41.add(jLabel74, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, -1, 20));

        jPanel1.add(jPanel41, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 470, 210, -1));

        jPanel42.setBackground(new java.awt.Color(255, 255, 255));
        jPanel42.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel42.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel69.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 18)); // NOI18N
        jLabel69.setForeground(new java.awt.Color(255, 0, 0));
        jLabel69.setText("      視力");
        jPanel42.add(jLabel69, new org.netbeans.lib.awtextra.AbsoluteConstraints(3, 1, 90, 30));

        jLabel71.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel71.setText("      Mắt");
        jPanel42.add(jLabel71, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 100, 30));

        jPanel1.add(jPanel42, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 370, 100, 90));

        jPanel43.setBackground(new java.awt.Color(255, 255, 255));
        jPanel43.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel43.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jdeokinh.setText("hoten");
        jPanel43.add(jdeokinh, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, 20));

        jPanel1.add(jPanel43, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 370, 100, 60));

        jPanel44.setBackground(new java.awt.Color(255, 255, 255));
        jPanel44.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel44.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jmumau.setText("hoten");
        jPanel44.add(jmumau, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, 20));

        jPanel1.add(jPanel44, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 430, 100, 40));

        jPanel45.setBackground(new java.awt.Color(255, 255, 255));
        jPanel45.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel45.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jcannang.setText("hoten");
        jPanel45.add(jcannang, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, 20));

        jPanel1.add(jPanel45, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 470, 100, 40));

        jPanel46.setBackground(new java.awt.Color(255, 255, 255));
        jPanel46.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel46.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel75.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel75.setText("Nhóm máu :");
        jPanel46.add(jLabel75, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, -1, 20));

        jLabel76.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 18)); // NOI18N
        jLabel76.setForeground(new java.awt.Color(255, 0, 0));
        jLabel76.setText("血液型 ");
        jPanel46.add(jLabel76, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 140, 20));

        jPanel1.add(jPanel46, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 510, 210, 60));

        jPanel47.setBackground(new java.awt.Color(255, 255, 255));
        jPanel47.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel47.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel77.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 18)); // NOI18N
        jLabel77.setForeground(new java.awt.Color(255, 0, 0));
        jLabel77.setText("利き手");
        jPanel47.add(jLabel77, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 140, 20));

        jLabel94.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel94.setText(" Thuận tay :");
        jPanel47.add(jLabel94, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, 100, 20));

        jPanel1.add(jPanel47, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 370, 220, 40));

        jPanel48.setBackground(new java.awt.Color(255, 255, 255));
        jPanel48.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel48.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel78.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 18)); // NOI18N
        jLabel78.setForeground(new java.awt.Color(255, 0, 0));
        jLabel78.setText("特異体質（アレルギー）");
        jPanel48.add(jLabel78, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 190, 20));

        jLabel95.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel95.setText(" Dị ứng :");
        jPanel48.add(jLabel95, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, 100, 20));

        jPanel1.add(jPanel48, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 410, 220, 40));

        jPanel49.setBackground(new java.awt.Color(255, 255, 255));
        jPanel49.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel49.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jCheckBox5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel49.add(jCheckBox5, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 5, 20, 30));

        jPanel1.add(jPanel49, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 530, 30, 40));

        jPanel33.setBackground(new java.awt.Color(255, 255, 255));
        jPanel33.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel33.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jmatphai.setText("hoten");
        jPanel33.add(jmatphai, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, -1, -1));

        jmattrai.setText("hoten");
        jPanel33.add(jmattrai, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, -1, -1));

        jPanel1.add(jPanel33, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 370, 80, 90));

        jPanel50.setBackground(new java.awt.Color(255, 255, 255));
        jPanel50.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel50.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel80.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 18)); // NOI18N
        jLabel80.setForeground(new java.awt.Color(255, 0, 0));
        jLabel80.setText("タバコを吸う");
        jPanel50.add(jLabel80, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 100, 20));

        jLabel97.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel97.setText(" Hút thuốc lá :");
        jPanel50.add(jLabel97, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, 100, 20));

        jPanel1.add(jPanel50, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 490, 120, 40));

        jPanel52.setBackground(new java.awt.Color(255, 255, 255));
        jPanel52.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel52.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel79.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 18)); // NOI18N
        jLabel79.setForeground(new java.awt.Color(255, 0, 0));
        jLabel79.setText("入れ墨");
        jPanel52.add(jLabel79, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 110, 20));

        jLabel96.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel96.setText(" Hình xăm");
        jPanel52.add(jLabel96, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, 100, 20));

        jPanel1.add(jPanel52, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 450, -1, -1));

        jPanel80.setBackground(new java.awt.Color(255, 255, 255));
        jPanel80.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel80.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel110.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel110.setText("   Không");
        jPanel80.add(jLabel110, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, 70, 20));

        jLabel93.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 18)); // NOI18N
        jLabel93.setForeground(new java.awt.Color(255, 0, 0));
        jLabel93.setText("  無");
        jPanel80.add(jLabel93, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 60, 20));

        jPanel1.add(jPanel80, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 530, -1, -1));

        jPanel81.setBackground(new java.awt.Color(255, 255, 255));
        jPanel81.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel81.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel85.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 18)); // NOI18N
        jLabel85.setForeground(new java.awt.Color(255, 0, 0));
        jLabel85.setText("  有");
        jPanel81.add(jLabel85, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 60, 20));

        jLabel102.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel102.setText("    Có");
        jPanel81.add(jLabel102, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, 70, 20));

        jPanel1.add(jPanel81, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 410, -1, -1));

        jPanel82.setBackground(new java.awt.Color(255, 255, 255));
        jPanel82.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel82.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel86.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 18)); // NOI18N
        jLabel86.setForeground(new java.awt.Color(255, 0, 0));
        jLabel86.setText("  有");
        jPanel82.add(jLabel86, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 60, 20));

        jLabel103.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel103.setText("    Có");
        jPanel82.add(jLabel103, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, 70, 20));

        jPanel1.add(jPanel82, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 450, -1, -1));

        jPanel83.setBackground(new java.awt.Color(255, 255, 255));
        jPanel83.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel83.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel87.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 18)); // NOI18N
        jLabel87.setForeground(new java.awt.Color(255, 0, 0));
        jLabel87.setText("  少");
        jPanel83.add(jLabel87, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 60, 20));

        jLabel104.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel104.setText("  Có - ít");
        jPanel83.add(jLabel104, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, 70, 20));

        jPanel1.add(jPanel83, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 490, -1, -1));

        jPanel84.setBackground(new java.awt.Color(255, 255, 255));
        jPanel84.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel84.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel88.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 18)); // NOI18N
        jLabel88.setForeground(new java.awt.Color(255, 0, 0));
        jLabel88.setText("  少");
        jPanel84.add(jLabel88, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 60, 20));

        jLabel105.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel105.setText("  Có - ít");
        jPanel84.add(jLabel105, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, 70, 20));

        jPanel1.add(jPanel84, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 530, -1, -1));

        jPanel85.setBackground(new java.awt.Color(255, 255, 255));
        jPanel85.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel85.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel1.add(jPanel85, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 450, 100, 40));

        jPanel86.setBackground(new java.awt.Color(255, 255, 255));
        jPanel86.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel86.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel82.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 18)); // NOI18N
        jLabel82.setForeground(new java.awt.Color(255, 0, 0));
        jLabel82.setText("よく");
        jPanel86.add(jLabel82, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 40, 20));

        jLabel99.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel99.setText(" Có-nhiều");
        jPanel86.add(jLabel99, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, 70, 20));

        jPanel1.add(jPanel86, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 490, -1, -1));

        jPanel87.setBackground(new java.awt.Color(255, 255, 255));
        jPanel87.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel87.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel83.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 18)); // NOI18N
        jLabel83.setForeground(new java.awt.Color(255, 0, 0));
        jLabel83.setText("よく");
        jPanel87.add(jLabel83, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 40, 20));

        jLabel100.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel100.setText(" Có-nhiều");
        jPanel87.add(jLabel100, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, 70, 20));

        jPanel1.add(jPanel87, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 530, -1, -1));

        jPanel88.setBackground(new java.awt.Color(255, 255, 255));
        jPanel88.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel88.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jCheckBox12.setBackground(new java.awt.Color(255, 255, 255));
        jPanel88.add(jCheckBox12, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 5, 20, 30));

        jPanel1.add(jPanel88, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 530, 30, 40));

        jPanel89.setBackground(new java.awt.Color(255, 255, 255));
        jPanel89.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel89.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jCheckBox11.setBackground(new java.awt.Color(255, 255, 255));
        jPanel89.add(jCheckBox11, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 5, 20, 30));

        jPanel1.add(jPanel89, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 490, 30, 40));

        jPanel90.setBackground(new java.awt.Color(255, 255, 255));
        jPanel90.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel90.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel31.setBackground(new java.awt.Color(255, 255, 255));
        jPanel31.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel31.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel103.setBackground(new java.awt.Color(255, 255, 255));
        jPanel103.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel103.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jCheckBox6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel103.add(jCheckBox6, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 5, 20, 30));

        jPanel31.add(jPanel103, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 160, 30, 40));

        jPanel90.add(jPanel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(-970, -160, 1000, 200));

        jPanel1.add(jPanel90, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 530, 30, 40));

        jPanel91.setBackground(new java.awt.Color(255, 255, 255));
        jPanel91.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel91.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jCheckBox2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel91.add(jCheckBox2, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 5, 20, 30));

        jPanel1.add(jPanel91, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 410, 30, 40));

        jPanel92.setBackground(new java.awt.Color(255, 255, 255));
        jPanel92.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel92.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jCheckBox3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel92.add(jCheckBox3, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 5, 20, 30));

        jPanel1.add(jPanel92, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 450, 30, 40));

        jPanel93.setBackground(new java.awt.Color(255, 255, 255));
        jPanel93.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel93.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jCheckBox4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel93.add(jCheckBox4, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 5, 20, 30));

        jPanel1.add(jPanel93, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 490, 30, 40));

        jPanel94.setBackground(new java.awt.Color(255, 255, 255));
        jPanel94.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel94.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel84.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 18)); // NOI18N
        jLabel84.setForeground(new java.awt.Color(255, 0, 0));
        jLabel84.setText("  右");
        jPanel94.add(jLabel84, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 50, 20));

        jLabel101.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel101.setText("   Phải");
        jPanel94.add(jLabel101, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, 70, 20));

        jPanel1.add(jPanel94, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 370, -1, -1));

        jPanel95.setBackground(new java.awt.Color(255, 255, 255));
        jPanel95.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel95.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel89.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 18)); // NOI18N
        jLabel89.setForeground(new java.awt.Color(255, 0, 0));
        jLabel89.setText("  左");
        jPanel95.add(jLabel89, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 60, 20));

        jLabel106.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel106.setText("   Trái");
        jPanel95.add(jLabel106, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, 70, 20));

        jPanel1.add(jPanel95, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 370, -1, -1));

        jPanel96.setBackground(new java.awt.Color(255, 255, 255));
        jPanel96.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel96.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel90.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 18)); // NOI18N
        jLabel90.setForeground(new java.awt.Color(255, 0, 0));
        jLabel90.setText("  無");
        jPanel96.add(jLabel90, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 60, 20));

        jLabel107.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel107.setText("   Không");
        jPanel96.add(jLabel107, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, 70, 20));

        jPanel1.add(jPanel96, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 410, -1, -1));

        jPanel97.setBackground(new java.awt.Color(255, 255, 255));
        jPanel97.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel97.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel108.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel108.setText("   Không");
        jPanel97.add(jLabel108, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, 70, 20));

        jLabel91.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 18)); // NOI18N
        jLabel91.setForeground(new java.awt.Color(255, 0, 0));
        jLabel91.setText("  無");
        jPanel97.add(jLabel91, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 60, 20));

        jPanel1.add(jPanel97, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 450, -1, 40));

        jPanel98.setBackground(new java.awt.Color(255, 255, 255));
        jPanel98.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel98.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel109.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel109.setText("   Không");
        jPanel98.add(jLabel109, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, 70, 20));

        jLabel92.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 18)); // NOI18N
        jLabel92.setForeground(new java.awt.Color(255, 0, 0));
        jLabel92.setText("  無");
        jPanel98.add(jLabel92, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 60, 20));

        jPanel1.add(jPanel98, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 490, -1, 40));

        jPanel99.setBackground(new java.awt.Color(255, 255, 255));
        jPanel99.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel99.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jCheckBox1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel99.add(jCheckBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 5, 20, 30));

        jPanel1.add(jPanel99, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 370, 30, 40));

        jPanel100.setBackground(new java.awt.Color(255, 255, 255));
        jPanel100.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel100.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jCheckBox10.setBackground(new java.awt.Color(255, 255, 255));
        jPanel100.add(jCheckBox10, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 5, 20, 30));

        jPanel1.add(jPanel100, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 370, 30, 40));

        jPanel101.setBackground(new java.awt.Color(255, 255, 255));
        jPanel101.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel101.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jCheckBox9.setBackground(new java.awt.Color(255, 255, 255));
        jPanel101.add(jCheckBox9, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 5, 20, 30));

        jPanel1.add(jPanel101, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 410, 30, 40));

        jPanel102.setBackground(new java.awt.Color(255, 255, 255));
        jPanel102.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel102.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jCheckBox8.setBackground(new java.awt.Color(255, 255, 255));
        jPanel102.add(jCheckBox8, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 5, 20, 30));

        jPanel1.add(jPanel102, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 450, 30, 40));

        jPanel105.setBackground(new java.awt.Color(255, 255, 255));
        jPanel105.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel105.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel130.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel130.setText("Đại học/");
        jPanel105.add(jLabel130, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, -1, -1));

        jLabel136.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 18)); // NOI18N
        jLabel136.setText("大学");
        jPanel105.add(jLabel136, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 0, 70, 20));

        jPanel1.add(jPanel105, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 1100, 160, 30));

        jPanel106.setBackground(new java.awt.Color(255, 255, 255));
        jPanel106.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel106.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTextField123.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 10)); // NOI18N
        jTextField123.setForeground(new java.awt.Color(255, 0, 51));
        jTextField123.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField123ActionPerformed(evt);
            }
        });
        jPanel106.add(jTextField123, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 120, 20));

        jnhaphoc1.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jnhaphoc1.setText(" hoten");
        jPanel106.add(jnhaphoc1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, 120, 10));

        jPanel1.add(jPanel106, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 950, 120, 30));

        jPanel107.setBackground(new java.awt.Color(255, 255, 255));
        jPanel107.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel107.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTextField126.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 10)); // NOI18N
        jTextField126.setForeground(new java.awt.Color(255, 0, 51));
        jTextField126.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField126ActionPerformed(evt);
            }
        });
        jPanel107.add(jTextField126, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 120, 20));

        jnhaphoc2.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jnhaphoc2.setText(" hoten");
        jPanel107.add(jnhaphoc2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, 120, 10));

        jPanel1.add(jPanel107, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 980, 120, 30));

        jPanel108.setBackground(new java.awt.Color(255, 255, 255));
        jPanel108.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel108.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTextField127.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 10)); // NOI18N
        jTextField127.setForeground(new java.awt.Color(255, 0, 51));
        jTextField127.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField127ActionPerformed(evt);
            }
        });
        jPanel108.add(jTextField127, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 120, 20));

        jnhaphoc3.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jnhaphoc3.setText(" hoten");
        jPanel108.add(jnhaphoc3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, 120, 10));

        jPanel1.add(jPanel108, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 1010, 120, 30));

        jPanel109.setBackground(new java.awt.Color(255, 255, 255));
        jPanel109.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel109.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTextField135.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 10)); // NOI18N
        jTextField135.setForeground(new java.awt.Color(255, 0, 51));
        jTextField135.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField135ActionPerformed(evt);
            }
        });
        jPanel109.add(jTextField135, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 120, 20));

        jnhaphoc4.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jnhaphoc4.setText(" hoten");
        jPanel109.add(jnhaphoc4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, 120, 10));

        jPanel1.add(jPanel109, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 1040, 120, 30));

        jPanel110.setBackground(new java.awt.Color(255, 255, 255));
        jPanel110.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel110.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTextField136.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 10)); // NOI18N
        jTextField136.setForeground(new java.awt.Color(255, 0, 51));
        jTextField136.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField136ActionPerformed(evt);
            }
        });
        jPanel110.add(jTextField136, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 120, 20));

        jnhaphoc5.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jnhaphoc5.setText(" hoten");
        jPanel110.add(jnhaphoc5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, 120, 10));

        jPanel1.add(jPanel110, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 1070, 120, 30));

        jPanel111.setBackground(new java.awt.Color(255, 255, 255));
        jPanel111.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel111.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel111.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 18)); // NOI18N
        jLabel111.setForeground(new java.awt.Color(255, 0, 0));
        jLabel111.setText("開始年");
        jPanel111.add(jLabel111, new org.netbeans.lib.awtextra.AbsoluteConstraints(13, 1, 100, 20));

        jLabel117.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel117.setText("NHẬP HỌC");
        jPanel111.add(jLabel117, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 100, -1));

        jPanel1.add(jPanel111, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 910, 120, 40));

        jPanel112.setBackground(new java.awt.Color(255, 255, 255));
        jPanel112.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel112.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jchuatn6.setText("hoten");
        jPanel112.add(jchuatn6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, 180, 10));

        jTextField28.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 10)); // NOI18N
        jTextField28.setForeground(new java.awt.Color(255, 0, 51));
        jTextField28.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField28ActionPerformed(evt);
            }
        });
        jPanel112.add(jTextField28, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 180, 20));

        jPanel1.add(jPanel112, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 1100, 180, 30));

        jPanel113.setBackground(new java.awt.Color(255, 255, 255));
        jPanel113.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel113.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTextField124.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 10)); // NOI18N
        jTextField124.setForeground(new java.awt.Color(255, 0, 51));
        jTextField124.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField124ActionPerformed(evt);
            }
        });
        jPanel113.add(jTextField124, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 120, 20));

        jketthucht1.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jketthucht1.setText(" hoten");
        jPanel113.add(jketthucht1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, 120, 10));

        jPanel1.add(jPanel113, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 950, 120, 30));

        jPanel114.setBackground(new java.awt.Color(255, 255, 255));
        jPanel114.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel114.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTextField125.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 10)); // NOI18N
        jTextField125.setForeground(new java.awt.Color(255, 0, 51));
        jTextField125.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField125ActionPerformed(evt);
            }
        });
        jPanel114.add(jTextField125, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 120, 20));

        jketthucht2.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jketthucht2.setText(" hoten");
        jPanel114.add(jketthucht2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, 120, 10));

        jPanel1.add(jPanel114, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 980, 120, 30));

        jPanel115.setBackground(new java.awt.Color(255, 255, 255));
        jPanel115.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel115.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTextField133.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 10)); // NOI18N
        jTextField133.setForeground(new java.awt.Color(255, 0, 51));
        jTextField133.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField133ActionPerformed(evt);
            }
        });
        jPanel115.add(jTextField133, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 120, 20));

        jketthucht3.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jketthucht3.setText(" hoten");
        jPanel115.add(jketthucht3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, 120, 10));

        jPanel1.add(jPanel115, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 1010, 120, 30));

        jPanel116.setBackground(new java.awt.Color(255, 255, 255));
        jPanel116.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel116.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTextField134.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 10)); // NOI18N
        jTextField134.setForeground(new java.awt.Color(255, 0, 51));
        jTextField134.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField134ActionPerformed(evt);
            }
        });
        jPanel116.add(jTextField134, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 120, 20));

        jketthucht4.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jketthucht4.setText(" hoten");
        jPanel116.add(jketthucht4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, 120, 10));

        jPanel1.add(jPanel116, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 1040, 120, 30));

        jPanel117.setBackground(new java.awt.Color(255, 255, 255));
        jPanel117.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel117.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTextField137.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 10)); // NOI18N
        jTextField137.setForeground(new java.awt.Color(255, 0, 51));
        jTextField137.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField137ActionPerformed(evt);
            }
        });
        jPanel117.add(jTextField137, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 120, 20));

        jketthucht5.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jketthucht5.setText(" hoten");
        jPanel117.add(jketthucht5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, 120, 10));

        jPanel1.add(jPanel117, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 1070, 120, 30));

        jPanel119.setBackground(new java.awt.Color(255, 255, 255));
        jPanel119.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel119.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel113.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 18)); // NOI18N
        jLabel113.setForeground(new java.awt.Color(255, 0, 0));
        jLabel113.setText("    専門 ");
        jPanel119.add(jLabel113, new org.netbeans.lib.awtextra.AbsoluteConstraints(13, 1, 90, 20));

        jLabel119.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel119.setText("CẤP BẬC HỌC");
        jPanel119.add(jLabel119, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 100, -1));

        jPanel1.add(jPanel119, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 910, 160, 40));

        jPanel120.setBackground(new java.awt.Color(255, 255, 255));
        jPanel120.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel120.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTextField117.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 10)); // NOI18N
        jTextField117.setForeground(new java.awt.Color(255, 0, 51));
        jTextField117.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField117ActionPerformed(evt);
            }
        });
        jPanel120.add(jTextField117, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 320, 20));

        jtentruong6.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jtentruong6.setText("THPT Buon Ho");
        jPanel120.add(jtentruong6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, 320, 10));

        jPanel1.add(jPanel120, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 1100, 320, 30));

        jPanel121.setBackground(new java.awt.Color(255, 255, 255));
        jPanel121.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel121.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel126.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel126.setText("THCS/");
        jPanel121.add(jLabel126, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 50, -1));

        jLabel132.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 18)); // NOI18N
        jLabel132.setText("中学校");
        jPanel121.add(jLabel132, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 0, 70, 20));

        jPanel1.add(jPanel121, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 980, 160, 30));

        jPanel122.setBackground(new java.awt.Color(255, 255, 255));
        jPanel122.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel122.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel127.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel127.setText("THPT/");
        jPanel122.add(jLabel127, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 50, -1));

        jLabel133.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 18)); // NOI18N
        jLabel133.setText("高校");
        jPanel122.add(jLabel133, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 0, 70, 20));

        jPanel1.add(jPanel122, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 1010, 160, 30));

        jPanel123.setBackground(new java.awt.Color(255, 255, 255));
        jPanel123.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel123.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel128.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel128.setText("Trung cấp/");
        jPanel123.add(jLabel128, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jLabel134.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 18)); // NOI18N
        jLabel134.setText("専門学校");
        jPanel123.add(jLabel134, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 0, 80, 20));

        jPanel1.add(jPanel123, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 1040, -1, 30));

        jPanel124.setBackground(new java.awt.Color(255, 255, 255));
        jPanel124.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel124.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel129.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel129.setText("Cao đẳng/");
        jPanel124.add(jLabel129, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 70, -1));

        jLabel135.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 18)); // NOI18N
        jLabel135.setText("短期大学");
        jPanel124.add(jLabel135, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 0, 80, 20));

        jPanel1.add(jPanel124, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 1070, -1, 30));

        jPanel125.setBackground(new java.awt.Color(255, 255, 255));
        jPanel125.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel125.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel112.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 18)); // NOI18N
        jLabel112.setForeground(new java.awt.Color(255, 0, 0));
        jLabel112.setText("  終了年");
        jPanel125.add(jLabel112, new org.netbeans.lib.awtextra.AbsoluteConstraints(13, 1, 100, 20));

        jLabel118.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel118.setText("  KẾT THÚC");
        jPanel125.add(jLabel118, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 100, -1));

        jPanel1.add(jPanel125, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 910, 120, 40));

        jPanel126.setBackground(new java.awt.Color(255, 255, 255));
        jPanel126.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel126.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jktht6.setText("hoten");
        jPanel126.add(jktht6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, 120, 10));

        jTextField33.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 10)); // NOI18N
        jTextField33.setForeground(new java.awt.Color(255, 0, 51));
        jTextField33.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField33ActionPerformed(evt);
            }
        });
        jPanel126.add(jTextField33, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 120, 20));

        jPanel1.add(jPanel126, new org.netbeans.lib.awtextra.AbsoluteConstraints(1040, 1100, 120, 30));

        jPanel128.setBackground(new java.awt.Color(255, 255, 255));
        jPanel128.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel128.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTextField118.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 10)); // NOI18N
        jTextField118.setForeground(new java.awt.Color(255, 0, 51));
        jTextField118.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField118ActionPerformed(evt);
            }
        });
        jPanel128.add(jTextField118, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 120, 20));

        jdatn2.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jdatn2.setText(" hoten");
        jPanel128.add(jdatn2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, 120, 10));

        jPanel1.add(jPanel128, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 980, 120, 30));

        jPanel129.setBackground(new java.awt.Color(255, 255, 255));
        jPanel129.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel129.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTextField119.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 10)); // NOI18N
        jTextField119.setForeground(new java.awt.Color(255, 0, 51));
        jTextField119.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField119ActionPerformed(evt);
            }
        });
        jPanel129.add(jTextField119, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 120, 20));

        jdatn3.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jdatn3.setText(" hoten");
        jPanel129.add(jdatn3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, 120, 10));

        jPanel1.add(jPanel129, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 1010, 120, 30));

        jPanel130.setBackground(new java.awt.Color(255, 255, 255));
        jPanel130.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel130.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTextField120.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 10)); // NOI18N
        jTextField120.setForeground(new java.awt.Color(255, 0, 51));
        jTextField120.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField120ActionPerformed(evt);
            }
        });
        jPanel130.add(jTextField120, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 120, 20));

        jdatn4.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jdatn4.setText(" hoten");
        jPanel130.add(jdatn4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, 120, 10));

        jPanel1.add(jPanel130, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 1040, 120, 30));

        jPanel131.setBackground(new java.awt.Color(255, 255, 255));
        jPanel131.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel131.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTextField121.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 10)); // NOI18N
        jTextField121.setForeground(new java.awt.Color(255, 0, 51));
        jTextField121.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField121ActionPerformed(evt);
            }
        });
        jPanel131.add(jTextField121, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 120, 20));

        jdatn5.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jdatn5.setText(" hoten");
        jPanel131.add(jdatn5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, 120, 10));

        jPanel1.add(jPanel131, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 1070, 120, 30));

        jPanel132.setBackground(new java.awt.Color(255, 255, 255));
        jPanel132.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel132.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTextField122.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 10)); // NOI18N
        jTextField122.setForeground(new java.awt.Color(255, 0, 51));
        jTextField122.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField122ActionPerformed(evt);
            }
        });
        jPanel132.add(jTextField122, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 120, 20));

        jdatn6.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jdatn6.setText(" hoten");
        jPanel132.add(jdatn6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, 120, 10));

        jPanel1.add(jPanel132, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 1100, 120, 30));

        jPanel133.setBackground(new java.awt.Color(255, 255, 255));
        jPanel133.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel133.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel115.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 18)); // NOI18N
        jLabel115.setForeground(new java.awt.Color(255, 0, 0));
        jLabel115.setText("        中退");
        jPanel133.add(jLabel115, new org.netbeans.lib.awtextra.AbsoluteConstraints(13, 1, 140, 20));

        jLabel121.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel121.setText("CHƯA TỐT NGHIỆP");
        jPanel133.add(jLabel121, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 150, -1));

        jPanel1.add(jPanel133, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 910, 180, 40));

        jPanel135.setBackground(new java.awt.Color(255, 255, 255));
        jPanel135.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel135.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jchuatn2.setText("hoten");
        jPanel135.add(jchuatn2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, 180, 10));

        jTextField24.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 10)); // NOI18N
        jTextField24.setForeground(new java.awt.Color(255, 0, 51));
        jTextField24.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField24ActionPerformed(evt);
            }
        });
        jPanel135.add(jTextField24, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 180, 20));

        jPanel1.add(jPanel135, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 980, 180, 30));

        jPanel136.setBackground(new java.awt.Color(255, 255, 255));
        jPanel136.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel136.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jchuatn3.setText("hoten");
        jPanel136.add(jchuatn3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, 180, 10));

        jTextField25.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 10)); // NOI18N
        jTextField25.setForeground(new java.awt.Color(255, 0, 51));
        jTextField25.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField25ActionPerformed(evt);
            }
        });
        jPanel136.add(jTextField25, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 180, 20));

        jPanel1.add(jPanel136, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 1010, 180, 30));

        jPanel137.setBackground(new java.awt.Color(255, 255, 255));
        jPanel137.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel137.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jchuatn4.setText("hoten");
        jPanel137.add(jchuatn4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, 180, 10));

        jTextField26.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 10)); // NOI18N
        jTextField26.setForeground(new java.awt.Color(255, 0, 51));
        jTextField26.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField26ActionPerformed(evt);
            }
        });
        jPanel137.add(jTextField26, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 180, 20));

        jPanel1.add(jPanel137, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 1040, 180, 30));

        jPanel138.setBackground(new java.awt.Color(255, 255, 255));
        jPanel138.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel138.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jchuatn5.setText("hoten");
        jPanel138.add(jchuatn5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, 180, 10));

        jTextField27.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 10)); // NOI18N
        jTextField27.setForeground(new java.awt.Color(255, 0, 51));
        jTextField27.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField27ActionPerformed(evt);
            }
        });
        jPanel138.add(jTextField27, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 180, 20));

        jPanel1.add(jPanel138, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 1070, 180, 30));

        jPanel139.setBackground(new java.awt.Color(255, 255, 255));
        jPanel139.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel139.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel114.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 18)); // NOI18N
        jLabel114.setForeground(new java.awt.Color(255, 0, 0));
        jLabel114.setText("      合格");
        jPanel139.add(jLabel114, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, 130, 20));

        jLabel120.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel120.setText(" ĐÃ TỐT NGHIỆP");
        jPanel139.add(jLabel120, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, 120, -1));

        jPanel1.add(jPanel139, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 910, 120, 40));

        jPanel140.setBackground(new java.awt.Color(255, 255, 255));
        jPanel140.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel140.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel116.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 18)); // NOI18N
        jLabel116.setForeground(new java.awt.Color(255, 0, 0));
        jLabel116.setText("  備考");
        jPanel140.add(jLabel116, new org.netbeans.lib.awtextra.AbsoluteConstraints(13, 1, 100, 20));

        jLabel122.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel122.setText("KẾT THÚC");
        jPanel140.add(jLabel122, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 100, -1));

        jPanel1.add(jPanel140, new org.netbeans.lib.awtextra.AbsoluteConstraints(1040, 910, 120, 40));

        jPanel141.setBackground(new java.awt.Color(255, 255, 255));
        jPanel141.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel141.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jktht1.setText("hoten");
        jPanel141.add(jktht1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, 120, 10));

        jTextField22.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 10)); // NOI18N
        jTextField22.setForeground(new java.awt.Color(255, 0, 51));
        jTextField22.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField22ActionPerformed(evt);
            }
        });
        jPanel141.add(jTextField22, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 120, 20));

        jPanel1.add(jPanel141, new org.netbeans.lib.awtextra.AbsoluteConstraints(1040, 950, 120, 30));

        jPanel142.setBackground(new java.awt.Color(255, 255, 255));
        jPanel142.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel142.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jktht2.setText("hoten");
        jPanel142.add(jktht2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, 120, 10));

        jTextField29.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 10)); // NOI18N
        jTextField29.setForeground(new java.awt.Color(255, 0, 51));
        jTextField29.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField29ActionPerformed(evt);
            }
        });
        jPanel142.add(jTextField29, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 120, 20));

        jPanel1.add(jPanel142, new org.netbeans.lib.awtextra.AbsoluteConstraints(1040, 980, 120, 30));

        jPanel143.setBackground(new java.awt.Color(255, 255, 255));
        jPanel143.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel143.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jktht3.setText("hoten");
        jPanel143.add(jktht3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, 120, 10));

        jTextField30.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 10)); // NOI18N
        jTextField30.setForeground(new java.awt.Color(255, 0, 51));
        jTextField30.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField30ActionPerformed(evt);
            }
        });
        jPanel143.add(jTextField30, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 120, 20));

        jPanel1.add(jPanel143, new org.netbeans.lib.awtextra.AbsoluteConstraints(1040, 1010, 120, 30));

        jPanel144.setBackground(new java.awt.Color(255, 255, 255));
        jPanel144.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel144.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jktht4.setText("hoten");
        jPanel144.add(jktht4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, 120, 10));

        jTextField31.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 10)); // NOI18N
        jTextField31.setForeground(new java.awt.Color(255, 0, 51));
        jTextField31.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField31ActionPerformed(evt);
            }
        });
        jPanel144.add(jTextField31, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 120, 20));

        jPanel1.add(jPanel144, new org.netbeans.lib.awtextra.AbsoluteConstraints(1040, 1040, 120, 30));

        jPanel145.setBackground(new java.awt.Color(255, 255, 255));
        jPanel145.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel145.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jktht5.setText("hoten");
        jPanel145.add(jktht5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, 120, 10));

        jTextField32.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 10)); // NOI18N
        jTextField32.setForeground(new java.awt.Color(255, 0, 51));
        jTextField32.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField32ActionPerformed(evt);
            }
        });
        jPanel145.add(jTextField32, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 120, 20));

        jPanel1.add(jPanel145, new org.netbeans.lib.awtextra.AbsoluteConstraints(1040, 1070, 120, 30));

        jPanel146.setBackground(new java.awt.Color(255, 255, 255));
        jPanel146.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel146.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel125.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel125.setText("Tiểu học/");
        jPanel146.add(jLabel125, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 70, -1));

        jLabel131.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 18)); // NOI18N
        jLabel131.setText("小学校");
        jPanel146.add(jLabel131, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 0, 70, 20));

        jPanel1.add(jPanel146, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 950, 160, 30));

        jPanel147.setBackground(new java.awt.Color(255, 255, 255));
        jPanel147.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel147.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel123.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 18)); // NOI18N
        jLabel123.setForeground(new java.awt.Color(255, 0, 0));
        jLabel123.setText("                       学校の名前");
        jPanel147.add(jLabel123, new org.netbeans.lib.awtextra.AbsoluteConstraints(13, 1, 290, 20));

        jLabel124.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel124.setText("                      TÊN TRƯỜNG");
        jPanel147.add(jLabel124, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 290, -1));

        jPanel1.add(jPanel147, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 910, 320, -1));

        jPanel148.setBackground(new java.awt.Color(255, 255, 255));
        jPanel148.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel148.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jtentruong1.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jtentruong1.setText("THPT Buôn Hồ há hash há HÁ HÁ");
        jPanel148.add(jtentruong1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, 320, 10));

        jTextField19.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 10)); // NOI18N
        jTextField19.setForeground(new java.awt.Color(255, 0, 51));
        jTextField19.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField19ActionPerformed(evt);
            }
        });
        jPanel148.add(jTextField19, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 320, 20));

        jPanel1.add(jPanel148, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 950, -1, 30));

        jPanel149.setBackground(new java.awt.Color(255, 255, 255));
        jPanel149.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel149.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTextField23.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 10)); // NOI18N
        jTextField23.setForeground(new java.awt.Color(255, 0, 51));
        jTextField23.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField23ActionPerformed(evt);
            }
        });
        jPanel149.add(jTextField23, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 320, 20));

        jtentruong2.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jtentruong2.setText("THPT Buon Ho");
        jPanel149.add(jtentruong2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, 320, 10));

        jPanel1.add(jPanel149, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 980, 320, 30));

        jPanel150.setBackground(new java.awt.Color(255, 255, 255));
        jPanel150.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel150.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTextField114.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 10)); // NOI18N
        jTextField114.setForeground(new java.awt.Color(255, 0, 51));
        jTextField114.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField114ActionPerformed(evt);
            }
        });
        jPanel150.add(jTextField114, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 320, 20));

        jtentruong3.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jtentruong3.setText("THPT Buon Ho");
        jPanel150.add(jtentruong3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, 320, 10));

        jPanel1.add(jPanel150, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 1010, 320, 30));

        jPanel151.setBackground(new java.awt.Color(255, 255, 255));
        jPanel151.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel151.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTextField116.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 10)); // NOI18N
        jTextField116.setForeground(new java.awt.Color(255, 0, 51));
        jTextField116.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField116ActionPerformed(evt);
            }
        });
        jPanel151.add(jTextField116, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 320, 20));

        jtentruong5.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jtentruong5.setText("THPT Buon Ho");
        jPanel151.add(jtentruong5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, 320, 10));

        jPanel1.add(jPanel151, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 1070, 320, 30));

        jPanel260.setBackground(new java.awt.Color(255, 255, 255));
        jPanel260.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel260.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTextField115.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 10)); // NOI18N
        jTextField115.setForeground(new java.awt.Color(255, 0, 51));
        jTextField115.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField115ActionPerformed(evt);
            }
        });
        jPanel260.add(jTextField115, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 320, 20));

        jtentruong4.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jtentruong4.setText("THPT Buon Ho");
        jPanel260.add(jtentruong4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, 320, 10));

        jPanel1.add(jPanel260, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 1040, 320, 30));

        jPanel261.setBackground(new java.awt.Color(255, 255, 255));
        jPanel261.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel261.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jCheckBox7.setBackground(new java.awt.Color(255, 255, 255));
        jPanel261.add(jCheckBox7, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 5, 20, 30));

        jPanel1.add(jPanel261, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 490, 30, 40));

        jPanel30.setBackground(new java.awt.Color(255, 255, 255));
        jPanel30.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel30.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel127.setBackground(new java.awt.Color(255, 255, 255));
        jPanel127.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel127.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jdatn1.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jdatn1.setText(" hoten");
        jPanel127.add(jdatn1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, 120, 10));

        jTextField109.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 10)); // NOI18N
        jTextField109.setForeground(new java.awt.Color(255, 0, 51));
        jTextField109.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField109ActionPerformed(evt);
            }
        });
        jPanel127.add(jTextField109, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 120, 20));

        jPanel30.add(jPanel127, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 40, 120, 30));

        jPanel134.setBackground(new java.awt.Color(255, 255, 255));
        jPanel134.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel134.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jchuatn1.setText("hoten");
        jPanel134.add(jchuatn1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, 180, 10));

        jTextField21.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 10)); // NOI18N
        jTextField21.setForeground(new java.awt.Color(255, 0, 51));
        jTextField21.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField21ActionPerformed(evt);
            }
        });
        jPanel134.add(jTextField21, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 180, 20));

        jPanel30.add(jPanel134, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 40, 180, -1));

        jPanel104.setBackground(new java.awt.Color(255, 255, 255));
        jPanel104.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel104.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTextField138.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 10)); // NOI18N
        jTextField138.setForeground(new java.awt.Color(255, 0, 51));
        jTextField138.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField138ActionPerformed(evt);
            }
        });
        jPanel104.add(jTextField138, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 120, 20));

        jnhaphoc6.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jnhaphoc6.setText(" hoten");
        jPanel104.add(jnhaphoc6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, 120, 10));

        jPanel30.add(jPanel104, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 190, 120, 30));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTextField139.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 10)); // NOI18N
        jTextField139.setForeground(new java.awt.Color(255, 0, 51));
        jTextField139.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField139ActionPerformed(evt);
            }
        });
        jPanel3.add(jTextField139, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 120, 20));

        jketthucht6.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jketthucht6.setText(" hoten");
        jPanel3.add(jketthucht6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, 120, 10));

        jPanel30.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 190, 120, 30));

        jPanel1.add(jPanel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 910, 1140, 220));

        jLabel137.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 18)); // NOI18N
        jLabel137.setText("E. 職歴/");
        jPanel1.add(jLabel137, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 1130, -1, -1));

        jLabel138.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel138.setText("QUÁ TRÌNH LÀM VIỆC");
        jPanel1.add(jLabel138, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 1120, -1, 50));

        jPanel155.setBackground(new java.awt.Color(255, 255, 255));
        jPanel155.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel155.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel139.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 18)); // NOI18N
        jLabel139.setForeground(new java.awt.Color(255, 0, 0));
        jLabel139.setText("開始年");
        jPanel155.add(jLabel139, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, 80, 20));

        jLabel140.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel140.setText("NGÀY VÀO");
        jPanel155.add(jLabel140, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 100, -1));

        jPanel1.add(jPanel155, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 1160, 120, 40));

        jPanel157.setBackground(new java.awt.Color(255, 255, 255));
        jPanel157.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel157.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTextField128.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 10)); // NOI18N
        jTextField128.setForeground(new java.awt.Color(255, 0, 51));
        jTextField128.setText("  ");
        jTextField128.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField128ActionPerformed(evt);
            }
        });
        jPanel157.add(jTextField128, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 120, 20));

        jngayvao1.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jPanel157.add(jngayvao1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 110, 20));

        jPanel1.add(jPanel157, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 1200, 120, 40));

        jPanel158.setBackground(new java.awt.Color(255, 255, 255));
        jPanel158.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel158.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTextField129.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 10)); // NOI18N
        jTextField129.setForeground(new java.awt.Color(255, 0, 51));
        jTextField129.setText(" ");
        jTextField129.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField129ActionPerformed(evt);
            }
        });
        jPanel158.add(jTextField129, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 120, 20));

        jngayvao2.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jPanel158.add(jngayvao2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 110, 20));

        jPanel1.add(jPanel158, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 1240, 120, 40));

        jPanel161.setBackground(new java.awt.Color(255, 255, 255));
        jPanel161.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel161.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel149.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel149.setText("KẾT THÚC");
        jPanel161.add(jLabel149, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 100, -1));

        jLabel150.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 18)); // NOI18N
        jLabel150.setForeground(new java.awt.Color(255, 0, 0));
        jLabel150.setText("終了年");
        jPanel161.add(jLabel150, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, 100, 20));

        jPanel1.add(jPanel161, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 1160, -1, 40));

        jPanel162.setBackground(new java.awt.Color(255, 255, 255));
        jPanel162.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel162.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jktlv1.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jPanel162.add(jktlv1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 110, 20));

        jTextField132.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 10)); // NOI18N
        jTextField132.setForeground(new java.awt.Color(255, 0, 51));
        jTextField132.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField132ActionPerformed(evt);
            }
        });
        jPanel162.add(jTextField132, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 120, -1));

        jPanel1.add(jPanel162, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 1200, 120, 40));

        jPanel166.setBackground(new java.awt.Color(255, 255, 255));
        jPanel166.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel166.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel147.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 18)); // NOI18N
        jLabel147.setForeground(new java.awt.Color(255, 0, 0));
        jLabel147.setText("会社名");
        jPanel166.add(jLabel147, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 0, 130, 20));

        jLabel148.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel148.setText("TÊN CÔNG TY");
        jPanel166.add(jLabel148, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 20, 140, -1));

        jPanel1.add(jPanel166, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 1160, 290, 40));

        jPanel170.setBackground(new java.awt.Color(255, 255, 255));
        jPanel170.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel170.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel141.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 18)); // NOI18N
        jLabel141.setForeground(new java.awt.Color(255, 0, 0));
        jLabel141.setText("職種");
        jPanel170.add(jLabel141, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 0, 130, 20));

        jLabel142.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel142.setText("LĨNH VỰC HOẠT ĐỘNG CỦA CÔNG TY");
        jPanel170.add(jLabel142, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 270, -1));

        jPanel1.add(jPanel170, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 1160, 310, 40));

        jPanel174.setBackground(new java.awt.Color(255, 255, 255));
        jPanel174.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel174.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTextField34.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 10)); // NOI18N
        jTextField34.setForeground(new java.awt.Color(255, 0, 51));
        jTextField34.setText(" ");
        jTextField34.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField34ActionPerformed(evt);
            }
        });
        jPanel174.add(jTextField34, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 310, 20));

        jTextField193.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 10)); // NOI18N
        jTextField193.setForeground(new java.awt.Color(255, 0, 51));
        jTextField193.setText(" ");
        jTextField193.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField193ActionPerformed(evt);
            }
        });
        jPanel174.add(jTextField193, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, 310, 20));

        jPanel1.add(jPanel174, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 1200, 310, 40));

        jPanel175.setBackground(new java.awt.Color(255, 255, 255));
        jPanel175.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel175.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel143.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 18)); // NOI18N
        jLabel143.setForeground(new java.awt.Color(255, 0, 0));
        jLabel143.setText("職種");
        jPanel175.add(jLabel143, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 0, 60, 20));

        jLabel144.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel144.setText("CÔNG VIỆC ĐÃ LÀM");
        jPanel175.add(jLabel144, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 150, -1));

        jPanel1.add(jPanel175, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 1160, 180, 40));

        jPanel179.setBackground(new java.awt.Color(255, 255, 255));
        jPanel179.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel179.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTextField147.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 10)); // NOI18N
        jTextField147.setForeground(new java.awt.Color(255, 0, 51));
        jTextField147.setText(" ");
        jTextField147.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField147ActionPerformed(evt);
            }
        });
        jPanel179.add(jTextField147, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 180, 20));

        jctdl1.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jPanel179.add(jctdl1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 170, 20));

        jPanel1.add(jPanel179, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 1200, 180, 40));

        jPanel180.setBackground(new java.awt.Color(255, 255, 255));
        jPanel180.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel180.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel145.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 18)); // NOI18N
        jLabel145.setForeground(new java.awt.Color(255, 0, 0));
        jLabel145.setText("備考");
        jPanel180.add(jLabel145, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 0, 60, 20));

        jLabel146.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel146.setText("GHI CHÚ");
        jPanel180.add(jLabel146, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 90, -1));

        jPanel1.add(jPanel180, new org.netbeans.lib.awtextra.AbsoluteConstraints(1040, 1160, 120, 40));

        jPanel181.setBackground(new java.awt.Color(255, 255, 255));
        jPanel181.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel181.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTextField143.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 10)); // NOI18N
        jTextField143.setText(" ");
        jTextField143.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField143ActionPerformed(evt);
            }
        });
        jPanel181.add(jTextField143, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, 120, -1));

        jTextField192.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 10)); // NOI18N
        jTextField192.setForeground(new java.awt.Color(255, 0, 51));
        jTextField192.setText(" ");
        jTextField192.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField192ActionPerformed(evt);
            }
        });
        jPanel181.add(jTextField192, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 120, 20));

        jPanel1.add(jPanel181, new org.netbeans.lib.awtextra.AbsoluteConstraints(1040, 1200, 120, 40));

        jPanel154.setBackground(new java.awt.Color(255, 255, 255));
        jPanel154.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel154.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel159.setBackground(new java.awt.Color(255, 255, 255));
        jPanel159.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel159.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTextField130.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 10)); // NOI18N
        jTextField130.setForeground(new java.awt.Color(255, 0, 51));
        jTextField130.setText(" ");
        jTextField130.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField130ActionPerformed(evt);
            }
        });
        jPanel159.add(jTextField130, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 120, 20));

        jngayvao3.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jPanel159.add(jngayvao3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 110, 20));

        jPanel154.add(jPanel159, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 120, -1, 40));

        jPanel164.setBackground(new java.awt.Color(255, 255, 255));
        jPanel164.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel164.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jktlv3.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jPanel164.add(jktlv3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 110, 20));

        jTextField141.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 10)); // NOI18N
        jTextField141.setForeground(new java.awt.Color(255, 0, 51));
        jTextField141.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField141ActionPerformed(evt);
            }
        });
        jPanel164.add(jTextField141, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 120, -1));

        jPanel154.add(jPanel164, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 120, -1, 40));

        jPanel163.setBackground(new java.awt.Color(255, 255, 255));
        jPanel163.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel163.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jktlv2.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jPanel163.add(jktlv2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 110, 20));

        jTextField140.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 10)); // NOI18N
        jTextField140.setForeground(new java.awt.Color(255, 0, 51));
        jTextField140.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField140ActionPerformed(evt);
            }
        });
        jPanel163.add(jTextField140, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 120, -1));

        jPanel154.add(jPanel163, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 80, -1, 40));

        jPanel169.setBackground(new java.awt.Color(255, 255, 255));
        jPanel169.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel169.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jtenct3.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jPanel169.add(jtenct3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 280, 20));

        jTextField40.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 10)); // NOI18N
        jTextField40.setForeground(new java.awt.Color(255, 0, 51));
        jTextField40.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField40ActionPerformed(evt);
            }
        });
        jPanel169.add(jTextField40, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 290, -1));

        jPanel154.add(jPanel169, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 120, -1, 40));

        jPanel168.setBackground(new java.awt.Color(255, 255, 255));
        jPanel168.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel168.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jtenct2.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jPanel168.add(jtenct2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 280, 20));

        jTextField39.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 10)); // NOI18N
        jTextField39.setForeground(new java.awt.Color(255, 0, 51));
        jTextField39.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField39ActionPerformed(evt);
            }
        });
        jPanel168.add(jTextField39, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 290, -1));

        jPanel154.add(jPanel168, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 80, 290, 40));

        jPanel167.setBackground(new java.awt.Color(255, 255, 255));
        jPanel167.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel167.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jtenct1.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jPanel167.add(jtenct1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 280, 20));

        jTextField38.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 10)); // NOI18N
        jTextField38.setForeground(new java.awt.Color(255, 0, 51));
        jTextField38.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField38ActionPerformed(evt);
            }
        });
        jPanel167.add(jTextField38, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 290, -1));

        jPanel154.add(jPanel167, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 40, -1, 40));

        jPanel172.setBackground(new java.awt.Color(255, 255, 255));
        jPanel172.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel172.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTextField36.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 10)); // NOI18N
        jTextField36.setForeground(new java.awt.Color(255, 0, 51));
        jTextField36.setText(" ");
        jTextField36.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField36ActionPerformed(evt);
            }
        });
        jPanel172.add(jTextField36, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 310, 20));

        jTextField195.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 10)); // NOI18N
        jTextField195.setForeground(new java.awt.Color(255, 0, 51));
        jTextField195.setText(" ");
        jTextField195.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField195ActionPerformed(evt);
            }
        });
        jPanel172.add(jTextField195, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, 310, 20));

        jPanel154.add(jPanel172, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 120, -1, 40));

        jPanel171.setBackground(new java.awt.Color(255, 255, 255));
        jPanel171.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel171.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTextField194.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 10)); // NOI18N
        jTextField194.setForeground(new java.awt.Color(255, 0, 51));
        jTextField194.setText(" ");
        jTextField194.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField194ActionPerformed(evt);
            }
        });
        jPanel171.add(jTextField194, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, 310, 20));

        jlvhdct2.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 10)); // NOI18N
        jlvhdct2.setForeground(new java.awt.Color(255, 0, 51));
        jlvhdct2.setText(" ");
        jlvhdct2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jlvhdct2ActionPerformed(evt);
            }
        });
        jPanel171.add(jlvhdct2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 310, -1));

        jPanel154.add(jPanel171, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 80, -1, 40));

        jPanel177.setBackground(new java.awt.Color(255, 255, 255));
        jPanel177.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel177.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTextField149.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 10)); // NOI18N
        jTextField149.setForeground(new java.awt.Color(255, 0, 51));
        jTextField149.setText(" ");
        jTextField149.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField149ActionPerformed(evt);
            }
        });
        jPanel177.add(jTextField149, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 180, 20));

        jctdl3.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jPanel177.add(jctdl3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 170, 20));

        jPanel154.add(jPanel177, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 120, -1, 40));

        jPanel176.setBackground(new java.awt.Color(255, 255, 255));
        jPanel176.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel176.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTextField148.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 10)); // NOI18N
        jTextField148.setForeground(new java.awt.Color(255, 0, 51));
        jTextField148.setText(" ");
        jTextField148.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField148ActionPerformed(evt);
            }
        });
        jPanel176.add(jTextField148, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 180, 20));

        jctdl2.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jPanel176.add(jctdl2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 170, 20));

        jPanel154.add(jPanel176, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 80, -1, 40));

        jPanel182.setBackground(new java.awt.Color(255, 255, 255));
        jPanel182.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel182.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTextField145.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 10)); // NOI18N
        jTextField145.setForeground(new java.awt.Color(255, 0, 51));
        jTextField145.setText(" ");
        jTextField145.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField145ActionPerformed(evt);
            }
        });
        jPanel182.add(jTextField145, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 120, 20));

        jTextField150.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 10)); // NOI18N
        jTextField150.setText(" ");
        jTextField150.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField150ActionPerformed(evt);
            }
        });
        jPanel182.add(jTextField150, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, 120, -1));

        jPanel154.add(jPanel182, new org.netbeans.lib.awtextra.AbsoluteConstraints(1020, 120, -1, 40));

        jPanel184.setBackground(new java.awt.Color(255, 255, 255));
        jPanel184.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel184.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTextField144.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 10)); // NOI18N
        jTextField144.setForeground(new java.awt.Color(255, 0, 51));
        jTextField144.setText(" ");
        jTextField144.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField144ActionPerformed(evt);
            }
        });
        jPanel184.add(jTextField144, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 120, 20));

        jTextField146.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 10)); // NOI18N
        jTextField146.setText(" ");
        jTextField146.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField146ActionPerformed(evt);
            }
        });
        jPanel184.add(jTextField146, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, 120, -1));

        jPanel154.add(jPanel184, new org.netbeans.lib.awtextra.AbsoluteConstraints(1020, 80, -1, 40));

        jPanel1.add(jPanel154, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 1160, 1140, 160));

        jLabel151.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 18)); // NOI18N
        jLabel151.setText("F. 家族/ GIA ĐÌNH ");
        jPanel1.add(jLabel151, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 1320, -1, 30));

        jPanel186.setBackground(new java.awt.Color(255, 255, 255));
        jPanel186.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel186.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel184.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel184.setText("6");
        jPanel186.add(jLabel184, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 20, -1));

        jPanel1.add(jPanel186, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 1590, 40, 40));

        jPanel187.setBackground(new java.awt.Color(255, 255, 255));
        jPanel187.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel187.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTextField155.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 10)); // NOI18N
        jTextField155.setForeground(new java.awt.Color(255, 0, 51));
        jTextField155.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField155ActionPerformed(evt);
            }
        });
        jPanel187.add(jTextField155, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 290, 20));

        jtengd6.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jPanel187.add(jtengd6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 280, 20));

        jPanel1.add(jPanel187, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 1590, 290, 40));

        jPanel188.setBackground(new java.awt.Color(255, 255, 255));
        jPanel188.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel188.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel176.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel176.setText("No");
        jPanel188.add(jLabel176, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 20, -1));

        jPanel1.add(jPanel188, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 1350, 40, 40));

        jPanel189.setBackground(new java.awt.Color(255, 255, 255));
        jPanel189.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel189.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel177.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel177.setText("1");
        jPanel189.add(jLabel177, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 20, -1));

        jPanel1.add(jPanel189, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 1390, 40, 40));

        jPanel190.setBackground(new java.awt.Color(255, 255, 255));
        jPanel190.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel190.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel180.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel180.setText("2");
        jPanel190.add(jLabel180, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 20, -1));

        jPanel1.add(jPanel190, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 1430, 40, 40));

        jPanel191.setBackground(new java.awt.Color(255, 255, 255));
        jPanel191.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel191.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel181.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel181.setText("3");
        jPanel191.add(jLabel181, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 20, -1));

        jPanel1.add(jPanel191, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 1470, 40, 40));

        jPanel192.setBackground(new java.awt.Color(255, 255, 255));
        jPanel192.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel192.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel182.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel182.setText("4");
        jPanel192.add(jLabel182, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 20, -1));

        jPanel1.add(jPanel192, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 1510, 40, 40));

        jPanel193.setBackground(new java.awt.Color(255, 255, 255));
        jPanel193.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel193.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel183.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel183.setText("5");
        jPanel193.add(jLabel183, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 20, -1));

        jPanel1.add(jPanel193, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 1550, 40, 40));

        jPanel194.setBackground(new java.awt.Color(255, 255, 255));
        jPanel194.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel194.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel154.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel154.setText("   Sống riêng");
        jPanel194.add(jLabel154, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 100, -1));

        jLabel155.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 18)); // NOI18N
        jLabel155.setForeground(new java.awt.Color(255, 0, 0));
        jLabel155.setText("別居に暮らす");
        jPanel194.add(jLabel155, new org.netbeans.lib.awtextra.AbsoluteConstraints(13, 1, 100, 20));

        jPanel1.add(jPanel194, new org.netbeans.lib.awtextra.AbsoluteConstraints(1040, 1350, 120, -1));

        jPanel195.setBackground(new java.awt.Color(255, 255, 255));
        jPanel195.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel195.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTextField161.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 10)); // NOI18N
        jTextField161.setForeground(new java.awt.Color(255, 0, 51));
        jTextField161.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField161ActionPerformed(evt);
            }
        });
        jPanel195.add(jTextField161, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 120, 20));

        jquanhe6.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jPanel195.add(jquanhe6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 110, 20));

        jPanel1.add(jPanel195, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 1590, 120, 40));

        jPanel196.setBackground(new java.awt.Color(255, 255, 255));
        jPanel196.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel196.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTextField167.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 10)); // NOI18N
        jTextField167.setForeground(new java.awt.Color(255, 0, 51));
        jTextField167.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField167ActionPerformed(evt);
            }
        });
        jPanel196.add(jTextField167, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 90, 20));

        jtuoigd6.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jPanel196.add(jtuoigd6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 80, 20));

        jPanel1.add(jPanel196, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 1590, 90, 40));

        jPanel197.setBackground(new java.awt.Color(255, 255, 255));
        jPanel197.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel197.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTextField173.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 10)); // NOI18N
        jTextField173.setForeground(new java.awt.Color(255, 0, 51));
        jTextField173.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField173ActionPerformed(evt);
            }
        });
        jPanel197.add(jTextField173, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 150, 20));

        jttskgd6.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jPanel197.add(jttskgd6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 130, 20));

        jPanel1.add(jPanel197, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 1590, 150, 40));

        jPanel198.setBackground(new java.awt.Color(255, 255, 255));
        jPanel198.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel198.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTextField179.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 10)); // NOI18N
        jTextField179.setForeground(new java.awt.Color(255, 0, 51));
        jTextField179.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField179ActionPerformed(evt);
            }
        });
        jPanel198.add(jTextField179, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 210, 20));

        jnghegd6.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jPanel198.add(jnghegd6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 200, 20));

        jPanel1.add(jPanel198, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 1590, 210, 40));

        jPanel199.setBackground(new java.awt.Color(255, 255, 255));
        jPanel199.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel199.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTextField185.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 10)); // NOI18N
        jTextField185.setForeground(new java.awt.Color(255, 0, 51));
        jTextField185.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField185ActionPerformed(evt);
            }
        });
        jPanel199.add(jTextField185, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 120, 20));

        jTextField205.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 10)); // NOI18N
        jTextField205.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField205ActionPerformed(evt);
            }
        });
        jPanel199.add(jTextField205, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, 120, 20));

        jPanel1.add(jPanel199, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 1590, 120, 40));

        jPanel200.setBackground(new java.awt.Color(255, 255, 255));
        jPanel200.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel200.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel166.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 18)); // NOI18N
        jLabel166.setForeground(new java.awt.Color(255, 0, 0));
        jLabel166.setText("氏名");
        jPanel200.add(jLabel166, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 0, 100, 20));

        jLabel167.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel167.setText("TÊN");
        jPanel200.add(jLabel167, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 20, 100, -1));

        jPanel1.add(jPanel200, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 1350, 290, 40));

        jPanel201.setBackground(new java.awt.Color(255, 255, 255));
        jPanel201.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel201.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTextField42.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 10)); // NOI18N
        jTextField42.setForeground(new java.awt.Color(255, 0, 51));
        jTextField42.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField42ActionPerformed(evt);
            }
        });
        jPanel201.add(jTextField42, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 290, 20));

        jtengd1.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jPanel201.add(jtengd1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 280, 20));

        jPanel1.add(jPanel201, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 1390, 290, 40));

        jPanel202.setBackground(new java.awt.Color(255, 255, 255));
        jPanel202.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel202.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTextField151.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 10)); // NOI18N
        jTextField151.setForeground(new java.awt.Color(255, 0, 51));
        jTextField151.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField151ActionPerformed(evt);
            }
        });
        jPanel202.add(jTextField151, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 290, 20));

        jtengd2.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jPanel202.add(jtengd2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 280, 20));

        jPanel1.add(jPanel202, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 1430, 290, 40));

        jPanel203.setBackground(new java.awt.Color(255, 255, 255));
        jPanel203.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel203.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTextField152.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 10)); // NOI18N
        jTextField152.setForeground(new java.awt.Color(255, 0, 51));
        jTextField152.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField152ActionPerformed(evt);
            }
        });
        jPanel203.add(jTextField152, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 290, 20));

        jtengd3.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jPanel203.add(jtengd3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 280, 20));

        jPanel1.add(jPanel203, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 1470, 290, 40));

        jPanel204.setBackground(new java.awt.Color(255, 255, 255));
        jPanel204.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel204.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTextField153.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 10)); // NOI18N
        jTextField153.setForeground(new java.awt.Color(255, 0, 51));
        jTextField153.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField153ActionPerformed(evt);
            }
        });
        jPanel204.add(jTextField153, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 290, 20));

        jtengd4.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jPanel204.add(jtengd4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 280, 20));

        jPanel1.add(jPanel204, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 1510, 290, 40));

        jPanel205.setBackground(new java.awt.Color(255, 255, 255));
        jPanel205.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel205.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTextField154.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 10)); // NOI18N
        jTextField154.setForeground(new java.awt.Color(255, 0, 51));
        jTextField154.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField154ActionPerformed(evt);
            }
        });
        jPanel205.add(jTextField154, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 290, 20));

        jtengd5.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jPanel205.add(jtengd5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 270, 20));

        jPanel1.add(jPanel205, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 1550, 290, 40));

        jPanel206.setBackground(new java.awt.Color(255, 255, 255));
        jPanel206.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel206.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel168.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel168.setText("    Quan hệ");
        jPanel206.add(jLabel168, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 100, -1));

        jLabel169.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 18)); // NOI18N
        jLabel169.setForeground(new java.awt.Color(255, 0, 0));
        jLabel169.setText("      続柄");
        jPanel206.add(jLabel169, new org.netbeans.lib.awtextra.AbsoluteConstraints(13, 1, 100, 20));

        jPanel1.add(jPanel206, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 1350, 120, 40));

        jPanel207.setBackground(new java.awt.Color(255, 255, 255));
        jPanel207.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel207.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTextField156.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 10)); // NOI18N
        jTextField156.setForeground(new java.awt.Color(255, 0, 51));
        jTextField156.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField156ActionPerformed(evt);
            }
        });
        jPanel207.add(jTextField156, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 120, 20));

        jquanhe1.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jquanhe1.setText(" ");
        jPanel207.add(jquanhe1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 110, 20));

        jPanel1.add(jPanel207, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 1390, 120, 40));

        jPanel208.setBackground(new java.awt.Color(255, 255, 255));
        jPanel208.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel208.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTextField157.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 10)); // NOI18N
        jTextField157.setForeground(new java.awt.Color(255, 0, 51));
        jTextField157.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField157ActionPerformed(evt);
            }
        });
        jPanel208.add(jTextField157, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 120, 20));

        jquanhe2.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jPanel208.add(jquanhe2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 110, 20));

        jPanel1.add(jPanel208, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 1430, 120, 40));

        jPanel209.setBackground(new java.awt.Color(255, 255, 255));
        jPanel209.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel209.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTextField158.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 10)); // NOI18N
        jTextField158.setForeground(new java.awt.Color(255, 0, 51));
        jTextField158.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField158ActionPerformed(evt);
            }
        });
        jPanel209.add(jTextField158, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 120, 20));

        jquanhe3.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jPanel209.add(jquanhe3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 110, 20));

        jPanel1.add(jPanel209, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 1470, 120, 40));

        jPanel210.setBackground(new java.awt.Color(255, 255, 255));
        jPanel210.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel210.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTextField159.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 10)); // NOI18N
        jTextField159.setForeground(new java.awt.Color(255, 0, 51));
        jTextField159.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField159ActionPerformed(evt);
            }
        });
        jPanel210.add(jTextField159, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 120, 20));

        jquanhe4.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jPanel210.add(jquanhe4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 110, 20));

        jPanel1.add(jPanel210, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 1510, 120, 40));

        jPanel211.setBackground(new java.awt.Color(255, 255, 255));
        jPanel211.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel211.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTextField160.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 10)); // NOI18N
        jTextField160.setForeground(new java.awt.Color(255, 0, 51));
        jTextField160.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField160ActionPerformed(evt);
            }
        });
        jPanel211.add(jTextField160, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 120, 20));

        jquanhe5.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jPanel211.add(jquanhe5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 110, 20));

        jPanel1.add(jPanel211, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 1550, 120, 40));

        jPanel212.setBackground(new java.awt.Color(255, 255, 255));
        jPanel212.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel212.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel170.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel170.setText("  Tuổi");
        jPanel212.add(jLabel170, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 70, -1));

        jLabel171.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 18)); // NOI18N
        jLabel171.setForeground(new java.awt.Color(255, 0, 0));
        jLabel171.setText(" 年齢");
        jPanel212.add(jLabel171, new org.netbeans.lib.awtextra.AbsoluteConstraints(13, 1, 50, 20));

        jPanel1.add(jPanel212, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 1350, 90, 40));

        jPanel213.setBackground(new java.awt.Color(255, 255, 255));
        jPanel213.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel213.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTextField162.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 10)); // NOI18N
        jTextField162.setForeground(new java.awt.Color(255, 0, 51));
        jTextField162.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField162ActionPerformed(evt);
            }
        });
        jPanel213.add(jTextField162, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 90, 20));

        jtuoigd1.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jPanel213.add(jtuoigd1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 80, 20));

        jPanel1.add(jPanel213, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 1390, 90, 40));

        jPanel214.setBackground(new java.awt.Color(255, 255, 255));
        jPanel214.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel214.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTextField163.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 10)); // NOI18N
        jTextField163.setForeground(new java.awt.Color(255, 0, 51));
        jTextField163.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField163ActionPerformed(evt);
            }
        });
        jPanel214.add(jTextField163, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 90, 20));

        jtuoigd2.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jPanel214.add(jtuoigd2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 80, 20));

        jPanel1.add(jPanel214, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 1430, 90, 40));

        jPanel215.setBackground(new java.awt.Color(255, 255, 255));
        jPanel215.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel215.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTextField164.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 10)); // NOI18N
        jTextField164.setForeground(new java.awt.Color(255, 0, 51));
        jTextField164.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField164ActionPerformed(evt);
            }
        });
        jPanel215.add(jTextField164, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 90, 20));

        jtuoigd3.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jPanel215.add(jtuoigd3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 80, 20));

        jPanel1.add(jPanel215, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 1470, 90, 40));

        jPanel216.setBackground(new java.awt.Color(255, 255, 255));
        jPanel216.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel216.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTextField165.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 10)); // NOI18N
        jTextField165.setForeground(new java.awt.Color(255, 0, 51));
        jTextField165.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField165ActionPerformed(evt);
            }
        });
        jPanel216.add(jTextField165, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 90, 20));

        jtuoigd4.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jPanel216.add(jtuoigd4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 80, 20));

        jPanel1.add(jPanel216, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 1510, 90, 40));

        jPanel217.setBackground(new java.awt.Color(255, 255, 255));
        jPanel217.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel217.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTextField166.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 10)); // NOI18N
        jTextField166.setForeground(new java.awt.Color(255, 0, 51));
        jTextField166.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField166ActionPerformed(evt);
            }
        });
        jPanel217.add(jTextField166, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 90, 20));

        jtuoigd5.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jPanel217.add(jtuoigd5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 80, 20));

        jPanel1.add(jPanel217, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 1550, 90, 40));

        jPanel218.setBackground(new java.awt.Color(255, 255, 255));
        jPanel218.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel218.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel172.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel172.setText(" TÌNH TRẠNG SK");
        jPanel218.add(jLabel172, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 130, -1));

        jLabel173.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 18)); // NOI18N
        jLabel173.setForeground(new java.awt.Color(255, 0, 0));
        jLabel173.setText("家族の健康状況");
        jPanel218.add(jLabel173, new org.netbeans.lib.awtextra.AbsoluteConstraints(13, 1, 130, 20));

        jPanel1.add(jPanel218, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 1350, 150, 40));

        jPanel219.setBackground(new java.awt.Color(255, 255, 255));
        jPanel219.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel219.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTextField168.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 10)); // NOI18N
        jTextField168.setForeground(new java.awt.Color(255, 0, 51));
        jTextField168.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField168ActionPerformed(evt);
            }
        });
        jPanel219.add(jTextField168, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 150, 20));

        jttskgd1.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jPanel219.add(jttskgd1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 140, 20));

        jPanel1.add(jPanel219, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 1390, 150, 40));

        jPanel220.setBackground(new java.awt.Color(255, 255, 255));
        jPanel220.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel220.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTextField169.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 10)); // NOI18N
        jTextField169.setForeground(new java.awt.Color(255, 0, 51));
        jTextField169.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField169ActionPerformed(evt);
            }
        });
        jPanel220.add(jTextField169, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 150, 20));

        jttskgd2.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jPanel220.add(jttskgd2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 140, 20));

        jPanel1.add(jPanel220, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 1430, 150, 40));

        jPanel221.setBackground(new java.awt.Color(255, 255, 255));
        jPanel221.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel221.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTextField170.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 10)); // NOI18N
        jTextField170.setForeground(new java.awt.Color(255, 0, 51));
        jTextField170.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField170ActionPerformed(evt);
            }
        });
        jPanel221.add(jTextField170, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 150, 20));

        jttskgd3.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jPanel221.add(jttskgd3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 130, 20));

        jPanel1.add(jPanel221, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 1470, 150, 40));

        jPanel222.setBackground(new java.awt.Color(255, 255, 255));
        jPanel222.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel222.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTextField171.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 10)); // NOI18N
        jTextField171.setForeground(new java.awt.Color(255, 0, 51));
        jTextField171.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField171ActionPerformed(evt);
            }
        });
        jPanel222.add(jTextField171, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 150, 20));

        jttskgd4.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jPanel222.add(jttskgd4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 140, 20));

        jPanel1.add(jPanel222, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 1510, 150, 40));

        jPanel223.setBackground(new java.awt.Color(255, 255, 255));
        jPanel223.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel223.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTextField172.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 10)); // NOI18N
        jTextField172.setForeground(new java.awt.Color(255, 0, 51));
        jTextField172.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField172ActionPerformed(evt);
            }
        });
        jPanel223.add(jTextField172, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 150, 20));

        jttskgd5.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jPanel223.add(jttskgd5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 140, 20));

        jPanel1.add(jPanel223, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 1550, 150, 40));

        jPanel224.setBackground(new java.awt.Color(255, 255, 255));
        jPanel224.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel224.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel174.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel174.setText("Nghề nghiệp");
        jPanel224.add(jLabel174, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 20, 100, -1));

        jLabel175.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 18)); // NOI18N
        jLabel175.setForeground(new java.awt.Color(255, 0, 0));
        jLabel175.setText("職業 ");
        jPanel224.add(jLabel175, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 0, 70, 20));

        jPanel1.add(jPanel224, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 1350, 210, 40));

        jPanel225.setBackground(new java.awt.Color(255, 255, 255));
        jPanel225.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel225.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTextField174.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 10)); // NOI18N
        jTextField174.setForeground(new java.awt.Color(255, 0, 51));
        jTextField174.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField174ActionPerformed(evt);
            }
        });
        jPanel225.add(jTextField174, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 210, 20));

        jnghegd1.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jPanel225.add(jnghegd1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 190, 20));

        jPanel1.add(jPanel225, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 1390, 210, 40));

        jPanel226.setBackground(new java.awt.Color(255, 255, 255));
        jPanel226.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel226.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTextField175.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 10)); // NOI18N
        jTextField175.setForeground(new java.awt.Color(255, 0, 51));
        jTextField175.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField175ActionPerformed(evt);
            }
        });
        jPanel226.add(jTextField175, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 210, 20));

        jnghegd2.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jPanel226.add(jnghegd2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 200, 20));

        jPanel1.add(jPanel226, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 1430, 210, 40));

        jPanel227.setBackground(new java.awt.Color(255, 255, 255));
        jPanel227.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel227.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTextField176.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 10)); // NOI18N
        jTextField176.setForeground(new java.awt.Color(255, 0, 51));
        jTextField176.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField176ActionPerformed(evt);
            }
        });
        jPanel227.add(jTextField176, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 210, 20));

        jnghegd3.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jPanel227.add(jnghegd3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 200, 20));

        jPanel1.add(jPanel227, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 1470, 210, 40));

        jPanel228.setBackground(new java.awt.Color(255, 255, 255));
        jPanel228.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel228.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTextField177.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 10)); // NOI18N
        jTextField177.setForeground(new java.awt.Color(255, 0, 51));
        jTextField177.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField177ActionPerformed(evt);
            }
        });
        jPanel228.add(jTextField177, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 210, 20));

        jnghegd4.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jPanel228.add(jnghegd4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 200, 20));

        jPanel1.add(jPanel228, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 1510, 210, 40));

        jPanel229.setBackground(new java.awt.Color(255, 255, 255));
        jPanel229.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel229.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTextField178.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 10)); // NOI18N
        jTextField178.setForeground(new java.awt.Color(255, 0, 51));
        jTextField178.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField178ActionPerformed(evt);
            }
        });
        jPanel229.add(jTextField178, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 210, 20));

        jnghegd5.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jPanel229.add(jnghegd5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 190, 20));

        jPanel1.add(jPanel229, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 1550, 210, 40));

        jPanel230.setBackground(new java.awt.Color(255, 255, 255));
        jPanel230.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel230.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTextField181.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 10)); // NOI18N
        jTextField181.setForeground(new java.awt.Color(255, 0, 51));
        jTextField181.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField181ActionPerformed(evt);
            }
        });
        jPanel230.add(jTextField181, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 120, 20));

        jTextField201.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 10)); // NOI18N
        jTextField201.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField201ActionPerformed(evt);
            }
        });
        jPanel230.add(jTextField201, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, 120, 20));

        jPanel1.add(jPanel230, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 1430, 120, 40));

        jPanel231.setBackground(new java.awt.Color(255, 255, 255));
        jPanel231.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel231.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel178.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel178.setText("  Sống chung");
        jPanel231.add(jLabel178, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 100, -1));

        jLabel179.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 18)); // NOI18N
        jLabel179.setForeground(new java.awt.Color(255, 0, 0));
        jLabel179.setText("同居に暮らす");
        jPanel231.add(jLabel179, new org.netbeans.lib.awtextra.AbsoluteConstraints(13, 1, 100, 20));

        jPanel1.add(jPanel231, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 1350, 120, 40));

        jPanel232.setBackground(new java.awt.Color(255, 255, 255));
        jPanel232.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel232.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTextField191.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 10)); // NOI18N
        jTextField191.setForeground(new java.awt.Color(255, 0, 51));
        jTextField191.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField191ActionPerformed(evt);
            }
        });
        jPanel232.add(jTextField191, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 120, 20));

        jTextField211.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 10)); // NOI18N
        jTextField211.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField211ActionPerformed(evt);
            }
        });
        jPanel232.add(jTextField211, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, 120, 20));

        jPanel1.add(jPanel232, new org.netbeans.lib.awtextra.AbsoluteConstraints(1040, 1590, 120, 40));

        jPanel233.setBackground(new java.awt.Color(255, 255, 255));
        jPanel233.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel233.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTextField182.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 10)); // NOI18N
        jTextField182.setForeground(new java.awt.Color(255, 0, 51));
        jTextField182.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField182ActionPerformed(evt);
            }
        });
        jPanel233.add(jTextField182, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 120, 20));

        jTextField202.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 10)); // NOI18N
        jTextField202.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField202ActionPerformed(evt);
            }
        });
        jPanel233.add(jTextField202, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, 120, 20));

        jPanel1.add(jPanel233, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 1470, 120, 40));

        jPanel234.setBackground(new java.awt.Color(255, 255, 255));
        jPanel234.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel234.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTextField183.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 10)); // NOI18N
        jTextField183.setForeground(new java.awt.Color(255, 0, 51));
        jTextField183.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField183ActionPerformed(evt);
            }
        });
        jPanel234.add(jTextField183, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 120, 20));

        jTextField203.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 10)); // NOI18N
        jTextField203.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField203ActionPerformed(evt);
            }
        });
        jPanel234.add(jTextField203, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, 120, 20));

        jPanel1.add(jPanel234, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 1510, 120, 40));

        jPanel235.setBackground(new java.awt.Color(255, 255, 255));
        jPanel235.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel235.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTextField184.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 10)); // NOI18N
        jTextField184.setForeground(new java.awt.Color(255, 0, 51));
        jTextField184.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField184ActionPerformed(evt);
            }
        });
        jPanel235.add(jTextField184, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 120, 20));

        jTextField204.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 10)); // NOI18N
        jTextField204.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField204ActionPerformed(evt);
            }
        });
        jPanel235.add(jTextField204, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, 120, 20));

        jPanel1.add(jPanel235, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 1550, 120, 40));

        jPanel236.setBackground(new java.awt.Color(255, 255, 255));
        jPanel236.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel236.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTextField187.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 10)); // NOI18N
        jTextField187.setForeground(new java.awt.Color(255, 0, 51));
        jTextField187.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField187ActionPerformed(evt);
            }
        });
        jPanel236.add(jTextField187, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 120, 20));

        jTextField207.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 10)); // NOI18N
        jTextField207.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField207ActionPerformed(evt);
            }
        });
        jPanel236.add(jTextField207, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, 120, 20));

        jPanel1.add(jPanel236, new org.netbeans.lib.awtextra.AbsoluteConstraints(1040, 1430, 120, 40));

        jPanel237.setBackground(new java.awt.Color(255, 255, 255));
        jPanel237.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel237.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTextField180.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 10)); // NOI18N
        jTextField180.setForeground(new java.awt.Color(255, 0, 51));
        jTextField180.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField180ActionPerformed(evt);
            }
        });
        jPanel237.add(jTextField180, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 120, 20));

        jTextField200.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 10)); // NOI18N
        jTextField200.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField200ActionPerformed(evt);
            }
        });
        jPanel237.add(jTextField200, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, 120, 20));

        jPanel1.add(jPanel237, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 1390, 120, 40));

        jPanel238.setBackground(new java.awt.Color(255, 255, 255));
        jPanel238.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel238.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTextField186.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 10)); // NOI18N
        jTextField186.setForeground(new java.awt.Color(255, 0, 51));
        jTextField186.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField186ActionPerformed(evt);
            }
        });
        jPanel238.add(jTextField186, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 120, 20));

        jTextField206.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 10)); // NOI18N
        jTextField206.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField206ActionPerformed(evt);
            }
        });
        jPanel238.add(jTextField206, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, 120, 20));

        jPanel1.add(jPanel238, new org.netbeans.lib.awtextra.AbsoluteConstraints(1040, 1390, 120, 40));

        jPanel239.setBackground(new java.awt.Color(255, 255, 255));
        jPanel239.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel239.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTextField188.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 10)); // NOI18N
        jTextField188.setForeground(new java.awt.Color(255, 0, 51));
        jTextField188.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField188ActionPerformed(evt);
            }
        });
        jPanel239.add(jTextField188, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 120, 20));

        jTextField208.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 10)); // NOI18N
        jTextField208.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField208ActionPerformed(evt);
            }
        });
        jPanel239.add(jTextField208, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, 120, 20));

        jPanel1.add(jPanel239, new org.netbeans.lib.awtextra.AbsoluteConstraints(1040, 1470, 120, 40));

        jPanel240.setBackground(new java.awt.Color(255, 255, 255));
        jPanel240.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel240.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTextField189.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 10)); // NOI18N
        jTextField189.setForeground(new java.awt.Color(255, 0, 51));
        jTextField189.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField189ActionPerformed(evt);
            }
        });
        jPanel240.add(jTextField189, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 120, 20));

        jTextField209.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 10)); // NOI18N
        jTextField209.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField209ActionPerformed(evt);
            }
        });
        jPanel240.add(jTextField209, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, 120, 20));

        jPanel1.add(jPanel240, new org.netbeans.lib.awtextra.AbsoluteConstraints(1040, 1510, 120, 40));

        jPanel241.setBackground(new java.awt.Color(255, 255, 255));
        jPanel241.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel241.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTextField190.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 10)); // NOI18N
        jTextField190.setForeground(new java.awt.Color(255, 0, 51));
        jTextField190.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField190ActionPerformed(evt);
            }
        });
        jPanel241.add(jTextField190, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 120, 20));

        jTextField210.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 10)); // NOI18N
        jTextField210.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField210ActionPerformed(evt);
            }
        });
        jPanel241.add(jTextField210, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, 120, 20));

        jPanel1.add(jPanel241, new org.netbeans.lib.awtextra.AbsoluteConstraints(1040, 1550, 120, 40));

        jPanel61.setBackground(new java.awt.Color(255, 255, 255));
        jPanel61.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel61.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jdiemyeu.setText("hoten");
        jPanel61.add(jdiemyeu, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 830, 20));

        jTextField18.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 10)); // NOI18N
        jTextField18.setForeground(new java.awt.Color(255, 0, 51));
        jPanel61.add(jTextField18, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 840, 20));

        jPanel1.add(jPanel61, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 640, 840, 40));

        jPanel67.setBackground(new java.awt.Color(255, 255, 255));
        jPanel67.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel67.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel1.add(jPanel67, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 640, 840, 40));

        jPanel68.setBackground(new java.awt.Color(255, 255, 255));
        jPanel68.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel68.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jdiachi.setText("hoten");
        jPanel68.add(jdiachi, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 830, 20));

        jTextField3.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 10)); // NOI18N
        jTextField3.setForeground(new java.awt.Color(255, 0, 51));
        jPanel68.add(jTextField3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 840, 20));

        jPanel1.add(jPanel68, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 600, 840, 40));

        jPanel69.setBackground(new java.awt.Color(255, 255, 255));
        jPanel69.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel69.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jdinhat.setText("hoten");
        jPanel69.add(jdinhat, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 830, 20));

        jTextField20.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 10)); // NOI18N
        jTextField20.setForeground(new java.awt.Color(255, 0, 51));
        jPanel69.add(jTextField20, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 840, 20));

        jPanel1.add(jPanel69, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 680, 840, 40));

        jPanel70.setBackground(new java.awt.Color(255, 255, 255));
        jPanel70.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel70.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jsothich.setText("hoten");
        jPanel70.add(jsothich, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 830, 20));

        jTextField110.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 10)); // NOI18N
        jTextField110.setForeground(new java.awt.Color(255, 0, 51));
        jPanel70.add(jTextField110, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 840, 20));

        jPanel1.add(jPanel70, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 720, 840, 40));

        jPanel71.setBackground(new java.awt.Color(255, 255, 255));
        jPanel71.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel71.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jvevn.setText("hoten");
        jPanel71.add(jvevn, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 830, 20));

        jTextField111.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 10)); // NOI18N
        jTextField111.setForeground(new java.awt.Color(255, 0, 51));
        jPanel71.add(jTextField111, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 840, 20));

        jPanel1.add(jPanel71, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 760, 840, 40));

        jPanel72.setBackground(new java.awt.Color(255, 255, 255));
        jPanel72.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel72.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jbietgi.setText("hoten");
        jPanel72.add(jbietgi, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 830, 20));

        jTextField112.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 10)); // NOI18N
        jTextField112.setForeground(new java.awt.Color(255, 0, 51));
        jPanel72.add(jTextField112, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 840, 20));

        jPanel1.add(jPanel72, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 800, 840, 40));

        jSYLL.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1190, 1720));
        jPanel1.getAccessibleContext().setAccessibleName("");

        getContentPane().add(jSYLL, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 1690));

        tuychon.setText("Tùy chọn");
        tuychon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tuychonActionPerformed(evt);
            }
        });

        printRecord.setText("In File ");
        printRecord.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                printRecordActionPerformed(evt);
            }
        });
        tuychon.add(printRecord);

        QL.setText("Quay lại");
        QL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                QLActionPerformed(evt);
            }
        });
        tuychon.add(QL);

        jMenuBar1.add(tuychon);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void printRecordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_printRecordActionPerformed
        // TODO add your handling code here:
        PrintUtil p=new PrintUtil(jPanel1);
        p.print();
    }//GEN-LAST:event_printRecordActionPerformed

    private void QLActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_QLActionPerformed
        danhsach ds = new danhsach();
        ds.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_QLActionPerformed

    private void tuychonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tuychonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tuychonActionPerformed

    private void formMouseWheelMoved(java.awt.event.MouseWheelEvent evt) {//GEN-FIRST:event_formMouseWheelMoved
         int h = jSYLL.getHeight();
        int a = evt.getWheelRotation();
        int x = jSYLL.getX();
        int y = jSYLL.getY();
        int b = 0;
        if(a>0)
        {
            if(y==this.getHeight()-jSYLL.getHeight())
            {
                a=0;
            }else
            {
                b+=50;
                jSYLL.setLocation(x,y-b);
                b=0;
            }
        }
        if(a<0)
        {
            if(y==0)
            {
                a=0;
            }else
            {
                b+=50;
                jSYLL.setLocation(x,y+b);
                b=0;
            }
        }
    }//GEN-LAST:event_formMouseWheelMoved

    private void jTextField23ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField23ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField23ActionPerformed

    private void jTextField19ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField19ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField19ActionPerformed

    private void jTextField22ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField22ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField22ActionPerformed

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField2ActionPerformed

    private void jTextField11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField11ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField11ActionPerformed

    private void jTextField10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField10ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField10ActionPerformed

    private void jTextField9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField9ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField9ActionPerformed

    private void jTextField8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField8ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField8ActionPerformed

    private void jTextField7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField7ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField7ActionPerformed

    private void jTextField6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField6ActionPerformed

    private void jTextField5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField5ActionPerformed

    private void jTextField4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField4ActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jPanel1CaretPositionChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_jPanel1CaretPositionChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel1CaretPositionChanged

    private void jTextField109ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField109ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField109ActionPerformed

    private void jTextField21ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField21ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField21ActionPerformed

    private void jTextField114ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField114ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField114ActionPerformed

    private void jTextField115ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField115ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField115ActionPerformed

    private void jTextField116ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField116ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField116ActionPerformed

    private void jTextField117ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField117ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField117ActionPerformed

    private void jTextField118ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField118ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField118ActionPerformed

    private void jTextField119ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField119ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField119ActionPerformed

    private void jTextField120ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField120ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField120ActionPerformed

    private void jTextField121ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField121ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField121ActionPerformed

    private void jTextField122ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField122ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField122ActionPerformed

    private void jTextField24ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField24ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField24ActionPerformed

    private void jTextField25ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField25ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField25ActionPerformed

    private void jTextField26ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField26ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField26ActionPerformed

    private void jTextField27ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField27ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField27ActionPerformed

    private void jTextField28ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField28ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField28ActionPerformed

    private void jTextField29ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField29ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField29ActionPerformed

    private void jTextField30ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField30ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField30ActionPerformed

    private void jTextField31ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField31ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField31ActionPerformed

    private void jTextField32ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField32ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField32ActionPerformed

    private void jTextField33ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField33ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField33ActionPerformed

    private void jTextField123ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField123ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField123ActionPerformed

    private void jTextField124ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField124ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField124ActionPerformed

    private void jTextField125ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField125ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField125ActionPerformed

    private void jTextField126ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField126ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField126ActionPerformed

    private void jTextField127ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField127ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField127ActionPerformed

    private void jTextField133ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField133ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField133ActionPerformed

    private void jTextField134ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField134ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField134ActionPerformed

    private void jTextField135ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField135ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField135ActionPerformed

    private void jTextField136ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField136ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField136ActionPerformed

    private void jTextField137ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField137ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField137ActionPerformed

    private void jTextField138ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField138ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField138ActionPerformed

    private void jTextField139ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField139ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField139ActionPerformed

    private void jTextField128ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField128ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField128ActionPerformed

    private void jTextField129ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField129ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField129ActionPerformed

    private void jTextField130ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField130ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField130ActionPerformed

    private void jTextField132ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField132ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField132ActionPerformed

    private void jTextField140ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField140ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField140ActionPerformed

    private void jTextField141ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField141ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField141ActionPerformed

    private void jTextField143ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField143ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField143ActionPerformed

    private void jTextField144ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField144ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField144ActionPerformed

    private void jTextField145ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField145ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField145ActionPerformed

    private void jTextField147ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField147ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField147ActionPerformed

    private void jTextField148ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField148ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField148ActionPerformed

    private void jTextField149ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField149ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField149ActionPerformed

    private void jTextField34ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField34ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField34ActionPerformed

    private void jlvhdct2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jlvhdct2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jlvhdct2ActionPerformed

    private void jTextField36ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField36ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField36ActionPerformed

    private void jTextField38ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField38ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField38ActionPerformed

    private void jTextField39ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField39ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField39ActionPerformed

    private void jTextField40ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField40ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField40ActionPerformed

    private void jTextField42ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField42ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField42ActionPerformed

    private void jTextField151ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField151ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField151ActionPerformed

    private void jTextField152ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField152ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField152ActionPerformed

    private void jTextField153ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField153ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField153ActionPerformed

    private void jTextField154ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField154ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField154ActionPerformed

    private void jTextField155ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField155ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField155ActionPerformed

    private void jTextField156ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField156ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField156ActionPerformed

    private void jTextField157ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField157ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField157ActionPerformed

    private void jTextField158ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField158ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField158ActionPerformed

    private void jTextField159ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField159ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField159ActionPerformed

    private void jTextField160ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField160ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField160ActionPerformed

    private void jTextField161ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField161ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField161ActionPerformed

    private void jTextField162ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField162ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField162ActionPerformed

    private void jTextField163ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField163ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField163ActionPerformed

    private void jTextField164ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField164ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField164ActionPerformed

    private void jTextField165ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField165ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField165ActionPerformed

    private void jTextField166ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField166ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField166ActionPerformed

    private void jTextField167ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField167ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField167ActionPerformed

    private void jTextField168ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField168ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField168ActionPerformed

    private void jTextField169ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField169ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField169ActionPerformed

    private void jTextField170ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField170ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField170ActionPerformed

    private void jTextField171ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField171ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField171ActionPerformed

    private void jTextField172ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField172ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField172ActionPerformed

    private void jTextField173ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField173ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField173ActionPerformed

    private void jTextField174ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField174ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField174ActionPerformed

    private void jTextField175ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField175ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField175ActionPerformed

    private void jTextField176ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField176ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField176ActionPerformed

    private void jTextField177ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField177ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField177ActionPerformed

    private void jTextField178ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField178ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField178ActionPerformed

    private void jTextField179ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField179ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField179ActionPerformed

    private void jTextField180ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField180ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField180ActionPerformed

    private void jTextField181ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField181ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField181ActionPerformed

    private void jTextField182ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField182ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField182ActionPerformed

    private void jTextField183ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField183ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField183ActionPerformed

    private void jTextField184ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField184ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField184ActionPerformed

    private void jTextField185ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField185ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField185ActionPerformed

    private void jTextField186ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField186ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField186ActionPerformed

    private void jTextField187ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField187ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField187ActionPerformed

    private void jTextField188ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField188ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField188ActionPerformed

    private void jTextField189ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField189ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField189ActionPerformed

    private void jTextField190ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField190ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField190ActionPerformed

    private void jTextField191ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField191ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField191ActionPerformed

    private void jTextField192ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField192ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField192ActionPerformed

    private void jTextField193ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField193ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField193ActionPerformed

    private void jTextField194ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField194ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField194ActionPerformed

    private void jTextField195ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField195ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField195ActionPerformed

    private void jTextField200ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField200ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField200ActionPerformed

    private void jTextField201ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField201ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField201ActionPerformed

    private void jTextField202ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField202ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField202ActionPerformed

    private void jTextField203ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField203ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField203ActionPerformed

    private void jTextField204ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField204ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField204ActionPerformed

    private void jTextField205ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField205ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField205ActionPerformed

    private void jTextField206ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField206ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField206ActionPerformed

    private void jTextField207ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField207ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField207ActionPerformed

    private void jTextField208ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField208ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField208ActionPerformed

    private void jTextField209ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField209ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField209ActionPerformed

    private void jTextField210ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField210ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField210ActionPerformed

    private void jTextField211ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField211ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField211ActionPerformed

    private void jTextField146ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField146ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField146ActionPerformed

    private void jTextField150ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField150ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField150ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Form_SYLL.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Form_SYLL.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Form_SYLL.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Form_SYLL.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Form_SYLL().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem QL;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JCheckBox jCheckBox10;
    private javax.swing.JCheckBox jCheckBox11;
    private javax.swing.JCheckBox jCheckBox12;
    private javax.swing.JCheckBox jCheckBox2;
    private javax.swing.JCheckBox jCheckBox3;
    private javax.swing.JCheckBox jCheckBox4;
    private javax.swing.JCheckBox jCheckBox5;
    private javax.swing.JCheckBox jCheckBox6;
    private javax.swing.JCheckBox jCheckBox7;
    private javax.swing.JCheckBox jCheckBox8;
    private javax.swing.JCheckBox jCheckBox9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel100;
    private javax.swing.JLabel jLabel101;
    private javax.swing.JLabel jLabel102;
    private javax.swing.JLabel jLabel103;
    private javax.swing.JLabel jLabel104;
    private javax.swing.JLabel jLabel105;
    private javax.swing.JLabel jLabel106;
    private javax.swing.JLabel jLabel107;
    private javax.swing.JLabel jLabel108;
    private javax.swing.JLabel jLabel109;
    private javax.swing.JLabel jLabel110;
    private javax.swing.JLabel jLabel111;
    private javax.swing.JLabel jLabel112;
    private javax.swing.JLabel jLabel113;
    private javax.swing.JLabel jLabel114;
    private javax.swing.JLabel jLabel115;
    private javax.swing.JLabel jLabel116;
    private javax.swing.JLabel jLabel117;
    private javax.swing.JLabel jLabel118;
    private javax.swing.JLabel jLabel119;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel120;
    private javax.swing.JLabel jLabel121;
    private javax.swing.JLabel jLabel122;
    private javax.swing.JLabel jLabel123;
    private javax.swing.JLabel jLabel124;
    private javax.swing.JLabel jLabel125;
    private javax.swing.JLabel jLabel126;
    private javax.swing.JLabel jLabel127;
    private javax.swing.JLabel jLabel128;
    private javax.swing.JLabel jLabel129;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel130;
    private javax.swing.JLabel jLabel131;
    private javax.swing.JLabel jLabel132;
    private javax.swing.JLabel jLabel133;
    private javax.swing.JLabel jLabel134;
    private javax.swing.JLabel jLabel135;
    private javax.swing.JLabel jLabel136;
    private javax.swing.JLabel jLabel137;
    private javax.swing.JLabel jLabel138;
    private javax.swing.JLabel jLabel139;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel140;
    private javax.swing.JLabel jLabel141;
    private javax.swing.JLabel jLabel142;
    private javax.swing.JLabel jLabel143;
    private javax.swing.JLabel jLabel144;
    private javax.swing.JLabel jLabel145;
    private javax.swing.JLabel jLabel146;
    private javax.swing.JLabel jLabel147;
    private javax.swing.JLabel jLabel148;
    private javax.swing.JLabel jLabel149;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel150;
    private javax.swing.JLabel jLabel151;
    private javax.swing.JLabel jLabel152;
    private javax.swing.JLabel jLabel153;
    private javax.swing.JLabel jLabel154;
    private javax.swing.JLabel jLabel155;
    private javax.swing.JLabel jLabel156;
    private javax.swing.JLabel jLabel157;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel166;
    private javax.swing.JLabel jLabel167;
    private javax.swing.JLabel jLabel168;
    private javax.swing.JLabel jLabel169;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel170;
    private javax.swing.JLabel jLabel171;
    private javax.swing.JLabel jLabel172;
    private javax.swing.JLabel jLabel173;
    private javax.swing.JLabel jLabel174;
    private javax.swing.JLabel jLabel175;
    private javax.swing.JLabel jLabel176;
    private javax.swing.JLabel jLabel177;
    private javax.swing.JLabel jLabel178;
    private javax.swing.JLabel jLabel179;
    private javax.swing.JLabel jLabel180;
    private javax.swing.JLabel jLabel181;
    private javax.swing.JLabel jLabel182;
    private javax.swing.JLabel jLabel183;
    private javax.swing.JLabel jLabel184;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabel57;
    private javax.swing.JLabel jLabel58;
    private javax.swing.JLabel jLabel59;
    private javax.swing.JLabel jLabel67;
    private javax.swing.JLabel jLabel68;
    private javax.swing.JLabel jLabel69;
    private javax.swing.JLabel jLabel70;
    private javax.swing.JLabel jLabel71;
    private javax.swing.JLabel jLabel72;
    private javax.swing.JLabel jLabel73;
    private javax.swing.JLabel jLabel74;
    private javax.swing.JLabel jLabel75;
    private javax.swing.JLabel jLabel76;
    private javax.swing.JLabel jLabel77;
    private javax.swing.JLabel jLabel78;
    private javax.swing.JLabel jLabel79;
    private javax.swing.JLabel jLabel80;
    private javax.swing.JLabel jLabel81;
    private javax.swing.JLabel jLabel82;
    private javax.swing.JLabel jLabel83;
    private javax.swing.JLabel jLabel84;
    private javax.swing.JLabel jLabel85;
    private javax.swing.JLabel jLabel86;
    private javax.swing.JLabel jLabel87;
    private javax.swing.JLabel jLabel88;
    private javax.swing.JLabel jLabel89;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabel90;
    private javax.swing.JLabel jLabel91;
    private javax.swing.JLabel jLabel92;
    private javax.swing.JLabel jLabel93;
    private javax.swing.JLabel jLabel94;
    private javax.swing.JLabel jLabel95;
    private javax.swing.JLabel jLabel96;
    private javax.swing.JLabel jLabel97;
    private javax.swing.JLabel jLabel98;
    private javax.swing.JLabel jLabel99;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel100;
    private javax.swing.JPanel jPanel101;
    private javax.swing.JPanel jPanel102;
    private javax.swing.JPanel jPanel103;
    private javax.swing.JPanel jPanel104;
    private javax.swing.JPanel jPanel105;
    private javax.swing.JPanel jPanel106;
    private javax.swing.JPanel jPanel107;
    private javax.swing.JPanel jPanel108;
    private javax.swing.JPanel jPanel109;
    private javax.swing.JPanel jPanel110;
    private javax.swing.JPanel jPanel111;
    private javax.swing.JPanel jPanel112;
    private javax.swing.JPanel jPanel113;
    private javax.swing.JPanel jPanel114;
    private javax.swing.JPanel jPanel115;
    private javax.swing.JPanel jPanel116;
    private javax.swing.JPanel jPanel117;
    private javax.swing.JPanel jPanel119;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel120;
    private javax.swing.JPanel jPanel121;
    private javax.swing.JPanel jPanel122;
    private javax.swing.JPanel jPanel123;
    private javax.swing.JPanel jPanel124;
    private javax.swing.JPanel jPanel125;
    private javax.swing.JPanel jPanel126;
    private javax.swing.JPanel jPanel127;
    private javax.swing.JPanel jPanel128;
    private javax.swing.JPanel jPanel129;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel130;
    private javax.swing.JPanel jPanel131;
    private javax.swing.JPanel jPanel132;
    private javax.swing.JPanel jPanel133;
    private javax.swing.JPanel jPanel134;
    private javax.swing.JPanel jPanel135;
    private javax.swing.JPanel jPanel136;
    private javax.swing.JPanel jPanel137;
    private javax.swing.JPanel jPanel138;
    private javax.swing.JPanel jPanel139;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel140;
    private javax.swing.JPanel jPanel141;
    private javax.swing.JPanel jPanel142;
    private javax.swing.JPanel jPanel143;
    private javax.swing.JPanel jPanel144;
    private javax.swing.JPanel jPanel145;
    private javax.swing.JPanel jPanel146;
    private javax.swing.JPanel jPanel147;
    private javax.swing.JPanel jPanel148;
    private javax.swing.JPanel jPanel149;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel150;
    private javax.swing.JPanel jPanel151;
    private javax.swing.JPanel jPanel154;
    private javax.swing.JPanel jPanel155;
    private javax.swing.JPanel jPanel157;
    private javax.swing.JPanel jPanel158;
    private javax.swing.JPanel jPanel159;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel161;
    private javax.swing.JPanel jPanel162;
    private javax.swing.JPanel jPanel163;
    private javax.swing.JPanel jPanel164;
    private javax.swing.JPanel jPanel166;
    private javax.swing.JPanel jPanel167;
    private javax.swing.JPanel jPanel168;
    private javax.swing.JPanel jPanel169;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel170;
    private javax.swing.JPanel jPanel171;
    private javax.swing.JPanel jPanel172;
    private javax.swing.JPanel jPanel174;
    private javax.swing.JPanel jPanel175;
    private javax.swing.JPanel jPanel176;
    private javax.swing.JPanel jPanel177;
    private javax.swing.JPanel jPanel179;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel180;
    private javax.swing.JPanel jPanel181;
    private javax.swing.JPanel jPanel182;
    private javax.swing.JPanel jPanel184;
    private javax.swing.JPanel jPanel186;
    private javax.swing.JPanel jPanel187;
    private javax.swing.JPanel jPanel188;
    private javax.swing.JPanel jPanel189;
    private javax.swing.JPanel jPanel190;
    private javax.swing.JPanel jPanel191;
    private javax.swing.JPanel jPanel192;
    private javax.swing.JPanel jPanel193;
    private javax.swing.JPanel jPanel194;
    private javax.swing.JPanel jPanel195;
    private javax.swing.JPanel jPanel196;
    private javax.swing.JPanel jPanel197;
    private javax.swing.JPanel jPanel198;
    private javax.swing.JPanel jPanel199;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel200;
    private javax.swing.JPanel jPanel201;
    private javax.swing.JPanel jPanel202;
    private javax.swing.JPanel jPanel203;
    private javax.swing.JPanel jPanel204;
    private javax.swing.JPanel jPanel205;
    private javax.swing.JPanel jPanel206;
    private javax.swing.JPanel jPanel207;
    private javax.swing.JPanel jPanel208;
    private javax.swing.JPanel jPanel209;
    private javax.swing.JPanel jPanel210;
    private javax.swing.JPanel jPanel211;
    private javax.swing.JPanel jPanel212;
    private javax.swing.JPanel jPanel213;
    private javax.swing.JPanel jPanel214;
    private javax.swing.JPanel jPanel215;
    private javax.swing.JPanel jPanel216;
    private javax.swing.JPanel jPanel217;
    private javax.swing.JPanel jPanel218;
    private javax.swing.JPanel jPanel219;
    private javax.swing.JPanel jPanel220;
    private javax.swing.JPanel jPanel221;
    private javax.swing.JPanel jPanel222;
    private javax.swing.JPanel jPanel223;
    private javax.swing.JPanel jPanel224;
    private javax.swing.JPanel jPanel225;
    private javax.swing.JPanel jPanel226;
    private javax.swing.JPanel jPanel227;
    private javax.swing.JPanel jPanel228;
    private javax.swing.JPanel jPanel229;
    private javax.swing.JPanel jPanel230;
    private javax.swing.JPanel jPanel231;
    private javax.swing.JPanel jPanel232;
    private javax.swing.JPanel jPanel233;
    private javax.swing.JPanel jPanel234;
    private javax.swing.JPanel jPanel235;
    private javax.swing.JPanel jPanel236;
    private javax.swing.JPanel jPanel237;
    private javax.swing.JPanel jPanel238;
    private javax.swing.JPanel jPanel239;
    private javax.swing.JPanel jPanel240;
    private javax.swing.JPanel jPanel241;
    private javax.swing.JPanel jPanel242;
    private javax.swing.JPanel jPanel260;
    private javax.swing.JPanel jPanel261;
    private javax.swing.JPanel jPanel262;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel30;
    private javax.swing.JPanel jPanel31;
    private javax.swing.JPanel jPanel32;
    private javax.swing.JPanel jPanel33;
    private javax.swing.JPanel jPanel34;
    private javax.swing.JPanel jPanel35;
    private javax.swing.JPanel jPanel36;
    private javax.swing.JPanel jPanel37;
    private javax.swing.JPanel jPanel38;
    private javax.swing.JPanel jPanel39;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel40;
    private javax.swing.JPanel jPanel41;
    private javax.swing.JPanel jPanel42;
    private javax.swing.JPanel jPanel43;
    private javax.swing.JPanel jPanel44;
    private javax.swing.JPanel jPanel45;
    private javax.swing.JPanel jPanel46;
    private javax.swing.JPanel jPanel47;
    private javax.swing.JPanel jPanel48;
    private javax.swing.JPanel jPanel49;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel50;
    private javax.swing.JPanel jPanel51;
    private javax.swing.JPanel jPanel52;
    private javax.swing.JPanel jPanel53;
    private javax.swing.JPanel jPanel54;
    private javax.swing.JPanel jPanel55;
    private javax.swing.JPanel jPanel56;
    private javax.swing.JPanel jPanel57;
    private javax.swing.JPanel jPanel58;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel60;
    private javax.swing.JPanel jPanel61;
    private javax.swing.JPanel jPanel62;
    private javax.swing.JPanel jPanel63;
    private javax.swing.JPanel jPanel67;
    private javax.swing.JPanel jPanel68;
    private javax.swing.JPanel jPanel69;
    private javax.swing.JPanel jPanel70;
    private javax.swing.JPanel jPanel71;
    private javax.swing.JPanel jPanel72;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel80;
    private javax.swing.JPanel jPanel81;
    private javax.swing.JPanel jPanel82;
    private javax.swing.JPanel jPanel83;
    private javax.swing.JPanel jPanel84;
    private javax.swing.JPanel jPanel85;
    private javax.swing.JPanel jPanel86;
    private javax.swing.JPanel jPanel87;
    private javax.swing.JPanel jPanel88;
    private javax.swing.JPanel jPanel89;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JPanel jPanel90;
    private javax.swing.JPanel jPanel91;
    private javax.swing.JPanel jPanel92;
    private javax.swing.JPanel jPanel93;
    private javax.swing.JPanel jPanel94;
    private javax.swing.JPanel jPanel95;
    private javax.swing.JPanel jPanel96;
    private javax.swing.JPanel jPanel97;
    private javax.swing.JPanel jPanel98;
    private javax.swing.JPanel jPanel99;
    private javax.swing.JPanel jSYLL;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField10;
    private javax.swing.JTextField jTextField109;
    private javax.swing.JTextField jTextField11;
    private javax.swing.JTextField jTextField110;
    private javax.swing.JTextField jTextField111;
    private javax.swing.JTextField jTextField112;
    private javax.swing.JTextField jTextField113;
    private javax.swing.JTextField jTextField114;
    private javax.swing.JTextField jTextField115;
    private javax.swing.JTextField jTextField116;
    private javax.swing.JTextField jTextField117;
    private javax.swing.JTextField jTextField118;
    private javax.swing.JTextField jTextField119;
    private javax.swing.JTextField jTextField120;
    private javax.swing.JTextField jTextField121;
    private javax.swing.JTextField jTextField122;
    private javax.swing.JTextField jTextField123;
    private javax.swing.JTextField jTextField124;
    private javax.swing.JTextField jTextField125;
    private javax.swing.JTextField jTextField126;
    private javax.swing.JTextField jTextField127;
    private javax.swing.JTextField jTextField128;
    private javax.swing.JTextField jTextField129;
    private javax.swing.JTextField jTextField130;
    private javax.swing.JTextField jTextField132;
    private javax.swing.JTextField jTextField133;
    private javax.swing.JTextField jTextField134;
    private javax.swing.JTextField jTextField135;
    private javax.swing.JTextField jTextField136;
    private javax.swing.JTextField jTextField137;
    private javax.swing.JTextField jTextField138;
    private javax.swing.JTextField jTextField139;
    private javax.swing.JTextField jTextField140;
    private javax.swing.JTextField jTextField141;
    private javax.swing.JTextField jTextField143;
    private javax.swing.JTextField jTextField144;
    private javax.swing.JTextField jTextField145;
    private javax.swing.JTextField jTextField146;
    private javax.swing.JTextField jTextField147;
    private javax.swing.JTextField jTextField148;
    private javax.swing.JTextField jTextField149;
    private javax.swing.JTextField jTextField150;
    private javax.swing.JTextField jTextField151;
    private javax.swing.JTextField jTextField152;
    private javax.swing.JTextField jTextField153;
    private javax.swing.JTextField jTextField154;
    private javax.swing.JTextField jTextField155;
    private javax.swing.JTextField jTextField156;
    private javax.swing.JTextField jTextField157;
    private javax.swing.JTextField jTextField158;
    private javax.swing.JTextField jTextField159;
    private javax.swing.JTextField jTextField160;
    private javax.swing.JTextField jTextField161;
    private javax.swing.JTextField jTextField162;
    private javax.swing.JTextField jTextField163;
    private javax.swing.JTextField jTextField164;
    private javax.swing.JTextField jTextField165;
    private javax.swing.JTextField jTextField166;
    private javax.swing.JTextField jTextField167;
    private javax.swing.JTextField jTextField168;
    private javax.swing.JTextField jTextField169;
    private javax.swing.JTextField jTextField170;
    private javax.swing.JTextField jTextField171;
    private javax.swing.JTextField jTextField172;
    private javax.swing.JTextField jTextField173;
    private javax.swing.JTextField jTextField174;
    private javax.swing.JTextField jTextField175;
    private javax.swing.JTextField jTextField176;
    private javax.swing.JTextField jTextField177;
    private javax.swing.JTextField jTextField178;
    private javax.swing.JTextField jTextField179;
    private javax.swing.JTextField jTextField18;
    private javax.swing.JTextField jTextField180;
    private javax.swing.JTextField jTextField181;
    private javax.swing.JTextField jTextField182;
    private javax.swing.JTextField jTextField183;
    private javax.swing.JTextField jTextField184;
    private javax.swing.JTextField jTextField185;
    private javax.swing.JTextField jTextField186;
    private javax.swing.JTextField jTextField187;
    private javax.swing.JTextField jTextField188;
    private javax.swing.JTextField jTextField189;
    private javax.swing.JTextField jTextField19;
    private javax.swing.JTextField jTextField190;
    private javax.swing.JTextField jTextField191;
    private javax.swing.JTextField jTextField192;
    private javax.swing.JTextField jTextField193;
    private javax.swing.JTextField jTextField194;
    private javax.swing.JTextField jTextField195;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField20;
    private javax.swing.JTextField jTextField200;
    private javax.swing.JTextField jTextField201;
    private javax.swing.JTextField jTextField202;
    private javax.swing.JTextField jTextField203;
    private javax.swing.JTextField jTextField204;
    private javax.swing.JTextField jTextField205;
    private javax.swing.JTextField jTextField206;
    private javax.swing.JTextField jTextField207;
    private javax.swing.JTextField jTextField208;
    private javax.swing.JTextField jTextField209;
    private javax.swing.JTextField jTextField21;
    private javax.swing.JTextField jTextField210;
    private javax.swing.JTextField jTextField211;
    private javax.swing.JTextField jTextField22;
    private javax.swing.JTextField jTextField23;
    private javax.swing.JTextField jTextField24;
    private javax.swing.JTextField jTextField25;
    private javax.swing.JTextField jTextField26;
    private javax.swing.JTextField jTextField27;
    private javax.swing.JTextField jTextField28;
    private javax.swing.JTextField jTextField29;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField30;
    private javax.swing.JTextField jTextField31;
    private javax.swing.JTextField jTextField32;
    private javax.swing.JTextField jTextField33;
    private javax.swing.JTextField jTextField34;
    private javax.swing.JTextField jTextField36;
    private javax.swing.JTextField jTextField38;
    private javax.swing.JTextField jTextField39;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField40;
    private javax.swing.JTextField jTextField42;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JTextField jTextField8;
    private javax.swing.JTextField jTextField9;
    private javax.swing.JLabel jbietgi;
    private javax.swing.JLabel jcannang;
    private javax.swing.JLabel jchieucao;
    private javax.swing.JLabel jchuatn1;
    private javax.swing.JLabel jchuatn2;
    private javax.swing.JLabel jchuatn3;
    private javax.swing.JLabel jchuatn4;
    private javax.swing.JLabel jchuatn5;
    private javax.swing.JLabel jchuatn6;
    private javax.swing.JLabel jctdl1;
    private javax.swing.JLabel jctdl2;
    private javax.swing.JLabel jctdl3;
    private javax.swing.JLabel jdatn1;
    private javax.swing.JLabel jdatn2;
    private javax.swing.JLabel jdatn3;
    private javax.swing.JLabel jdatn4;
    private javax.swing.JLabel jdatn5;
    private javax.swing.JLabel jdatn6;
    private javax.swing.JLabel jdeokinh;
    private javax.swing.JLabel jdiachi;
    private javax.swing.JLabel jdiemyeu;
    private javax.swing.JLabel jdinhat;
    private javax.swing.JLabel jgiadinh;
    private javax.swing.JLabel jgioitinh;
    private javax.swing.JLabel jgioitinh1;
    private javax.swing.JLabel jhonnhan;
    private javax.swing.JLabel jhoten;
    private javax.swing.JLabel jketthucht1;
    private javax.swing.JLabel jketthucht2;
    private javax.swing.JLabel jketthucht3;
    private javax.swing.JLabel jketthucht4;
    private javax.swing.JLabel jketthucht5;
    private javax.swing.JLabel jketthucht6;
    private javax.swing.JLabel jktht1;
    private javax.swing.JLabel jktht2;
    private javax.swing.JLabel jktht3;
    private javax.swing.JLabel jktht4;
    private javax.swing.JLabel jktht5;
    private javax.swing.JLabel jktht6;
    private javax.swing.JLabel jktlv1;
    private javax.swing.JLabel jktlv2;
    private javax.swing.JLabel jktlv3;
    private javax.swing.JTextField jlvhdct2;
    private javax.swing.JLabel jmatphai;
    private javax.swing.JLabel jmattrai;
    private javax.swing.JLabel jmumau;
    private javax.swing.JLabel jngaysinh;
    private javax.swing.JLabel jngayvao1;
    private javax.swing.JLabel jngayvao2;
    private javax.swing.JLabel jngayvao3;
    private javax.swing.JLabel jnghegd1;
    private javax.swing.JLabel jnghegd2;
    private javax.swing.JLabel jnghegd3;
    private javax.swing.JLabel jnghegd4;
    private javax.swing.JLabel jnghegd5;
    private javax.swing.JLabel jnghegd6;
    private javax.swing.JLabel jnhaphoc1;
    private javax.swing.JLabel jnhaphoc2;
    private javax.swing.JLabel jnhaphoc3;
    private javax.swing.JLabel jnhaphoc4;
    private javax.swing.JLabel jnhaphoc5;
    private javax.swing.JLabel jnhaphoc6;
    private javax.swing.JLabel jnhommau;
    private javax.swing.JLabel jquanhe1;
    private javax.swing.JLabel jquanhe2;
    private javax.swing.JLabel jquanhe3;
    private javax.swing.JLabel jquanhe4;
    private javax.swing.JLabel jquanhe5;
    private javax.swing.JLabel jquanhe6;
    private javax.swing.JLabel jsothich;
    private javax.swing.JLabel jtenct1;
    private javax.swing.JLabel jtenct2;
    private javax.swing.JLabel jtenct3;
    private javax.swing.JLabel jtengd1;
    private javax.swing.JLabel jtengd2;
    private javax.swing.JLabel jtengd3;
    private javax.swing.JLabel jtengd4;
    private javax.swing.JLabel jtengd5;
    private javax.swing.JLabel jtengd6;
    private javax.swing.JLabel jtentruong1;
    private javax.swing.JLabel jtentruong2;
    private javax.swing.JLabel jtentruong3;
    private javax.swing.JLabel jtentruong4;
    private javax.swing.JLabel jtentruong5;
    private javax.swing.JLabel jtentruong6;
    private javax.swing.JLabel jttskgd1;
    private javax.swing.JLabel jttskgd2;
    private javax.swing.JLabel jttskgd3;
    private javax.swing.JLabel jttskgd4;
    private javax.swing.JLabel jttskgd5;
    private javax.swing.JLabel jttskgd6;
    private javax.swing.JLabel jtuoi;
    private javax.swing.JLabel jtuoigd1;
    private javax.swing.JLabel jtuoigd2;
    private javax.swing.JLabel jtuoigd3;
    private javax.swing.JLabel jtuoigd4;
    private javax.swing.JLabel jtuoigd5;
    private javax.swing.JLabel jtuoigd6;
    private javax.swing.JLabel jvevn;
    private javax.swing.JMenuItem printRecord;
    private javax.swing.JMenu tuychon;
    // End of variables declaration//GEN-END:variables
}
