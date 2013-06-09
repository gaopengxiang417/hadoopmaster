package com.gao.first;

import org.apache.hadoop.io.Text;
import org.junit.Test;

import java.nio.charset.Charset;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * User: wangchen.gpx
 * Date: 13-6-9
 * Time: 上午8:07
 */
public class StringAndTextCompareTest {
    String str = "\u0041\u00df\u6771\ud801\udc00";

    @Test
    public void testString(){
        assertThat(str.length() , is(5));
        assertThat(str.getBytes(Charset.forName("utf-8")).length , is(10));

        assertThat(str.indexOf("\u0041") , is(0));
        assertThat(str.indexOf("\u00df") , is(1));
        assertThat(str.indexOf("\u6771") , is(2));
        assertThat(str.indexOf("\ud801") , is(3));
        assertThat(str.indexOf("\udc00") , is(4));

        assertThat(str.charAt(0) , is('\u0041'));
        assertThat(str.charAt(1) , is('\u00df'));
        assertThat(str.charAt(2) , is('\u6771'));
        assertThat(str.charAt(3) , is('\ud801'));
        assertThat(str.charAt(4) , is('\udc00'));

        assertThat(str.codePointAt(0) , is(0x0041));
        assertThat(str.codePointAt(1) , is(0x00df));
        assertThat(str.codePointAt(2) , is(0x6771));
        assertThat(str.codePointAt(3) , is(0x10400));

    }

    @Test
    public void testText(){
        Text text = new Text(str);

        assertThat(text.getLength() , is(10));
        assertThat(text.find("\u0041") , is(0));
        assertThat(text.find("\u00df") , is(1));
        assertThat(text.find("\u6771") , is(3));
        assertThat(text.find("\ud801\udc00") , is(6));

        assertThat(text.charAt(0) , is(0x0041));
        assertThat(text.charAt(1) , is(0x00df));
        assertThat(text.charAt(3) , is(0x6771));
        assertThat(text.charAt(6) , is(0x10400));

    }
}
