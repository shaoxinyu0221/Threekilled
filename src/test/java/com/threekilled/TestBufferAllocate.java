package com.threekilled;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class TestBufferAllocate {

    public static void main(String[] args) {

        System.out.println(ByteBuffer.allocate(16).getClass());
        System.out.println(ByteBuffer.allocateDirect(16).getClass());
        /**
         * class java.nio.HeapByteBuffer     - java 堆内存,读写效率较低,受到垃圾回收的影响
         * class java.nio.DirectByteBuffer   - 直接内存,读写效率高(少一次拷贝)但是因为要调用系统内存,所以分配效率低,
         * 使用的是系统内存,不会受到java垃圾回收的影响,如果使用不当,可能会造成内存泄漏
         */
        try(FileChannel channel = new FileOutputStream(new File("data.txt")).getChannel()) {
            ByteBuffer buffer = ByteBuffer.allocate(10);
            String name = "123";
            buffer.put(name.getBytes("UTF-8"));
            buffer.flip();
            channel.write(buffer);
        }catch (Exception e){

        }

    }


}
