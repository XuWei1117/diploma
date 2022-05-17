package com.school.management1.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.school.management1.domain.vo.CommentVO;
import com.school.management1.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/management/comment")
public class CommentController {
    @Autowired
    private CommentService commentService;

    /**
     * 根据条件搜索评论（条件为评论者名称或者课程名称）
     *
     * @param comment
     * @return
     */
    @RequestMapping("/selectAllComment")
    private PageInfo<CommentVO> selectAllComment(@RequestBody CommentVO comment) {
        if (null == comment || null == String.valueOf(comment.getPageNum())) {
            comment.setPageNum(1);
        }
        if (null == comment || null == String.valueOf(comment.getPageSize())) {
            comment.setPageSize(10);
        }
        PageHelper.startPage(comment.getPageNum(), comment.getPageSize());
        //进行模糊查询
        comment.setConditionNew("%" + comment.getCondition() + "%");
        List<CommentVO> commentVOS = commentService.selectAllComment(comment);
        PageInfo<CommentVO> pageInfo = new PageInfo<>(commentVOS);
        return pageInfo;
    }
    @RequestMapping("/deleteComment")
    private HashMap<String, Object> deleteComment(@RequestBody CommentVO comment) throws Exception {
        if(comment.getComment_id() == null){
            throw new Exception("id不能为空");
        }
        HashMap<String, Object> map = new HashMap<>();
        Integer count = commentService.deleteComment(comment.getComment_id());
        if (count == 1){
            map.put("msg","删除成功");
            map.put("code","200");
        }
            return map;
    }
}
