package info.answerfinder.textprocessor;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ParagraphTest {

    Paragraph paragraph;

    @Before
    public void setup(){
        String rawText = "This is a multi word string. It has three sentences. This is the last sentence.";
        paragraph = new Paragraph(rawText);
        paragraph.process();
    }

    @Test
    public void TestSentenceSplit() {
        assertEquals(3, paragraph.getSentences().size());
    }
}