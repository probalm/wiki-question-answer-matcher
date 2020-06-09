package info.answerfinder.algorithm;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import info.answerfinder.textmodel.TextModel;

public class SimilarityQAMatcher implements QAMatcher {

    private int[] bestMatch;

    @Override
    public int[] getBestMatch() {
        return bestMatch;
    }

    @Override
    public void match(TextModel textModel) {
        List<Set<String>> questions = textModel.getQuestions().getProcessedTextList();
        List<Set<String>> answers = textModel.getAnswers().getProcessedTextList();
        List<Set<String>> sentences = textModel.getParagraph().getProcessedTextList();
        bestMatch = new int[questions.size()];
        for(int i = 0; i < questions.size(); i++){
            float maxMatch = 0;
            for(int j = 0; j < answers.size(); j++){
                for(Set<String> sentenceSet: sentences){
                    float matchCount = similarity(sentenceSet,questions.get(i)) *
                            similarity(sentenceSet,answers.get(j));
                    if(matchCount > maxMatch ){
                        maxMatch = matchCount;
                        bestMatch[i] = j;
                    }
                }
            }
        }
    }

    public float similarity(Set set1, Set set2){
        Set<String> tempSet = new HashSet<>(set1);
        tempSet.retainAll(set2);
        return (float)tempSet.size()/set2.size();
    }
}
