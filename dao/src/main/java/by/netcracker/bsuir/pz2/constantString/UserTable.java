package by.netcracker.bsuir.pz2.constantString;

public class UserTable {

    // Column's name
    public static final String USER_ID = "userId";
    public static final String LOGIN = "login";
    public static final String PASSWORD = "password";
    public static final String IS_TEACHER = "isTeacher";

    // Query
    public static final String GET_USER_BY_ID = "SELECT * FROM `courses`.`user` WHERE `userId`=?;";
    public static final String CREATE_USER = "INSERT INTO `courses`.`user` (`login`, `password`, " +
            "`isTeacher`) VALUES (?, ?, ?);";
    public static final String DELETE_USER = "DELETE FROM `courses`.`user` WHERE `userId`=?;";
    public static final String UPDATE_USER = "UPDATE `courses`.`user` SET `login`=?, `password`=?, " +
            "`isTeacher`=? WHERE `userId`=?;";
    public static final String GET_USERS = "SELECT * FROM courses.user;";
    public static final String GET_USER_BY_LOGIN_INFO = "SELECT * FROM `courses`.`user` WHERE `login`=? AND `password`=?;";
}
