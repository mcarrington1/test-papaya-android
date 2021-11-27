package utils;

import enums.BillType;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class AvdManagement {

    public static void setTestImage(BillType billType) {
        setAvdCameraImageTemplate();
        setTestImageInAvd(billType);
    }

    private static void setAvdCameraImageTemplate() {
        Path posterFile = Paths.get("src/main/resources/avd/Toren1BD.posters");
        Path destination = Paths.get(System.getenv("ANDROID_HOME")
                + "/emulator/resources/Toren1BD.posters");
        copyFile(posterFile, destination);
    }

    private static void setTestImageInAvd(BillType billType) {
        String testImageName;
        switch (billType) {
            case MEDICAL:
                testImageName = billType.testImage;
                break;
            case UTILITY:
                testImageName = billType.testImage;
                break;
            default:
                testImageName = "bill-utility.png";
                break;
        }

        Path source = Paths.get("src/main/resources/avd/" + testImageName);
        Path destination = Paths.get(System.getenv("ANDROID_HOME")
                + "/emulator/resources/bill.png");
        copyFile(source, destination);
    }

    private static void copyFile(Path source, Path destination) {
        try {
            Files.copy(source, destination, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            System.out.println(e);
        }
    }
}
