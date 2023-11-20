package task1;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Підклас ConferenceWithArray, що надає методи сортування для зустрічей.
 */
public class ConferenceSortingMethods extends ConferenceWithArray {

    /**
     * Конструює об'єкт ConferenceSortingMethods із назвою, місцем проведення та масивом зустрічей.
     *
     * @param name     Назва конференції.
     * @param venue    Місце проведення конференції.
     * @param meetings Масив зустрічей, пов'язаних із конференцією.
     */
    public ConferenceSortingMethods(String name, String venue, Meeting[] meetings) {
        super(name, venue, meetings);
    }

    /**
     * Перевизначає алгоритм сортування "бульбашковим" методом для сортування зустріч за кількістю учасників.
     * Ця реалізація використовує метод сортування з класу Arrays.
     */
    @Override
    public void bubbleSortMeetingsByParticipants() {
        Arrays.sort(getMeetings());
    }

    /**
     * Перевизначає алгоритм сортування вставкою для сортування зустріч за назвою.
     * Ця реалізація використовує метод сортування з класу Arrays з Comparator, що базується на темах зустріч.
     */
    @Override
    public void insertionSortMeetingsByName() {
        Arrays.sort(getMeetings(), Comparator.comparing(Meeting::getTopic));
    }
}
