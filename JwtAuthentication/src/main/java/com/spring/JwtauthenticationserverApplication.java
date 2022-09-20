package com.spring ;
import org.springframework.beans.factory.annotation.Autowired;  
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import com.spring.dao.UserRepository;
import com.spring.entity.User;

import java.util.Random;

@SpringBootApplication
@ComponentScan(basePackages = "com.spring")
public class JwtauthenticationserverApplication implements  CommandLineRunner  {

    @Autowired
    private UserRepository userRepository;

    Random random = new Random();

    public void createUsers() {

        User user = new User();
        int id =  random.nextInt(100);
        user.setId(id);
        user.setUserEmail("user" +id+"@gmail.com");
        user.setUserName("user" +id);
        user.setUserPassword("user"+id+"123");
        user.setUserProfile("Developer");
        User save = this.userRepository.save(user);

        System.out.println(save);

    }

    public static void main(String[] args) {
        SpringApplication.run(JwtauthenticationserverApplication.class, args);

    }


    @Override
    public void run(String... args) throws Exception {
        createUsers();
    }
}
