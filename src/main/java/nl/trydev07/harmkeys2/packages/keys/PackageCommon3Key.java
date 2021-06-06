package nl.trydev07.harmkeys2.packages.keys;

import nl.trydev07.harmkeys2.packages.PackageRegistery;
import nl.trydev07.harmkeys2.packages.PackageStructure;
import nl.trydev07.harmkeys2.packages.PackageTypes;

@PackageRegistery(name = "CommonCrate3" , packageStructure = PackageCommon3Key.class)
public class PackageCommon3Key extends PackageStructure {

    @Override
    public PackageTypes packageType() {
        return PackageTypes.COMMONKEY_3;
    }

    @Override
    public String serverBind() {
        return "skyblock";
    }
}
