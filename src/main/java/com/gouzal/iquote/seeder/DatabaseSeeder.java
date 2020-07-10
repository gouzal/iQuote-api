package com.gouzal.iquote.seeder;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Slf4j
@Component
public class DatabaseSeeder {

    private final RoleSeeder roleSeeder;
    private final UserSeeder userSeeder;
    private final TagSeeder tagSeeder;
    private final QuoteSeeder quoteSeeder;
    private final AuthorSeeder authorSeeder;
    @Value("${myapp.seeder.start:false}")
    private boolean enable;

    @Autowired
    public DatabaseSeeder(RoleSeeder roleSeeder, UserSeeder userSeeder, TagSeeder tagSeeder, QuoteSeeder quoteSeeder, AuthorSeeder authorSeeder) {
        this.roleSeeder = roleSeeder;
        this.userSeeder = userSeeder;
        this.tagSeeder = tagSeeder;
        this.quoteSeeder = quoteSeeder;
        this.authorSeeder = authorSeeder;
    }

    /*@EventListener
    public void seed(ContextRefreshedEvent event) {
        if (enable) {
            this.runSeeders();
        }

    }*/

    @PostConstruct
    public void runSeeders() {
        this.roleSeeder.run();
        this.userSeeder.run();
        this.tagSeeder.run();
        this.authorSeeder.run();
        this.quoteSeeder.run();
        log.info("SEEDER IS FINISHED");
    }

}
