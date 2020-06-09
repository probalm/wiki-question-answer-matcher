package info.answerfinder.textmodel;

import java.util.List;

public class TextModel {
    Paragraph paragraph;
    Questions questions;
    Answers answers;

    public TextModel(String paragraph, List<String> questions, String answers) {
        this.paragraph = new Paragraph(paragraph);
        this.questions = new Questions(questions);
        this.answers = new Answers(answers);
    }

    public Questions getQuestions() {
        return questions;
    }

    public Answers getAnswers() {
        return answers;
    }

    public Paragraph getParagraph() {
        return paragraph;
    }

}
