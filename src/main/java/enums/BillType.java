package enums;

public enum BillType {

    UTILITY("bill-utility.png"),
    MEDICAL("bill-medical.png");

    public final String testImage;

    BillType(String testImage) {
        this.testImage = testImage;
    }
}
