package br.com.victor.coke.service.mondayIntegration.util;

import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import java.text.Normalizer;

public class MondayIntegrationUtil {

    public static boolean isValidPerson(boolean enable, String companyName) {
        return enable && companyName.equalsIgnoreCase("SEA Tecnologia");
    }

    public static String getFirstName(String name) {
        String[] nameParts = name.split(" ");

        return removeAccents(nameParts[0]);
    }

    public static String getLastName(String name) {
        String[] nameParts = name.split(" ");

        return removeAccents(nameParts[nameParts.length - 1]);
    }

    public static String getUserName(String name) {
        return (getFirstName(name) + "." + getLastName(name).toLowerCase());
    }

    public static String getMimeType(String imageUrl) throws IOException {
        URL url = new URL(imageUrl);
        URLConnection connection = url.openConnection();
        connection.setRequestProperty("User-Agent", "Mozilla/5.0");
        String mimeType = connection.getContentType();

        switch (mimeType) {
            case "image/jpeg":
                return ".jpg";
            case "image/png":
                return ".png";
            case "image/gif":
                return ".gif";
            default:
                return "";
        }
    }

    private static String removeAccents(String str) {
        String nfdNormalizedString = Normalizer.normalize(str, Normalizer.Form.NFD);

        return nfdNormalizedString.replaceAll("[^\\p{ASCII}]", "");
    }
}