package com.course.controller;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.course.modle.User;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.log4j.Log4j2;


@Log4j2
@RestController
@Api(value ="v1",description="这是我的第一个版本的demo")
@RequestMapping("v1")
public class Demo {
	//首先获取一个执行sql语句的对象
    @Autowired  //表示启动即加载
    private SqlSessionTemplate template ;
    
    @RequestMapping(value = "/getUserList",method=RequestMethod.GET)
    @ApiOperation(value="可以获取到用户数",httpMethod = "GET")
    public int getUserCount(){
        return template.selectOne("getUserCount");
    }

    @RequestMapping(value="/addUser" ,method=RequestMethod.POST)
    public int addUser(@RequestBody User user){
    	int insertNum = template.insert("addUser",user);
		return insertNum;	
    }
    
    @RequestMapping(value="/updateUser",method=RequestMethod.POST)
    public int updateUser(@RequestBody User user){
    	int updateNum = template.update("updateUser",user);
		return updateNum; 	
    }
    
    @RequestMapping(value="/delUser")
    public int delUser(@RequestParam int id){
    	int deleteNum = template.delete("delUser",id);
		return deleteNum;
    	
    }
    
    
}
