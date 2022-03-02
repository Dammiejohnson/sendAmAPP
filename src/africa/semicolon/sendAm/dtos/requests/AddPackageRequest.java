package africa.semicolon.sendAm.dtos.requests;

import africa.semicolon.sendAm.data.models.PackageDescription;
import africa.semicolon.sendAm.data.models.User;

public class AddPackageRequest {
    private int id;
    private User owner;
    private int qty;
    private PackageDescription packageDescription;

    public int getId() {
        return id;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    public PackageDescription getPackageDescription() {
        return packageDescription;
    }

    public void setPackageDescription(PackageDescription packageDescription) {
        this.packageDescription = packageDescription;
    }
}
