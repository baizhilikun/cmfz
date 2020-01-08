package com.baizhi.controller;

import com.baizhi.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.Map;

@RestController
@RequestMapping("Admin")
public class AdminController {
    @Autowired
    private AdminService adminService;

    @ResponseBody
    @RequestMapping("login")
    public Map<String,Object> login(String username, String password, String yzm, HttpSession session){
        Map<String, Object> map = adminService.login(username, password, yzm, session);
        System.out.println(map);
        return map;
    }
}
