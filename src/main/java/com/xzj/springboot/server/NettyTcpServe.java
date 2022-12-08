package com.xzj.springboot.server;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.RandomUtil;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.PooledByteBufAllocator;
import io.netty.buffer.Unpooled;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.util.CharsetUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.math.RoundingMode;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Slf4j
@Service
public class NettyTcpServe {

    protected static final Map<Integer,SocketChannel> ipMap = new HashMap<>();

    public void init(Integer port){

        EventLoopGroup bossGroup = new NioEventLoopGroup();
        EventLoopGroup workGroup = new NioEventLoopGroup();
        ServerBootstrap serverBootstrap = new ServerBootstrap();

        try {
            serverBootstrap.group(bossGroup, workGroup)
                    //非阻塞
                    .channel(NioServerSocketChannel.class)
                    //连接缓冲池的大小
                    .option(ChannelOption.SO_BACKLOG, 1024)
                    //设置通道Channel的分配器
                    .childOption(ChannelOption.ALLOCATOR, PooledByteBufAllocator.DEFAULT)
                    .childHandler(new ChannelInitializer<SocketChannel>() {
                        protected void initChannel(SocketChannel socketChannel) throws Exception {
                            // 为通道进行初始化，数据传输过来的适合会进行拦截和执行(可以有多个拦截器)
                            socketChannel.pipeline().addLast(new ServerHandler());
                            ipMap.put(port, socketChannel);
                        }
                    });
            // 绑定端口，同步等待成功
            ChannelFuture sync = serverBootstrap.bind(port).sync();
            // 等待服务端监听端口关闭
            sync.channel().closeFuture().sync();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            // 优雅退出，释放线程资源
            bossGroup.shutdownGracefully();
            workGroup.shutdownGracefully();
        }
    }

    public void start(int port){
            init(port);
    }

    @Scheduled(cron = "0/5 * * * * ? ")
    public void remote(){
        detail(6431, 1004);
    }

//    @Scheduled(cron = "0/5 * * * * ? ")
//    public void remote2(){
//        detail(6432, 1004);
//    }

    public void detail(int port, int toolId){
        double psi = RandomUtil.randomDouble(500.0,1800.0,2, RoundingMode.HALF_UP);
        double temp = RandomUtil.randomDouble(10.0,60.0,1, RoundingMode.HALF_UP);
        String msg = "ToolId:"+ toolId +",Type:0001,Flags:(BORRST:0-PINRST:0-IWDGRST:0-LPWRST:0-OC:0), " +
                "PSI:" + psi + ", Transmit:(9913mV，45mA，220288mohm), Battery Current:   49mA, " +
                "Temp:" + temp + "end";
        ByteBuf buf = Unpooled.copiedBuffer(msg, CharsetUtil.UTF_8);
        ipMap.get(port).writeAndFlush(buf);
        log.info("PSI:" + psi + ",Temp:+" + temp + "C");
    }
}
