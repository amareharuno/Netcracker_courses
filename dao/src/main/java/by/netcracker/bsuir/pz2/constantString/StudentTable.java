package by.netcracker.bsuir.pz2.constantString;

public class StudentTable {
    public static final String STUDENT_ID = "studentId";
    public static final String FIRST_NAME = "firstName";
    public static final String LAST_NAME = "lastName";
    public static final String MIDDLE_NAME = "middleName";

    public static final String CREATE_STUDENT = "INSERT INTO `courses`.`student` (`firstName`, " +
            "`lastName`, `middleName`) VALUES (?, ?, ?);";
    public static final String GET_STUDENT = "SELECT * FROM `courses`.`student` WHERE studentId=?;";
    public static final String UPDATE_STUDENT = "UPDATE `courses`.`student` SET `firstName`=?, " +
            "`lastName`=?, `middleName`=? WHERE `studentId`=?;";
    public static final String DELETE_STUDENT = "DELETE FROM `courses`.`student` WHERE `studentId`=?;";
    public static final String GET_STUDENTS = "SELECT * FROM courses.student;";
}
