package com.school.education.service.impl;

import com.school.education.domain.Comment;
import com.school.education.mapper.CommentMapper;
import com.school.education.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {
    @Autowired
    private CommentMapper mapper;
    @Override
    public List<Comment> selectCommentByCourseId(Integer cs_id) {
        List<Comment> comments = mapper.selectCommentByCourseId(cs_id);
        return comments;
    }

    @Override
    public Integer addComment(Comment comment) {
        Integer count = mapper.addComment(comment);
        return count;
    }

    @Override
    public Integer deleteComment(Integer cm_id) {
        Integer count = mapper.deleteComment(cm_id);
        return count;
    }

    @Override
    public List<Comment> selectAllByUserId(Integer user_id) {
        List<Comment> comments = mapper.selectAllByUserId(user_id);
        return comments;
    }
}
