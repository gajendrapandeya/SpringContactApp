
package com.codderMonkey.test1;

import com.codderMonkey.config.SpringRootConfig;
import com.codderMonkey.dao.UserDAO;
import com.codderMonkey.domain.User;
import com.codderMonkey.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 *
 * @author gajen
 */
public class TestUserServiceRegister {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringRootConfig.class);
        UserService userService = ctx.getBean(UserService.class);
        User u = new User();
        u.setName("xxx");
        u.setPhone("610150");
        u.setEmail("xx@gmail.com");
        u.setAddress("XXXX");
        u.setLoginName("XA");
        u.setPassword("AX");
        u.setRole(UserService.ROLE_ADMIN);
        u.setLoginStatus(UserService.LOGIN_STATUS_ACTIVE);
        
        userService.register(u);
        System.out.println("-------------------------------------User Registered Successfully----------------------------");
        
        
    }
    
}
