package info.answerfinder.textmodel;

public class Answers extends Text {

    private final String rawAnswers;

    public Answers(String answers) {
        this.rawAnswers = answers;
        splitSentences(rawAnswers, ";");
    }
}
