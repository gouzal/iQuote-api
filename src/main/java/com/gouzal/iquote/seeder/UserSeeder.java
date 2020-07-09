package com.gouzal.iquote.seeder;

import com.gouzal.iquote.model.User;
import com.gouzal.iquote.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserSeeder extends AbstractTableSeeder {
    final private UserService userService;

    @Autowired
    public UserSeeder(UserService userService) {
        this.userService = userService;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            User user = new User();
            user.setEmail(faker.internet().emailAddress());
            user.setImage(faker.number().digits(10) + ".png");
            user.setPassword("pass");
            user.setUserName(faker.name().username());
            user.setEnable(true);
            user.setLock(false);
            user.setBirthdayDate(faker.date().birthday(18, 65));
            user.setFirstName(faker.name().firstName());
            user.setLastName(faker.name().lastName());
        }
    }
}
