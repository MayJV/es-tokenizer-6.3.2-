package org.elasticsearch.gridsum.plugin;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.lucene.analysis.Analyzer;
import org.elasticsearch.gridsum.plugin.extend.GridsumAnalyzerProvider;
import org.elasticsearch.gridsum.plugin.extend.GridsumTokenizerFactory;
import org.elasticsearch.index.analysis.AnalyzerProvider;
import org.elasticsearch.index.analysis.TokenizerFactory;
import org.elasticsearch.indices.analysis.AnalysisModule;
import org.elasticsearch.plugins.AnalysisPlugin;
import org.elasticsearch.plugins.Plugin;

import java.util.Collections;
import java.util.Map;

public class GridsumPlugin extends Plugin implements AnalysisPlugin {
    public static String PLUGIN_NAME = "analysis-gridsum"; // script name
    private final static Logger LOGGER = LogManager.getLogger(GridsumPlugin.class);

    public GridsumPlugin() {
        super();
        LOGGER.info("---- {} installed into elasticsearch ----", PLUGIN_NAME);
    }

    @Override
    public Map<String, AnalysisModule.AnalysisProvider<TokenizerFactory>> getTokenizers() {
        return Collections.singletonMap("gridsum-word", GridsumTokenizerFactory::new);
    }

    /**
     * 分词器 必须有且有一个，"analyzer":"ik_smart",就是用的这个
     * 分词器把字符串分解成单个词条或者词汇单元
     *
     * @return
     */
    @Override
    public Map<String, AnalysisModule.AnalysisProvider<AnalyzerProvider<? extends Analyzer>>> getAnalyzers() {
        return Collections.singletonMap("gridsum", GridsumAnalyzerProvider::new);
        // function name
    }
}
