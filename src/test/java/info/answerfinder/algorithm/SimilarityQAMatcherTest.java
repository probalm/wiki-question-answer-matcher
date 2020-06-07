package info.answerfinder.algorithm;

import java.util.HashSet;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class SimilarityQAMatcherTest {

    private SimilarityQAMatcher similarityQAMatcher;

    @Before
    public void setup(){
        similarityQAMatcher = new SimilarityQAMatcher();
    }

    @Test
    public void TestNoMatch() {
        Set<String> set1 = new HashSet();
        set1.add("Hello");
        set1.add("World");

        Set<String> set2 = new HashSet<>();
        set2.add("Second");
        set2.add("Set");

        assertEquals(0.0, similarityQAMatcher.similarity(set1,set2), 0.05);
    }

    @Test
    public void Test50percmatch() {
        Set<String> set1 = new HashSet();
        set1.add("First");
        set1.add("Sentence");

        Set<String> set2 = new HashSet<>();
        set2.add("Second");
        set2.add("Sentence");

        assertEquals(0.5, similarityQAMatcher.similarity(set1,set2), 0.05);
    }
}