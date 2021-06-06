package nl.trydev07.harmkeys2.packages.keys;

import nl.trydev07.harmkeys2.packages.PackageRegistery;
import nl.trydev07.harmkeys2.packages.PackageStructure;
import nl.trydev07.harmkeys2.packages.PackageTypes;

@PackageRegistery(name = "CommonCrate1" , packageStructure = PackageCommon1Key.class)
public class PackageCommon1Key extends PackageStructure {

    @Override
    public PackageTypes packageType() {
        return PackageTypes.COMMONKEY_1;
    }

    @Override
    public String serverBind() {
        return "skyblock";
    }
}