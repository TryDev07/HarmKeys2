package nl.trydev07.harmkeys2.packages;

import com.google.inject.Inject;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class PackageUserSerializer {


    @Inject
    PackageRegisteryContainer packageRegisteryContainer;

    public String serialize(PackageUser packages) {
        StringBuilder s = new StringBuilder();

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("name", packages.getAPackage().packageType().getPackageName());
        jsonObject.put("dateA", packages.getDateClaimed());
        jsonObject.put("dateB", packages.getDateClaimed());
        jsonObject.put("isClaimed", packages.isClaimed());
        return s.toString();
    }

    public PackageUser serialize(String packages) {
        try {
            JSONObject jsonObject = (JSONObject) new JSONParser().parse(packages);

            PackageUser packageUser = new PackageUser();
            packageUser.setAPackage(packageRegisteryContainerjsonObject.get("name").toString());
   /*     jsonObject.put("name", packages.getAPackage().packageType().getPackageName());
        jsonObject.put("dateA", packages.getDateClaimed());
        jsonObject.put("dateB", packages.getDateClaimed());
        jsonObject.put("isClaimed", packages.isClaimed());*/
        } catch (ParseException exception) {
            exception.printStackTrace();
        }
        return null;
    }

}
