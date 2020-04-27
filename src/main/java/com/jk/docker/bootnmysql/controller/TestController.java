package com.jk.docker.bootnmysql.controller;

import com.jk.docker.bootnmysql.entity.JsonResult;
import com.jk.docker.bootnmysql.entity.User;
import com.jk.docker.bootnmysql.service.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TestController {

    private final UserRepository userRepository;

    @Autowired
    public TestController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @ResponseBody
    @RequestMapping(value = "/get")
    public JsonResult get (@RequestParam(value = "id") Long id) {
        try {
            User user = userRepository.findById(id).orElse(null);

            return JsonResult.success(user);
        } catch (Exception ex) {
            return JsonResult.fail(ex.getMessage());
        }
    }

    @ResponseBody
    @RequestMapping(value = "/saveOrUpdate")
    public JsonResult saveOrUpdate (
            @RequestParam(value = "id", required = false) Long id,
            @RequestParam(value = "age", required = false, defaultValue = "-1") int age,
            @RequestParam(value = "name", required = false) String name) {
        try {
            User user = userRepository.findById(id).orElse(new User());

            if (age != -1) {
                user.setAge(age);
            }

            if (StringUtils.hasText(name)) {
                user.setName(name);
            }

            userRepository.saveAndFlush(user);

            return JsonResult.success();
        } catch (Exception ex) {
            return JsonResult.fail(ex.getMessage());
        }
    }
}
