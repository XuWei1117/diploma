package com.school.management1.mapper;

import com.school.management1.domain.vo.CommentVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface CommentMapper {
    List<CommentVO> selectAllComment(@Param("condition") String condition,@Param("conditionNew") String conditionNew);
    Integer deleteComment(Integer cm_id);
}
