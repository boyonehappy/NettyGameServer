package com.wolf.shoot.service.net.message.command;

import com.wolf.shoot.common.constant.BOEnum;

/**
 * Created by jiangwenping on 17/2/20.
 */
public enum MessageCommandEnum {

    ONLINE_HEART_MESSAGE(MessageCommandIndex.ONLINE_HEART_CLIENT_TCP_MESSAGE, BOEnum.WORLD,false, false),
    COMMON_RESPONSE_MESSAGE(MessageCommandIndex.COMMON_RESPONSE_MESSAGE, BOEnum.WORLD, false, true),
    COMMON_ERROR_RESPONSE_MESSAGE(MessageCommandIndex.COMMON_ERROR_RESPONSE_MESSAGE, BOEnum.WORLD, false, true),
    ONLINE_HEART_UDP_MESSAGE(MessageCommandIndex.ONLINE_HEART_CLIENT_UDP_MESSAGE, BOEnum.WORLD, true, false),
    ONLINE_LOGIN_TCP_CLIENT_MESSAGE(MessageCommandIndex.ONLINE_LOGIN_TCP_CLIENT_MESSAGE, BOEnum.WORLD,false, false),
    ONLINE_LOGIN_TCP_SERVER_MESSAGE(MessageCommandIndex.ONLINE_LOGIN_TCP_SERVER_MESSAGE, BOEnum.WORLD,false, false),
    ;
    /**
     * 协议号
     */
    public final int command_id;

    /**
     * boconstant的id
     */
    public final int bo_id;

    /**
     * 是否需要过滤
     */
    public final boolean is_need_filter;

    /**
     * 通用消息
     */
    public final boolean is_common;

    MessageCommandEnum(int commandId, BOEnum boEnum, boolean is_need_filter, boolean is_common) {
        this.command_id = commandId;
        this.bo_id = boEnum.getBoId();
        this.is_need_filter = is_need_filter;
        this.is_common = is_common;
    }

    public static String getMessageCommandName(int commandId) {
        MessageCommandEnum commands = MessageCommandEnum.ONLINE_HEART_MESSAGE;
        MessageCommandEnum[] set = commands.values();
        for (int i = 0; i < set.length; i++) {
            MessageCommandEnum tempCommand = set[i];
            if (tempCommand.command_id == commandId) {
                commands = tempCommand;
                break;
            }
        }
        return commands.name();

    }

    public static MessageCommandEnum getMessageCommand(int commandId) {
        MessageCommandEnum commands = MessageCommandEnum.ONLINE_HEART_MESSAGE;
        MessageCommandEnum[] set = commands.values();
        for (int i = 0; i < set.length; i++) {
            MessageCommandEnum tempCommand = set[i];
            if (tempCommand.command_id == commandId) {
                commands = tempCommand;
                break;
            }
        }
        return commands;

    }

    public static int getBoIdByCommandId(int commandId) {
        MessageCommandEnum commands = MessageCommandEnum.ONLINE_HEART_MESSAGE;
        MessageCommandEnum[] set = commands.values();
        for (int i = 0; i < set.length; i++) {
            MessageCommandEnum tempCommand = set[i];
            if (tempCommand.command_id == commandId) {
                commands = tempCommand;
                break;
            }
        }
        return commands.bo_id;
    }

}
