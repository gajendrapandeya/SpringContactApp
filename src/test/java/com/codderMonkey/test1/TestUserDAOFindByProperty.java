
package com.codderMonkey.test1;

import java.util.Collection.*;
import com.codderMonkey.config.SpringRootConfig;
import com.codderMonkey.dao.UserDAO;
import com.codderMonkey.domain.User;
import java.util.List;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 *
 * @author gajen
 */
public class TestUserDAOFindByProperty {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringRootConfig.class);
        UserDAO userDAO = ctx.getBean(UserDAO.class);
        List<User> users = userDAO.findByProperty("name", "virat");
        System.out.println("-------------------------------------User List----------------------------");
        
        for(User u: users) {
            System.out.println(u.getUserId());
            System.out.println(u.getName());
             System.out.println(u.getEmail());
              System.out.println(u.getRole());
          
        }
        
        
        
    }
    
}
