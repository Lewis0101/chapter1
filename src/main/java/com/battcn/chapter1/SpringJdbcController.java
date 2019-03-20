package com.battcn.chapter1;

import com.sun.javafx.binding.Logging;

import org.hibernate.validator.internal.util.logging.Log;
import org.hibernate.validator.internal.util.logging.Log_$logger;
import org.springframework.beans.factory.InitializingBean;
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

/**
 * @author : 00222 [liu.yang@unisinsight.com]
 * @description:Springboot的JDBC
 * @date : 2019/3/20 14:03
 * @since: 1.0
 */


//需要重新配置mysql文件  否则连接不上JdbcTemplate
@RestController
@RequestMapping("/users")
public class SpringJdbcController implements InitializingBean {

    @Autowired
    private  JdbcTemplate jdbcTemplate;

    @GetMapping
    public List<User> queryUsers(){
        //查询所有用户
        String sql = "select * from t_user";
        return jdbcTemplate.query(sql,new Object[]{},new BeanPropertyRowMapper<>(User.class));
    }

    @GetMapping("/{id}")
    public  User getUser(@PathVariable Long id){
        //根据主键ID查询
        String sql = "select * from t_user where id = ?";
        return jdbcTemplate.queryForObject(sql,new Object[]{id},new BeanPropertyRowMapper<>(User.class));
    }

    @DeleteMapping ("/{id}")
    public int delUser(@PathVariable Long id){
        //根据主键ID删除用户信息
        String sql = "DELETE FROM t_user WHERE id = ?";
        return jdbcTemplate.update(sql,id);
    }

    @PostMapping
    public int addUser(@RequestBody User user){
        //添加用户
        String sql = "insert into t_user(username,password) values(?,?))";
        return jdbcTemplate.update(sql,user.getUsername(),user.getPassword());
    }

    @PutMapping("/{id}")
    public  int editUser(@PathVariable Long id,@RequestBody User user){
        //根据主键ID修改用户信息
        String sql = "UPDATE t_user SET username = ? ,password = ? WHERE id = ?";
        return jdbcTemplate.update(sql,user.getUsername(),user.getPassword(),id);
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println();
    }
}
