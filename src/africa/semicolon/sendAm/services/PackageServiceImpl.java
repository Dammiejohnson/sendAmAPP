package africa.semicolon.sendAm.services;

import africa.semicolon.sendAm.data.models.Package;
import africa.semicolon.sendAm.data.repositories.PackageRepository;
import africa.semicolon.sendAm.data.repositories.PackageRepositoryImpl;
import africa.semicolon.sendAm.dtos.requests.AddPackageRequest;
import africa.semicolon.sendAm.dtos.responses.AddPackageResponse;
import africa.semicolon.sendAm.exceptions.SendAmAppException;

public class PackageServiceImpl implements PackageService{

    PackageRepository packageRepository = new PackageRepositoryImpl();
    private int id;

    @Override
    public AddPackageResponse addPackage(AddPackageRequest packageRequest) {
        Package aPackage = new Package();
        if(packageExist(packageRequest)) throw new SendAmAppException("Package already exist");
        aPackage.setId(packageRequest.getId());
        aPackage.setOwner(packageRequest.getOwner());
        aPackage.setQty(packageRequest.getQty());
        packageRepository.save(aPackage);

        AddPackageResponse packageResponse = new AddPackageResponse();
        packageResponse.setId(aPackage.getId());
        packageResponse.setQty(aPackage.getQty());
        return packageResponse;
    }

    private boolean packageExist(AddPackageRequest packageRequest) {
        Package aPackage = packageRepository.findById(packageRequest.getId());
        if (aPackage == null) return false;
        return true;
    }


    @Override
    public PackageRepository getRepository() {
        return packageRepository;
    }
}
