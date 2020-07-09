package com.gouzal.iquote.seeder;

import com.gouzal.iquote.model.Author;
import com.gouzal.iquote.model.Quote;
import com.gouzal.iquote.model.User;
import com.gouzal.iquote.service.AuthorService;
import com.gouzal.iquote.service.QuoteService;
import com.gouzal.iquote.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.TimeUnit;

@Component
public class QuoteSeeder extends AbstractTableSeeder {
    final private QuoteService quoteService;
    final private AuthorService authorService;
    final private UserService userService;

    @Autowired
    public QuoteSeeder(QuoteService quoteService, AuthorService authorService, UserService userService) {
        this.quoteService = quoteService;
        this.authorService = authorService;
        this.userService = userService;
    }

    @Override
    public void run() {
        List<Author> authors = authorService.findAll();
        List<User> users = userService.findAll();
        for (int i = 0; i < 30; i++) {
            Quote quote = new Quote();
            quote.setAuthor(authors.get(faker.random().nextInt(0, authors.size() - 1)));
            quote.setUser(users.get(faker.random().nextInt(0, users.size() - 1)));
            quote.setCitation(faker.lorem().paragraph());
            quote.setVisible(true);
            quote.setCreatedAt(faker.date().past(3, TimeUnit.DAYS));
            quoteService.save(quote);
        }
    }
}
