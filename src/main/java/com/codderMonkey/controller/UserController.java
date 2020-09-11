
package com.codderMonkey.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author gajen
 */
@Controller
public class UserController {
    
    @RequestMapping(value = {"/","/index"})
    public String index() {
        return "index";
    }
    
}
