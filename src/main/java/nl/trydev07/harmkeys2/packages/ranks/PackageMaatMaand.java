package nl.trydev07.harmkeys2.packages.ranks;

import nl.trydev07.harmkeys2.packages.PackageRegistery;
import nl.trydev07.harmkeys2.packages.PackageStructure;
import nl.trydev07.harmkeys2.packages.PackageTypes;

@PackageRegistery(name = "MaatMaand", packageStructure = PackageMaatMaand.class)
public class PackageMaatMaand extends PackageStructure {

    @Override
    public PackageTypes packageType() {
        return PackageTypes.MAAT_MAAND;
    }

    @Override
    public String serverBind() {
        return "skyblock";
    }
}
