package com.gouzal.iquote.seeder;

import com.gouzal.iquote.model.Author;
import com.gouzal.iquote.service.Impl.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AuthorSeeder extends AbstractTableSeeder {
    final private AuthorService authorService;

    @Autowired
    public AuthorSeeder(AuthorService authorService) {
        this.authorService = authorService;
    }

    @Override
    public void run() {
        for (int i = 0; i < 4; i++) {
            Author author = new Author();
            author.setFullName(faker.name().fullName());
            this.authorService.save(author);
        }
    }
}
