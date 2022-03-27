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
import model.TinhTrangSucKhoe;
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
public class TinhTrangSucKhoeUser {
     XSSFRow row; 
     public TinhTrangSucKhoe getAllUsers(String cmnd){
        TinhTrangSucKhoe tinhtrangsuckhoe = new TinhTrangSucKhoe(); 
        
        Connection connection = DBConnection.getConnection();
           String sql ="SELECT * FROM tinhtrangsuckhoe where cmnd=?";
           try{
               PreparedStatement preparedStatement = connection.prepareStatement(sql);
               preparedStatement.setString(1, cmnd);
               ResultSet rs = preparedStatement.executeQuery();                 
               while (rs.next()){
                                     
                  tinhtrangsuckhoe.setCmnd(rs.getString("cmnd"));
                  tinhtrangsuckhoe.setChieucao(rs.getString("chieucao"));
                  tinhtrangsuckhoe.setCannang(rs.getString("cannang"));
                  tinhtrangsuckhoe.setNhommau(rs.getString("nhommau"));
                  tinhtrangsuckhoe.setTaythuan(rs.getString("taythuan"));
                  tinhtrangsuckhoe.setMattrai(rs.getString("mattrai"));
                  tinhtrangsuckhoe.setMatphai(rs.getString("matphai"));
                  tinhtrangsuckhoe.setDeokinh(rs.getString("deokinh"));
                  tinhtrangsuckhoe.setMumau(rs.getString("mumau"));
                  tinhtrangsuckhoe.setDiung(rs.getString("diung"));
                  tinhtrangsuckhoe.setHutthuoc(rs.getString("hutthuoc"));
                  tinhtrangsuckhoe.setRuou(rs.getString("ruou"));
                  tinhtrangsuckhoe.setHinhxam(rs.getString("hinhxam"));
                  tinhtrangsuckhoe.setPhauthuat(rs.getString("phauthuat"));
                  tinhtrangsuckhoe.setTaytrai(rs.getString("taytrai"));
                  tinhtrangsuckhoe.setTayphai(rs.getString("tayphai"));
                                                  
               }
           }catch (SQLException e){
             Logger.getLogger(TinhTrangSucKhoeUser.class.getName()).log(Level.SEVERE, null, e);
           }
       return tinhtrangsuckhoe;
                
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
            List<TinhTrangSucKhoe> list=new ArrayList<TinhTrangSucKhoe>();
            rowIterator.next();
            while (rowIterator.hasNext()) {
                TinhTrangSucKhoe tt=new TinhTrangSucKhoe();
                row = (XSSFRow) rowIterator.next();
                Iterator< Cell> cellIterator = row.cellIterator();
                   for(int i=0;i<10;i++)cellIterator.next();
                   
                while (cellIterator.hasNext()) {
                    Cell cell = cellIterator.next();
                    cell.setCellType(CellType.STRING);
                    if(cell.getColumnIndex()==10) tt.setCmnd(cell.getStringCellValue());
                    if(cell.getColumnIndex()<22)continue;
                    switch (cell.getColumnIndex()) {
                        
                        case 22:
                            
                            tt.setChieucao(cell.getStringCellValue());
                            break;
                        case 23:
                            tt.setCannang(cell.getStringCellValue());
                             break;
                        case 24:
                            
                            tt.setNhommau(cell.getStringCellValue());
                             break;
                        case 25:
                            tt.setTaythuan(cell.getStringCellValue());
                             break;
                        case 26:
                            tt.setMattrai(cell.getStringCellValue());
                             break;
                        case 27:
                            tt.setMatphai(cell.getStringCellValue());
                             break;     
                        case 28:
                            tt.setDeokinh(cell.getStringCellValue());
                             break;     
                       case 29:
                            tt.setMumau(cell.getStringCellValue());
                             break;      
                        case 30:
                            tt.setDiung(cell.getStringCellValue());
                             break;     
                        case 31:
                            tt.setHutthuoc(cell.getStringCellValue());
                             break;     
                       case 32:
                            tt.setRuou(cell.getStringCellValue());
                             break;      
                        case 33:
                            tt.setHinhxam(cell.getStringCellValue());
                             break;     
                        case 34:
                            tt.setPhauthuat(cell.getStringCellValue());
                             break;                  
                        case 35:
                            tt.setTaytrai(cell.getStringCellValue());
                             break;     
                        case 36:
                            tt.setTayphai(cell.getStringCellValue());
                             break;     
                      
                    }
                }
                insertThongTin(tt);
            }
            
            fis.close();
        } catch (IOException e) {
            e.printStackTrace();JOptionPane.showMessageDialog(null, "Lỗi");
        }
    }
    public void insertThongTin(TinhTrangSucKhoe ttsk){
       Connection connection = DBConnection.getConnection();
        String sql ="INSERT INTO tinhtrangsuckhoe(cmnd, chieucao, cannang, nhommau, taythuan, mattrai, matphai, deokinh,mumau,diung,hutthuoc,ruou,hinhxam,phauthuat,taytrai,tayphai) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement preparedStatement =connection.prepareStatement(sql);
            preparedStatement.setString(1, ttsk.getCmnd());
            preparedStatement.setString(2, ttsk.getChieucao());
            preparedStatement.setString(3, ttsk.getCannang());
            preparedStatement.setString(4, ttsk.getNhommau());
            preparedStatement.setString(5, ttsk.getTaythuan());
            preparedStatement.setString(6, ttsk.getMattrai());
            preparedStatement.setString(7, ttsk.getMatphai());
            preparedStatement.setString(8, ttsk.getDeokinh());
            preparedStatement.setString(9, ttsk.getMumau());
            preparedStatement.setString(10, ttsk.getDiung());
            preparedStatement.setString(11, ttsk.getHutthuoc());
            preparedStatement.setString(12, ttsk.getRuou());
            preparedStatement.setString(13, ttsk.getHinhxam());
            preparedStatement.setString(14, ttsk.getPhauthuat());
            preparedStatement.setString(15, ttsk.getTaytrai());
            preparedStatement.setString(16, ttsk.getTayphai());
           
            int rs=preparedStatement.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(TinhTrangSucKhoeUser.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void delete(){
        Connection connection = DBConnection.getConnection();
        String sql="Delete from tinhtrangsuckhoe where 1";
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement(sql);
            int rs=preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(CongViecUser.class.getName()).log(Level.SEVERE, null, ex);
        }
                       
    }
    public static void main(String[] args) throws IOException {
        TinhTrangSucKhoeUser user=new TinhTrangSucKhoeUser();
         String fileName="C:\\Users\\Nhat Anh\\Desktop\\btt.xlsx";
        user.readFile(fileName);
    }
}
