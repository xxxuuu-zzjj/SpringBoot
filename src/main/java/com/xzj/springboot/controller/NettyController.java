package com.xzj.springboot.controller;

import com.xzj.springboot.common.response.Response;
import com.xzj.springboot.server.NettyTcpServe;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * netty 控制器
 */
@Api(tags = {"04 Netty服务端"})
@RestController
@RequestMapping("/netty")
public class NettyController {

    @Resource NettyTcpServe nettyTcpServe;

    @ApiOperation("启动服务端")
    @PostMapping("start")
    public Response start(@RequestParam("port") int port){
        nettyTcpServe.start(port);
        return new Response();
    }
}
