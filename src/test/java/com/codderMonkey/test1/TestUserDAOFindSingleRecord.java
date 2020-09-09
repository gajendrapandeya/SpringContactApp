
package com.codderMonkey.test1;

import com.codderMonkey.config.SpringRootConfig;
import com.codderMonkey.dao.UserDAO;
import com.codderMonkey.domain.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 *
 * @author gajen
 */
public class TestUserDAOFindSingleRecord {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringRootConfig.class);
        UserDAO userDAO = ctx.getBean(UserDAO.class);
        User u = userDAO.findById(7);
        System.out.println("-------------------------------------User List----------------------------");
        System.out.println(u.getUserId());
        System.out.println(u.getName());
        System.out.println(u.getEmail());
        System.out.println(u.getPhone());
        System.out.println(u.getAddress());
        System.out.println(u.getLoginName());
        System.out.println(u.getRole());
        System.out.println(u.getLoginStatus());
        
        
        
        
    }
    
}
