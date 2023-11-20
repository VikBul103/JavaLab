package task1;

import java.io.*;
import java.util.List;

abstract class FileOperations extends ConferenceWithList {

    public FileOperations(String name, String venue, List<Meeting> meetings) {
        super(name, venue, meetings);
    }

    public abstract void readFromFile(String fileName) throws IOException;
    public abstract void writeToFile(String fileName) throws IOException;

    public abstract void sortAndWriteToFile(String inputFileName, String outputFileName) throws IOException;

}

