package nl.trydev07.harmkeys2.packages.keys;

import nl.trydev07.harmkeys2.packages.PackageRegistery;
import nl.trydev07.harmkeys2.packages.PackageStructure;
import nl.trydev07.harmkeys2.packages.PackageTypes;

@PackageRegistery(name = "RareCrate3" ,packageStructure = PackageRare3Key.class)
public class PackageRare3Key extends PackageStructure {

    @Override
    public PackageTypes packageType() {
        return PackageTypes.RARECRATE_3;
    }

    @Override
    public String serverBind() {
        return "skyblock";
    }
}