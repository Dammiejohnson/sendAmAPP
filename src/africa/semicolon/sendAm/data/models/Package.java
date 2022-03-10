package africa.semicolon.sendAm.data.models;

import java.util.ArrayList;
import java.util.List;

public class Package {
    private User owner;
    //private PackageDescription description;
    private final List<Status> statusList = new ArrayList<>();
    private int id;
    private int qty;
    private String name;
    private double weightInGrammes;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getWeightInGrammes() {
        return weightInGrammes;
    }

    public void setWeightInGrammes(double weightInGrammes) {
        this.weightInGrammes = weightInGrammes;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public int getId() {
        return id;
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

//    public PackageDescription getDescription() {
//        return description;
//    }
//
//    public void setDescription(PackageDescription description) {
//        this.description = description;
//    }

    public List<Status> getStatusList() {
        return statusList;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Package{");
        sb.append("id=").append(id);
        sb.append(", owner=").append(owner);
        sb.append(", statusList=").append(statusList);
        sb.append('}');
        return sb.toString();
    }
}
