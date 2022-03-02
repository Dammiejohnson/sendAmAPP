package africa.semicolon.sendAm.data.repositories;

import africa.semicolon.sendAm.data.models.Package;
import africa.semicolon.sendAm.data.models.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class UserRepositoryImplTest {
    private UserRepository userRepository;

    @BeforeEach
    public void setUp(){
        userRepository = new UserRepositoryImpl();
    }

    @Test
    public void canCreateNewUser () {
        //given that there is a user
        User firstUser = new User("Sannijay@yahoo.com");
        //when a new user is create
        User savedUser = userRepository.createUser(firstUser);
        //assert that user has been created
        assertEquals("Sannijay@yahoo.com", savedUser.getEmail());
       assertEquals(1, userRepository.count());
    }

    @Test
    public void canCreateMoreThanOneUser (){
        //given that there is a user
        User firstUser = new User("Sannijay@yahoo.com");
        User secondUser = new User("Sannidam@yahoo.com");
        //when two usetrs are saved
        userRepository.createUser(firstUser);
        userRepository.createUser(secondUser);
        //assert that the number of user]s is 2
        assertEquals(2, userRepository.count());
    }

    @Test
    public void canFindUserByEmail (){
        //given that there are users
        User firstUser = new User("Sannijay@yahoo.com");
        User secondUser = new User("Sannidam@yahoo.com");
        User thirdUser = new User("damsari@yahoo.com");
        User fourthUser = new User("damjay@yahoo.com");

        userRepository.createUser(firstUser);
        userRepository.createUser(secondUser);
        userRepository.createUser(thirdUser);
        userRepository.createUser(fourthUser);
        //when i try to find s user by email
        User foundUser = userRepository.findByEmail("damsari@yahoo.com");
        assertEquals("damsari@yahoo.com", foundUser.getEmail());
        assertEquals(foundUser, thirdUser);

    }

    private void saveFourUsers() {
        User firstUser = new User("Sannijay@yahoo.com");
        User secondUser = new User("Sannidam@yahoo.com");
        User thirdUser = new User("damsari@yahoo.com");
        User fourthUser = new User("damjay@yahoo.com");

        userRepository.createUser(firstUser);
        userRepository.createUser(secondUser);
        userRepository.createUser(thirdUser);
        userRepository.createUser(fourthUser);
    }

    @Test
    public void canFindUserByName (){
        //given that there are users with full names registered
            User firstUser = new User("Sannijay@yahoo.com");
            firstUser.setFullname("Sanni Johnson");
            User secondUser = new User("Sannidam@yahoo.com");
            secondUser.setFullname("Dammy Sanni");
            User thirdUser = new User("damsari@yahoo.com");
            thirdUser.setFullname("Damsari Man");

        userRepository.createUser(firstUser);
        userRepository.createUser(secondUser);
        userRepository.createUser(thirdUser);

            //when i try to find by full name
        User foundUser = userRepository.findByFullname("Dammy Sanni");
        assertSame(foundUser, secondUser);

    }

    @Test
    public void canDeleteUserByEmail(){
        //given that four users were saved
        saveFourUsers();
        assertEquals(4, userRepository.count());
        //when i try to delete by mail
       userRepository.delete("Sannidam@yahoo.com");
       assertEquals(3, userRepository.count());
    }

    @Test
    public void deleteByUser(){
        //given that there are two saved users
        User firstUser = new User("Sannijay@yahoo.com");
        User secondUser = new User("Sannidam@yahoo.com");
        userRepository.createUser(firstUser);
        userRepository.createUser(secondUser);
        //when i try to delete by User
        userRepository.delete(firstUser);
        assertEquals(1, userRepository.count());
        assertNull(userRepository.findByEmail("Sannijay@yahoo.com"));
    }

    @Test
    public void findByEmailWorks_AfterDeletingByMail (){
        //given that four users were saved
        saveFourUsers();
        //when i delete by email
        userRepository.delete("Sannidam@yahoo.com");
        User foundUser = userRepository.findByEmail("Sannidam@yahoo.com");
        //assert that the deleted user is null
        assertNull(foundUser);
    }

    @Test
    void saveAfterDelete_givesCorrectUserEmailTest(){
        //given that i have four users saved
        saveFourUsers();
        //when i try to delete two users
        userRepository.delete("Sannidam@yahoo.com");
        userRepository.delete("Sannijay@yahoo.com");
        //when i try to add new user
        User newUser = new User("deejay@yahoo.com");
        userRepository.createUser(newUser);
        assertEquals(3, userRepository.count() );
    }



    @Test
    public void findAllUsers (){
        //given that i have saved four users
        saveFourUsers();
        //when i try to find all users
        List<User> all = userRepository.findAll();
        //assert that all users will be gotten
        assertEquals(4, all.size());
    }

}