package user.database.management;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import user.database.management.repository.UserRepository;


import javax.transaction.Transactional;

@SpringBootApplication
@Transactional
public class UserApplication {

  // @Autowired
    //UserRepository userRepository;

    public static void main(String[] args) {
        SpringApplication s=new SpringApplication();
        s.run(UserApplication.class);
    }
}
