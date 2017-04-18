package by.netcracker.bsuir.pz2.constantString;

public class CourseTable {
    // Column's name
    public static final String COURSE_ID = "courseId";
    public static final String SUBJECT = "subject";
    public static final String COURSE_NAME = "courseName";
    public static final String LESSONS_COUNT = "lessonsCount";
    public static final String LESSON_DURATION = "lessonDuration";
    public static final String COURSE_DURATION = "courseDuration";
    public static final String TEACHER_ID = "teacher_teacherId";

    // Query
    public static final String GET_COURSE = "SELECT * FROM `courses`.`course` WHERE `courseId`=?;";
    public static final String CREATE_COURSE = "INSERT INTO `courses`.`course` (`subject`, `courseName`, " +
            "`lessonsCount`, `lessonDuration`, `courseDuration`, `teacher_teacherId`) VALUES (?, ?, ?, ?, ?, ?);";
    public static final String DELETE_COURSE = "DELETE FROM `courses`.`course` WHERE `courseId`=?;";
    public static final String UPDATE_COURSE = "UPDATE `courses`.`course` SET `subject`=?, `courseName`=?, " +
            "`lessonsCount`=?, `lessonDuration`=?, `courseDuration`=?, `teacher_teacherId`=? WHERE `courseId`=?;";
    public static final String GET_COURSES = "SELECT * FROM courses.course;";
}
