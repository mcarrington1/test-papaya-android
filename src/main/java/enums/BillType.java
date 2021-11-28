package enums;

public enum BillType {

    UTILITY("bill-utility.png"),
    MEDICAL("bill-medical.png");

    public final String testImage;

    /**
     * Mapping for the bill type to the test image
     * @param testImage
     */
    BillType(String testImage) {
        this.testImage = testImage;
    }
}
