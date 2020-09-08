
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
public class TestUserDAOSave {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringRootConfig.class);
        UserDAO userDAO = ctx.getBean(UserDAO.class);
        User u = new User();
        u.setName("Suraj");
        u.setPhone("9812610150");
        u.setEmail("surje@gmail.com");
        u.setAddress("Jali");
        u.setLoginName("Surje");
        u.setPassword("thulle");
        u.setRole(1);//for admin
        u.setLoginStatus(1);//active
        
        userDAO.save(u);
        System.out.println("-------------------------------------Saved Successfully----------------------------");
        
        
    }
    
}
