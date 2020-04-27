package com.jk.docker.bootnmysql;

import com.jk.docker.bootnmysql.entity.User;
import com.jk.docker.bootnmysql.service.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class BootnmysqlApplicationTests {

    @Autowired
    private UserRepository userRepository;

    @Test
    void contextLoads() {
        User user = userRepository.findById((long) 1).orElse(new User());
        
        System.out.println("J Tag");
    }

}
