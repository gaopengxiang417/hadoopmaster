package com.gao.first;

import org.apache.commons.configuration.ConfigurationUtils;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IOUtils;

import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URL;

/**
 * User: wangchen.gpx
 * Date: 13-5-27
 * Time: 下午5:53
 */
public class FileSystemCat {
    public static void main(String[] args) throws IOException {
        String urlString = "file:///D://a.txt";
        Configuration configuration = new Configuration();
        FileSystem fileSystem = FileSystem.get(URI.create(urlString), configuration);

        InputStream inputStream = null;
        try {
            inputStream = fileSystem.open(new Path(urlString));
            IOUtils.copyBytes(inputStream, System.out, 4068, false);
        }finally {
            IOUtils.closeStream(inputStream);
        }
    }
}
