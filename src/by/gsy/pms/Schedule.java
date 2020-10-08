package by.gsy.pms;


public class Schedule implements Comparable<Schedule>{
    private String subject;
    private String teacher;
    private int cours;
    private int numberLectures;
    private int numberPractice;
    private String dayOfWeek;
    private String time;

    public Schedule(String subject, String teacher, int cours, int numberLectures, int numberPractice, String dayOfWeek, String time) {
        this.subject = subject;
        this.teacher = teacher;
        this.cours = cours;
        this.numberLectures = numberLectures;
        this.numberPractice = numberPractice;
        this.dayOfWeek = dayOfWeek;
        this.time = time;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getTeacher() {
        return teacher;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }

    public int getCours() {
        return cours;
    }

    public void setCours(int cours) {
        this.cours = cours;
    }

    public int getNumberLectures() {
        return numberLectures;
    }

    public void setNumberLectures(int numberLectures) {
        this.numberLectures = numberLectures;
    }

    public int getNumberPractice() {
        return numberPractice;
    }

    public void setNumberPractice(int numberPractice) {
        this.numberPractice = numberPractice;
    }

    public String getDayOfWeek() {
        return dayOfWeek;
    }

    public void setDayOfWeek(String dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return
                "предмет='" + subject + '\'' +
                        ", преподаватель='" + teacher + '\'' +
                        ", курс=" + cours +
                        ", кол-во лекций=" + numberLectures +
                        ", кол-во практических=" + numberLectures +
                        ", день недели=" + dayOfWeek +
                        ", время проведения=" + time;
    }

    @Override
    public int compareTo(Schedule that) {
        return this.subject.compareTo(that.getSubject());
    }
}
