package com.allere.sample.netty.client;

import com.allere.sample.netty.pojo.UnixTime;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;

import java.util.List;

/**
 * Created by G_dragon on 2017/3/1.
 */
public class TimeDecoder extends ByteToMessageDecoder { // (1)

    @Override
    protected void decode(ChannelHandlerContext ctx, ByteBuf in, List<Object> out) { // (2)
        if (in.readableBytes() < 4) {
            return; // (3)
        }

//        out.add(in.readBytes(4));            // (4)       decode to byte
        out.add(new UnixTime(in.readUnsignedInt()));         //(5)       decode to POJO
    }
}