package info.answerfinder.textprocessor;

import java.util.Collection;
import java.util.List;

import info.answerfinder.textprocessor.Answers;
import info.answerfinder.textprocessor.Paragraph;
import info.answerfinder.textprocessor.Questions;

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

    public void processText() {
        paragraph.process();
        questions.process();
        answers.process();
    }
}
