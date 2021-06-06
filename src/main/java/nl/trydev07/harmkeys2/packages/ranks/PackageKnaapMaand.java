package nl.trydev07.harmkeys2.packages.ranks;

import nl.trydev07.harmkeys2.packages.PackageRegistery;
import nl.trydev07.harmkeys2.packages.PackageStructure;
import nl.trydev07.harmkeys2.packages.PackageTypes;

@PackageRegistery(name = "KnaapMaand", packageStructure = PackageKnaapMaand.class)
public class PackageKnaapMaand extends PackageStructure {

    @Override
    public PackageTypes packageType() {
        return PackageTypes.KNAAP_MAAND;
    }

    @Override
    public String serverBind() {
        return "skyblock";
    }
}
