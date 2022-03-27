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
import model.HocVan;

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
public class HocVanUser {
    XSSFRow row;  
    public List<HocVan>getAllUsers(String cmnd){
        List<HocVan> hocvans = new ArrayList<HocVan>();
        
        Connection connection = DBConnection.getConnection();
           String sql ="SELECT * FROM hocvan where cmnd=?";
           try{
               PreparedStatement preparedStatement = connection.prepareStatement(sql);
               preparedStatement.setString(1, cmnd);
               ResultSet rs = preparedStatement.executeQuery();     
               while (rs.next()){
                   HocVan hocvan = new HocVan();                   
                   hocvan.setCmnd(rs.getString("cmnd"));
                   hocvan.setCap(rs.getInt("cap"));
                   hocvan.setBatdautu(rs.getString("batdautu"));
                   hocvan.setKetthuc(rs.getString("ketthuc"));
                   hocvan.setTentruong(rs.getString("tentruong"));
                   hocvan.setDiachi(rs.getString("diachi"));
                   hocvan.setTotnghiep(rs.getString("totnghiep"));
                  
                   hocvans.add(hocvan);                                   
               }
           }catch (SQLException e){
             Logger.getLogger(HocVanUser.class.getName()).log(Level.SEVERE, null, e);
           }
       return hocvans;
                
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
            List<HocVan> list=new ArrayList<HocVan>();
            rowIterator.next();
            
            while (rowIterator.hasNext()) {
                HocVan hv1=new HocVan();
                HocVan hv3=new HocVan();
                HocVan hv4=new HocVan();
                HocVan hv2=new HocVan();
                row = (XSSFRow) rowIterator.next();
                Iterator< Cell> cellIterator = row.cellIterator(); 
                   for(int i=0;i<10;i++)cellIterator.next();
                   
                while (cellIterator.hasNext()) {
                    Cell cell = cellIterator.next();
                    cell.setCellType(CellType.STRING);
                    if(cell.getColumnIndex()==10) 
                    {
                        hv1.setCmnd(cell.getStringCellValue());
                        hv2.setCmnd(cell.getStringCellValue());
                        hv3.setCmnd(cell.getStringCellValue());
                        hv4.setCmnd(cell.getStringCellValue());
                        hv1.setCap(1);
                        hv2.setCap(2);
                        hv3.setCap(3);
                        hv4.setCap(4);
                    }
                    if(cell.getColumnIndex()<45)continue;
                    switch (cell.getColumnIndex()) {
                        
                        case 45:
                            
                            hv1.setBatdautu(cell.getStringCellValue());
                            break;
                        case 46:
                            hv1.setKetthuc(cell.getStringCellValue());
                             break;
                        case 47:
                            hv1.setTentruong(cell.getStringCellValue());
                             break;
                        case 48:
                            hv1.setDiachi(cell.getStringCellValue());
                             break;
                        case 49:
                            hv1.setTotnghiep(cell.getStringCellValue());
                            
                             break;
                        case 50:
                            
                            hv2.setBatdautu(cell.getStringCellValue());
                            break;
                        case 51:
                            hv2.setKetthuc(cell.getStringCellValue());
                             break;
                        case 52:
                            hv2.setTentruong(cell.getStringCellValue());
                             break;
                        case 53:
                            hv2.setDiachi(cell.getStringCellValue());
                             break;
                        case 54:
                            hv2.setTotnghiep(cell.getStringCellValue());
                            
                             break;
                        case 55:
                            
                            hv3.setBatdautu(cell.getStringCellValue());
                            break;
                        case 56:
                            hv3.setKetthuc(cell.getStringCellValue());
                             break;
                        case 57:
                            hv3.setTentruong(cell.getStringCellValue());
                             break;
                        case 58:
                            hv3.setDiachi(cell.getStringCellValue());
                             break;
                        case 59:
                            hv3.setTotnghiep(cell.getStringCellValue());
                             break;
                        case 60:
                            
                            hv4.setBatdautu(cell.getStringCellValue());
                            break;
                        case 61:
                            hv4.setKetthuc(cell.getStringCellValue());
                             break;
                        case 62:
                            hv4.setTentruong(cell.getStringCellValue());
                             break;
                        case 63:
                            hv4.setDiachi(cell.getStringCellValue());
                             break;
                        case 64:
                            hv4.setTotnghiep(cell.getStringCellValue());
                             break;
                        
                    }
                    
                }
                //insertThongTin(hv);
                if(hv1.getTotnghiep()!=null){
                list.add(hv1);
                    insertThongTin(hv1);
                }
                if(hv2.getTotnghiep()!=null){
                list.add(hv2);
                    insertThongTin(hv2);
                }
                if(hv3.getTotnghiep()!=null){
                list.add(hv3);
                    insertThongTin(hv3);
                }
                if(hv4.getTotnghiep()!=null){
                list.add(hv4);
                    insertThongTin(hv4);
                }
            }
       
            
            fis.close();
        } catch (IOException e) {
            e.printStackTrace();JOptionPane.showMessageDialog(null, "Lỗi");
        }
    }
    public void insertThongTin(HocVan hv){
       Connection connection = DBConnection.getConnection();
        String sql ="INSERT INTO hocvan(cmnd, cap,batdautu, ketthuc, tentruong, diachi, totnghiep) VALUES (?,?,?,?,?,?,?)";
        try {
            PreparedStatement preparedStatement =connection.prepareStatement(sql);
            preparedStatement.setString(1, hv.getCmnd());
            preparedStatement.setInt(2, hv.getCap());
            preparedStatement.setString(3, hv.getBatdautu());
            preparedStatement.setString(4, hv.getKetthuc());
            preparedStatement.setString(5, hv.getTentruong());
            preparedStatement.setString(6, hv.getDiachi());
            preparedStatement.setString(7, hv.getTotnghiep());
           
            int rs=preparedStatement.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(HocVan.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    public void delete(){
        Connection connection = DBConnection.getConnection();
        String sql="Delete from hocvan where 1";
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement(sql);
            int rs=preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(CongViecUser.class.getName()).log(Level.SEVERE, null, ex);
        }
                       
    }
    public static void main(String[] args) throws IOException {
        HocVanUser user=new HocVanUser();
        String fileName="C:\\Users\\Nhat Anh\\Desktop\\btt.xlsx";

        user.readFile(fileName);
//        for(HocVan h:user.getAllUsers("123456789")){System.out.println(h.getCap());}
    }
}
