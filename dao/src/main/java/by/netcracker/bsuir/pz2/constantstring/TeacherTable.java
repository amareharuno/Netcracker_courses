package by.netcracker.bsuir.pz2.constantstring;

public class TeacherTable {

    public static final String TEACHER_ID = "teacherId";
    public static final String FIRST_NAME = "firstName";
    public static final String LAST_NAME = "lastName";
    public static final String MIDDLE_NAME = "middleName";

    public static final String CREATE_TEACHER = "INSERT INTO `courses`.`teacher` (`firstName`, " +
            "`lastName`, `middleName`) VALUES (?, ?, ?);";
    public static final String GET_TEACHER = "SELECT * FROM `courses`.`teacher` WHERE teacherId=?;";
    public static final String UPDATE_TEACHER = "UPDATE `courses`.`teacher` SET `firstName`=?, " +
            "`lastName`=?, `middleName`=? WHERE `teacherId`=?;";
    public static final String DELETE_TEACHER = "DELETE FROM `courses`.`teacher` WHERE `teacherId`=?;";
    public static final String GET_TEACHERS = "SELECT * FROM courses.teacher;";
}
