package com.gao.first;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FSDataOutputStream;
import org.apache.hadoop.fs.FileStatus;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;

import java.io.IOException;
import java.net.URI;

/**
 * User: wangchen.gpx
 * Date: 13-5-29
 * Time: 下午3:30
 */
public class SyncTest {
    public static void main(String[] args) throws IOException {
        FileSystem fileSystem = FileSystem.get(URI.create("file:///D:/"), new Configuration());

        Path path = new Path("D:/a/");
        FSDataOutputStream outputStream = fileSystem.create(path);

        outputStream.write("content".getBytes("utf-8"));
        outputStream.write("this is a charset".getBytes());
        outputStream.flush();
        outputStream.sync();

        outputStream.close();

        FileStatus fileStatus = fileSystem.getFileStatus(path);
        System.out.println(fileStatus.getLen());
    }
}
