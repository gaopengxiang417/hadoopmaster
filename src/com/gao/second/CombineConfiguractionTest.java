package com.gao.second;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;

import java.util.Map;
import java.util.Set;

/**
 * User: wangchen.gpx
 * Date: 13-6-16
 * Time: 下午5:15
 */
public class CombineConfiguractionTest {
    public static void main(String[] args) {
        Configuration configuration = new Configuration();
        configuration.addResource(new Path("G:\\idea_workspace\\hadoopmaster\\src\\com\\gao\\second\\configur.xml"));
        configuration.addResource(new Path("G:\\idea_workspace\\hadoopmaster\\src\\com\\gao\\second\\configur2.xml"));

        String size = configuration.get("size");
        String weight = configuration.get("weight");
        Map<String,String> resultMap = configuration.getValByRegex("size");
        Set<Map.Entry<String,String>> entries = resultMap.entrySet();
        for (Map.Entry<String, String> entry : entries) {
            System.out.println(entry.getKey()+":"+entry.getValue());
        }

        System.out.printf("%s\t%s\n", size, weight);

    }
}
