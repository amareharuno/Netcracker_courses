package by.netcracker.bsuir.pz2.entity;

import java.util.Objects;

public class Course {
    private int id;
    private String subject;
    private String courseName;
    private int lessonsCount;
    private int lessonDuration;
    private Teacher teacher;
    private int courseDuration;

    public Course() {
    }

    public Course(String subject, String courseName, int lessonsCount, int lessonDuration, Teacher teacher) {
        this.subject = subject;
        this.courseName = courseName;
        this.lessonsCount = lessonsCount;
        this.lessonDuration = lessonDuration;
        this.teacher = teacher;
        this.courseDuration = lessonsCount * lessonDuration;
    }

    public Course(int id, String subject, String courseName, int lessonsCount, int lessonDuration, Teacher teacher) {
        this.id = id;
        this.subject = subject;
        this.courseName = courseName;
        this.lessonsCount = lessonsCount;
        this.lessonDuration = lessonDuration;
        this.teacher = teacher;
        this.courseDuration = lessonsCount * lessonDuration;
    }

    public Course(int id, String subject, String courseName, int lessonsCount, int lessonDuration) {
        this.id = id;
        this.subject = subject;
        this.courseName = courseName;
        this.lessonsCount = lessonsCount;
        this.lessonDuration = lessonDuration;
        this.courseDuration = lessonsCount * lessonDuration;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public int getLessonsCount() {
        return lessonsCount;
    }

    public void setLessonsCount(int lessonsCount) {
        this.lessonsCount = lessonsCount;
    }

    public int getLessonDuration() {
        return lessonDuration;
    }

    public void setLessonDuration(int lessonDuration) {
        this.lessonDuration = lessonDuration;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public int getCourseDuration() {
        return courseDuration;
    }

    public void setCourseDuration(int courseDuration) {
        this.courseDuration = courseDuration;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Course course = (Course) o;
        return id == course.id &&
                lessonsCount == course.lessonsCount &&
                lessonDuration == course.lessonDuration &&
                courseDuration == course.courseDuration &&
                Objects.equals(subject, course.subject) &&
                Objects.equals(courseName, course.courseName) &&
                Objects.equals(teacher, course.teacher);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, subject, courseName, lessonsCount, lessonDuration, teacher, courseDuration);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Course{");
        sb.append("id=").append(id);
        sb.append(", subject='").append(subject).append('\'');
        sb.append(", courseName='").append(courseName).append('\'');
        sb.append(", lessonsCount=").append(lessonsCount);
        sb.append(", lessonDuration=").append(lessonDuration);
        sb.append(", courseDuration=").append(courseDuration);
        sb.append('}');
        return sb.toString();
    }
}
