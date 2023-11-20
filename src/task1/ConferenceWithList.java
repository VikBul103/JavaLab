package task1;

import java.util.Collections;
import java.util.List;
import java.util.Comparator;

/**
 * Клас ConferenceWithList розширює клас Conference
 * і використовує список (List) для зберігання зустрічей (Meeting).
 */
public class ConferenceWithList extends Conference {
    private List<Meeting> meetingList;


    public ConferenceWithList(String name, String venue, List<Meeting> meetings) {
        super(name, venue);
        this.meetingList = meetings;
    }

    @Override
    public Meeting[] getMeetings() {
        return meetingList.toArray(new Meeting[0]);
    }


    public void addMeeting(Meeting meeting) {
        meetingList.add(meeting);
    }


    public void sortMeetingsByParticipants() {
        Collections.sort(meetingList);
    }


    public void sortMeetingsByName() {
        Collections.sort(meetingList, Comparator.comparing(Meeting::getTopic));
    }
}
