package com.gao.first;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;

import java.io.IOException;
import java.net.URI;

/**
 * User: wangchen.gpx
 * Date: 13-5-29
 * Time: 上午9:46
 */
public class DeleteFileTest {
    public static void main(String[] args) throws IOException {
        Configuration configuration = new Configuration();
        FileSystem fileSystem = FileSystem.get(URI.create("file:///D:/a/"), configuration);

        boolean isDelete = fileSystem.delete(new Path("D:/a/"), true);
        System.out.println(isDelete);
    }
}
