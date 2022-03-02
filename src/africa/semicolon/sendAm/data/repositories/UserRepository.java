package africa.semicolon.sendAm.data.repositories;

import africa.semicolon.sendAm.data.models.Package;
import africa.semicolon.sendAm.data.models.User;

import java.util.List;

public interface UserRepository {
    User createUser(User aUser);
    User findByEmail(String mail);
    User findByFullname(String name);
    void delete(User aUser);
    void delete(String mail);
    List<User> findAll();

    int count();
}
