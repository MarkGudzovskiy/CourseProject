package sample.courseproject2;

public class Quote {

    private final String quote, teacher, lesson, date;
    private final int id;

    public Quote(int id,String quote, String teacher, String lesson, String date) {
        this.id = id;
        this.quote = quote;
        this.teacher = teacher;
        this.lesson = lesson;
        this.date = date;
    }
    public int getId() {
        return id;
    }

    public String getQuote() {
        return quote;
    }

    public String getTeacher() {
        return teacher;
    }

    public String getLesson() {
        return lesson;
    }

    public String getDate() {
        return date;
    }
}
