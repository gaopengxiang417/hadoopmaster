package com.gao.first;

import org.apache.hadoop.io.Text;

import static org.hamcrest.core.AllOf.allOf;
import static org.hamcrest.core.Is.is;
import  static org.junit.Assert.*;

/**
 * User: wangchen.gpx
 * Date: 13-6-9
 * Time: 上午7:41
 */
public class TextTest {
    public static void main(String[] args) {
        Text text = new Text("hadoop");
        //charat and getlength
        assertThat(text.getLength() , is(6));
        assertThat("fail ",text.getBytes().length , is(6));
        assertThat(text.charAt(2) , is((int) 'd'));
        assertThat("out of bound" , text.charAt(100) , is(-1));

        //find
        assertThat("find do " , text.find("do") , is(2));
        assertThat("find the first 'o' " , text.find("o") , is(3));
        assertThat("find the 'o' from position 4" , text.find("o",4) , is(4));
        assertThat("find no match" , text.find("pig") , is(-1));
    }
}
