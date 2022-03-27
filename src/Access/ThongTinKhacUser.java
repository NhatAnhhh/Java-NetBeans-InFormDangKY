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
import model.ThongTinCaNhan;
import model.ThongTinKhac;
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
public class ThongTinKhacUser {
    XSSFRow row;  
    public ThongTinKhac getAllUsers(String cmnd){
        ThongTinKhac thongtinkhac = new ThongTinKhac();
        
        Connection connection = DBConnection.getConnection();
           String sql ="SELECT * FROM thongtinkhac where cmnd=?";
           try{
               PreparedStatement preparedStatement = connection.prepareStatement(sql);
               preparedStatement.setString(1, cmnd);
               ResultSet rs = preparedStatement.executeQuery();              
               while (rs.next()){
                                   
                   thongtinkhac.setCmnd(rs.getString("cmnd"));
                   thongtinkhac.setNguoithan(rs.getString("nguoithan"));
                   thongtinkhac.setDennhat(rs.getString("dennhat"));
                   thongtinkhac.setDinhatgd(rs.getString("dinhatgd"));
                   thongtinkhac.setLolang(rs.getString("lolang"));
                   thongtinkhac.setConguoiquendk(rs.getString("conguoiquendk"));
                   thongtinkhac.setBietdgquadau(rs.getString("bietdgquadau"));
                  thongtinkhac.setHotennguoiquen(rs.getString("hotennguoiquen"));
                  thongtinkhac.setKytucxa(rs.getString("kytucxa"));
                  thongtinkhac.setNganh(rs.getString("nganh"));
                                                   
               }
           }catch (SQLException e){
             Logger.getLogger(ThongTinKhacUser.class.getName()).log(Level.SEVERE, null, e);
           }
       return thongtinkhac;
                
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
            List<ThongTinKhac> list=new ArrayList<ThongTinKhac>();
            rowIterator.next();
            while (rowIterator.hasNext()) {
                ThongTinKhac tt=new ThongTinKhac();
                row = (XSSFRow) rowIterator.next();
                Iterator< Cell> cellIterator = row.cellIterator();
                   cellIterator.next();
                while (cellIterator.hasNext()) {
                    Cell cell = cellIterator.next();
                    cell.setCellType(CellType.STRING);
                    if(cell.getColumnIndex()==10) 
                    {
                        tt.setCmnd(cell.getStringCellValue());
                    }
                    if(cell.getColumnIndex()<103) continue;
                    switch (cell.getColumnIndex()) {
                        
                        
                        case 103:
                            tt.setLolang(cell.getStringCellValue());
                             break;
                        case 104:
                            tt.setConguoiquendk(cell.getStringCellValue());
                             break;
                        case 105:
                            tt.setBietdgquadau(cell.getStringCellValue());
                             break;
                        case 106:
                            tt.setHotennguoiquen(cell.getStringCellValue());
                             break;     
                        case 107:
                            tt.setKytucxa(cell.getStringCellValue());
                             break;     
                       case 108:
                            tt.setNganh(cell.getStringCellValue());
                             break;      
                           
                        case 109:
                            tt.setNguoithan(cell.getStringCellValue());
                             break;
                        case 110:
                            tt.setDennhat(cell.getStringCellValue());
                             break;
                        case 111:
                            tt.setDinhatgd(cell.getStringCellValue());
                             break;     
                             
                       
                    }
                }
                if(tt.getCmnd()!=null)
                insertThongTin(tt);
                list.add(tt);
            }
            
            fis.close();
        } catch (IOException e) {
            e.printStackTrace();JOptionPane.showMessageDialog(null, "Lỗi");
        }
    }
    public void insertThongTin(ThongTinKhac ttk){
       Connection connection = DBConnection.getConnection();
        String sql ="INSERT INTO thongtinkhac(nguoithan,dennhat,dinhatgd,lolang,conguoiquendk,bietdgquadau,hotennguoiquen,kytucxa,nganh,cmnd) VALUES (?,?,?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement preparedStatement =connection.prepareStatement(sql);
            
            preparedStatement.setString(1, ttk.getNguoithan());
            preparedStatement.setString(2, ttk.getDennhat());
            preparedStatement.setString(3, ttk.getDinhatgd());
            preparedStatement.setString(4, ttk.getLolang());
            preparedStatement.setString(5, ttk.getConguoiquendk());
            preparedStatement.setString(6, ttk.getBietdgquadau());
            preparedStatement.setString(7, ttk.getHotennguoiquen());
            preparedStatement.setString(8, ttk.getKytucxa());
            preparedStatement.setString(9, ttk.getNganh());
            preparedStatement.setString(10, ttk.getCmnd());
            
            int rs=preparedStatement.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(ThongTinKhacUser.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void delete(){
        Connection connection = DBConnection.getConnection();
        String sql="Delete from thongtinkhac where 1";
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement(sql);
            int rs=preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(CongViecUser.class.getName()).log(Level.SEVERE, null, ex);
        }
                       
    }
    public static void main(String[] args) throws IOException {
        ThongTinKhacUser user=new ThongTinKhacUser();
        String fileName="C:\\Users\\Nhat Anh\\Desktop\\btt.xlsx";
//        user.readFile(fileName);
        user.getAllUsers("1");
        System.out.println(user.getAllUsers("312596013").getCmnd());
    }
}
