package by.netcracker.bsuir.pz2.daoInterface;

import by.netcracker.bsuir.pz2.entity.User;

import java.util.List;

public interface UserDao {

    boolean create(User user);
    User getUserById(int id);
    boolean update(User user);
    boolean delete(int userId);
    User getUserByLoginInfo(String login, String password);

    List<User> getAll();
}
