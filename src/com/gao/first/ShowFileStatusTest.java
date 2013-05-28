package com.gao.first;

import org.apache.commons.configuration.ConfigurationUtils;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FSDataOutputStream;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.hdfs.MiniDFSCluster;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.Charset;

/**
 * User: wangchen.gpx
 * Date: 13-5-27
 * Time: 下午7:26
 */
public class ShowFileStatusTest {
    private MiniDFSCluster cluster;
    private FileSystem fileSystem;
    @Before
    public void setup() throws IOException {
        Configuration configuration = new Configuration();
        if (System.getProperty("test.build.data") == null) {
            System.setProperty("test.build.data" , "D:/data.txt");
        }
        cluster = new MiniDFSCluster(configuration, 1, true, null);
        fileSystem = cluster.getFileSystem();
        FSDataOutputStream outputStream = fileSystem.create(new Path("D:/x.txt"));
        outputStream.write("content".getBytes(Charset.defaultCharset()));
        outputStream.close();
    }

    @After
    public void tearDown() throws IOException {
        if (fileSystem != null) {
            fileSystem.close();
        }
        if (cluster != null) {
            cluster.shutdown();
        }
    }

    @Test(expected = FileNotFoundException.class)
    public void testThrowFileNotFoundException() throws IOException {
        fileSystem.getFileStatus(new Path("D:/sdfasd.txt"));
    }
}
