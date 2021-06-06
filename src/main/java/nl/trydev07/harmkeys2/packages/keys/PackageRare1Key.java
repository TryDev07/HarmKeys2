package nl.trydev07.harmkeys2.packages.keys;

import nl.trydev07.harmkeys2.packages.PackageRegistery;
import nl.trydev07.harmkeys2.packages.PackageStructure;
import nl.trydev07.harmkeys2.packages.PackageTypes;

@PackageRegistery(name = "RareCrate1" , packageStructure = PackageRare1Key.class)
public class PackageRare1Key extends PackageStructure {

    @Override
    public PackageTypes packageType() {
        return PackageTypes.RARECRATE_1;
    }

    @Override
    public String serverBind() {
        return "skyblock";
    }
}