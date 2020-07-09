package com.gouzal.iquote.seeder;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class DatabaseSeeder {

    private final UserSeeder userSeeder;
    @Value("${myapp.seeder.start:false}")
    private boolean enable;

    @Autowired
    public DatabaseSeeder(UserSeeder userSeeder) {
        this.userSeeder = userSeeder;
    }

    @EventListener
    public void seed(ContextRefreshedEvent event) {
        if (enable) {
            this.runSeeders();
        }

    }

    public void runSeeders() {
        this.userSeeder.run();
        log.info("SEEDER IS FINISHED");
    }

}
