package com.syica.statistics.controller;

import com.syica.statistics.bean.User;
import com.syica.statistics.config.PassToken;
import com.syica.statistics.service.TokenService;
import com.syica.statistics.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class LoginController {

    @Autowired
    private UserService userService;

    @Autowired
    private TokenService tokenService;

    @PassToken
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public Map<String, Object> login(@RequestBody Map map) {
        Map<String, Object> result = new HashMap<>();
        String username = (String) map.get("username");
        String password = (String) map.get("password");
        if (username != null && username != "" && password != null && password != "") {
            password = DigestUtils.md5DigestAsHex(password.getBytes());
            User user = this.userService.findByUsernameAndPassword(username, password);
            if (user == null) {
                result.put("code", 2);
                result.put("message", "do not has this user");
            } else {
                // 生成token返回给前端
                String token = this.tokenService.getToken(user);
                result.put("code", 0);
                result.put("message", "success");
                result.put("token", token);
                result.put("userId", user.getId());
            }
        } else {
            result.put("code", 1);
            result.put("message", "params has null");
        }
        return result;
    }
}
