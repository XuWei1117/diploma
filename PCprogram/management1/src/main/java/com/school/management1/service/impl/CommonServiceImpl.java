package com.school.management1.service.impl;

import com.school.management1.domain.vo.CommentVO;
import com.school.management1.mapper.CommentMapper;
import com.school.management1.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommonServiceImpl implements CommentService {
    @Autowired
    private CommentMapper commentMapper;
    @Override
    public List<CommentVO> selectAllComment(CommentVO comment) {
        List<CommentVO> commentVOS = commentMapper.selectAllComment(comment.getCondition(),comment.getConditionNew());
        return commentVOS;
    }

    @Override
    public Integer deleteComment(Integer cm_id) {
        Integer count = commentMapper.deleteComment(cm_id);
        return count;
    }
}
