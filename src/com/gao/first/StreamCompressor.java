package com.gao.first;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.io.IOUtils;
import org.apache.hadoop.io.compress.CompressionCodec;
import org.apache.hadoop.io.compress.CompressionOutputStream;
import org.apache.hadoop.io.compress.GzipCodec;
import org.apache.hadoop.util.ReflectionUtils;

import java.io.IOException;

/**
 * User: wangchen.gpx
 * Date: 13-5-30
 * Time: 下午1:46
 */
public class StreamCompressor {
    public static void main(String[] args) throws ClassNotFoundException, IOException {
        String className = "DefaultCodec";
//        Class<?> clazz = Class.forName(className);
        Configuration configuration = new Configuration();

        CompressionCodec compressionCodec = (CompressionCodec) ReflectionUtils.newInstance(GzipCodec.class, configuration);

        CompressionOutputStream outputStream = compressionCodec.createOutputStream(System.out);
        IOUtils.copyBytes(System.in , outputStream , 4096 , false);
        outputStream.finish();
        outputStream.flush();
    }
}
