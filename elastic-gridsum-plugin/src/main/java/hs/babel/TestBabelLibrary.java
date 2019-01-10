package hs.babel;


import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.tokenattributes.CharTermAttribute;
import org.elasticsearch.gridsum.plugin.extend.GridsumAnalyzer;

import java.io.IOException;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.Analyzer;

public class TestBabelLibrary {

    public static void main(String[] args) throws IOException {


        long Conv = HSBabelLibrary.initConv();

        String instr = "S(=O)(=O)(C(F)(F)F)Oc1cc2CN(CCc2cc1)CCCCNC(=O)/C=C/c1cc2c(nccc2)cc1";
//        String instr = "N[C@@H](C(=O)O)C";
        // 索引
        System.out.println("输入：" + instr );
        String fptvec_str = HSBabelLibrary.ConvFullConvert(Conv, instr);
        System.out.println("索引:" + fptvec_str + "]");

        // 分词
        String descr = HSBabelLibrary.GetOBFingerprint(Conv, fptvec_str);
        System.out.println("分词：" + descr + "]");


    }
}
