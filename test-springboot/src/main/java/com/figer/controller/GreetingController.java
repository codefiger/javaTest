package com.figer.controller;

import com.figer.mapper.TLoginLogMapper;
import com.figer.mapper.TUserMapper;
import com.figer.mybatis.TLoginLogExample;
import com.figer.mybatis.TUser;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by figer on 17/10/2016.
 */
@RestController
@Api(value = "HelloWorld", description = "Just :）")
public class GreetingController {
  private static final String template = "Hello, %s!";
  private final AtomicLong counter = new AtomicLong();

  @Autowired
  TLoginLogMapper loginLogMapper;
  @Autowired
  TUserMapper userMapper;


  @ApiOperation(value = "getGreeting", nickname = "getGreeting")
  @RequestMapping(method = RequestMethod.GET, path="/greeting", produces = "application/json")
  @ApiImplicitParams({
      @ApiImplicitParam(name = "name", value = "User's name", required = false, dataType = "string", paramType = "query", defaultValue="Niklas")
  })
  @ApiResponses(value = {
      @ApiResponse(code = 200, message = "Success", response = GreetingVo.class),
      @ApiResponse(code = 401, message = "Unauthorized"),
      @ApiResponse(code = 403, message = "Forbidden"),
      @ApiResponse(code = 404, message = "Not Found"),
      @ApiResponse(code = 500, message = "Failure")})
  public GreetingVo greeting(@RequestParam(value="name", defaultValue="World") String name) {

    TLoginLogExample example = new TLoginLogExample();
    example.createCriteria().andIpIsNotNull();
    System.out.println(loginLogMapper.selectByExample(example).size());

    System.out.println(userMapper.selectByPrimaryKey(1).getUserName());
    return new GreetingVo(counter.incrementAndGet(),String.format(template, name));

  }
}
