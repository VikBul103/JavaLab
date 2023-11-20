package task1;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class TextFileOperations extends FileOperations {

    public TextFileOperations(String name, String venue, List<Meeting> meetings) {
        super(name, venue, meetings);
    }

    @Override
    public void readFromFile(String fileName) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        String line;
        while ((line = reader.readLine()) != null) {
            // Assuming the format of each line is "Дата: [date], Тема: [topic], Учасники: [participants]"
            String[] parts = line.split(", ");
            String date = parts[0].substring("Дата: ".length());
            String topic = parts[1].substring("Тема: ".length());
            int participants = Integer.parseInt(parts[2].substring("Учасники: ".length()));

            // Create a Meeting object and add it to the meetingList
            addMeeting(new Meeting(date, topic, participants));
        }
        reader.close();
    }

    @Override
    public void writeToFile(String fileName) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));
        for (Meeting meeting : getMeetings()) {
            writer.write(meeting.toString());
            writer.newLine();
        }
        writer.close();
    }

    @Override
    public void sortAndWriteToFile(String inputFileName, String outputFileName) throws IOException {
        readFromFile(inputFileName);
        sortMeetingsByParticipants(); // Or use any other sorting method
        writeToFile(outputFileName);
    }
}
