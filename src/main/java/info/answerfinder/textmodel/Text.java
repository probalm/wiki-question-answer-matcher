package info.answerfinder.textmodel;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

public abstract class Text {

    List<Set<String>> processedTextList;

    public List<String> getSentences() {
        return sentences;
    }

    protected List<String> sentences;

    public List<Set<String>> getProcessedTextList() {
        return processedTextList;
    }

    public void splitSentences(String rawText, String delimeter){
        sentences = Arrays.asList(rawText.toLowerCase().split(delimeter));
    }

    public void setProcessedTextList(List<Set<String>> processedTextList) {
        this.processedTextList = processedTextList;
    }

}
