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
import model.CongViec;
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
public class CongViecUser {
    XSSFRow row;  
    public List<CongViec>getAllUsers(String cmnd){
        List<CongViec> congviecs = new ArrayList<CongViec>();
            
        Connection connection = DBConnection.getConnection();
           String sql ="SELECT * FROM congviec where cmnd=?";
           try{
               PreparedStatement preparedStatement = connection.prepareStatement(sql);
               preparedStatement.setString(1, cmnd);
               ResultSet rs = preparedStatement.executeQuery();               
               while (rs.next()){
                   CongViec congviec = new CongViec();                   
                   congviec.setCmnd(rs.getString("cmnd"));
                   congviec.setStt(rs.getString("stt"));
                   congviec.setBatdau(rs.getString("batdau"));
                   congviec.setKetthuc(rs.getString("ketthuc"));
                   congviec.setTencongty(rs.getString("tencongty"));
                   congviec.setDiachi(rs.getString("diachi"));
                   congviec.setCongviec(rs.getString("congviec"));
                   congviec.setLuong(rs.getString("luong"));                                  
                   congviecs.add(congviec);                                   
               }
               
           }catch (SQLException e){
             Logger.getLogger(CongViecUser.class.getName()).log(Level.SEVERE, null, e);
           }
       return congviecs;
                
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
            List<CongViec> list=new ArrayList<CongViec>();
            rowIterator.next();
            
            while (rowIterator.hasNext()) {
                CongViec cv1=new CongViec();
                CongViec cv2=new CongViec();
                CongViec cv3=new CongViec();
                row = (XSSFRow) rowIterator.next();
                Iterator< Cell> cellIterator = row.cellIterator();
                    for(int i=0;i<10;i++)cellIterator.next();
                while (cellIterator.hasNext()) {
                    Cell cell = cellIterator.next();
                    cell.setCellType(CellType.STRING);
                    if(cell.getColumnIndex()==10) 
                    {
                        
                        cv1.setCmnd(cell.getStringCellValue());
                        cv2.setCmnd(cell.getStringCellValue());
                        cv3.setCmnd(cell.getStringCellValue());
                    }
                    if(cell.getColumnIndex()<65) continue;
                    switch (cell.getColumnIndex()) {
                        case 65:
                            
                            cv1.setBatdau(cell.getStringCellValue());
                            break;
                        case 66:
                            cv1.setKetthuc(cell.getStringCellValue());
                             break;
                        case 67:
                            cv1.setTencongty(cell.getStringCellValue());
                             break;
                        case 68:
                            cv1.setDiachi(cell.getStringCellValue());
                             break;
                        case 69:
                            cv1.setCongviec(cell.getStringCellValue());
                             break;
                        case 70:
                            cv1.setLuong((cell.getStringCellValue()));
                            
                            break;
                        case 71:
                            cv2.setBatdau(cell.getStringCellValue());
                            break;
                        case 72:
                            cv2.setKetthuc(cell.getStringCellValue());
                             break;
                        case 73:
                            cv2.setTencongty(cell.getStringCellValue());
                             break;
                        case 74:
                            cv2.setDiachi(cell.getStringCellValue());
                             break;
                        case 75:
                            cv2.setCongviec(cell.getStringCellValue());
                             break;
                        case 76:
                            cv2.setLuong((cell.getStringCellValue()));
                            
                            break;
                        case 77:
                            cv3.setBatdau(cell.getStringCellValue());
                            break;
                        case 78:
                            cv3.setKetthuc(cell.getStringCellValue());
                             break;
                        case 79:
                            cv3.setTencongty(cell.getStringCellValue());
                             break;
                        case 80:
                            cv3.setDiachi(cell.getStringCellValue());
                             break;
                        case 81:
                            cv3.setCongviec(cell.getStringCellValue());
                             break;
                        case 82:
                            cv3.setLuong((cell.getStringCellValue()));
                            
                            break;
                    }
                }
                if(cv1.getLuong()!=null){
                    cv1.setStt("1");
                    insertThongTin(cv1);
                }
                if(cv2.getLuong()!=null){
                    cv2.setStt("2");
                    insertThongTin(cv2);
                }
                if(cv3.getLuong()!=null){
                    cv3.setStt("3");
                    insertThongTin(cv3);
                }
            }
            
            
            
            fis.close();
        } catch (IOException e) {
            e.printStackTrace();JOptionPane.showMessageDialog(null, "Lỗi");
        }
    }
    public void insertThongTin(CongViec cv){
       Connection connection = DBConnection.getConnection();
        String sql ="INSERT INTO congviec(cmnd, stt, batdau, ketthuc, tencongty, diachi, congviec, luong) VALUEs  (?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement preparedStatement =connection.prepareStatement(sql);
            preparedStatement.setString(1, cv.getCmnd());
            preparedStatement.setString(2, cv.getStt());
            preparedStatement.setString(3, cv.getBatdau());
            preparedStatement.setString(4, cv.getKetthuc());
            preparedStatement.setString(5, cv.getTencongty());
            preparedStatement.setString(6, cv.getDiachi());
            preparedStatement.setString(7, cv.getCongviec());
            preparedStatement.setString(8, cv.getLuong());
           
            int rs=preparedStatement.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(CongViecUser.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void delete(){
        Connection connection = DBConnection.getConnection();
        String sql="Delete from congviec where 1";
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement(sql);
            int rs=preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(CongViecUser.class.getName()).log(Level.SEVERE, null, ex);
        }
                       
    }
    public static void main(String[] args) throws IOException {
        CongViecUser user=new CongViecUser();
        String fileName="C:\\Users\\Nhat Anh\\Desktop\\btt.xlsx";
        user.readFile(fileName);
//        user.delete();
    }
}
