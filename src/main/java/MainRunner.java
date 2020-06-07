import info.answerfinder.algorithm.QAMatcher;
import info.answerfinder.algorithm.QAMatcherFactory;
import info.answerfinder.exceptions.InputException;
import info.answerfinder.io.IOProcessor;
import info.answerfinder.io.IoProcessorFactory;
import info.answerfinder.textprocessor.TextModel;

public class MainRunner {

    IOProcessor ioProcessor;

    public static void main(String[] args) {
        String filePath = args[0];
        MainRunner mainRunner = new MainRunner();
        mainRunner.run(filePath);
    }

    public void run(String filePath){
        ioProcessor = IoProcessorFactory.getInstance(filePath);
        try {
            ioProcessor.processInput();
            TextModel textModel = new TextModel(ioProcessor.getParagraph(), ioProcessor.getQuestions(), ioProcessor.getAnswers());
            textModel.processText();
            QAMatcher qaMatcher = QAMatcherFactory.getQAMatcher();
            qaMatcher.match(textModel);
            ioProcessor.processOutput(textModel, qaMatcher);
        } catch (InputException e) {
            e.printStackTrace();
        }
    }
}
