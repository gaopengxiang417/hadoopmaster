package com.gao.first;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FSDataOutputStream;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IOUtils;
import org.apache.hadoop.util.Progressable;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URI;

/**
 * User: wangchen.gpx
 * Date: 13-5-27
 * Time: 下午7:11
 */
public class FileCopyWithProcess {
    public static void main(String[] args) throws IOException {
        BufferedInputStream inputStream = new BufferedInputStream(new FileInputStream("D:/a.txt"));
        FileSystem fileSystem = FileSystem.get(URI.create("file:///D:/b.txt"), new Configuration());

        FSDataOutputStream fsDataOutputStream = fileSystem.create(new Path("file:///D:/b.txt"), new Progressable() {
            @Override
            public void progress() {
                System.out.println("gaopengxiang");
            }
        });

        IOUtils.copyBytes(inputStream , fsDataOutputStream , 4096 , true);
    }
}
