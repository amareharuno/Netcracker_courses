package by.netcracker.bsuir.pz2.daoInterface;

import by.netcracker.bsuir.pz2.entity.Teacher;

import java.sql.SQLException;
import java.util.List;

public interface TeacherDao {
    public boolean create(Teacher teacher) throws SQLException;
    public Teacher getTeacherById(int teacherId) throws SQLException;
    public boolean update(Teacher teacher) throws SQLException;
    public boolean delete(int teacherId) throws SQLException;

    public List<Teacher> getAll() throws SQLException;
}
