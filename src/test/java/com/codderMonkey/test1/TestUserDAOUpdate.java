
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
public class TestUserDAOUpdate {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringRootConfig.class);
        UserDAO userDAO = ctx.getBean(UserDAO.class);
        User u = new User();
        u.setUserId(5);
        u.setName("surne");
        u.setPhone("9812610");
        u.setEmail("thulle.surje@gmail.com");
        u.setAddress("Jali Gau");
        u.setRole(1);//for admin
        u.setLoginStatus(1);//active
        
        userDAO.update(u);
        System.out.println("-------------------------------------Updated Successfully----------------------------");
        
        
    }
    
}
