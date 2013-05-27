package com.gao.first;

import org.apache.hadoop.fs.FsUrlStreamHandlerFactory;
import org.apache.hadoop.io.IOUtils;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * User: wangchen.gpx
 * Date: 13-5-27
 * Time: 下午5:03
 */
public class URLCat {
    static {
        URL.setURLStreamHandlerFactory(new FsUrlStreamHandlerFactory());
    }
    public static void main(String[] args) throws IOException {
        InputStream inputStream = null;
        try {
            inputStream = new URL("file:///D://a.txt").openStream();
            IOUtils.copyBytes(inputStream , System.out , 4068 , false);
        }finally {
            IOUtils.closeStream(inputStream);
        }
    }
}
