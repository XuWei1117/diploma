package com.school.education.service;

import com.school.education.domain.Comment;

import java.util.List;

public interface CommentService {
    List<Comment> selectCommentByCourseId(Integer cs_id);
    Integer addComment(Comment comment);
    Integer deleteComment(Integer cm_id);
    List<Comment> selectAllByUserId(Integer user_id);
}
