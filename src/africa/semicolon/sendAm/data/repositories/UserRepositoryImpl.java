package africa.semicolon.sendAm.data.repositories;

import africa.semicolon.sendAm.data.models.Package;
import africa.semicolon.sendAm.data.models.User;

import java.util.ArrayList;
import java.util.List;

public class UserRepositoryImpl implements UserRepository{
    private List<User> database = new ArrayList<>();


    @Override
    public User createUser(User aUser) {
        database.add(aUser);
        return aUser;
    }

    @Override
    public User findByEmail(String mail) {
        for (User aUser : database){
            if (aUser.getEmail().equals(mail)){
                return aUser;
            }
        }

        return null;
    }

    @Override
    public User findByFullname(String name) {
        for (User aUser :database){
            if(aUser.getFullname().equals(name)){
                return aUser;
            }
        }
        return null;
    }

    @Override
    public void delete(User aUser) {
        database.remove(aUser);
    }

    @Override
    public void delete(String mail) {
        User aUser = findByEmail(mail);
        delete(aUser);
    }

    @Override
    public List<User> findAll() {
        return database;
    }

    @Override
    public int count() {
        return database.size();
    }
}
