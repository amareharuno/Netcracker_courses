package dao.entitiesdao;

import entities.Teacher;

import java.util.List;

public interface ITeacherDao {
    public Teacher create();
    public Teacher read(int key);
    public boolean update(Teacher teacher);
    public boolean delete(Teacher teacher);

    public List<Teacher> getAll();
}
