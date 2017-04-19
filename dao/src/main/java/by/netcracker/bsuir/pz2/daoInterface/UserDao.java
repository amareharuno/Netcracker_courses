package by.netcracker.bsuir.pz2.daoInterface;

import by.netcracker.bsuir.pz2.entity.User;

import java.util.List;

public interface UserDao {

    public boolean create(User user);
    public User getUserById(int id);
    public boolean update(User user);
    public boolean delete(int userId);
    public User getUserByLoginInfo(String login, String password);

    public List<User> getAll();
}
