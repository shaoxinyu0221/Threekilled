package com.threekilled;

import org.springframework.boot.test.context.SpringBootTest;

import java.nio.ByteBuffer;

@SpringBootTest
public class TestBufferReadWrite {


    public static void main(String[] args) {
        ByteBuffer buffer = ByteBuffer.allocate(10);
        buffer.put((byte) 97);


    }

}
