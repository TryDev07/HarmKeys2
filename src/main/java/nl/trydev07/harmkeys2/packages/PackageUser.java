package nl.trydev07.harmkeys2.packages;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PackageUser {

    private PackageStructure aPackage;
    private long dateReceived;
    private long dateClaimed;

    private boolean claimed;

}
