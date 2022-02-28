package africa.semicolon.sendAm.data.repositories;

import africa.semicolon.sendAm.data.models.Package;

import java.util.List;

public interface PackageRepository {
    Package save(Package apackage);
    Package findById(int id);
    void delete(Package apackage);
    void delete(int id);
    List<Package> findAll();

    int count();
}
