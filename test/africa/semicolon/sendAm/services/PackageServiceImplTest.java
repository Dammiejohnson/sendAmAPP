package africa.semicolon.sendAm.services;

import africa.semicolon.sendAm.data.models.Package;
import africa.semicolon.sendAm.data.models.User;
import africa.semicolon.sendAm.dtos.requests.AddPackageRequest;
import africa.semicolon.sendAm.dtos.requests.UpdateTrackingInfoRequest;
import africa.semicolon.sendAm.dtos.responses.AddPackageResponse;
import africa.semicolon.sendAm.dtos.responses.TrackPackageResponse;
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
    void thatPackagesCanBeAddedTest(){
       AddPackageRequest packageRequest = createPackageRequest();
       //when
       packageService.addPackage(packageRequest);

    assertEquals(1, packageService.getRepository().count());
   }

    @Test
    void thatPackagesCanBeAdded_StatusIsAddedTest(){
        AddPackageRequest packageRequest = createPackageRequest();
        packageService.addPackage(packageRequest);
        assertEquals(1, packageService.getRepository().count());

        Package aPackage = packageService.getRepository().findById(1);
        assertEquals(1, aPackage.getStatusList().size());
    }

//   @Test
//    void packageWithDuplicateId_throwsException(){
//        //given
//       AddPackageRequest packageRequest = createPackageRequest();
//       //when
//       packageService.addPackage(packageRequest);
//       assertThrows(SendAmAppException.class, ()-> packageService.addPackage(packageRequest));
//   }

   @Test
    void packageRequestGivesCorrectResponse (){
        //given
       AddPackageRequest packageRequest = createPackageRequest();
       AddPackageResponse response = packageService.addPackage(packageRequest);
       assertEquals(1, response.getId());
       assertEquals(5, response.getQty());
   }

    private AddPackageRequest createPackageRequest() {
      //  User user = new User();
        AddPackageRequest packageRequest = new AddPackageRequest();
        //packageRequest.setId(1);
       // packageRequest.setOwner(user);
        packageRequest.setName("Wristwatch");
        packageRequest.setWeightInGrammes(3);
//        packageRequest.setPackageDescription("wristwatch", 5.5);
        packageRequest.setQty(5);
        return packageRequest;
    }



    @Test
    public void addStatusTest (){
        //given there is a package
        AddPackageRequest packageRequest = createPackageRequest();
        packageService.addPackage(packageRequest);
        //when i update
        UpdateTrackingInfoRequest trackingInfoRequest = new UpdateTrackingInfoRequest();
        trackingInfoRequest.setTrackingInfo("Arrived Helen's Office");
        trackingInfoRequest.setTrackingNumber(1);
        packageService.updateTrackingInfo(trackingInfoRequest);
        //confirm status count
        Package aPackage = packageService.getRepository().findById(1);
        assertEquals(2, aPackage.getStatusList().size());
        //confirm status message
    }

    @Test
    public  void trackPackageTest (){
        //given there is a package
        AddPackageRequest packageRequest = createPackageRequest();
        packageService.addPackage(packageRequest);
        //when
        TrackPackageResponse trackingInfo = packageService.trackPackage(1);
        //assert
        //assertEquals();
    }
}