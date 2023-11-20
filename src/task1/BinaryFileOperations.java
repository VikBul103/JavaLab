package task1;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class BinaryFileOperations extends FileOperations {

    public BinaryFileOperations(String name, String venue, List<Meeting> meetings) {
        super(name, venue, meetings);
    }

    @Override
    public void readFromFile(String fileName) throws IOException {
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName));
        try {
            List<Meeting> loadedMeetings = (List<Meeting>) ois.readObject();
            for (Meeting meeting : loadedMeetings) {
                addMeeting(meeting);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            ois.close();
        }
    }

    @Override
    public void writeToFile(String fileName) throws IOException {
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName));
        oos.writeObject(getMeetings());
        oos.close();
    }

    @Override
    public void sortAndWriteToFile(String inputFileName, String outputFileName) throws IOException {
        readFromFile(inputFileName);
        sortMeetingsByParticipants(); // Or use any other sorting method
        writeToFile(outputFileName);
    }
}
