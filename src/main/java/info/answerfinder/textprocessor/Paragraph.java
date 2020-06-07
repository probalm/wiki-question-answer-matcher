package info.answerfinder.textprocessor;

import java.util.Arrays;
import java.util.List;

public class Paragraph extends Text{
    String rawParagraph;
    List<String> sentences;

    public Paragraph(String paragraph) {
        this.rawParagraph = paragraph;
    }

    public void process() {
        sentences = Arrays.asList(rawParagraph.toLowerCase().split("[.]"));
        process(sentences);
    }

    public List<String> getSentences() {
        return sentences;
    }
}
