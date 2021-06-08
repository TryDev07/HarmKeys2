package nl.trydev07.harmkeys2.packages;

import com.google.inject.Inject;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class PackageUserSerializer {

    @Inject
    private static PackageRegisteryContainer packageRegisteryContainer;

    public static String serialize(PackageUser packages) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("name", packages.getAPackage().packageType().getPackageName());
        jsonObject.put("date_received", packages.getDateClaimed());
        jsonObject.put("date_claimed", packages.getDateClaimed());
        jsonObject.put("claimed", packages.isClaimed());
        return jsonObject.toJSONString();
    }

    public static PackageUser deserialize(String packages) {
        try {
            JSONObject jsonObject = (JSONObject) new JSONParser().parse(packages);

            PackageUser packageUser = new PackageUser();
            packageUser.setAPackage(packageRegisteryContainer.getPackage((String) jsonObject.get("name")));
            packageUser.setDateReceived((long) jsonObject.get("date_received"));
            packageUser.setDateClaimed((long) jsonObject.get("date_claimed"));
            packageUser.setClaimed((boolean) jsonObject.get("claimed"));
            packageUser.setOldValue(packages);

            return packageUser;
        } catch (ParseException exception) {
            exception.printStackTrace();
        }
        return null;
    }

}
