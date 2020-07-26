package com.gouzal.iquote.seeder;

import com.gouzal.iquote.model.Author;
import com.gouzal.iquote.model.Quote;
import com.gouzal.iquote.model.Tag;
import com.gouzal.iquote.model.User;
import com.gouzal.iquote.service.Impl.AuthorService;
import com.gouzal.iquote.service.Impl.QuoteService;
import com.gouzal.iquote.service.Impl.TagService;
import com.gouzal.iquote.service.Impl.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

@Component
public class QuoteSeeder extends AbstractTableSeeder {
    final private QuoteService quoteService;
    final private AuthorService authorService;
    final private UserService userService;
    final private TagService tagService;

    @Autowired
    public QuoteSeeder(QuoteService quoteService, AuthorService authorService, UserService userService, TagService tagService) {
        this.quoteService = quoteService;
        this.authorService = authorService;
        this.userService = userService;
        this.tagService = tagService;
    }

    @Override
    public void run() {
        this.quoteService.truncate();
        List<Author> authors = authorService.findAll();
        List<User> users = userService.findAll();
        List<Tag> tags = tagService.findAll();
        for (int i = 0; i < 30; i++) {
            Quote quote = new Quote();
            quote.setAuthor(authors.get(faker.random().nextInt(0, authors.size() - 1)));
            quote.setUser(users.get(faker.random().nextInt(0, users.size() - 1)));
            String citation = faker.lorem().paragraph();
            quote.setCitation(citation.substring(0, Math.min(citation.length(), 200)));
            quote.setVisible(true);
            quote.setCreatedAt(faker.date().past(3, TimeUnit.DAYS));
            quote.setTags(this.assignTags(tags));
            quoteService.save(quote);
        }
    }

    private List<Tag> assignTags(List<Tag> tags) {
        Random rand = new Random();
        HashMap<Long, Tag> tagHashMap = new HashMap<Long, Tag>();
        int max = rand.nextInt(tags.size());
        for (int i = 0; i < max; i++) {
            int randomIndex = rand.nextInt(tags.size());
            Tag tag = tags.get(randomIndex);
            tagHashMap.put(tag.getId(), tag);
        }
        return Collections.list(Collections.enumeration(tagHashMap.values()));
    }
}
