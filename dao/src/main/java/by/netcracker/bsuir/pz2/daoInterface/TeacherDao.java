package by.netcracker.bsuir.pz2.daoInterface;

import by.netcracker.bsuir.pz2.entity.Teacher;

import java.util.List;

public interface TeacherDao {
    boolean create(Teacher teacher);
    Teacher getTeacherById(int teacherId);
    boolean update(Teacher teacher);
    boolean delete(int teacherId);

    List<Teacher> getAll();
}
