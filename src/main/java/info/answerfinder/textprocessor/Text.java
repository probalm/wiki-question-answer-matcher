package info.answerfinder.textprocessor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public abstract class Text {
    static final  Set<String> commonWords;

    static{
        commonWords = CommonWordsPopulator.getCommonWords();
    }

    public List<Set<String>> getProcessedTextList() {
        return processedTextList;
    }

    List<Set<String>> processedTextList;

    protected void process(List<String> sentences){
        processedTextList = new ArrayList<>();
        for(String sentence : sentences){
            sentence = sentence.replaceAll("[,()?]"," ");
            String[] sentenceWords = sentence.split(" ");
            Set<String> sentenceWordSet = new HashSet<>();

            for(String sentenceWord : sentenceWords){
                if(sentenceWord.endsWith("s"))
                {
                    sentenceWord = sentenceWord.substring(0,sentenceWord.length()-1);
                }
                if(!commonWords.contains(sentenceWord)){
                    sentenceWordSet.add(sentenceWord);
                }
            }
            processedTextList.add(sentenceWordSet);
        }
    }
}
