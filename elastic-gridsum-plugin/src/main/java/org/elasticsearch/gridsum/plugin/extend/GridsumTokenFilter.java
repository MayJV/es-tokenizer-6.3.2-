package org.elasticsearch.gridsum.plugin.extend;

import org.apache.lucene.analysis.FilteringTokenFilter;
import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.tokenattributes.CharTermAttribute;

import java.io.IOException;

public class GridsumTokenFilter extends FilteringTokenFilter {

    private final CharTermAttribute termAtt = addAttribute(CharTermAttribute.class);

    public GridsumTokenFilter(TokenStream in) {
        super(in);
    }

    /**
     * Override this method and return if the current input token should be returned by {@link #incrementToken}.
     */
    @Override
    protected boolean accept() throws IOException {
        return termAtt.toString().equals("gridsum");
    }
}
