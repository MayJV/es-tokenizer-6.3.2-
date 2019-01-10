package org.elasticsearch.gridsum.plugin.extend;

import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.env.Environment;
import org.elasticsearch.index.IndexSettings;
import org.elasticsearch.index.analysis.AbstractIndexAnalyzerProvider;

public class GridsumAnalyzerProvider extends AbstractIndexAnalyzerProvider<GridsumAnalyzer> {

    private final GridsumAnalyzer gridsumAnalyzer;

    public GridsumAnalyzerProvider(IndexSettings indexSettings, Environment environment, String name, Settings settings) {
        super(indexSettings, name, settings);
        gridsumAnalyzer = new GridsumAnalyzer();
    }

    /**
     * 重写GET 方法返回自定义分词器
     * @return
     */
    @Override
    public GridsumAnalyzer get() {
        return gridsumAnalyzer;
    }
}
