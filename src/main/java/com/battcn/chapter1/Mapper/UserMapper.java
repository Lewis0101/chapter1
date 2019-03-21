package com.battcn.chapter1.Mapper;

import com.battcn.chapter1.responseDTO.Video;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author : 00222 [liu.yang@unisinsight.com]
 * @description:
 * @date : 2019/3/21 14:25
 * @since: 1.0
 */
@Mapper
public interface UserMapper {

    /**
     * 获取视频信息
     * 通过注解实现
     * @return 查询结果
     */
    @Select("SELECT * FROM video_info")
    List<Video> getVideoInfo();

    /**
     * 获取视频信息
     * 在xml里面实现
     * @return 查询结果
     */
    List<Video> getVideoInfo1();

    /**
     * 保存用户信息
     *
     * @param user 用户信息
     * @return 成功 1 失败 0
     */
    int insert(Video user);

}
