package com.baizhi.service;

import javax.servlet.http.HttpSession;
import java.util.Map;

public interface AdminService {
    Map<String,Object> login(String username, String password, String code, HttpSession session);
}
