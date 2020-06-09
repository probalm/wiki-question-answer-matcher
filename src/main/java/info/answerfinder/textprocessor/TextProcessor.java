package info.answerfinder.textprocessor;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import info.answerfinder.textmodel.TextModel;

public class TextProcessor {
    public static final Set<String> commonWords;

    private static TextProcessor INSTANCE = new TextProcessor();

    public static TextProcessor getInstance() {
        return INSTANCE;
    }

    static {
        commonWords = CommonWordsPopulator.getCommonWords();
    }

    public void processText(TextModel model) {
        model.getParagraph().setProcessedTextList(getProcessedText(model.getParagraph().getSentences()));
        model.getQuestions().setProcessedTextList(getProcessedText(model.getQuestions().getSentences()));
        model.getAnswers().setProcessedTextList(getProcessedText(model.getAnswers().getSentences()));
    }

    public List<Set<String>> getProcessedText(List<String> textSentences){
        List<Set<String>> processedTextList = new ArrayList<>();
        for(String sentence : textSentences){
            sentence = sentence.replaceAll("[,()?]"," ");
            String[] sentenceWords = sentence.split(" ");
            Set<String> sentenceWordSet = new HashSet<>();

            for(String sentenceWord : sentenceWords){
                if(!commonWords.contains(sentenceWord)){
                    if(sentenceWord.endsWith("s"))
                    {
                        sentenceWord = sentenceWord.substring(0,sentenceWord.length()-1);
                    }
                    sentenceWordSet.add(sentenceWord);
                }
            }
            processedTextList.add(sentenceWordSet);
        }
        return processedTextList;
    }
}
