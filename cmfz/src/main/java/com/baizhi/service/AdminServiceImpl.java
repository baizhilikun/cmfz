package com.baizhi.service;

import com.baizhi.dao.AdminDao;
import com.baizhi.entity.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;


@Service
@Transactional
public class AdminServiceImpl implements AdminService {
    @Autowired
    AdminDao adminDao;

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public Map<String, Object> login(String username, String password, String yzm, HttpSession session) {
        HashMap<String, Object> map = new HashMap<>();
        String code1 = (String) session.getAttribute("code");
        System.out.println(code1+"1231232123213212312");
        System.out.println(yzm+"1111111111111111111111111111");
        if (yzm.equals(code1)){
            Admin admin = adminDao.login(username);
            if (admin !=null){
                if (password.equals(admin.getPassword())){
                    map.put("msg","ok");
                    return map;
                }else {
                    map.put("msg","您输入的密码错误，请重新输入！");
                    return map;
                }
            }else {
                map.put("msg","此用户不存在");
                return map;
            }
        }else {
            map.put("msg","验证码错误");
            return map;
        }
    }
}
