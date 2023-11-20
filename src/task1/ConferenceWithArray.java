package task1;

/**
 * Представляє конференцію, яка містить масив зустрічей.
 */
public class ConferenceWithArray extends Conference {
    private Meeting[] meetings;

    /**
     * Конструює об'єкт ConferenceWithArray з назвою, місцем проведення та масивом зустрічей.
     *
     * @param name     Назва конференції.
     * @param venue    Місце проведення конференції.
     * @param meetings Масив зустрічей, пов'язаних з конференцією.
     */
    public ConferenceWithArray(String name, String venue, Meeting[] meetings) {
        super(name, venue);
        this.meetings = meetings;
    }

    /**
     * Отримати масив зустрічей, пов'язаних із цією конференцією.
     *
     * @return Масив зустрічей.
     */
    @Override
    public Meeting[] getMeetings() {
        return meetings;
    }
}