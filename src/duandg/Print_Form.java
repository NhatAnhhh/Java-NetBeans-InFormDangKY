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
import Service.UserService;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.PrintJob;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
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
public class Print_Form extends javax.swing.JFrame {
    UserService userService;
    /**
     * Creates new form Print_Form
     */
    private String getcmnd;
    CongViecUser cv;
    DacTinhCaNhanUser dt;
    GiaDinhUser gd;
    HocVanUser hv;
    ThongTinCaNhanDAO ttcn;
    ThongTinKhacUser ttk;
    TinhTrangSucKhoeUser sk;
    private Iterable<HocVan> hocvans;
    public Print_Form(String cmnd){
        initComponents();
        jhocvan.getTableHeader().setFont(new Font("Segoe UI",Font.BOLD, 20));
        tblGiaDinh.getTableHeader().setFont(new Font("Segoe UI",Font.BOLD, 20));
        tblCongViec.getTableHeader().setFont(new Font("Segoe UI",Font.BOLD, 20));
        this.getcmnd=cmnd;
        getdl();
        
    }
    
//    Print_Form jtRowData = new Print_Form();
    
    public Print_Form() {
        initComponents();
        
        jhocvan.getTableHeader().setFont(new Font("Segoe UI",Font.BOLD, 20));
        
        tblGiaDinh.getTableHeader().setFont(new Font("Segoe UI",Font.BOLD, 20));
        tblCongViec.getTableHeader().setFont(new Font("Segoe UI",Font.BOLD, 20));
        
    }
    private void hocvan(List<HocVan> l){
        
        DefaultTableModel defaultTableModel = new DefaultTableModel();
        jhocvan.setModel(defaultTableModel); 
        defaultTableModel.addColumn("Năm nhập học");
        defaultTableModel.addColumn("Năm tốt nghiệp");
        defaultTableModel.addColumn("Tên Trường");
        defaultTableModel.addColumn("Địa chỉ");
        defaultTableModel.addColumn("Tình trạng đã TN/Chưa TN");
        for(HocVan hv:l){
             defaultTableModel.addRow(new Object[]{hv.getBatdautu(),hv.getKetthuc(),hv.getTentruong(),hv.getDiachi(),hv.getTotnghiep()});
        }
    }
    private void giadinh(List<GiaDinh> l){
        DefaultTableModel defaultTableModel = new DefaultTableModel();
        tblGiaDinh.setModel(defaultTableModel); 
        defaultTableModel.addColumn("Họ tên");
        defaultTableModel.addColumn("Quan hệ");
        defaultTableModel.addColumn("Tuổi");
        defaultTableModel.addColumn("Nghề nghiệp");
        defaultTableModel.addColumn("Tình trạng sức khỏe");
        for(GiaDinh hv:l){
             defaultTableModel.addRow(new Object[]{hv.getHoten(),hv.getQuanhe(),hv.getTuoi(),hv.getNghenghiep(),hv.getSuckhoe()});
        }
    }
    private void congviec(List<CongViec> l){
        DefaultTableModel defaultTableModel = new DefaultTableModel();
        tblCongViec.setModel(defaultTableModel); 
        defaultTableModel.addColumn("Từ tháng/năm");
        defaultTableModel.addColumn("Đến tháng/năm");
        defaultTableModel.addColumn("Tên Công Ty");
        defaultTableModel.addColumn("Địa Chỉ");
        defaultTableModel.addColumn("Công Việc");
        defaultTableModel.addColumn("Lương");
        for(CongViec hv:l){
             defaultTableModel.addRow(new Object[]{hv.getBatdau(),hv.getKetthuc(),hv.getTencongty(),hv.getDiachi(),hv.getCongviec(),hv.getLuong()});
        }
    }
    private void getdl(){
        cv= new CongViecUser();
        dt=new DacTinhCaNhanUser();
        gd=new GiaDinhUser();
        hv=new HocVanUser();
        ttcn=new ThongTinCaNhanDAO();
        ttk=new ThongTinKhacUser();
        sk=new TinhTrangSucKhoeUser();
        
        List<CongViec> listcv= cv.getAllUsers(getcmnd);
        DacTinhCaNhan dtcn= dt.getAllUsers(getcmnd);
        List<GiaDinh> listgd=gd.getAllUsers(getcmnd);
        List<HocVan> listhv= hv.getAllUsers(getcmnd);
        ThongTinCaNhan thongtin= ttcn.getUsers(getcmnd);
        ThongTinKhac ttkhac= ttk.getAllUsers(getcmnd);
        TinhTrangSucKhoe suckhoe= sk.getAllUsers(getcmnd);
        
//        DefaultTableModel defaultTableModel = new DefaultTableModel();
//        jhocvan.setModel(defaultTableModel); 
//        for ( HocVan hocvan : hocvans ){
//            defaultTableModel.addRow(new Object[]{hocvan.getBatdautu(),hocvan.getKetthuc(),hocvan.getTentruong(),hocvan.getDiachi(),hocvan.getTotnghiep()});    
//        }
        hocvan(listhv);
        giadinh(listgd);
        congviec(listcv);
        jhoten.setText(thongtin.getHoten());
        jhoten1.setText(thongtin.getHoten());
        jgioitinh.setText(thongtin.getGioitinh());
        jgioitinh1.setText(thongtin.getGioitinh());
        jtongiao.setText(thongtin.getTongiao());
        jngaysinh.setText(thongtin.getNgaysinh());
        jngaysinh1.setText(thongtin.getNgaysinh());
        jtuoi.setText(String.valueOf(thongtin.getTuoi()));
        jnoisinh.setText(thongtin.getNoisinh());
        jnguyenquan.setText(thongtin.getNguyenquan());
        jdantoc.setText(thongtin.getDantoc());
        jhonnhan.setText(thongtin.getHonnhan());
        jcmnd.setText(thongtin.getCmnd());
        jcmnd1.setText(thongtin.getCmnd());
        jngaycapcc.setText(thongtin.getNgaycapcc());
        jnoicapcc.setText(thongtin.getNoicapcc());
        jpassport.setText(thongtin.getPassport());
        jngaycappp.setText(thongtin.getNgaycappp());
        jnoicappp.setText(thongtin.getNoicappp());
        jhokhau.setText(thongtin.getHokhau());
        
        //jdiachi1.setText(thongtin.getHokhau());
        jsdt.setText(thongtin.getSdt());
        jsdt2.setText(thongtin.getSdt());
        jdiachill.setText(thongtin.getDiachill());
        jsdtll.setText(thongtin.getSdtll());
        jhotenll.setText(thongtin.getHotenll());
        jmqh.setText(thongtin.getMqh());
        jchieucao.setText(suckhoe.getChieucao());
        jcannang.setText(suckhoe.getCannang());
        jnhommau.setText(suckhoe.getNhommau());
        jtaythuan.setText(suckhoe.getTaythuan());
        jmattrai.setText(suckhoe.getMattrai());
        jmatphai.setText(suckhoe.getMatphai());
        jdeokinh.setText(suckhoe.getDeokinh());
        jmumau.setText(suckhoe.getMumau());
        jdiung.setText(suckhoe.getDiung());
        jhutthuoc.setText(suckhoe.getHutthuoc());
        jhinhxam.setText(suckhoe.getHinhxam());
        jphauthuat.setText(suckhoe.getPhauthuat());
        jluctt.setText(suckhoe.getTaytrai());
        jluctp.setText(suckhoe.getTayphai());
//        jmucdichdinhat.setText(dtcn.getMucdich());
        jdiemmanh.setText(dtcn.getDiemmanh());
        String[] t=dtcn.getMucdich().split(",");
        String k="";
        for(String a:t){
            k+=a+"\n";
        }
        jmucdichdinhat.setText(k);
        jdiemyeu.setText(dtcn.getDiemyeu());
        jsothich.setText(dtcn.getSothich());
        jskve.setText(dtcn.getVenuoclamgi());
        jbgvnnhat.setText(dtcn.getVenuocnhat());
        jtien3nam.setText(dtcn.getSotien3nam());
        jtienveque.setText(dtcn.getGuiveque());
        jnguoithan.setText(ttkhac.getNguoithan());
        jdennhat.setText(ttkhac.getDennhat());
        jdinhat.setText(ttkhac.getDinhatgd());
        jlolang.setText(ttkhac.getLolang());
        jacedinhat.setText(ttkhac.getConguoiquendk());
        jbietdg.setText(ttkhac.getBietdgquadau());
        
        jrohoten.setText(ttkhac.getHotennguoiquen());
        
        jnganh.setText(ttkhac.getNganh());
        
        
         
       
        
        
        
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel7 = new javax.swing.JLabel();
        jPanel1_a = new javax.swing.JPanel();
        page1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jdiachi1 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jhoten1 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jgioitinh1 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jngaysinh1 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jcmnd1 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jngaysinh = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jtuoi = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jnoisinh = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jnguyenquan = new javax.swing.JLabel();
        jdantoc = new javax.swing.JLabel();
        jhonnhan = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jcmnd = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jngaycapcc = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jnoicapcc = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jpassport = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jngaycappp = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jnoicappp = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jhokhau = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        jsdt = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        jdiachill = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        jsdtll = new javax.swing.JLabel();
        jLabel42 = new javax.swing.JLabel();
        jhotenll = new javax.swing.JLabel();
        jLabel44 = new javax.swing.JLabel();
        jLabel77 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jmqh = new javax.swing.JLabel();
        jhoten = new javax.swing.JLabel();
        jLabel46 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jgioitinh = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jtongiao = new javax.swing.JLabel();
        jLabel47 = new javax.swing.JLabel();
        jchieucao = new javax.swing.JLabel();
        jLabel49 = new javax.swing.JLabel();
        jLabel50 = new javax.swing.JLabel();
        jcannang = new javax.swing.JLabel();
        jLabel52 = new javax.swing.JLabel();
        jLabel53 = new javax.swing.JLabel();
        jnhommau = new javax.swing.JLabel();
        jtaythuan = new javax.swing.JLabel();
        jLabel57 = new javax.swing.JLabel();
        jmattrai = new javax.swing.JLabel();
        jLabel59 = new javax.swing.JLabel();
        jmatphai = new javax.swing.JLabel();
        jLabel61 = new javax.swing.JLabel();
        jdeokinh = new javax.swing.JLabel();
        jmumau = new javax.swing.JLabel();
        jLabel65 = new javax.swing.JLabel();
        jdiung = new javax.swing.JLabel();
        jLabel67 = new javax.swing.JLabel();
        jhutthuoc = new javax.swing.JLabel();
        jLabel69 = new javax.swing.JLabel();
        jhinhxam = new javax.swing.JLabel();
        jphauthuat = new javax.swing.JLabel();
        jLabel73 = new javax.swing.JLabel();
        jluctt = new javax.swing.JLabel();
        jLabel75 = new javax.swing.JLabel();
        jluctp = new javax.swing.JLabel();
        jskve = new javax.swing.JLabel();
        jLabel182 = new javax.swing.JLabel();
        jbgvnnhat = new javax.swing.JLabel();
        jLabel184 = new javax.swing.JLabel();
        jtien3nam = new javax.swing.JLabel();
        jLabel186 = new javax.swing.JLabel();
        jLabel78 = new javax.swing.JLabel();
        jLabel95 = new javax.swing.JLabel();
        jmucdichdinhat = new javax.swing.JLabel();
        jLabel174 = new javax.swing.JLabel();
        jdiemmanh = new javax.swing.JLabel();
        jLabel176 = new javax.swing.JLabel();
        jdiemyeu = new javax.swing.JLabel();
        jLabel178 = new javax.swing.JLabel();
        jsothich = new javax.swing.JLabel();
        jLabel180 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel45 = new javax.swing.JLabel();
        jLabel93 = new javax.swing.JLabel();
        jtienveque = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jsdt2 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jLabel54 = new javax.swing.JLabel();
        jLabel56 = new javax.swing.JLabel();
        jLabel58 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        page2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane15 = new javax.swing.JScrollPane();
        jhocvan = new javax.swing.JTable();
        jLabel192 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblCongViec = new javax.swing.JTable();
        jLabel193 = new javax.swing.JLabel();
        jScrollPane16 = new javax.swing.JScrollPane();
        tblGiaDinh = new javax.swing.JTable();
        jLabel35 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel51 = new javax.swing.JLabel();
        page3 = new javax.swing.JPanel();
        jLabel194 = new javax.swing.JLabel();
        jLabel196 = new javax.swing.JLabel();
        jlolang = new javax.swing.JLabel();
        jLabel199 = new javax.swing.JLabel();
        jLabel200 = new javax.swing.JLabel();
        jbietdg = new javax.swing.JLabel();
        jacedinhat = new javax.swing.JLabel();
        jLabel204 = new javax.swing.JLabel();
        jrohoten = new javax.swing.JLabel();
        jkhac = new javax.swing.JLabel();
        jLabel208 = new javax.swing.JLabel();
        jLabel212 = new javax.swing.JLabel();
        jnganh = new javax.swing.JLabel();
        jLabel214 = new javax.swing.JLabel();
        jLabel215 = new javax.swing.JLabel();
        jLabel216 = new javax.swing.JLabel();
        jLabel217 = new javax.swing.JLabel();
        jLabel218 = new javax.swing.JLabel();
        jLabel219 = new javax.swing.JLabel();
        jLabel220 = new javax.swing.JLabel();
        jLabel221 = new javax.swing.JLabel();
        jLabel222 = new javax.swing.JLabel();
        jLabel198 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        jLabel203 = new javax.swing.JLabel();
        jnguoithan = new javax.swing.JLabel();
        jLabel202 = new javax.swing.JLabel();
        jdinhat = new javax.swing.JLabel();
        jLabel197 = new javax.swing.JLabel();
        jdennhat = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel48 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        tuychon = new javax.swing.JMenu();
        printRecord = new javax.swing.JMenuItem();
        QL = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });
        getContentPane().setLayout(null);

        jPanel1_a.setBackground(new java.awt.Color(102, 102, 255));
        jPanel1_a.setMinimumSize(new java.awt.Dimension(1300, 4775));
        jPanel1_a.setPreferredSize(new java.awt.Dimension(1295, 5030));
        jPanel1_a.addMouseWheelListener(new java.awt.event.MouseWheelListener() {
            public void mouseWheelMoved(java.awt.event.MouseWheelEvent evt) {
                jPanel1_aMouseWheelMoved(evt);
            }
        });
        jPanel1_a.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        page1.setBackground(new java.awt.Color(255, 255, 255));
        page1.setPreferredSize(new java.awt.Dimension(1295, 680));
        page1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 25)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("BẢN TỰ THUẬT CỦA THỰC TẬP SINH");
        page1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(-60, 100, 1290, 60));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("Ảnh 4x6");
        jPanel3.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 110, 60, -1));

        page1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 170, 180, 250));

        jdiachi1.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        page1.add(jdiachi1, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 390, 570, -1));

        jLabel19.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        jLabel19.setText("Họ tên:");
        page1.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 220, -1, -1));

        jhoten1.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        jhoten1.setText("abcd");
        page1.add(jhoten1, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 220, 570, -1));

        jLabel23.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        jLabel23.setText("Giới tính:");
        page1.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 250, -1, -1));

        jgioitinh1.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        jgioitinh1.setText("abcd");
        page1.add(jgioitinh1, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 250, 570, -1));

        jLabel27.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        jLabel27.setText("Ngày sinh:");
        page1.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 280, -1, -1));

        jngaysinh1.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        jngaysinh1.setText("abcd");
        page1.add(jngaysinh1, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 280, 570, -1));

        jLabel31.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        jLabel31.setText("CMND:");
        page1.add(jLabel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 310, -1, -1));

        jcmnd1.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        jcmnd1.setText("abcd");
        page1.add(jcmnd1, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 310, 570, -1));

        jLabel10.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        jLabel10.setText("a. Họ tên :");
        page1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 490, -1, -1));

        jngaysinh.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        jngaysinh.setText("30062000");
        page1.add(jngaysinh, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 530, 130, -1));

        jLabel12.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        jLabel12.setText("Tuổi:");
        page1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 530, -1, -1));

        jtuoi.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        jtuoi.setText("22");
        page1.add(jtuoi, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 530, 70, -1));

        jLabel14.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        jLabel14.setText("Nơi sinh:");
        page1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 530, -1, -1));

        jnoisinh.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        jnoisinh.setText("daklak");
        page1.add(jnoisinh, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 530, 570, -1));

        jLabel16.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        jLabel16.setText("e. Số Passport:");
        page1.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 650, -1, -1));

        jnguyenquan.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        jnguyenquan.setText("daklak");
        page1.add(jnguyenquan, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 570, 380, -1));

        jdantoc.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        jdantoc.setText("kinh");
        page1.add(jdantoc, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 570, 120, -1));

        jhonnhan.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        jhonnhan.setText("e");
        page1.add(jhonnhan, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 570, 190, -1));

        jLabel22.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        jLabel22.setText("c. Nguyên quán:");
        page1.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 570, -1, -1));

        jcmnd.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        jcmnd.setText("123456789");
        page1.add(jcmnd, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 610, 140, -1));

        jLabel24.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        jLabel24.setText("Ngày cấp:");
        page1.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 610, -1, -1));

        jngaycapcc.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        jngaycapcc.setText("30/06/2000");
        page1.add(jngaycapcc, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 610, 120, -1));

        jLabel26.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        jLabel26.setText("Nơi cấp:");
        page1.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 650, -1, -1));

        jnoicapcc.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        jnoicapcc.setText("daklak");
        page1.add(jnoicapcc, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 610, 590, -1));

        jLabel28.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        jLabel28.setText("d. Số CMND/CCCD:");
        page1.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 610, -1, -1));

        jpassport.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        jpassport.setText("1234567891011");
        page1.add(jpassport, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 650, 180, -1));

        jLabel30.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        jLabel30.setText("Ngày cấp:");
        page1.add(jLabel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 650, -1, -1));

        jngaycappp.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        jngaycappp.setText("30062000");
        page1.add(jngaycappp, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 650, 100, -1));

        jLabel32.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        jLabel32.setText("Nơi cấp:");
        page1.add(jLabel32, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 610, -1, -1));

        jnoicappp.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        jnoicappp.setText("dakalk");
        page1.add(jnoicappp, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 650, 580, -1));

        jLabel34.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        jLabel34.setText("Số điện thoại:");
        page1.add(jLabel34, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 870, -1, -1));

        jhokhau.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        jhokhau.setText("daklak, phuong abc, so nha. tinh thanh pho noi o abc xzy 1/100/100/111");
        page1.add(jhokhau, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 720, 960, -1));

        jLabel36.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        jLabel36.setText("f. Hộ khẩu thường trú:");
        page1.add(jLabel36, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 690, -1, -1));

        jsdt.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        jsdt.setText("0399999999999");
        page1.add(jsdt, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 760, 330, -1));

        jLabel38.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        jLabel38.setText("g. Địa chỉ liên lạc trong trường hợp khẩn cấp:");
        page1.add(jLabel38, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 800, -1, -1));

        jdiachill.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        jdiachill.setText("phuong ong quan ba thanh pho nay tinh no ben bo vu tru");
        page1.add(jdiachill, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 830, 1090, -1));

        jLabel40.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        jLabel40.setText("Số điện thoại liên lạc:");
        page1.add(jLabel40, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 760, -1, -1));

        jsdtll.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        jsdtll.setText("03999999999999");
        page1.add(jsdtll, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 870, 190, -1));

        jLabel42.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        jLabel42.setText("Tên người liên lạc:");
        page1.add(jLabel42, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 870, -1, -1));

        jhotenll.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        jhotenll.setText("thay ong noi abbc xyz");
        page1.add(jhotenll, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 870, 270, -1));

        jLabel44.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        jLabel44.setText("Mối quan hệ:");
        page1.add(jLabel44, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 870, 110, -1));

        jLabel77.setFont(new java.awt.Font("Times New Roman", 3, 22)); // NOI18N
        jLabel77.setText("2. Tình trạng sức khỏe");
        page1.add(jLabel77, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 910, -1, 30));

        jLabel4.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        jLabel4.setText("b. Ngày tháng năm sinh:");
        page1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 530, -1, -1));

        jmqh.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        jmqh.setText("thay ong noi");
        page1.add(jmqh, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 870, 150, -1));

        jhoten.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        jhoten.setText("NTNA");
        page1.add(jhoten, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 490, 190, -1));

        jLabel46.setFont(new java.awt.Font("Times New Roman", 3, 22)); // NOI18N
        jLabel46.setText("1. Thông tin cá nhân");
        page1.add(jLabel46, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 450, -1, 30));

        jLabel6.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        jLabel6.setText("Giới tính :");
        page1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 490, -1, -1));

        jgioitinh.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        jgioitinh.setText("Nam");
        page1.add(jgioitinh, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 490, 210, -1));

        jLabel8.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        jLabel8.setText("Tôn giáo :");
        page1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 490, -1, -1));

        jtongiao.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        jtongiao.setText("Khoong");
        page1.add(jtongiao, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 490, 160, -1));

        jLabel47.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        jLabel47.setText("Chiều cao:");
        page1.add(jLabel47, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 950, -1, -1));

        jchieucao.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        jchieucao.setText("165");
        page1.add(jchieucao, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 950, 50, -1));

        jLabel49.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        jLabel49.setText("Cm");
        page1.add(jLabel49, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 950, -1, -1));

        jLabel50.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        jLabel50.setText("Cân nặng :");
        page1.add(jLabel50, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 950, 90, -1));

        jcannang.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        jcannang.setText("162");
        page1.add(jcannang, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 950, 60, -1));

        jLabel52.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        jLabel52.setText("Kg");
        page1.add(jLabel52, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 950, -1, -1));

        jLabel53.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        jLabel53.setText("Phẫu  thuật:");
        page1.add(jLabel53, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 1030, -1, -1));

        jnhommau.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        jnhommau.setText("a");
        page1.add(jnhommau, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 950, 80, -1));

        jtaythuan.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        jtaythuan.setText("trai phai");
        page1.add(jtaythuan, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 950, 130, -1));

        jLabel57.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        jLabel57.setText("Thị lực: Mắt trái:");
        page1.add(jLabel57, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 990, 150, -1));

        jmattrai.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        jmattrai.setText("10/10");
        page1.add(jmattrai, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 990, 80, -1));

        jLabel59.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        jLabel59.setText("Mắt phải :");
        page1.add(jLabel59, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 990, -1, -1));

        jmatphai.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        jmatphai.setText("10/10");
        page1.add(jmatphai, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 990, 80, -1));

        jLabel61.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        jLabel61.setText("Đeo kính:");
        page1.add(jLabel61, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 990, -1, -1));

        jdeokinh.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        jdeokinh.setText("khong");
        page1.add(jdeokinh, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 990, 90, -1));

        jmumau.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        jmumau.setText("khong");
        page1.add(jmumau, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 990, 130, -1));

        jLabel65.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        jLabel65.setText("Dị ứng:");
        page1.add(jLabel65, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 1030, -1, -1));

        jdiung.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        jdiung.setText("khong");
        page1.add(jdiung, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 1030, 130, -1));

        jLabel67.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        jLabel67.setText("Hút thuốc :");
        page1.add(jLabel67, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 1030, -1, -1));

        jhutthuoc.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        jhutthuoc.setText("khogn");
        page1.add(jhutthuoc, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 1030, 100, -1));

        jLabel69.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        jLabel69.setText("Hình xăm:");
        page1.add(jLabel69, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 1030, -1, -1));

        jhinhxam.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        jhinhxam.setText("khong");
        page1.add(jhinhxam, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 1030, 130, -1));

        jphauthuat.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        jphauthuat.setText("khong");
        page1.add(jphauthuat, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 1030, 130, -1));

        jLabel73.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        jLabel73.setText("Lực tay trái:");
        page1.add(jLabel73, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 1070, -1, -1));

        jluctt.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        jluctt.setText("99");
        page1.add(jluctt, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 1070, 90, -1));

        jLabel75.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        jLabel75.setText("Lực tay phải:");
        page1.add(jLabel75, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 1070, -1, -1));

        jluctp.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        jluctp.setText("99");
        page1.add(jluctp, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 1070, 130, -1));

        jskve.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        jskve.setText("cuoi vo ");
        page1.add(jskve, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 1340, 1010, -1));

        jLabel182.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        jLabel182.setText("f) Bạn biết gì về nước Nhật:");
        page1.add(jLabel182, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 1380, -1, -1));

        jbgvnnhat.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        jbgvnnhat.setText("biet nhieu ");
        page1.add(jbgvnnhat, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 1380, 740, -1));

        jLabel184.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        jLabel184.setText("g) Số tiền bạn muốn mang về VN sau 3 năm làm việc:");
        page1.add(jLabel184, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 1420, -1, -1));

        jtien3nam.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        jtien3nam.setText("năm trăm triệu");
        page1.add(jtien3nam, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 1420, 210, -1));

        jLabel186.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        jLabel186.setText("VNĐ");
        page1.add(jLabel186, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 1420, -1, -1));

        jLabel78.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        jLabel78.setText("a) Mục đích đi Nhật:");
        page1.add(jLabel78, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 1150, -1, -1));

        jLabel95.setFont(new java.awt.Font("Times New Roman", 3, 22)); // NOI18N
        jLabel95.setText("3. Đặc tính cá nhân");
        page1.add(jLabel95, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 1110, -1, 30));

        jmucdichdinhat.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        jmucdichdinhat.setText("di nhat de kiem tien ve cuoi vo lam nay lam kia lam du thu do di nhat de kiem nguoi yeu o nhat asdsadsadsadasdsadsad");
        page1.add(jmucdichdinhat, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 1170, 1170, 40));

        jLabel174.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        jLabel174.setText("b) Điểm mạnh:");
        page1.add(jLabel174, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 1220, -1, -1));

        jdiemmanh.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        jdiemmanh.setText("diem manh la diem yeu asdsadsadsadsadasasdsdsadsadasd");
        page1.add(jdiemmanh, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 1220, 850, -1));

        jLabel176.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        jLabel176.setText("c) Điểm yếu:");
        page1.add(jLabel176, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 1260, -1, -1));

        jdiemyeu.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        jdiemyeu.setText("diem yeu la diem manh cua diem yeu");
        page1.add(jdiemyeu, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 1260, 1120, -1));

        jLabel178.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        jLabel178.setText("d) Sở thích:");
        page1.add(jLabel178, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 1300, -1, -1));

        jsothich.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        jsothich.setText("lam bieng lam tinh lam minh lam nay");
        page1.add(jsothich, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 1300, 1120, -1));

        jLabel180.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        jLabel180.setText("e) Sau khi về nước làm gì:");
        page1.add(jLabel180, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 1340, -1, -1));
        page1.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 1600, -1, -1));

        jLabel45.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        jLabel45.setText("Số điện thoại :");
        page1.add(jLabel45, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 340, -1, -1));

        jLabel93.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        jLabel93.setText("h) Trong thời gian làm việc tại Nhật bạn có dự định gửi tiền về quê cho ai không? Mục đích?");
        page1.add(jLabel93, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 1460, -1, -1));

        jtienveque.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        jtienveque.setText("khong.vi khong thich gui");
        page1.add(jtienveque, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 1490, 930, -1));

        jLabel21.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/testfoot4.png"))); // NOI18N
        page1.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 1540, -1, -1));

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/lg.png"))); // NOI18N
        page1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, -1, -1));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/KeyChinh.png"))); // NOI18N
        page1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 20, -1, -1));

        jsdt2.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        jsdt2.setText("0399999999999");
        page1.add(jsdt2, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 340, 330, -1));

        jLabel33.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        jLabel33.setText("Dân tộc:");
        page1.add(jLabel33, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 570, -1, -1));

        jLabel54.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        jLabel54.setText("Nhóm máu:");
        page1.add(jLabel54, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 950, -1, -1));

        jLabel56.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        jLabel56.setText("Tay  thuận:");
        page1.add(jLabel56, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 950, -1, -1));

        jLabel58.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        jLabel58.setText("Bệnh  mù  màu:");
        page1.add(jLabel58, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 990, -1, -1));

        jLabel13.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        jLabel13.setText("Tình  trạng  hôn  nhân:");
        page1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 570, -1, -1));

        jPanel1_a.add(page1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1295, 1685));

        page2.setBackground(new java.awt.Color(255, 255, 255));
        page2.setPreferredSize(new java.awt.Dimension(1295, 1685));
        page2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Times New Roman", 3, 22)); // NOI18N
        jLabel3.setText("6. Thành phần gia đình");
        page2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 1040, -1, 30));

        jhocvan.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        jhocvan.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, "", null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Năm nhập học", "Năm tốt nghiệp", "Tên trường", "Địa chỉ", "Tình trạng Đã TN/Chưa TN"
            }
        ));
        jhocvan.setAlignmentX(2.0F);
        jhocvan.setAlignmentY(2.0F);
        jhocvan.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jhocvan.setRowHeight(45);
        jhocvan.setRowMargin(5);
        jScrollPane15.setViewportView(jhocvan);

        page2.add(jScrollPane15, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 240, 1100, 340));

        jLabel192.setFont(new java.awt.Font("Times New Roman", 3, 22)); // NOI18N
        jLabel192.setText("4. Trình độ học vấn");
        page2.add(jLabel192, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 190, -1, 30));

        tblCongViec.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        tblCongViec.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, ""},
                {null, null, "", null, null, ""},
                {null, null, null, null, null, ""},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Từ Tháng/Năm", "Đến Tháng/Năm", "Tên công ty", "Địa chỉ", "Công việc đã làm", "Lương VNĐ/Tháng"
            }
        ));
        tblCongViec.setRowHeight(45);
        jScrollPane3.setViewportView(tblCongViec);

        page2.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 690, 1100, 300));

        jLabel193.setFont(new java.awt.Font("Times New Roman", 3, 22)); // NOI18N
        jLabel193.setText("5. Quá trình công việc");
        page2.add(jLabel193, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 640, -1, 30));

        tblGiaDinh.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        tblGiaDinh.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        tblGiaDinh.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, "Đã đến Nhật bao giờ chưa ?"},
                {null, null, "", null, null, ""},
                {null, null, null, null, null, "Đi Nhật gia đình có đồng ý không?"},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Họ Tên", "Quan hệ", "Tuổi", "Nghề nghiệp", "Tình trạng sức khỏe", "Có người thân ở Nhật không?"
            }
        ));
        tblGiaDinh.setFocusable(false);
        tblGiaDinh.setRowHeight(45);
        tblGiaDinh.setRowMargin(5);
        jScrollPane16.setViewportView(tblGiaDinh);
        if (tblGiaDinh.getColumnModel().getColumnCount() > 0) {
            tblGiaDinh.getColumnModel().getColumn(4).setResizable(false);
            tblGiaDinh.getColumnModel().getColumn(5).setResizable(false);
        }

        page2.add(jScrollPane16, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 1080, 1100, 340));

        jLabel35.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/testfoot4.png"))); // NOI18N
        page2.add(jLabel35, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 1520, -1, -1));

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/KeyChinh.png"))); // NOI18N
        page2.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 20, -1, -1));

        jLabel51.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/lg.png"))); // NOI18N
        page2.add(jLabel51, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, -1, -1));

        jPanel1_a.add(page2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 1685, 1295, 1685));
        page2.getAccessibleContext().setAccessibleDescription("");

        page3.setBackground(new java.awt.Color(255, 255, 255));
        page3.setPreferredSize(new java.awt.Dimension(1295, 1450));
        page3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel194.setFont(new java.awt.Font("Times New Roman", 3, 22)); // NOI18N
        jLabel194.setText("7. Thông tin khác ");
        page3.add(jLabel194, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 250, -1, 30));

        jLabel196.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        jLabel196.setText("mà Công Ty Dũng Giang đang tuyển chọn.");
        page3.add(jLabel196, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 560, 370, -1));

        jlolang.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        jlolang.setText("lo qua do ko kiem duoc nguoi yeu");
        page3.add(jlolang, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 290, 980, -1));

        jLabel199.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        jLabel199.setText("Có anh, chị, em, bạn bè nào của bạn từng đăng ký tại Công Ty Dũng Giang không?");
        page3.add(jLabel199, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 330, -1, -1));

        jLabel200.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        jLabel200.setText("Họ và tên người giới thiệu:");
        page3.add(jLabel200, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 410, -1, -1));

        jbietdg.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        jbietdg.setText("Website");
        page3.add(jbietdg, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 370, -1, -1));

        jacedinhat.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        jacedinhat.setText("khong");
        page3.add(jacedinhat, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 330, 240, -1));

        jLabel204.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        jLabel204.setText("Ký và ghi rõ họ tên");
        page3.add(jLabel204, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 840, -1, -1));

        jrohoten.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        jrohoten.setText("jLabel6");
        page3.add(jrohoten, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 410, 580, -1));

        jkhac.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        page3.add(jkhac, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 500, 580, -1));

        jLabel208.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        jLabel208.setText("Bạn biết đến Dũng Giang qua kênh thông tin nào?");
        page3.add(jLabel208, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 370, -1, -1));

        jLabel212.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        jLabel212.setText("Nguyện vọng đăng ký ngành:");
        page3.add(jLabel212, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 450, 250, -1));

        jnganh.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        jnganh.setText("gi cung dc");
        page3.add(jnganh, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 450, 280, -1));

        jLabel214.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        jLabel214.setText("Sau khi được tư vấn và hiểu rõ các vấn đề liên quan, tôi xin tình nguyện đăng ký tham gia chương trình đi làm việc ở nước ngoài  ");
        page3.add(jLabel214, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 520, -1, -1));

        jLabel215.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        jLabel215.setText("Tôi đồng ý để công ty sắp xếp ngành nghề phỏng vấn theo khả năng của tôi và yêu cầu của xí nghiệp tiếp nhận đưa ra.");
        page3.add(jLabel215, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 600, -1, -1));

        jLabel216.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        jLabel216.setText("Tôi xin cam kết các thông tin đã khai trên là đúng sự thật.");
        page3.add(jLabel216, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 640, -1, -1));

        jLabel217.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        jLabel217.setText("Tôi xin chịu trách nhiệm trước pháp luật về tính chính xác của các thông tin này.");
        page3.add(jLabel217, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 680, -1, -1));

        jLabel218.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        jLabel218.setText(".............Ngày............Tháng.........Năm.........");
        page3.add(jLabel218, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 780, -1, -1));

        jLabel219.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        jLabel219.setText("NGƯỜI KHAI");
        page3.add(jLabel219, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 810, -1, -1));

        jLabel220.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        jLabel220.setText("NHÂN VIÊN TƯ VẤN");
        page3.add(jLabel220, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 780, -1, -1));

        jLabel221.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        jLabel221.setText("(Đã yêu cầu người đăng ký đọc kỹ nội dung trên)");
        page3.add(jLabel221, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 810, -1, -1));

        jLabel222.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        jLabel222.setText("Ký và ghi rõ họ tên");
        page3.add(jLabel222, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 840, -1, -1));

        jLabel198.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        jLabel198.setText("Điều lo lắng khi đi Nhật? ");
        page3.add(jLabel198, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 290, -1, -1));

        jLabel37.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/testfoot4.png"))); // NOI18N
        page3.add(jLabel37, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 1400, -1, -1));

        jLabel203.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        jLabel203.setText("Có người thân ở Nhật không?");
        page3.add(jLabel203, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 170, -1, -1));

        jnguoithan.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        jnguoithan.setText("chưa");
        page3.add(jnguoithan, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 170, 110, -1));

        jLabel202.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        jLabel202.setText("Đi Nhật gia đình có đồng ý không?");
        page3.add(jLabel202, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 210, -1, -1));

        jdinhat.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        jdinhat.setText("chưa");
        page3.add(jdinhat, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 210, 110, -1));

        jLabel197.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        jLabel197.setText("Đã đến Nhật bao giờ chưa?");
        page3.add(jLabel197, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 170, -1, -1));

        jdennhat.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        jdennhat.setText("chưa");
        page3.add(jdennhat, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 170, 110, -1));

        jLabel29.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/KeyChinh.png"))); // NOI18N
        page3.add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 20, -1, -1));

        jLabel48.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/lg.png"))); // NOI18N
        page3.add(jLabel48, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, -1, -1));

        jPanel1_a.add(page3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 3370, 1295, 1685));

        getContentPane().add(jPanel1_a);
        jPanel1_a.setBounds(0, 0, 1295, 5030);

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

        jMenuItem1.setText("In DKVL");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        tuychon.add(jMenuItem1);

        jMenuBar1.add(tuychon);

        setJMenuBar(jMenuBar1);

        setSize(new java.awt.Dimension(1312, 5098));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void printRecordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_printRecordActionPerformed
        // TODO add your handling code here:
        PrintUtil p=new PrintUtil(jPanel1_a);
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

    private void jPanel1_aMouseWheelMoved(java.awt.event.MouseWheelEvent evt) {//GEN-FIRST:event_jPanel1_aMouseWheelMoved
        // TODO add your handling code here
            int h = jPanel1_a.getHeight();
        int a = evt.getWheelRotation();
        int x = jPanel1_a.getX();
        int y = jPanel1_a.getY();
        int b = 0;
        if(a>0)
        {
            if(y==this.getHeight()-jPanel1_a.getHeight())
            {
                a=0;
            }else
            {
                b+=50;
                jPanel1_a.setLocation(x,y-b);
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
                jPanel1_a.setLocation(x,y+b);
                b=0;
            }
        }
    }//GEN-LAST:event_jPanel1_aMouseWheelMoved

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
        this.dispose();
        FormDKLVC form=new FormDKLVC(getcmnd);
        form.setVisible(true);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        // TODO add your handling code here:
        new danhsach().setVisible(true);
        setDefaultCloseOperation(Print_Form.DISPOSE_ON_CLOSE); 
    }//GEN-LAST:event_formWindowClosing

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
            java.util.logging.Logger.getLogger(Print_Form.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Print_Form.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Print_Form.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Print_Form.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Print_Form().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem QL;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel174;
    private javax.swing.JLabel jLabel176;
    private javax.swing.JLabel jLabel178;
    private javax.swing.JLabel jLabel180;
    private javax.swing.JLabel jLabel182;
    private javax.swing.JLabel jLabel184;
    private javax.swing.JLabel jLabel186;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel192;
    private javax.swing.JLabel jLabel193;
    private javax.swing.JLabel jLabel194;
    private javax.swing.JLabel jLabel196;
    private javax.swing.JLabel jLabel197;
    private javax.swing.JLabel jLabel198;
    private javax.swing.JLabel jLabel199;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel200;
    private javax.swing.JLabel jLabel202;
    private javax.swing.JLabel jLabel203;
    private javax.swing.JLabel jLabel204;
    private javax.swing.JLabel jLabel208;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel212;
    private javax.swing.JLabel jLabel214;
    private javax.swing.JLabel jLabel215;
    private javax.swing.JLabel jLabel216;
    private javax.swing.JLabel jLabel217;
    private javax.swing.JLabel jLabel218;
    private javax.swing.JLabel jLabel219;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel220;
    private javax.swing.JLabel jLabel221;
    private javax.swing.JLabel jLabel222;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel42;
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
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabel57;
    private javax.swing.JLabel jLabel58;
    private javax.swing.JLabel jLabel59;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel61;
    private javax.swing.JLabel jLabel65;
    private javax.swing.JLabel jLabel67;
    private javax.swing.JLabel jLabel69;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel73;
    private javax.swing.JLabel jLabel75;
    private javax.swing.JLabel jLabel77;
    private javax.swing.JLabel jLabel78;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabel93;
    private javax.swing.JLabel jLabel95;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPanel jPanel1_a;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane15;
    private javax.swing.JScrollPane jScrollPane16;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel jacedinhat;
    private javax.swing.JLabel jbgvnnhat;
    private javax.swing.JLabel jbietdg;
    private javax.swing.JLabel jcannang;
    private javax.swing.JLabel jchieucao;
    private javax.swing.JLabel jcmnd;
    private javax.swing.JLabel jcmnd1;
    private javax.swing.JLabel jdantoc;
    private javax.swing.JLabel jdennhat;
    private javax.swing.JLabel jdeokinh;
    private javax.swing.JLabel jdiachi1;
    private javax.swing.JLabel jdiachill;
    private javax.swing.JLabel jdiemmanh;
    private javax.swing.JLabel jdiemyeu;
    private javax.swing.JLabel jdinhat;
    private javax.swing.JLabel jdiung;
    private javax.swing.JLabel jgioitinh;
    private javax.swing.JLabel jgioitinh1;
    private javax.swing.JLabel jhinhxam;
    private javax.swing.JTable jhocvan;
    private javax.swing.JLabel jhokhau;
    private javax.swing.JLabel jhonnhan;
    private javax.swing.JLabel jhoten;
    private javax.swing.JLabel jhoten1;
    private javax.swing.JLabel jhotenll;
    private javax.swing.JLabel jhutthuoc;
    private javax.swing.JLabel jkhac;
    private javax.swing.JLabel jlolang;
    private javax.swing.JLabel jluctp;
    private javax.swing.JLabel jluctt;
    private javax.swing.JLabel jmatphai;
    private javax.swing.JLabel jmattrai;
    private javax.swing.JLabel jmqh;
    private javax.swing.JLabel jmucdichdinhat;
    private javax.swing.JLabel jmumau;
    private javax.swing.JLabel jnganh;
    private javax.swing.JLabel jngaycapcc;
    private javax.swing.JLabel jngaycappp;
    private javax.swing.JLabel jngaysinh;
    private javax.swing.JLabel jngaysinh1;
    private javax.swing.JLabel jnguoithan;
    private javax.swing.JLabel jnguyenquan;
    private javax.swing.JLabel jnhommau;
    private javax.swing.JLabel jnoicapcc;
    private javax.swing.JLabel jnoicappp;
    private javax.swing.JLabel jnoisinh;
    private javax.swing.JLabel jpassport;
    private javax.swing.JLabel jphauthuat;
    private javax.swing.JLabel jrohoten;
    private javax.swing.JLabel jsdt;
    private javax.swing.JLabel jsdt2;
    private javax.swing.JLabel jsdtll;
    private javax.swing.JLabel jskve;
    private javax.swing.JLabel jsothich;
    private javax.swing.JLabel jtaythuan;
    private javax.swing.JLabel jtien3nam;
    private javax.swing.JLabel jtienveque;
    private javax.swing.JLabel jtongiao;
    private javax.swing.JLabel jtuoi;
    private javax.swing.JPanel page1;
    private javax.swing.JPanel page2;
    private javax.swing.JPanel page3;
    private javax.swing.JMenuItem printRecord;
    private javax.swing.JTable tblCongViec;
    private javax.swing.JTable tblGiaDinh;
    private javax.swing.JMenu tuychon;
    // End of variables declaration//GEN-END:variables

    private int printRecord(JPanel panel){
        
        PrinterJob printerJob = PrinterJob.getPrinterJob();
        
        printerJob.setPrintable(new Printable() {
            @Override
            public int print(Graphics graphics, PageFormat pageFormat, int pageIndex) throws PrinterException {
                if (pageIndex > 0){
                    return Printable.NO_SUCH_PAGE;
                }
                
                Graphics2D graphics2D =(Graphics2D)graphics;
                
                graphics2D.translate(pageFormat.getImageableX()*2,pageFormat.getImageableY()*2);
                
                graphics2D.scale(0.5,0.5);
                
                panel.print(graphics2D);
                
                return Printable.PAGE_EXISTS;
            }
        });
        boolean returningResult = printerJob.printDialog();
        int t=0;
        if(returningResult){
            try{
                printerJob.print();
                return t=1;
            }catch (PrinterException printerException){
                JOptionPane.showMessageDialog(this, "In Lỗi :" + printerException.getLocalizedMessage());
            }
        }
        return t;
    }


}
