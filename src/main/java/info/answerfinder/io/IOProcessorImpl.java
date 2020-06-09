package info.answerfinder.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import info.answerfinder.algorithm.QAMatcher;
import info.answerfinder.exceptions.InputException;
import info.answerfinder.textmodel.TextModel;

public class IOProcessorImpl implements IOProcessor {

    String paragraph;
    List<String> questions;
    String answers;

    private final String filePath;

    public String getParagraph() {
        return paragraph;
    }

    public List<String> getQuestions() {
        return questions;
    }

    public String getAnswers() {
        return answers;
    }

    public IOProcessorImpl(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public void processInput() throws InputException {
        FileInputStream input= null;
        questions = new ArrayList<>();
        try {
            input = new FileInputStream(filePath);
        } catch (FileNotFoundException e) {
            throw new InputException(e);
        }
        Scanner scanner = new Scanner(input);

        int lineNumber = 0;
        while(scanner.hasNext()){
            if(lineNumber==0){
                paragraph = scanner.nextLine();
            }
            else{
                questions.add(scanner.nextLine().toLowerCase());
            }
            lineNumber++;
        }
        validate(lineNumber);
        answers = questions.get(questions.size()-1);
        questions.remove(questions.size()-1);
    }

    public void setQuestions(List<String> list) {
        this.questions = list;
    }

    protected void validate(int totalLine) throws InputException {
        if(totalLine<3){
            throw new InputException("Minimum lines less than 3");
        }
        if(questions.get(questions.size() - 1).split(";").length != totalLine-2){
            throw new InputException("Answer count does not match question count");
        }
    }

    @Override
    public void processOutput(TextModel textModel, QAMatcher qaMatcher) {
        for(int i = 0 ; i < qaMatcher.getBestMatch().length; i++){
            System.out.println(textModel.getAnswers().getSentences().get(qaMatcher.getBestMatch()[i]));
        }
    }
}
