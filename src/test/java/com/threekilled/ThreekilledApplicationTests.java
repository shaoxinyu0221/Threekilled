package com.threekilled;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.FileInputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

@SpringBootTest
class ThreeKilledApplicationTests {

    public static void main(String[] args) {
        //FileChannel
        //获取方式 1.输入输出流 2.RandomAccessFile
        try(FileChannel fileChannel = new FileInputStream("data.txt").getChannel()) {
            //准备缓冲区
            ByteBuffer buffer = ByteBuffer.allocate(10);
            while (true){
                //从channel读取数据,向buffer写入
                int read = fileChannel.read(buffer);
                if (read==-1){
                    break;
                }
                //打印buffer
                //切换buffer的读模式
                buffer.flip();
                while (buffer.hasRemaining()){
                    byte b = buffer.get();
                    System.out.println((char) b);
                }
                //切换成写模式
                buffer.clear();
            }
        }catch(Exception e){

        }
    }

}
