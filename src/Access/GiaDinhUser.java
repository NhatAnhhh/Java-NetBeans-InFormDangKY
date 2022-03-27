/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Access;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.GiaDinh;
import model.ThongTinCaNhan;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


/**
 *
 * @author Nhat Anh
 */
public class GiaDinhUser {
    XSSFRow row;  
     public List<GiaDinh>getAllUsers(String cmnd){
        List<GiaDinh> giadinhs = new ArrayList<GiaDinh>();
        
        Connection connection = DBConnection.getConnection();
           String sql ="SELECT * FROM giadinh where cmnd=?";
           try{
               PreparedStatement preparedStatement = connection.prepareStatement(sql);
               preparedStatement.setString(1, cmnd);
               ResultSet rs = preparedStatement.executeQuery();              
               while (rs.next()){
                   GiaDinh giadinh = new GiaDinh();                   
                   giadinh.setCmnd(rs.getString("cmnd"));
                   giadinh.setStt(rs.getInt("nguoithu"));
                   giadinh.setHoten(rs.getString("hoten"));
                   giadinh.setQuanhe(rs.getString("quanhe"));
                   giadinh.setTuoi(rs.getInt("tuoi"));
                   giadinh.setNghenghiep(rs.getString("nghenghiep"));
                   giadinh.setSuckhoe(rs.getString("suckhoe"));
                 
                   giadinhs.add(giadinh);                                   
               }
           }catch (SQLException e){
             Logger.getLogger(GiaDinhUser.class.getName()).log(Level.SEVERE, null, e);
           }
       return giadinhs;
                
    }
      public void readFile(String fileName) throws FileNotFoundException, IOException {
        FileInputStream fis;
        delete();
        try {
            System.out.println("-------------------------------READING THE SPREADSHEET-------------------------------------");
            fis = new FileInputStream(fileName);
            XSSFWorkbook workbookRead = new XSSFWorkbook(fis);
            XSSFSheet spreadsheetRead = workbookRead.getSheetAt(0);

            Iterator< Row> rowIterator = spreadsheetRead.iterator();
            List<GiaDinh> list=new ArrayList<GiaDinh>();
            rowIterator.next();
            
            while (rowIterator.hasNext()) {
                GiaDinh gd1=new GiaDinh();
                GiaDinh gd2=new GiaDinh();
                GiaDinh gd3=new GiaDinh();
                GiaDinh gd4=new GiaDinh();
                row = (XSSFRow) rowIterator.next();
                Iterator< Cell> cellIterator = row.cellIterator();
                for(int i=0;i<10;i++)cellIterator.next();
                while (cellIterator.hasNext()) {
                    Cell cell = cellIterator.next();
                    cell.setCellType(CellType.STRING);
                    if(cell.getColumnIndex()==10) 
                    {
                        gd1.setCmnd(cell.getStringCellValue());
                        gd2.setCmnd(cell.getStringCellValue());
                        gd3.setCmnd(cell.getStringCellValue());
                        gd4.setCmnd(cell.getStringCellValue());
                    }
                    if(cell.getColumnIndex()<83) continue;
                    switch (cell.getColumnIndex()) {
                        case 83:
                            gd1.setHoten(cell.getStringCellValue());
                            break;
                        case 84:
                            gd1.setQuanhe(cell.getStringCellValue());
                            break;
                        case 85:
                           gd1.setTuoi(Integer.valueOf(cell.getStringCellValue()));
                             break;
                        case 86:
                            gd1.setNghenghiep(cell.getStringCellValue());
                            break;
                        case 87:
                            gd1.setSuckhoe(cell.getStringCellValue());
                            break;
                       case 88:
                            gd2.setHoten(cell.getStringCellValue());
                            break;
                        case 89:
                            gd2.setQuanhe(cell.getStringCellValue());
                            break;
                        case 90:
                            gd2.setTuoi(Integer.valueOf(cell.getStringCellValue()));
                             break;
                        case 91:
                            gd2.setNghenghiep(cell.getStringCellValue());
                            break;
                        case 92:
                            gd2.setSuckhoe(cell.getStringCellValue());
                            break;
                        case 93:
                            gd3.setHoten(cell.getStringCellValue());
                            break;
                        case 94:
                            gd3.setQuanhe(cell.getStringCellValue());
                            break;
                        case 95:
                            if(cell.getStringCellValue()=="")
                                gd3.setTuoi(0);
                            else
                                gd3.setTuoi(Integer.valueOf(cell.getStringCellValue()));
                             break;
                        case 96:
                            gd3.setNghenghiep(cell.getStringCellValue());
                            break;
                        case 97:
                            gd3.setSuckhoe(cell.getStringCellValue());
                            break;
                        case 98:
                            gd4.setHoten(cell.getStringCellValue());
                            break;
                        case 99:
                            gd4.setQuanhe(cell.getStringCellValue());
                            break;
                        case 100:
                            if(cell.getStringCellValue()=="")
                                gd4.setTuoi(0);
                            else
                                gd4.setTuoi(Integer.valueOf(cell.getStringCellValue()));
                             break;
                        case 101:
                            gd4.setNghenghiep(cell.getStringCellValue());
                            break;
                        case 102:
                            gd4.setSuckhoe(cell.getStringCellValue());
                            break;
                             
                    }
                }
                gd1.setStt(1);
                gd2.setStt(2);
                insertThongTin(gd1);
                insertThongTin(gd2);
                if(gd3.getTuoi()!=0){
                    gd3.setStt(3);
                    insertThongTin(gd3);
                }
                if(gd4.getTuoi()!=0){
                    gd4.setStt(4);
                    insertThongTin(gd4);
                }
            }
           
            
            fis.close();
        } catch (IOException e) {
            e.printStackTrace();JOptionPane.showMessageDialog(null, "Lỗi");
        }
    }
    public void insertThongTin(GiaDinh gd){
       Connection connection = DBConnection.getConnection();
        String sql ="INSERT INTO giadinh(cmnd,nguoithu ,hoten, quanhe, tuoi, nghenghiep, suckhoe) VALUES (?,?,?,?,?,?,?)";
        try {
            PreparedStatement preparedStatement =connection.prepareStatement(sql);
            preparedStatement.setString(1, gd.getCmnd());
            preparedStatement.setInt(2, gd.getStt());
            preparedStatement.setString(3, gd.getHoten());
            preparedStatement.setString(4, gd.getQuanhe());
            preparedStatement.setInt(5, gd.getTuoi());
            preparedStatement.setString(6, gd.getNghenghiep());
            preparedStatement.setString(7, gd.getSuckhoe());
           
           
            int rs=preparedStatement.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(GiaDinhUser.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void delete(){
        Connection connection = DBConnection.getConnection();
        String sql="Delete from giadinh where 1";
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement(sql);
            int rs=preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(CongViecUser.class.getName()).log(Level.SEVERE, null, ex);
        }
                       
    }
    public static void main(String[] args) throws IOException {
        GiaDinhUser user=new GiaDinhUser();
       String fileName="C:\\Users\\Nhat Anh\\Desktop\\btt.xlsx";
        user.readFile(fileName);
//        user.delete();
    }
}
