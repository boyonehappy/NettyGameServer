package com.wolf.shoot.udp.client;

import com.wolf.shoot.net.message.AbstractAbstractNetProtoBufMessage;
import com.wolf.shoot.net.message.logic.udp.online.OnlineHeartUDPMessageAbstract;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by jiangwenping on 17/2/16.
 */
public class UdpProtoBufHandler  extends SimpleChannelInboundHandler<AbstractAbstractNetProtoBufMessage> {

    public static final Logger utilLogger = LoggerFactory.getLogger("util");
    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, AbstractAbstractNetProtoBufMessage netMessage) throws Exception {
        System.out.println(netMessage);
        if(netMessage instanceof OnlineHeartUDPMessageAbstract){
            OnlineHeartUDPMessageAbstract onlineHeartUDPMessage = new OnlineHeartUDPMessageAbstract();
            onlineHeartUDPMessage.setId(Short.MAX_VALUE);
//            InetSocketAddress inetSocketAddress = new InetSocketAddress("127.0.0.1", port);
            onlineHeartUDPMessage.setReceive(((OnlineHeartUDPMessageAbstract) netMessage).getSend());
            channelHandlerContext.writeAndFlush(onlineHeartUDPMessage).sync();
        }
//        //读取数据
////        ByteBuffer buf =  ByteBuffer.wrap(datagramPacket.copy().content().array());
////        ByteBuffer readBuffer = buf.asReadOnlyBuffer();
////        String body = new String(readBuffer.array(), CharsetUtil.UTF_8);
//        String string = datagramPacket.content().toString(Charset.forName("UTF-8"));
//        utilLogger.debug("收到客户端数据" + string);
//        //回复客户端
//        String response = "Hello, 服务器事件为" + System.currentTimeMillis();
//        byte[] bytes = response.getBytes(CharsetUtil.UTF_8);
//        InetSocketAddress inetSocketAddress = datagramPacket.sender();
//        System.out.println(inetSocketAddress);
//        DatagramPacket responsePacket = new DatagramPacket(Unpooled.copiedBuffer(bytes), datagramPacket.sender());
////        channelHandlerContext.writeAndFlush(responsePacket).sync();
//        channelHandlerContext.channel().writeAndFlush(responsePacket).sync();
    }

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) {
        ctx.flush();
    }

    /**
     * Gets called if an user event was triggered.
     */
    public void userEventTriggered(ChannelHandlerContext ctx, Object evt) throws Exception{
        System.out.println("d");
    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        ctx.fireChannelInactive();
    }

    @Override
    public void channelUnregistered(ChannelHandlerContext ctx) throws Exception {
        ctx.fireChannelUnregistered();
    }

    @Override
    public void channelRegistered(ChannelHandlerContext ctx) throws Exception {
        ctx.fireChannelRegistered();
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        ctx.fireChannelActive();
    }


}

