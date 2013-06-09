package com.gao.first;

import org.apache.hadoop.io.BytesWritable;
import org.apache.hadoop.util.StringUtils;

import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

/**
 * User: wangchen.gpx
 * Date: 13-6-9
 * Time: 上午8:59
 */
public class BytesWritableTest {
    public static void main(String[] args) throws IOException {
        BytesWritable bytesWritable = new BytesWritable(new byte[]{4, 5, 2});

        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);

        bytesWritable.write(dataOutputStream);

        byte[] bytes = byteArrayOutputStream.toByteArray();

        System.out.println(StringUtils.byteToHexString(bytes));

        bytesWritable.set(new BytesWritable(new byte[]{2,3}));
        System.out.println(bytesWritable.getLength());
        System.out.println(bytesWritable.getBytes().length);
    }
}
