package task1;

import java.io.Serializable;

/**
 * Представляє об'єкт Meeting з датою, темою та кількістю учасників.
 */
public class Meeting implements Comparable<Meeting> {
    private String date;
    private String topic;
    private int participants;

    /**
     * Конструктор для створення об'єкту Meeting із заданою датою, темою та кількістю учасників.
     *
     * @param date         Дата зустрічі.
     * @param topic        Тема зустрічі.
     * @param participants Кількість учасників на зустрічі.
     */
    public Meeting(String date, String topic, int participants) {
        this.date = date;
        this.topic = topic;
        this.participants = participants;
    }

    /**
     * Стандартний конструктор Meeting.
     */
    public Meeting() {

    }

    /**
     * Отримати дату зустрічі.
     *
     * @return Дата зустрічі.
     */
    public String getDate() {
        return date;
    }

    /**
     * Встановити дату зустрічі.
     *
     * @param date Нова дата зустрічі.
     */
    public void setDate(String date) {
        this.date = date;
    }

    /**
     * Отримати тему зустрічі.
     *
     * @return Тема зустрічі.
     */
    public String getTopic() {
        return topic;
    }

    /**
     * Встановити тему зустрічі.
     *
     * @param topic Нова тема зустрічі.
     */
    public void setTopic(String topic) {
        this.topic = topic;
    }

    /**
     * Отримати кількість учасників на зустрічі.
     *
     * @return Кількість учасників на зустрічі.
     */
    public int getParticipants() {
        return participants;
    }

    /**
     * Встановити кількість учасників на зустрічі.
     *
     * @param participants Нова кількість учасників на зустрічі.
     */
    public void setParticipants(int participants) {
        this.participants = participants;
    }

    /**
     * Порівнює об'єкти Meeting на основі кількості учасників.
     *
     * @param o Об'єкт Meeting для порівняння.
     * @return Значення, що вказує на порівняння двох зустрічей за кількістю учасників.
     */
    @Override
    public int compareTo(Meeting o) {
        return Integer.compare(getParticipants(), o.getParticipants());
    }

    /**
     * Отримати рядкове представлення об'єкту Meeting.
     *
     * @return Рядкове представлення, що містить дату, тему та кількість учасників.
     */
    @Override
    public String toString() {
        return "Дата: " + date + ", Тема: " + topic + ", Учасники: " + participants;
    }

    /**
     * Перевіряє, чи рівні два об'єкта Meeting за їх датою, темою та кількістю учасників.
     *
     * @param obj Об'єкт для порівняння.
     * @return true, якщо об'єкти рівні, інакше false.
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Meeting that = (Meeting) obj;
        return participants == that.participants &&
                date.equals(that.date) &&
                topic.equals(that.topic);
    }

    /**
     * Генерує хеш-код на основі дати, теми та кількості учасників об'єкту Зустрічі.
     *
     * @return Хеш-код об'єкта Meeting.
     */
    @Override
    public int hashCode() {
        int result = date.hashCode();
        result = 31 * result + topic.hashCode();
        result = 31 * result + participants;
        return result;
    }

    /**
     * Метод для тестування класу Meeting шляхом встановлення значень за замовчуванням та відображення інформації.
     */
    protected void testMeeting() {
        setDate("2020-20-02");
        setParticipants(20);
        setTopic("Тест");
        System.out.println(this);
    }

    /**
     * Головний метод для демонстрації функціональності методу testMeeting().
     * Створює об'єкт Зустрічі та викликає метод testMeeting().
     *
     * @param args Аргументи командного рядка (не використовуються).
     */
    public static void main(String[] args) {
        new Meeting().testMeeting();
    }
}
