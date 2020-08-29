package user.database.management;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import user.database.management.repository.UserRepository;


import javax.transaction.Transactional;

@SpringBootTest
@Transactional
public class UserApplication {

    @Autowired
    UserRepository catRepository;
}
