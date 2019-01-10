package org.elasticsearch.gridsum.plugin.extend;


import org.apache.lucene.analysis.Analyzer;

public class GridsumAnalyzer extends Analyzer {

    /**
     * 需要塞一个分词器
     * @param fieldName
     * @return
     */
    @Override
    protected TokenStreamComponents createComponents(String fieldName) {
        return new TokenStreamComponents(new GridsumTokenizer());
    }
}
