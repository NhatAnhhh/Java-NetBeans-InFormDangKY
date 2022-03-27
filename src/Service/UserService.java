/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Access.ThongTinCaNhanDAO;
import java.sql.SQLException;
import java.util.List;
import model.ThongTinCaNhan;

/**
 *
 * @author Nhat Anh
 */
public class UserService {
    private ThongTinCaNhanDAO userDao;
    
    public UserService(){
        userDao = new ThongTinCaNhanDAO();
    }
    
    public List<ThongTinCaNhan> getAllUsers(){
        return userDao.getAllUsers();
    }
}
