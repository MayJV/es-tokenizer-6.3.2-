package org.elasticsearch.gridsum.plugin.extend;

import com.sun.javafx.collections.MappingChange;
import hs.babel.HSBabelLibrary;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.lucene.analysis.Tokenizer;
import org.apache.lucene.analysis.tokenattributes.CharTermAttribute;
import org.apache.lucene.analysis.tokenattributes.OffsetAttribute;
import org.elasticsearch.common.recycler.Recycler;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class GridsumTokenizer extends Tokenizer {

//    private final static Logger LOGGER = LogManager.getLogger(GridsumTokenizer.class);
//    private final static String PUNCTION = " -()/";
//    private final StringBuilder buffer = new StringBuilder();
    private int suffixOffset;
    private int tokenStart = 0, tokenEnd = 0;
    private final CharTermAttribute termAtt = addAttribute(CharTermAttribute.class);
    private final OffsetAttribute offsetAtt = addAttribute(OffsetAttribute.class);

    private char[] buffer1 = new char[256];
    private static int MAX_SIZE;
    private int termSize;
    private static String[] splitTup;
    int ci;
//


    /**
     * 分词程序
     *
     * @return
     * @throws IOException
     */
    @Override
    public final boolean incrementToken() throws IOException {

/*        clearAttributes();

        if (termSize != -1) {
            termSize = input.read(buffer);
            if (termSize >= 0) {
                MAX_SIZE = termSize;
            }

//            String fptvec_str = HSBabelLibrary.ConvFullConvert(Conv, "-:" + new String(buffer));
//            String descr = HSBabelLibrary.GetOBFingerprint(Conv, fptvec_str);
            String descr = new String(buffer);
            splitTup = descr.split(" ");
        }

//        if (suffixOffset <= MAX_SIZE) {
//            termAtt.append("属性" + suffixOffset);
//            suffixOffset++;
//            return true;
//        }

//        for (String fc : splitTup){
//            termAtt.append(fc);
//            return true;
//        }
        if ( suffixOffset < splitTup.length ) {
            String string = splitTup[suffixOffset];
            termAtt.append(string);
            suffixOffset++;
            return true;
        }

        return false;*/

//        try {
//            System.out.println("--------- ready clear!!! ----------");
//            clearAttributes();
//
//            System.out.println("termSize:" + termSize);
//            System.out.println(buffer);
//            System.out.println("MAX_SIZE:" + MAX_SIZE);
//            System.out.println("suffixOffset:" + suffixOffset);
//            System.out.println(termAtt.buffer());
//            System.out.println("offsetAtt.startOffset():" + offsetAtt.startOffset());
//            System.out.println("offsetAtt.endOffset():" + offsetAtt.endOffset());
//
//
//            if (termSize != -1) {
//                termSize = input.read(buffer);
//                if (termSize >= 0) {
//                    MAX_SIZE = termSize;
//                }
//            }else {
//                return false;
//            }
//
//            if (suffixOffset + 1 >= MAX_SIZE) {
//                return false;
//            }
//
//            termAtt.setEmpty().copyBuffer(buffer, suffixOffset, MAX_SIZE);
//
//            termAtt.setLength(MAX_SIZE - suffixOffset);
//            offsetAtt.setOffset(correctOffset(suffixOffset), correctOffset(MAX_SIZE));
//            LOGGER.debug(termAtt.buffer());
//            suffixOffset++;
//        } catch (Exception e) {
//            LOGGER.error(e.getMessage(), e);
//        }
//
//        return true;


        clearAttributes();
        ci = input.read(buffer1);

        if (ci != -1) {
            if (ci >= 0) {
                getList(String.valueOf(buffer1,0,ci));
                MAX_SIZE = splitTup.length;
            }
        }

        if (termSize >= MAX_SIZE) {

            return false;

        } else {
            termAtt.setEmpty().append(splitTup[termSize]);
            termSize++;
            return true;
        }
    }


    @Override
    public final void end() {
        final int finalOffset = correctOffset(suffixOffset);
        this.offsetAtt.setOffset(finalOffset, finalOffset);
    }

    @Override
    public void reset() throws IOException {
        super.reset();
        tokenStart = tokenEnd = 0;
        /* 重置buffer1 不影响后续输入值 */
        buffer1 = new char[256];
        termSize = 0;
        MAX_SIZE = 0;

    }

    public static void getList(String cc) {
        long Conv = HSBabelLibrary.initConv();
        String fptvec_str = HSBabelLibrary.ConvFullConvert(Conv, cc.trim());
        String descr = "";
        if (fptvec_str.length() > 11) {
             descr = HSBabelLibrary.GetOBFingerprint(Conv, fptvec_str);
        }
        splitTup = descr.split("\n");

    }


}
