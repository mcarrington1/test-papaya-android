package utils;

import enums.BillType;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class AvdManagement {

    private static final Logger logger = LogManager.getLogger(AvdManagement.class);

    /**
     * Set AVD camera template and image source based on BillType, driven by /avd/*.png filenames
     * @param billType Bill type set in enum, uses image name value stored
     */
    public static void setTestImage(BillType billType) {
        setAvdCameraImageTemplate();
        setTestImageInAvd(billType);
    }

    /**
     * Set Toren1BD.posters camera template for AVD, this WILL fail if ANDROID_HOME env is not set.
     */
    private static void setAvdCameraImageTemplate() {
        logger.info("Setting AVD Template");
        Path posterFile = Paths.get("src/main/resources/avd/Toren1BD.posters");
        Path destination = Paths.get(System.getenv("ANDROID_HOME")
                + "/emulator/resources/Toren1BD.posters");
        copyFile(posterFile, destination);
    }

    /**
     * Grabs image from /avd folder based on BillType
     * @param billType
     */
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

        logger.info("Setting test image for bill {} scenario", billType);
        Path source = Paths.get("src/main/resources/avd/" + testImageName);
        Path destination = Paths.get(System.getenv("ANDROID_HOME")
                + "/emulator/resources/bill.png");
        copyFile(source, destination);
    }

    /**
     * Performs actual copy with Java NIO lib
     * @param source entire source file, including path
     * @param destination entire destination, including path
     */
    private static void copyFile(Path source, Path destination) {
        try {
            Files.copy(source, destination, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            logger.error(e);
        }
    }
}
