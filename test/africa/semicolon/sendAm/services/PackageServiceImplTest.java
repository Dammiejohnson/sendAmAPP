package africa.semicolon.sendAm.services;

import africa.semicolon.sendAm.data.repositories.PackageRepository;
import africa.semicolon.sendAm.data.repositories.PackageRepositoryImpl;
import africa.semicolon.sendAm.dtos.requests.RegisterUserRequest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PackageServiceImplTest {
    private PackageService packageService;

    @BeforeEach
    public void setUp() {
        packageService = new PackageServiceImpl();
    }

    @Test
    void afterRegister_repositoryContainOneElement (){


    }

}