package info.answerfinder.textmodel;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TextTest {

    @Test
    public void TestAnswerSplit() {
        String rawText = "This is first answer;Second answer;This is last answer.";
        Text answers = new Answers(rawText);
        assertEquals(3, answers.getSentences().size());
    }

    @Test
    public void TestParagraphSplit() {
        String rawText = "This is a multi word string. It has three sentences. This is the last sentence.";
        Text paragraph = new Paragraph(rawText);
        assertEquals(3, paragraph.getSentences().size());
    }
}