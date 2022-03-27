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
import model.DacTinhCaNhan;
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
public class DacTinhCaNhanUser {
    XSSFRow row;  
     public DacTinhCaNhan getAllUsers(String cmnd){
        DacTinhCaNhan dactinhcanhan = new DacTinhCaNhan();                   
        
        Connection connection = DBConnection.getConnection();
           String sql ="SELECT * FROM dactinhcanhan where cmnd=?";
           try{
              PreparedStatement preparedStatement = connection.prepareStatement(sql);
               preparedStatement.setString(1, cmnd);
               ResultSet rs = preparedStatement.executeQuery();           
               while (rs.next()){
                   
                   dactinhcanhan.setCmnd(rs.getString("cmnd"));
                   dactinhcanhan.setMucdich(rs.getString("mucdich"));
                   dactinhcanhan.setDiemmanh(rs.getString("diemmanh"));
                   dactinhcanhan.setDiemyeu(rs.getString("diemyeu"));
                   dactinhcanhan.setSothich(rs.getString("sothich"));
                   dactinhcanhan.setVenuoclamgi(rs.getString("venuoclamgi"));
                   dactinhcanhan.setVenuocnhat(rs.getString("venuocnhat"));
                   dactinhcanhan.setSotien3nam(rs.getString("sotien3nam")); 
                   dactinhcanhan.setGuiveque(rs.getString("guiveque"));
                   
               }
           }catch (SQLException e){
             Logger.getLogger(DacTinhCaNhanUser.class.getName()).log(Level.SEVERE, null, e);
           }
       return dactinhcanhan;
                
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
            List<DacTinhCaNhan> list=new ArrayList<DacTinhCaNhan>();
            rowIterator.next();
            while (rowIterator.hasNext()) {
                DacTinhCaNhan tt=new DacTinhCaNhan();
                row = (XSSFRow) rowIterator.next();
                Iterator< Cell> cellIterator = row.cellIterator();
                   for(int i=0;i<10;i++)cellIterator.next();
                while (cellIterator.hasNext()) {
                    Cell cell = cellIterator.next();
                    cell.setCellType(CellType.STRING);
                    if(cell.getColumnIndex()==10) 
                    {
                        
                        tt.setCmnd(cell.getStringCellValue());
                        
                    }
                    if(cell.getColumnIndex()<37)continue;
                    switch (cell.getColumnIndex()) {
                        
                        case 37:
                            
                            tt.setMucdich(cell.getStringCellValue());
                            break;
                        case 38:
                            tt.setDiemmanh(cell.getStringCellValue());
                             break;
                        case 39:
                            tt.setDiemyeu(cell.getStringCellValue());
                             break;
                        case 40:
                            tt.setSothich(cell.getStringCellValue());
                             break;
                        case 41:
                            tt.setVenuoclamgi(cell.getStringCellValue());
                             break;
                        case 42:
                            tt.setVenuocnhat(cell.getStringCellValue());
                             break;     
                        case 43:
                            tt.setSotien3nam(cell.getStringCellValue());
                             break;     
                       case 44:
                            tt.setGuiveque(cell.getStringCellValue());
                             break;      
                        
                    }
                }
                
                insertThongTin(tt);
                list.add(tt);
            }
           
            fis.close();
        } catch (IOException e) {
            e.printStackTrace();JOptionPane.showMessageDialog(null, "Lỗi");
        }
    }
    public void insertThongTin(DacTinhCaNhan dtcn){
       Connection connection = DBConnection.getConnection();
        String sql ="INSERT INTO dactinhcanhan(cmnd, mucdich, diemmanh , diemyeu, sothich, venuoclamgi, venuocnhat, sotien3nam,guiveque) VALUES (?,?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement preparedStatement =connection.prepareStatement(sql);
            preparedStatement.setString(1, dtcn.getCmnd());
            preparedStatement.setString(2, dtcn.getMucdich());
            preparedStatement.setString(3, dtcn.getDiemmanh());
            preparedStatement.setString(4, dtcn.getDiemyeu());
            preparedStatement.setString(5, dtcn.getSothich());
            preparedStatement.setString(6, dtcn.getVenuoclamgi());
            preparedStatement.setString(7, dtcn.getVenuocnhat());
            preparedStatement.setString(8, dtcn.getSotien3nam());
            preparedStatement.setString(9, dtcn.getGuiveque());
            
            int rs=preparedStatement.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(DacTinhCaNhanUser.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void delete(){
        Connection connection = DBConnection.getConnection();
        String sql="Delete from dactinhcanhan where 1";
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement(sql);
            int rs=preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DacTinhCaNhanUser.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public static void main(String[] args) throws IOException {
        DacTinhCaNhanUser user=new DacTinhCaNhanUser();
        String fileName="C:\\Users\\Nhat Anh\\Desktop\\btt.xlsx";
        user.readFile(fileName);
//        System.out.println(user.getAllUsers("123456789").getDiemmanh());
    }
}
