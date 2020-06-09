package info.answerfinder.algorithm;

import info.answerfinder.textmodel.TextModel;

public interface QAMatcher {
    void match(TextModel textModel);
    int[] getBestMatch();
}
