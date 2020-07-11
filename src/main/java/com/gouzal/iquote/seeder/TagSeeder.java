package com.gouzal.iquote.seeder;

import com.gouzal.iquote.model.Tag;
import com.gouzal.iquote.service.Impl.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TagSeeder extends AbstractTableSeeder {
    final private TagService tagService;

    @Autowired
    public TagSeeder(TagService tagService) {
        this.tagService = tagService;
    }

    @Override
    public void run() {
        final String[] tags = {"love", "life", "happiness", "friendship", "sadness", "sex", "religion", "philosophy"};
        for (int i = 0; i < tags.length; i++) {
            Tag tag = new Tag();
            tag.setValue(tags[i]);
            this.tagService.save(tag);
        }
    }
}
