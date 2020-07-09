package com.gouzal.iquote.seeder;

import com.github.javafaker.Faker;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Locale;
import java.util.Random;

public abstract class AbstractTableSeeder {
    final protected Logger log = LoggerFactory.getLogger(AbstractTableSeeder.class);
    final protected Faker faker = new Faker(new Locale("fr"));
    final protected Random rand = new Random();

    public abstract void run();
}
