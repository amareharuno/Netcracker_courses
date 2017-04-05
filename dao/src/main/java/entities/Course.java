package entities;

public class Course extends Entity{
    private int id;
    private String subject;
    private String courseName;
    private int lessonsCount;
    private int lessonDuration;
    private int teacherId;
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

    public Course(int id, String subject, String courseName, int lessonsCount, int lessonDuration) {
        this.id = id;
        this.subject = subject;
        this.courseName = courseName;
        this.lessonsCount = lessonsCount;
        this.lessonDuration = lessonDuration;
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

    public int getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(int teacherId) {
        this.teacherId = teacherId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Course course = (Course) o;

        return id == course.id
                && lessonsCount == course.lessonsCount
                && lessonDuration == course.lessonDuration
                && courseDuration == course.courseDuration
                && subject.equals(course.subject)
                && courseName.equals(course.courseName)
                && teacher.equals(course.teacher);
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + subject.hashCode();
        result = 31 * result + courseName.hashCode();
        result = 31 * result + lessonsCount;
        result = 31 * result + lessonDuration;
        result = 31 * result + teacher.hashCode();
        result = 31 * result + courseDuration;
        return result;
    }

    @Override
    public String toString() {
        return id + ". " + subject + ": " + courseName + '\n' +
                "- teacherID: " + teacherId + '\n' +
                "- course duration: " + (courseDuration * 1.00)/60 + " hours" + '\n' +
                "- lessons count: " + lessonsCount + '\n' +
                "- lesson duration: " + lessonDuration + " min";
    }
}
