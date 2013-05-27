package com.gao.first;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FSDataInputStream;
import org.apache.hadoop.fs.FSInputStream;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IOUtils;

import java.io.IOException;
import java.net.URI;

/**
 * User: wangchen.gpx
 * Date: 13-5-27
 * Time: 下午6:10
 */
public class FileSystemDouble {
    public static void main(String[] args) throws IOException {
        String uriString = "file:///d:/a.txt";
        Configuration configuration = new Configuration();
        FSDataInputStream inputStream = null;
        FileSystem fileSystem = FileSystem.get(URI.create(uriString), configuration);
        try {
            inputStream = fileSystem.open(new Path(uriString));
            IOUtils.copyBytes(inputStream , System.out , 4096 , false);

            inputStream.seek(0);
            IOUtils.copyBytes(inputStream , System.out , 4096 , false);
        }finally {
            IOUtils.closeStream(inputStream);
        }
    }
}
