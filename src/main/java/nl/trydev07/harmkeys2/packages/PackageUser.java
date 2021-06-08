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

    private String oldValue;
    private boolean changed;


    public static class Builder {

        PackageUser packageUser;

        public Builder() {
            this.packageUser = new PackageUser();
        }

        public Builder setPackage(PackageStructure packages) {
            packageUser.setAPackage(packages);
            return this;
        }

        public Builder setDateReceived(Long time) {
            packageUser.setDateReceived(time);
            return this;
        }

        public Builder setDateClaimed(Long time) {
            packageUser.setDateClaimed(time);
            return this;
        }

        public Builder setClaimed(boolean claimed) {
            packageUser.setClaimed(claimed);
            return this;
        }

        public Builder setChanged(boolean changed) {
            packageUser.setChanged(changed);
            return this;
        }

        public Builder setOldValue(String oldValue) {
            packageUser.setOldValue(oldValue);
            return this;
        }

        public PackageUser build() {
            return packageUser;
        }
    }

}
