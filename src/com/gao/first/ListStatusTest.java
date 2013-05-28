package com.gao.first;

import org.apache.commons.configuration.ConfigurationUtils;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileStatus;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.FileUtil;
import org.apache.hadoop.fs.Path;

import java.io.IOException;
import java.net.URI;

/**
 * User: wangchen.gpx
 * Date: 13-5-28
 * Time: 下午10:48
 */
public class ListStatusTest {
    public static void main(String[] args) throws IOException {
        Configuration configuration = new Configuration();
        FileSystem fileSystem = FileSystem.get(URI.create("file:///D:/"), configuration);

        FileStatus fileStatus = fileSystem.getFileStatus(new Path("D:/"));
        System.out.println(fileStatus.getAccessTime());
        System.out.println(fileStatus.getBlockSize());
        //System.out.println(fileStatus.getGroup());
        System.out.println(fileStatus.getLen());
        System.out.println(fileStatus.getModificationTime());
//        System.out.println(fileStatus.getOwner());
//        System.out.println(fileStatus.getPermission());
        System.out.println(fileStatus.getReplication());
        System.out.println(fileStatus.getPath());

        FileStatus[] fileStatuses = fileSystem.listStatus(new Path("D:/"));

        Path[] paths = FileUtil.stat2Paths(fileStatuses);
        for (Path path : paths) {
            System.out.println(path);
        }
    }
}
