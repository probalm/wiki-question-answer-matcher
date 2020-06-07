package info.answerfinder.algorithm;

import info.answerfinder.textprocessor.TextModel;

public interface QAMatcher {
    void match(TextModel textModel);
    int[] getBestMatch();
}
