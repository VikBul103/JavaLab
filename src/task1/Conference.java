package task1;


/**
 * Абстрактний клас, що представляє конференцію.
 */
public abstract class Conference {
    private String name;
    private String venue;

    /**
     * Конструктор для ініціалізації назви та місця проведення конференції.
     *
     * @param name  Назва конференції
     * @param venue Місце проведення конференції
     */
    public Conference(String name, String venue) {
        this.name = name;
        this.venue = venue;
    }

    /**
     * Отримати назву конференції.
     *
     * @return Назва конференції
     */
    public String getName() {
        return name;
    }

    /**
     * Встановити назву конференції.
     *
     * @param name Нова назва конференції
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Отримати місце проведення конференції.
     *
     * @return Місце проведення конференції
     */
    public String getVenue() {
        return venue;
    }

    /**
     * Встановити місце проведення конференції.
     *
     * @param venue Нове місце проведення конференції
     */
    public void setVenue(String venue) {
        this.venue = venue;
    }

    /**
     * Абстрактний метод для отримання масиву зустрічей на конференції.
     *
     * @return Масив об'єктів типу Meeting, які представляють зустрічі на конференції
     */
    public abstract Meeting[] getMeetings();

    /**
     * Перевизначення методу toString для отримання рядкового представлення конференції.
     *
     * @return Рядкове представлення конференції, що містить назву та місце проведення
     */
    @Override
    public String toString() {
        return "Name: " + name + ", Venue: " + venue;
    }

    /**
     * Перевизначення методу equals для порівняння двох конференцій за назвою та місцем проведення.
     *
     * @param obj Об'єкт, з яким порівнюється поточний об'єкт
     * @return true, якщо об'єкти рівні, інакше false
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Conference that = (Conference) obj;
        return name.equals(that.name) && venue.equals(that.venue);
    }

    /**
     * Перевизначення методу hashCode для обчислення хеш-коду конференції на основі назви та місця проведення.
     *
     * @return Хеш-код об'єкта конференції
     */
    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + venue.hashCode();
        return result;
    }

    /**
     * Отримати довжину назви конференції.
     *
     * @return Довжина назви конференції
     */
    public int findNameLength() {
        return name.length();
    }

    /**
     * Сортування зустрічей за кількістю учасників методом "бульбашкового" сортування.
     */
    public void bubbleSortMeetingsByParticipants() {
        Meeting[] meetings = getMeetings();
        int n = meetings.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (meetings[j].getParticipants() > meetings[j + 1].getParticipants()) {
                    Meeting temp = meetings[j];
                    meetings[j] = meetings[j + 1];
                    meetings[j + 1] = temp;
                }
            }
        }
    }

    /**
     * Сортування зустрічей за назвою методом вставки.
     */
    public void insertionSortMeetingsByName() {
        Meeting[] meetings = getMeetings();
        int n = meetings.length;
        for (int i = 1; i < n; i++) {
            Meeting key = meetings[i];
            int j = i - 1;
            while (j >= 0 && meetings[j].getTopic().compareTo(key.getTopic()) > 0) {
                meetings[j + 1] = meetings[j];
                j = j - 1;
            }
            meetings[j + 1] = key;
        }
    }

    /**
     * Обчислення середньої кількості учасників у зустрічах конференції.
     *
     * @return Середня кількість учасників у зустрічах
     */
    public int calculateAverageParticipants() {
        Meeting[] meetings = getMeetings();
        int totalParticipants = 0;
        for (Meeting meeting : meetings) {
            totalParticipants += meeting.getParticipants();
        }
        return totalParticipants / meetings.length;
    }

    /**
     * Знаходження зустрічі з найбільшою кількістю учасників на конференції.
     *
     * @return Зустріч з найбільшою кількістю учасників
     */
    public Meeting findLargestMeeting() {
        Meeting[] meetings = getMeetings();
        Meeting largestMeeting = meetings[0];
        for (Meeting meeting : meetings) {
            if (meeting.getParticipants() > largestMeeting.getParticipants()) {
                largestMeeting = meeting;
            }
        }
        return largestMeeting;
    }

    /**
     * Виконання основного завдання конференції, включаючи обчислення середньої кількості учасників у зустрічах,
     * знаходження найбільшої за кількістю учасників зустрічі та визначення довжини назви конференції.
     */
    public void performMainTask() {
        Meeting[] meetings = getMeetings();
        int averageParticipants = calculateAverageParticipants();
        Meeting largestMeeting = findLargestMeeting();
        int nameLength = findNameLength();

        System.out.println("Середня кількість учасників у зустрічах: " + averageParticipants);
        System.out.println("Зустріч з найбільшою кількістю учасників: " + largestMeeting);
        System.out.println("Довжина назви: " + nameLength);
    }
}












