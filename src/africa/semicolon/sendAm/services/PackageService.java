package africa.semicolon.sendAm.services;

import africa.semicolon.sendAm.data.repositories.PackageRepository;
import africa.semicolon.sendAm.dtos.requests.AddPackageRequest;
import africa.semicolon.sendAm.dtos.requests.UpdateTrackingInfoRequest;
import africa.semicolon.sendAm.dtos.responses.AddPackageResponse;
import africa.semicolon.sendAm.dtos.responses.TrackPackageResponse;
import africa.semicolon.sendAm.dtos.responses.UpdateTrackingInfoResponse;

public interface PackageService {
    AddPackageResponse addPackage(AddPackageRequest packageRequest);

    PackageRepository getRepository();

    UpdateTrackingInfoResponse updateTrackingInfo(UpdateTrackingInfoRequest trackingInfoRequest);

    TrackPackageResponse trackPackage(int trackingNumber);
}
