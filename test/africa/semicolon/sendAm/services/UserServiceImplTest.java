package africa.semicolon.sendAm.services;

import africa.semicolon.sendAm.dtos.requests.RegisterUserRequest;
import africa.semicolon.sendAm.dtos.responses.FindUserResponse;
import africa.semicolon.sendAm.dtos.responses.RegisterUserResponse;
import africa.semicolon.sendAm.exceptions.SendAmAppException;
import africa.semicolon.sendAm.exceptions.UserNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserServiceImplTest {
    private UserService userservice;

    @BeforeEach
    public void setUp (){
       userservice = new UserServiceImpl();
    }

    @Test
    void afterRegister_repositoryContainOneElement(){
        //given
        RegisterUserRequest registerForm = createRegisterForm();
        // when
        userservice.register(registerForm);

        //assert
        assertEquals(1, userservice.getRepository().count());
    }

    private RegisterUserRequest createRegisterForm() {
        RegisterUserRequest registerForm = new RegisterUserRequest();
        registerForm.setFirstName("Lotachi");
        registerForm.setLastName("Senior Dave");
        registerForm.setEmailAddress("seniorDaveDevil@gmail.com");
        registerForm.setAddress("Code Cold Hell");
        registerForm.setPhoneNumber("2MillionDollars");
        return registerForm;
    }

    @Test
    public void duplicateEmailThrowsExceptionTest(){
        //given
        RegisterUserRequest lotaForm = createRegisterForm();
        //when i try to regisyter sane
        userservice.register(lotaForm);
        //assert
        assertThrows(SendAmAppException.class, ()-> userservice.register(lotaForm));

    }

    @Test
    public void duplicatedEmailWithDifferentCase_throwsException (){
        RegisterUserRequest lotaForm = createRegisterForm();
        //when
        userservice.register(lotaForm);
        lotaForm.setEmailAddress("seniorDavedevil@gmail.com");
        //assert
        assertThrows(SendAmAppException.class, ()-> userservice.register(lotaForm));

    }

    @Test
    public void registrationReturnCorrectResponseTest(){
        RegisterUserRequest lotaform = createRegisterForm();
        RegisterUserResponse response = userservice.register(lotaform);

        assertEquals("Lotachi Senior Dave", response.getFullName());
        assertEquals("seniordavedevil@gmail.com", response.getEmail());
    }

    @Test
    public void findRegisteredUserByEmailTest (){
        RegisterUserRequest lotaform = createRegisterForm();
        userservice.register(lotaform);

        FindUserResponse response = userservice.findUserByEmail(lotaform.getEmailAddress().toLowerCase());
        //assertEquals(result)
        assertEquals("Lotachi Senior Dave", response.getFullName());
        assertEquals("seniordavedevil@gmail.com", response.getEmail());
    }

    @Test
    public void findUnRegisteredUserByEmail_throwsExceptionTest (){
        RegisterUserRequest lotaform = createRegisterForm();
        userservice.register(lotaform);

     assertThrows(UserNotFoundException.class, ()-> userservice.findUserByEmail("emma@gmail.com") );
    }

    @Test
    public void findUserEmailIsNotCaseSensitiveTest(){
        RegisterUserRequest lotaform = createRegisterForm();
        userservice.register(lotaform);

        FindUserResponse response = userservice.findUserByEmail("seNiorDaVedevil@gmail.com");

        assertEquals("Lotachi Senior Dave", response.getFullName());
        assertEquals("seniordavedevil@gmail.com", response.getEmail());
    }
}