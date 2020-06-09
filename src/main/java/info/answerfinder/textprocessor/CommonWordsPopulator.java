package info.answerfinder.textprocessor;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class CommonWordsPopulator {

    private static String configFilePath = "src/main/resources/commonwords.config";

    public static Set<String> getCommonWords() {
        Set<String> commonWords = new HashSet<>();
        FileInputStream input= null;
        try {
            input = new FileInputStream(configFilePath);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Scanner scanner = new Scanner(input);
        while(scanner.hasNext()){
            commonWords.add(scanner.next().toLowerCase());
        }
        return  commonWords;
    }

}

