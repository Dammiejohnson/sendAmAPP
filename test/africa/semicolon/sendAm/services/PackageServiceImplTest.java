package africa.semicolon.sendAm.services;

import africa.semicolon.sendAm.data.models.User;
import africa.semicolon.sendAm.dtos.requests.AddPackageRequest;
import africa.semicolon.sendAm.dtos.responses.AddPackageResponse;
import africa.semicolon.sendAm.exceptions.SendAmAppException;
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
    void test_that_packages_can_be_added_test(){
       User user = new User();
        //given
       AddPackageRequest packageRequest = new AddPackageRequest();
       packageRequest.setId(1);
       packageRequest.setOwner(user);
       packageRequest.setQty(5);
       //when
       packageService.addPackage(packageRequest);

    assertEquals(1, packageService.getRepository().count());
   }

   @Test
    void packageWithDuplicateId_throwsException(){
        //given
       User user = new User();
       AddPackageRequest packageRequest = new AddPackageRequest();
       packageRequest.setId(1);
       packageRequest.setOwner(user);
       packageRequest.setQty(5);
       //when
       packageService.addPackage(packageRequest);
       assertThrows(SendAmAppException.class, ()-> packageService.addPackage(packageRequest));
   }

   @Test
    void packageRequestGivesCorrectResponse (){
        //given
       User user = new User();
       AddPackageRequest packageRequest = new AddPackageRequest();
       packageRequest.setId(1);
       packageRequest.setOwner(user);
       packageRequest.setQty(5);

       AddPackageResponse response = packageService.addPackage(packageRequest);
       assertEquals(1, response.getId());
       assertEquals(5, response.getQty());
   }

}