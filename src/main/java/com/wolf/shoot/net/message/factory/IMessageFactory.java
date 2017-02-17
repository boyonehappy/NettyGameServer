package com.wolf.shoot.net.message.factory;

import com.wolf.shoot.net.message.AbstractNetMessage;

/**
 * Created by jwp on 2017/2/10.
 * 协议工厂
 */
public interface IMessageFactory {
    public AbstractNetMessage createCommonErrorResponseMessage(int serial, int cmd, int state);
}
