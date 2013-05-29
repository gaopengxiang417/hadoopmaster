package com.gao.first;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileStatus;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.fs.PathFilter;

import java.io.IOException;
import java.net.URI;

/**
 * User: wangchen.gpx
 * Date: 13-5-29
 * Time: 上午9:05
 */
public class RegexExcludeFileFilterTest implements PathFilter{

    private String regex ;

    public RegexExcludeFileFilterTest(String regex) {
        this.regex = regex;
    }

    @Override
    public boolean accept(Path path) {
        return !path.toString().matches(regex);
    }

    public static void main(String[] args) throws IOException {
        Configuration configuration = new Configuration();
        FileSystem fileSystem = FileSystem.get(URI.create("file:///D:/a"), configuration);

        FileStatus[] fileStatuses = fileSystem.globStatus(new Path("D:/a/*"), new RegexExcludeFileFilterTest("^.*/2010-05-30$"));

        System.out.println(fileStatuses.length);
        for (FileStatus fileStatuse : fileStatuses) {
            System.out.println(fileStatuse.getPath());
        }
    }
}
