package info.answerfinder.textmodel;

public class Paragraph extends Text{
    String rawParagraph;

    public Paragraph(String paragraph) {
        this.rawParagraph = paragraph;
        splitSentences(rawParagraph, "[.]");
    }
}
