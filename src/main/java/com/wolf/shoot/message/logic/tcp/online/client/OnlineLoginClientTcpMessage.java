package com.wolf.shoot.message.logic.tcp.online.client;

import com.wolf.shoot.common.annotation.MessageCommandAnnotation;
import com.wolf.shoot.message.auto.tcp.online.client.OnlineTCPClientProBuf;
import com.wolf.shoot.service.net.message.AbstractNetProtoBufTcpMessage;
import com.wolf.shoot.service.net.message.command.MessageCommandIndex;

/**
 * Created by jiangwenping on 17/2/21.
 */
@MessageCommandAnnotation(command = MessageCommandIndex.ONLINE_LOGIN_TCP_CLIENT_MESSAGE)
public class OnlineLoginClientTcpMessage extends AbstractNetProtoBufTcpMessage {

    private int id;

    public OnlineLoginClientTcpMessage(){
        setCmd(MessageCommandIndex.ONLINE_LOGIN_TCP_CLIENT_MESSAGE);
    }

    @Override
    public void decoderNetProtoBufMessageBody() throws Exception {
        byte[] bytes = getNetMessageBody().getBytes();
        OnlineTCPClientProBuf.OnlineLoginTCPClientProBuf req = OnlineTCPClientProBuf.OnlineLoginTCPClientProBuf.parseFrom(bytes);
        setId(req.getId());
    }

    @Override
    public void release() {

    }

    @Override
    public void encodeNetProtoBufMessageBody() throws Exception {
        OnlineTCPClientProBuf.OnlineLoginTCPClientProBuf.Builder builder = OnlineTCPClientProBuf.OnlineLoginTCPClientProBuf.newBuilder();
        builder.setId(getId());
        byte[] bytes = builder.build().toByteArray();
        getNetMessageBody().setBytes(bytes);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}

