package info.answerfinder.textprocessor;

import java.util.List;

public class Questions extends Text{

    List<String> questions;

    public Questions(List<String> questions) {
        this.questions = questions;
    }

    public void process(){
        process(questions);
    }
}
