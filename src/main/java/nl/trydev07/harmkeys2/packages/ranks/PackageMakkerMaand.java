package nl.trydev07.harmkeys2.packages.ranks;

import nl.trydev07.harmkeys2.packages.PackageRegistery;
import nl.trydev07.harmkeys2.packages.PackageStructure;
import nl.trydev07.harmkeys2.packages.PackageTypes;

@PackageRegistery(name = "MakkerMaand", packageStructure = PackageMakkerMaand.class)
public final class PackageMakkerMaand extends PackageStructure {

    @Override
    public PackageTypes packageType() {
        return PackageTypes.MAKKER_MAAND;
    }

    @Override
    public String serverBind() {
        return "skyblock";
    }
}