package africa.semicolon.sendAm.services;

import africa.semicolon.sendAm.data.models.User;
import africa.semicolon.sendAm.data.repositories.UserRepository;
import africa.semicolon.sendAm.data.repositories.UserRepositoryImpl;
import africa.semicolon.sendAm.dtos.requests.RegisterUserRequest;
import africa.semicolon.sendAm.dtos.responses.RegisterUserResponse;
import africa.semicolon.sendAm.exceptions.RegisterFailureException;

public class UserServiceImpl  implements  UserService{
    private UserRepository userRepository = new UserRepositoryImpl();

    @Override
    public RegisterUserResponse register(RegisterUserRequest requestForm) {
        requestForm.setEmailAddress(requestForm.getEmailAddress().toLowerCase());
        if(emailExists(requestForm.getEmailAddress())) throw new RegisterFailureException("Duplicated Email");
        User user = new User();
        user.setEmail(requestForm.getEmailAddress());
        user.setAddress(requestForm.getAddress());
        user.setFullname(requestForm.getFirstName() + " " + requestForm.getLastName());
        user.setPhoneNumber(requestForm.getPhoneNumber());

       User savedUser = userRepository.createUser(user);

       RegisterUserResponse response = new RegisterUserResponse();
       response.setEmail(savedUser.getEmail());
       response.setFullName(savedUser.getFullname());
        return response;
    }

    private boolean emailExists(String emailAddress) {
      User user =  userRepository.findByEmail(emailAddress);
      if (user == null) return false;
      return true;
    }

    @Override
    public UserRepository getRepository() {
        return userRepository;
    }
}
