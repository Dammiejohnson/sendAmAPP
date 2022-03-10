package africa.semicolon.sendAm.controllers;

import africa.semicolon.sendAm.dtos.requests.AddPackageRequest;
import africa.semicolon.sendAm.dtos.requests.UpdateTrackingInfoRequest;
import africa.semicolon.sendAm.dtos.responses.AddPackageResponse;
import africa.semicolon.sendAm.dtos.responses.TrackPackageResponse;
import africa.semicolon.sendAm.dtos.responses.UpdateTrackingInfoResponse;
import africa.semicolon.sendAm.services.PackageService;
import africa.semicolon.sendAm.services.PackageServiceImpl;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/package")
public class PackageController {
    private PackageService packageService = new PackageServiceImpl();

    @PostMapping("/addPackage")
    public AddPackageResponse addNewPackage(@RequestBody AddPackageRequest request) {
        return packageService.addPackage(request);
    }

    @GetMapping("/{trackingNumber}")
    public TrackPackageResponse trackPackage(@PathVariable int trackingNumber) {
        return packageService.trackPackage(trackingNumber);
    }

    @PatchMapping("/updateStatus")
    public UpdateTrackingInfoResponse updateTrackingInfo(@RequestBody UpdateTrackingInfoRequest request) {
        return packageService.updateTrackingInfo(request);
    }

}
