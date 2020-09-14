
package com.codderMonkey.controller;

import com.codderMonkey.command.LoginCommand;
import com.codderMonkey.command.UserCommand;
import com.codderMonkey.domain.User;
import com.codderMonkey.exception.UserBlockedException;
import com.codderMonkey.service.UserService;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author gajen
 */
@Controller
public class UserController {
    
    @Autowired
    private UserService userService;
    
    @RequestMapping(value = {"/","/index"})
    public String index(Model m) {
        m.addAttribute("command", new LoginCommand());
        return "index";
    }
    
    @RequestMapping(value = "/login", method=RequestMethod.POST)
    public String handleLogin(@ModelAttribute("command") LoginCommand cmd, Model m, HttpSession session) {
       
        try {
            User loggedInUser = userService.login(cmd.getLoginName(), cmd.getPassword());
            if(loggedInUser == null) {
                 //FAILED
                //add error message and go back to login-form
                
                m.addAttribute("err", "Login Failed!. Enter valid Credentials");
                return "index";
            } else //SUCCESS
            //check the role and redirect to a appropriate dashboard 
            {
                if(loggedInUser.getRole().equals(UserService.ROLE_ADMIN)) {
                    //add user detail in session (assign session to logged in user)
                    addUserInSession(loggedInUser, session);
                    return "redirect:admin/dashboard";
                } else if(loggedInUser.getRole().equals(UserService.ROLE_USER)) {
                    //add user detail in session (assign session to logged in user)
                    addUserInSession(loggedInUser, session);
                    return "redirect:user/dashboard";
                } else {
                    //add error message and go back to login-form
                    m.addAttribute("err", "Invalid User Role");
                    return "index";
                }
            }
        } catch (UserBlockedException ex) {
            m.addAttribute("err", ex.getMessage());
            return "index";
        }

    }
    
    @RequestMapping(value = "/user/dashboard")
    public String userDashboard() {
        return "dashboard_user";
    }
    
      @RequestMapping(value = "/admin/dashboard")
    public String adminDashboard() {
        return "dashboard_admin";
    }
    
    @RequestMapping(value = "/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:index?act=lo";
    }
    
    private void addUserInSession(User u, HttpSession session) {
        
        session.setAttribute("user", u);
        session.setAttribute("userId", u.getUserId());
        session.setAttribute("role", u.getRole());
    }
    
    @RequestMapping(value = "/reg_form")
    public String registrationForm(Model m) {
        UserCommand cmd = new UserCommand();
        m.addAttribute("command", cmd);
        return "reg_form";
    }
    
    @RequestMapping(value = "/register")
    public String registerUser(@ModelAttribute("command") UserCommand cmd, Model m) {
        User user = cmd.getUser();
        user.setRole(UserService.ROLE_USER);
        user.setLoginStatus(UserService.LOGIN_STATUS_ACTIVE);
        userService.register(user);
        return "redirect:index?act=reg";
    }
    
}
