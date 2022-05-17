package com.school.management1.service;

import com.school.management1.domain.vo.CommentVO;

import java.util.List;

public interface CommentService {
    List<CommentVO> selectAllComment(CommentVO comment);
    Integer deleteComment(Integer cm_id);
}
