/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Access;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
 
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import model.ThongTinCaNhan;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.DateUtil;
/**
 *
 * @author Nhat Anh
 */
public class ThongTinCaNhanDAO {
    XSSFRow row;  
    public ThongTinCaNhan getUsers(String cmnd){
        
                   ThongTinCaNhan thongtincanhan = new ThongTinCaNhan();
        Connection connection = DBConnection.getConnection();
            
            String sql ="SELECT * FROM thongtincanhan where cmnd=?";
            
           try{
               PreparedStatement preparedStatement = connection.prepareStatement(sql);
               preparedStatement.setString(1, cmnd);
               ResultSet rs = preparedStatement.executeQuery();
               while (rs.next()){
                   
                   
                   thongtincanhan.setHoten(rs.getString("hoten"));
                   thongtincanhan.setGioitinh(rs.getString("gioitinh"));
                   thongtincanhan.setTongiao(rs.getString("tongiao"));
                   thongtincanhan.setNgaysinh(rs.getString("ngaysinh"));
                   thongtincanhan.setTuoi(rs.getString("tuoi"));
                   thongtincanhan.setNoisinh(rs.getString("noisinh"));
                   thongtincanhan.setNguyenquan(rs.getString("nguyenquan"));
                   thongtincanhan.setDantoc(rs.getString("dantoc"));
                   thongtincanhan.setHonnhan(rs.getString("honnhan"));
                   thongtincanhan.setCmnd(rs.getString("cmnd"));
                   thongtincanhan.setNgaycapcc(rs.getString("ngaycapcc"));
                   thongtincanhan.setNoicapcc(rs.getString("noicapcc"));
                   thongtincanhan.setPassport(rs.getString("passport"));
                   thongtincanhan.setNgaycappp(rs.getString("ngaycappp"));
                   thongtincanhan.setNoicappp(rs.getString("noicappp"));
                   thongtincanhan.setHokhau(rs.getString("hokhau"));
                   thongtincanhan.setSdt(rs.getString("sdt"));
                   thongtincanhan.setDiachill(rs.getString("diachill"));
                   thongtincanhan.setSdtll(rs.getString("sdtll"));
                   thongtincanhan.setHotenll(rs.getString("hotenll"));
                   thongtincanhan.setMqh(rs.getString("mqh"));
                   
               }
           }catch (SQLException e){
             Logger.getLogger(ThongTinCaNhanDAO.class.getName()).log(Level.SEVERE, null, e);
           }
       return thongtincanhan;
                
    }
     public List<ThongTinCaNhan>getAllUsers(){
        List<ThongTinCaNhan> thongtincanhans = new ArrayList<ThongTinCaNhan>();
                   
        Connection connection = DBConnection.getConnection();
            
            String sql ="SELECT * FROM thongtincanhan where 1";
            
           try{
               PreparedStatement preparedStatement = connection.prepareStatement(sql);
                
               ResultSet rs = preparedStatement.executeQuery();
               while (rs.next()){
                   ThongTinCaNhan thongtincanhan = new ThongTinCaNhan();
                   
                   thongtincanhan.setHoten(rs.getString("hoten"));
                   thongtincanhan.setGioitinh(rs.getString("gioitinh"));
                   thongtincanhan.setTongiao(rs.getString("tongiao"));
                   thongtincanhan.setNgaysinh(rs.getString("ngaysinh"));
                   thongtincanhan.setTuoi(rs.getString("tuoi"));
                   thongtincanhan.setNoisinh(rs.getString("noisinh"));
                   thongtincanhan.setNguyenquan(rs.getString("nguyenquan"));
                   thongtincanhan.setDantoc(rs.getString("dantoc"));
                   thongtincanhan.setHonnhan(rs.getString("honnhan"));
                   thongtincanhan.setCmnd(rs.getString("cmnd"));
                   thongtincanhan.setNgaycapcc(rs.getString("ngaycapcc"));
                   thongtincanhan.setNoicapcc(rs.getString("noicapcc"));
                   thongtincanhan.setPassport(rs.getString("passport"));
                   thongtincanhan.setNgaycappp(rs.getString("ngaycappp"));
                   thongtincanhan.setNoicappp(rs.getString("noicappp"));
                   thongtincanhan.setHokhau(rs.getString("hokhau"));
                   thongtincanhan.setSdt(rs.getString("sdt"));
                   thongtincanhan.setDiachill(rs.getString("diachill"));
                   thongtincanhan.setSdtll(rs.getString("sdtll"));
                   thongtincanhan.setHotenll(rs.getString("hotenll"));
                   thongtincanhan.setMqh(rs.getString("mqh"));
                   thongtincanhans.add(thongtincanhan);
               }
           }catch (SQLException e){
             Logger.getLogger(ThongTinCaNhanDAO.class.getName()).log(Level.SEVERE, null, e);
           }
       return thongtincanhans;
                
    }
     public List<ThongTinCaNhan>getAllUsersByName(String ten){
        List<ThongTinCaNhan> thongtincanhans = new ArrayList<ThongTinCaNhan>();
                   
        Connection connection = DBConnection.getConnection();
            
            String sql ="SELECT * FROM thongtincanhan where hoten like concat('%',?,'%')";
            
           try{
               PreparedStatement preparedStatement = connection.prepareStatement(sql);
               preparedStatement.setString(1, ten);
               ResultSet rs = preparedStatement.executeQuery();
               while (rs.next()){
                   ThongTinCaNhan thongtincanhan = new ThongTinCaNhan();
                   
                   thongtincanhan.setHoten(rs.getString("hoten"));
                   thongtincanhan.setGioitinh(rs.getString("gioitinh"));
                   thongtincanhan.setTongiao(rs.getString("tongiao"));
                   thongtincanhan.setNgaysinh(rs.getString("ngaysinh"));
                   thongtincanhan.setTuoi(rs.getString("tuoi"));
                   thongtincanhan.setNoisinh(rs.getString("noisinh"));
                   thongtincanhan.setNguyenquan(rs.getString("nguyenquan"));
                   thongtincanhan.setDantoc(rs.getString("dantoc"));
                   thongtincanhan.setHonnhan(rs.getString("honnhan"));
                   thongtincanhan.setCmnd(rs.getString("cmnd"));
                   thongtincanhan.setNgaycapcc(rs.getString("ngaycapcc"));
                   thongtincanhan.setNoicapcc(rs.getString("noicapcc"));
                   thongtincanhan.setPassport(rs.getString("passport"));
                   thongtincanhan.setNgaycappp(rs.getString("ngaycappp"));
                   thongtincanhan.setNoicappp(rs.getString("noicappp"));
                   thongtincanhan.setHokhau(rs.getString("hokhau"));
                   thongtincanhan.setSdt(rs.getString("sdt"));
                   thongtincanhan.setDiachill(rs.getString("diachill"));
                   thongtincanhan.setSdtll(rs.getString("sdtll"));
                   thongtincanhan.setHotenll(rs.getString("hotenll"));
                   thongtincanhan.setMqh(rs.getString("mqh"));
                   thongtincanhans.add(thongtincanhan);
               }
           }catch (SQLException e){
             Logger.getLogger(ThongTinCaNhanDAO.class.getName()).log(Level.SEVERE, null, e);
           }
       return thongtincanhans;
                
    }
    public void readFile(String fileName) throws FileNotFoundException, IOException {
        FileInputStream fis;
        convertdate c= new convertdate();
        delete();
        try {
            System.out.println("-------------------------------READING THE SPREADSHEET-------------------------------------");
            fis = new FileInputStream(fileName);
            XSSFWorkbook workbookRead = new XSSFWorkbook(fis);
            XSSFSheet spreadsheetRead = workbookRead.getSheetAt(0);

            Iterator< Row> rowIterator = spreadsheetRead.iterator();
            List<ThongTinCaNhan> list=new ArrayList<ThongTinCaNhan>();
            rowIterator.next();
            while (rowIterator.hasNext()) {
                ThongTinCaNhan tt=new ThongTinCaNhan();
                row = (XSSFRow) rowIterator.next();
                Iterator< Cell> cellIterator = row.cellIterator();
                   cellIterator.next();
                while (cellIterator.hasNext()) {
                    Cell cell = cellIterator.next();
                    cell.setCellType(CellType.STRING);
                    switch (cell.getColumnIndex()) {
                        case 1:
                            tt.setHoten(cell.getStringCellValue());
                            break;
                        case 2:
                            
                            tt.setGioitinh(cell.getStringCellValue());
                            break;
                        case 3:
                            tt.setTongiao(cell.getStringCellValue());
                             break;
                        case 4:
                            
                            String date=c.convert(Integer.valueOf(cell.getStringCellValue()));
                            tt.setNgaysinh(date);
                            
                             break;
                        case 5:
                            tt.setTuoi((cell.getStringCellValue()));
                             break;
                        case 6:
                            tt.setNoisinh(cell.getStringCellValue());
                             break;
                        case 7:
                            tt.setNguyenquan(cell.getStringCellValue());
                             break;     
                        case 8:
                            tt.setDantoc(cell.getStringCellValue());
                             break;     
                       case 9:
                            tt.setHonnhan(cell.getStringCellValue());
                             break;      
                        case 10:
                            tt.setCmnd(cell.getStringCellValue());
                             break;     
                        case 11:
                            
                             date=c.convert(Integer.valueOf(cell.getStringCellValue()));
                            tt.setNgaycapcc(date);
                             break;     
                       case 12:
                            tt.setNoicapcc(cell.getStringCellValue());
                             break;      
                        case 13:
                            tt.setPassport(cell.getStringCellValue());
                             break;     
                        case 14:
                            if(cell.getStringCellValue()=="")
                                tt.setNgaycappp("");
                            else{
                            date=c.convert(Integer.valueOf(cell.getStringCellValue()));
                            tt.setNgaycappp(date);}
                             break;                  
                        case 15:
                            tt.setNoicappp(cell.getStringCellValue());
                             break;     
                        case 16:
                            tt.setHokhau(cell.getStringCellValue());
                             break;     
                        case 17:
                            tt.setSdt(cell.getStringCellValue());
                             break;     
                        case 18:
                            tt.setDiachill(cell.getStringCellValue());
                             break;     
                        case 19:
                            tt.setSdtll(cell.getStringCellValue());
                             break;     
                        case 20:
                            tt.setHotenll(cell.getStringCellValue());
                             break;     
                        case 21:
                            tt.setMqh(cell.getStringCellValue());
                             break;     
                    }
                }
                if(tt.getCmnd()!=null)
                insertThongTin(tt);
                
            }
            
            fis.close();
        } catch (IOException e) {
            e.printStackTrace();JOptionPane.showMessageDialog(null, "Lỗi");
        }
    }
    public void insertThongTin(ThongTinCaNhan ttcn){
       Connection connection = DBConnection.getConnection();
        String sql ="INSERT INTO thongtincanhan(hoten,gioitinh,tongiao,ngaysinh,tuoi,noisinh,nguyenquan,dantoc,honnhan,cmnd,ngaycapcc,noicapcc,passport,ngaycappp,noicappp,hokhau,sdt,diachill,sdtll,hotenll,mqh) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement preparedStatement =connection.prepareStatement(sql);
            preparedStatement.setString(1, ttcn.getHoten());
            preparedStatement.setString(2, ttcn.getGioitinh());
            preparedStatement.setString(3, ttcn.getTongiao());
            preparedStatement.setString(4, ttcn.getNgaysinh());
            preparedStatement.setString(5, ttcn.getTuoi());
            preparedStatement.setString(6, ttcn.getNoisinh());
            preparedStatement.setString(7, ttcn.getNguyenquan());
            preparedStatement.setString(8, ttcn.getDantoc());
            preparedStatement.setString(9, ttcn.getHonnhan());
            preparedStatement.setString(10, ttcn.getCmnd());
            preparedStatement.setString(11, ttcn.getNgaycapcc());
            preparedStatement.setString(12, ttcn.getNoicapcc());
            preparedStatement.setString(13, ttcn.getPassport());
            preparedStatement.setString(14, ttcn.getNgaycappp());
            preparedStatement.setString(15, ttcn.getNoicappp());
            preparedStatement.setString(16, ttcn.getHokhau());
            preparedStatement.setString(17, ttcn.getSdt());
            preparedStatement.setString(18, ttcn.getDiachill());
            preparedStatement.setString(19, ttcn.getSdtll());
            preparedStatement.setString(20, ttcn.getHotenll());
            preparedStatement.setString(21, ttcn.getMqh());
            int rs=preparedStatement.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(ThongTinCaNhanDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void delete(){
        Connection connection = DBConnection.getConnection();
        String sql="Delete from thongtincanhan where 1";
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement(sql);
            int rs=preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(CongViecUser.class.getName()).log(Level.SEVERE, null, ex);
        }
                       
    }
    public static void main(String[] args) throws IOException {
        ThongTinCaNhanDAO user=new ThongTinCaNhanDAO();
                String fileName="C:\\Users\\Nhat Anh\\Desktop\\btt.xlsx";

        user.readFile(fileName);
    }
}
