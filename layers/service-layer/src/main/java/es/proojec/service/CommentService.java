package es.proojec.service;

import es.proojec.store.entities.Comment;

/**
 * Created by ggb191983 on 09/09/2017.
 */
public interface CommentService  {
    Comment save(Comment entity);

    Comment find(Long id);

    Iterable<Comment> findAll();
}
