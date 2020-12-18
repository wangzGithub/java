package com.syica.statistics.controller;

import com.syica.statistics.bean.User;
import com.syica.statistics.config.CheckToken;
import com.syica.statistics.config.PassToken;
import com.syica.statistics.service.TokenService;
import com.syica.statistics.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class TestController {

    @Autowired
    private UserService userService;

    @Autowired
    private TokenService tokenService;

    @CheckToken
    @RequestMapping("/getMessage")
    public String getMessage() {
        return "token验证通过";
    }

    @PassToken
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public Map<String, Object> login(@RequestBody Map map) {
        Map<String, Object> result = new HashMap<>();
        Map<String, String> params = (Map) map.get("params");
        String username = params.get("username");
        String password = params.get("password");
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
            }
        } else {
            result.put("code", 1);
            result.put("message", "params has null");
        }
        return result;
    }

}
