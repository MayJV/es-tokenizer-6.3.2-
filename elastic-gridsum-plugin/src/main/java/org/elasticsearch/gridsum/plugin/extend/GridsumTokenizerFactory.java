package org.elasticsearch.gridsum.plugin.extend;

import org.apache.lucene.analysis.Tokenizer;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.env.Environment;
import org.elasticsearch.index.IndexSettings;
import org.elasticsearch.index.analysis.AbstractTokenizerFactory;

public class GridsumTokenizerFactory extends AbstractTokenizerFactory {


    public GridsumTokenizerFactory(IndexSettings indexSettings, Environment environment, String ignored, Settings settings) {
        super(indexSettings, ignored, settings);
    }

    /**
     * 返回自定义分词器
     * @return
     */
    @Override
    public Tokenizer create() {
        return new GridsumTokenizer();
    }
}
