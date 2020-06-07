package info.answerfinder.textprocessor;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TextTest {

    List<String> strList;
    Text text;
    List<Set<String>> list;

    @Before
    public void setup(){
        strList = new ArrayList<>();
        strList.add("What to test ? ");
        strList.add("This Text(text) is to test brackets");
        strList.add("This is a common word test");
        text = new Paragraph("");
        text.process(strList);
        list = text.getProcessedTextList();
    }

    @Test
    public void TestNoQuestionMark() {
        assertFalse(list.stream().anyMatch(set -> set.stream().anyMatch(str -> str.contains("?"))));
    }

    @Test
    public void TestNoBrackets() {
        assertFalse(list.stream().anyMatch(set -> set.stream().anyMatch(str -> str.contains("(") || str.contains(")"))));
    }

    @Test
    public void TestNoCommonWords(){
        assertFalse(list.stream().anyMatch(set -> set.stream().anyMatch(str -> text.commonWords.contains(str))));
    }

    @Test
    public void TestWordCountAfterProcessing(){
        assertEquals(4, list.get(2).size());
    }

}