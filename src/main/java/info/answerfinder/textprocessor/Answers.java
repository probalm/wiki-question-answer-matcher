package info.answerfinder.textprocessor;

import java.util.Arrays;
import java.util.List;

public class Answers extends Text{

    private final String rawAnswers;
    private List<String> answerSentences;

    public Answers(String answers) {
        this.rawAnswers = answers;
    }

    public void process(){
        answerSentences = Arrays.asList(rawAnswers.toLowerCase().split(";"));
        process(answerSentences);
    }

    public List<String> getAnswerSentences(){
        return answerSentences;
    }
}
