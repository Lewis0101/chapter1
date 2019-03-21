package com.battcn.chapter1.Controller;

import com.battcn.chapter1.Mapper.UserMapper;
import com.battcn.chapter1.responseDTO.Video;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import javax.annotation.Resource;

/**
 * @author : 00222 [liu.yang@unisinsight.com]
 * @description:Springboot的JDBC
 * @date : 2019/3/20 14:03
 * @since: 1.0
 */


//需要重新配置mysql文件  否则连接不上JdbcTemplate
@RestController
@RequestMapping("/users")
public class SpringJdbcController  {

    @Resource
    private UserMapper userMapper;

    @Autowired
    private  JdbcTemplate jdbcTemplate;


    @GetMapping
    public List<Video> queryUsers(){
        //查询所有用户
        String sql = "select * from video_info";
        return jdbcTemplate.query(sql,new Object[]{},new BeanPropertyRowMapper<>(Video.class));
    }

    @GetMapping("{video_id}")
    public Video getUser(@PathVariable String  video_id){
        //根据主键ID查询
        String sql = "select * from video_info where video_id = ?";
        return jdbcTemplate.queryForObject(sql,new Object[]{video_id},new BeanPropertyRowMapper<>(Video.class));
    }

    @DeleteMapping ("/{id}")
    public int delUser(@PathVariable Long id){
        //根据主键ID删除用户信息
        String sql = "DELETE FROM video_info WHERE id = ?";
        return jdbcTemplate.update(sql,id);
    }

    @PostMapping
    public int addUser(@RequestBody Video user){
        //添加用户
        String sql = "insert into video_info(device_id,video_id) values(?,?))";
        return jdbcTemplate.update(sql,user.getDeviceId(),user.getVideoId());
    }

    @PutMapping("/{id}")
    public  int editUser(@PathVariable Long id,@RequestBody Video user){
        //根据主键ID修改用户信息
        String sql = "UPDATE video_info SET device_id = ? ,video_id = ? WHERE id = ?";
        return jdbcTemplate.update(sql,user.getDeviceId(),user.getVideoId(),id);
    }

    //测试mapper
    @GetMapping("/mapper")
    public List<Video> mapper(){
        return userMapper.getVideoInfo();
    }

    //测试mapper1
    @GetMapping("/mapper1")
    public List<Video> mapper1(){

        return userMapper.getVideoInfo1();
    }


}
