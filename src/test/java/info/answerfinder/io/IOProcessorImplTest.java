package info.answerfinder.io;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import info.answerfinder.exceptions.InputException;

import static org.junit.Assert.*;

public class IOProcessorImplTest {

    private IOProcessorImpl iOProcessorImpl;

    @Before
    public void setup(){
        iOProcessorImpl = new IOProcessorImpl("dummyFilePath");

    }

    @Test(expected = InputException.class)
    public void TestMinimumInput() throws InputException {
       iOProcessorImpl.validate(1);
    }

    @Test(expected = InputException.class)
    public void TestAnswerNotMatchingQuestionCount() throws InputException {
        List<String> questionList = new ArrayList<>();
        questionList.add("One Question");
        questionList.add("One Answer; Two Answer");
        iOProcessorImpl.setQuestions(questionList);
        iOProcessorImpl.validate(3);
    }
}