
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
public class TestUserDAODelete {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringRootConfig.class);
        UserDAO userDAO = ctx.getBean(UserDAO.class);
        userDAO.delete(3);
        System.out.println("-------------------------------------deleted Successfully----------------------------");
        
        
    }
    
}
