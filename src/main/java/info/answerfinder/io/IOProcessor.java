package info.answerfinder.io;

import java.util.List;

import info.answerfinder.algorithm.QAMatcher;
import info.answerfinder.exceptions.InputException;
import info.answerfinder.textmodel.TextModel;

public interface IOProcessor {

    void processInput () throws InputException;

    String getParagraph();
    String getAnswers();
    List<String> getQuestions();

    void processOutput(TextModel textModel, QAMatcher qaMatcher);
}
