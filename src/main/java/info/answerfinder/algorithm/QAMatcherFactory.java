package info.answerfinder.algorithm;

import info.answerfinder.algorithm.QAMatcher;

public class QAMatcherFactory {
    public static QAMatcher getQAMatcher() {
        return new SimilarityQAMatcher();
    }
}
