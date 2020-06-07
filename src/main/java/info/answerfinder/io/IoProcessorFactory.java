package info.answerfinder.io;

import info.answerfinder.io.IOProcessor;
import info.answerfinder.io.IOProcessorImpl;

public class IoProcessorFactory {

    public static IOProcessor getInstance(String filePath){
        return new IOProcessorImpl(filePath);
    }
}
