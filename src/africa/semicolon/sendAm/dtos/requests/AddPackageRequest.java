package africa.semicolon.sendAm.dtos.requests;

import africa.semicolon.sendAm.data.models.User;

public class AddPackageRequest {
   private int id;
    private User owner;
    private int qty;
    private String name;

    public double getWeightInGrammes() {
        return weightInGrammes;
    }

    public void setWeightInGrammes(double weightInGrammes) {
        this.weightInGrammes = weightInGrammes;
    }

    private double weightInGrammes;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



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

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("AddPackageRequest{");
        sb.append("id=").append(id);
        sb.append(", owner=").append(owner);
        sb.append(", qty=").append(qty);
        sb.append(", name='").append(name).append('\'');
        sb.append(", weightInGrammes=").append(weightInGrammes);
        sb.append('}');
        return sb.toString();
    }
//    public PackageDescription getPackageDescription() {
//        return packageDescription;
//    }
//
//    public void setPackageDescription(String name, double weight) {
//        PackageDescription packageDescription = new PackageDescription();
//        packageDescription.setName(name);
//        packageDescription.setWeightInGrammes(weight);
//    }
}
