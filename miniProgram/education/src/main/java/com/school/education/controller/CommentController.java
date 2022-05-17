package com.school.education.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.school.education.domain.Comment;
import com.school.education.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/education/comment")
public class CommentController {
    @Autowired
    private CommentService service;
  /*  @RequestMapping("/findByPage")
    public @ResponseBody List<Comment> findByPage(
            @RequestParam("currentPage1") String currentPage1,@RequestParam("cs_id") Integer cs_id){
        Integer currentPage = null;
        if(currentPage1 == null){
            currentPage = 1;
        }else {
            currentPage = Integer.parseInt(currentPage1);
        }
        PageHelper.startPage(currentPage,10);
        List<Comment> comments = service.selectCommentByCourseId(cs_id);
        PageInfo<Comment> pageInfo = new PageInfo<>(comments);
        List<Comment>  list = pageInfo.getList();
        return list;
    }*/

    //获取该课程下的所有评论
    @RequestMapping("/getAllRecommend")
    public @ResponseBody List<Comment> getAllRecommend(@RequestParam("cs_id") Integer cs_id){
        List<Comment> comments = service.selectCommentByCourseId(cs_id);
        return comments;
    }

    /**
     * 发表评论
     * @param s
     * @return
     */
    /*
    * cm_id 不需要传递自动递增
    * cm_name 需要获取到用户登录的昵称
    * cm_desc 用户填写的评论
    * cm_date 用户发表评论的日期为当前时间
    * course_id 用户评论的课程id
    * user_id 用户的id
    * */
    //发表评论
    @PostMapping("/addComment")
    public @ResponseBody
    Map<String,String> addComment(@RequestBody HashMap<String,String> s){
        Comment comment = new Comment();
        comment.setCm_name(s.get("cm_name"));
        comment.setCm_desc(s.get("cm_desc"));
        comment.setCourse_id(Integer.valueOf(s.get("course_id")));
        comment.setUser_id(Integer.valueOf(s.get("user_id")));
        HashMap<String, String> map = new HashMap<>();
        comment.setCm_date(new Date());
        Integer count = service.addComment(comment);
        if(count == 1){
            map.put("msg","评论成功");
            map.put("code","200");
        }
        return map;
    }

    /**
     * 根据id删除该登录用户自己的评论
     * 删除只能删除自己的评论，别人的不可以删除
     * @param comment
     * @return
     */
    @RequestMapping("/deleteComment")
    public @ResponseBody Map<String,String> deleteComment(Comment comment){
        HashMap<String, String> map = new HashMap<>();
        Integer count = service.deleteComment(comment.getCm_id());
        if(count == 1){
            map.put("msg","删除评论成功");
            map.put("code","200");
        }
        return map;
    }

    /**
     * 显示当前用户的全部评论
     * @param user_id
     * @return
     */
    @RequestMapping("/selectAllByUserId")
    public @ResponseBody List<Comment> showCommentByUserId(Integer user_id){
        List<Comment> comments = service.selectAllByUserId(user_id);
        return comments;
    }



}
