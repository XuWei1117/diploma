package com.school.education.mapper;

import com.school.education.domain.Comment;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CommentMapper {
    List<Comment> selectCommentByCourseId(Integer cs_id);
    Integer addComment(Comment comment);
    Integer deleteComment(Integer cm_id);
    List<Comment> selectAllByUserId(Integer user_id);
}
