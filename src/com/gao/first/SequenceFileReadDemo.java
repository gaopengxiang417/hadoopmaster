package com.gao.first;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IOUtils;
import org.apache.hadoop.io.SequenceFile;
import org.apache.hadoop.io.Writable;
import org.apache.hadoop.util.ReflectionUtils;

import java.io.IOException;
import java.net.URI;

/**
 * User: wangchen.gpx
 * Date: 13-6-16
 * Time: 下午1:06
 */
public class SequenceFileReadDemo {
    public static void main(String[] args) throws IOException {
        URI uri = URI.create("file:///d:/ss.seq");
        Configuration configuration = new Configuration();
        FileSystem fileSystem = FileSystem.get(uri, configuration);
        Path path = new Path(uri);

        SequenceFile.Reader reader = null;
        try{
            reader = new SequenceFile.Reader(fileSystem, path, configuration);
            Writable key = (Writable) ReflectionUtils.newInstance(reader.getKeyClass(), configuration);
            Writable value = (Writable) ReflectionUtils.newInstance(reader.getValueClass(), configuration);

            long position = reader.getPosition();
            while (reader.next(key,value)){
                String synSeen = reader.syncSeen() ? "*" : "";
                System.out.printf("[%s%s]\t%s\t%s\n",position,synSeen,key,value);
                position = reader.getPosition();
            }
        }finally {
            IOUtils.closeStream(reader);
        }
    }
}
