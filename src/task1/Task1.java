package task1;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
/**
 * Представляє завдання для демонстрації операцій з Конференцією та Зустрічами.
 */
public class Task1 {
    /**
     * Основний метод, що демонструє різноманітні операції з Конференцією та Зустрічами.
     *
     * @param args Аргументи командного рядка (не використовуються).
     */
    public static void main(String[] args) {
        // Creating a list of meetings
        List<Meeting> meetings = new ArrayList<>();
        meetings.add(new Meeting("2023-11-20", "Meeting A", 30));
        meetings.add(new Meeting("2023-11-21", "Meeting B", 20));
        meetings.add(new Meeting("2023-11-22", "Meeting C", 25));

        // Testing TextFileOperations
        TextFileOperations textFileOperations = new TextFileOperations("ConferenceText", "VenueText", meetings);
        try {
            // Writing meetings to a text file
            textFileOperations.writeToFile("textFile.txt");

            // Reading meetings from the text file and sorting by participants
            textFileOperations.sortAndWriteToFile("textFile.txt", "sortedTextFile.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Testing BinaryFileOperations
        BinaryFileOperations binaryFileOperations = new BinaryFileOperations("ConferenceBinary", "VenueBinary", meetings);
        try {
            // Writing meetings to a binary file
            binaryFileOperations.writeToFile("binaryFile.dat");

            // Reading meetings from the binary file and sorting by participants
            binaryFileOperations.sortAndWriteToFile("binaryFile.dat", "sortedBinaryFile.dat");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
