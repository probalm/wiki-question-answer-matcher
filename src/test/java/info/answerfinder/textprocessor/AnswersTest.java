package info.answerfinder.textprocessor;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class AnswersTest {

    Answers answers;

    @Before
    public void setup(){
        String rawText = "This is first answer;Second answer;This is last answer.";
        answers = new Answers(rawText);
        answers.process();
    }

    @Test
    public void TestAnswerSplit() {
        assertEquals(3, answers.getAnswerSentences().size());
    }
}