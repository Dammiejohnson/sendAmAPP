package africa.semicolon.sendAm.services;

import africa.semicolon.sendAm.data.models.Package;
import africa.semicolon.sendAm.data.models.PackageDescription;
import africa.semicolon.sendAm.data.models.Status;
import africa.semicolon.sendAm.data.repositories.PackageRepository;
import africa.semicolon.sendAm.data.repositories.PackageRepositoryImpl;
import africa.semicolon.sendAm.dtos.requests.AddPackageRequest;
import africa.semicolon.sendAm.dtos.requests.UpdateTrackingInfoRequest;
import africa.semicolon.sendAm.dtos.responses.AddPackageResponse;
import africa.semicolon.sendAm.dtos.responses.TrackPackageResponse;
import africa.semicolon.sendAm.dtos.responses.TrackingInfo;
import africa.semicolon.sendAm.dtos.responses.UpdateTrackingInfoResponse;
import africa.semicolon.sendAm.exceptions.SendAmAppException;

import java.time.format.DateTimeFormatter;
import java.util.List;

public class PackageServiceImpl implements PackageService {

    PackageRepository packageRepository = new PackageRepositoryImpl();
    //private int id;

    @Override
    public AddPackageResponse addPackage(AddPackageRequest packageRequest) {
        Package aPackage = new Package();
        //if(packageExist(packageRequest)) throw new SendAmAppException("Package already exist");
        PackageDescription packageDescription = new PackageDescription();
        //aPackage.setId(packageRequest.getId());
        aPackage.setOwner(packageRequest.getOwner());
        //packageDescription.setName(packageRequest.getName());
        aPackage.setQty(packageRequest.getQty());
        aPackage.setName(packageRequest.getName());
        aPackage.setWeightInGrammes(packageRequest.getWeightInGrammes());

//        User user = new User();
//        user.setname()

        //aPackage.setDescription(packageRequest.getPackageDescription());

        Status status = new Status();
        status.setStatus("Created");
        aPackage.getStatusList().add(status);

        packageRepository.save(aPackage);

        AddPackageResponse packageResponse = new AddPackageResponse();
        packageResponse.setId(aPackage.getId());
        packageResponse.setQty(aPackage.getQty());
        packageResponse.setName(aPackage.getName());
        return packageResponse;
    }

//    private boolean packageExist(AddPackageRequest packageRequest) {
//        Package aPackage = packageRepository.findById(packageRequest.getId());
//        if (aPackage == null) return false;
//        return true;
//    }


    @Override
    public PackageRepository getRepository() {
        return packageRepository;
    }

    @Override
    public UpdateTrackingInfoResponse updateTrackingInfo(UpdateTrackingInfoRequest trackingInfoRequest) {
        //get package from repository
        Package foundPackage = packageRepository.findById(trackingInfoRequest.getTrackingNumber());
        //create new status
        Status status = new Status();
        status.setStatus(trackingInfoRequest.getTrackingInfo());
        //add new status
        foundPackage.getStatusList().add(status);
        packageRepository.save(foundPackage);
        //save package
        return null;
    }

    @Override
    public TrackPackageResponse trackPackage(int trackingNumber) {
        //find package
        Package aPackage = packageRepository.findById(trackingNumber);
        //get list of status
        List<Status> statusList = aPackage.getStatusList();
        //create response
        TrackPackageResponse response = new TrackPackageResponse();
        //add list of status
        for (Status status : statusList) {
            TrackingInfo info = new TrackingInfo();
            info.setInformation(status.getStatus());
            info.setDateTime(DateTimeFormatter.ofPattern("E dd/MM/yyyy hh:mm:s").format(status.getDateTime()));
            response.getTrackingInfo().add(info);
        }
            return response;
        }



}
