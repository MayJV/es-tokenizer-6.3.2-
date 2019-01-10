package org.elasticsearch.gridsum.plugin;

import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.tokenattributes.CharTermAttribute;
import org.elasticsearch.gridsum.plugin.extend.GridsumAnalyzer;
import org.junit.Test;

import javax.lang.model.element.NestingKind;

public class GridsumAnalyzerTest {
    @Test
    public void testAnalyzer() throws Exception {

        GridsumAnalyzer analyzer = new GridsumAnalyzer();
        TokenStream ts = analyzer.tokenStream("text", "a,bc");
        CharTermAttribute term = ts.addAttribute(CharTermAttribute.class);
        ts.reset();
        while (ts.incrementToken()) {
            System.out.println("R:" + term.toString() + "]");
        }
        ts.end();
        ts.close();

        System.out.println("----------------------------------——————————————————————————---------");
        TokenStream tss = analyzer.tokenStream("text", "哈哈,哈哈");
        CharTermAttribute terms = tss.addAttribute(CharTermAttribute.class);
        tss.reset();
        while (tss.incrementToken()) {
            System.out.println("R:" + terms.toString() + "]");
        }
        tss.end();
        tss.close();



//        String substring = "我爱 北京 天安门".substring(0, 3);
//        System.out.println(substring + "=");
//        String substring1 = "我爱 北京 天安门".substring(3, 6);
//        System.out.println(substring1 + "=");
//        String substring2 = "我爱 北京 天安门".substring(6, 9);
//        System.out.println(substring2 + "=");


    }

}