package com.gouzal.iquote.service.operation;

import com.gouzal.iquote.model.Tag;

import java.util.List;

public interface ITagService extends Operation<Tag> {

    List<Tag> findByQuote(long quoteId);

}
