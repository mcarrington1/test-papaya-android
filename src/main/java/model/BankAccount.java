package model;

public class BankAccount {
    private String phoneNumber = "3148675309";
    private String emailAddress = "qa@papayapay.com";
    private String accountHolderName = "test customer";
    private String routingNumber = "081000210";
    private String routingNumberConfirmation = routingNumber;
    private String accountNumber = "12345978910";
    private String accountNumberConfirmation = accountNumber;

    public BankAccount() {
    }

    public BankAccount(String phoneNumber, String emailAddress, String accountHolderName,
                       String routingNumber, String accountNumber) {
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAccountHolderName() {
        return accountHolderName;
    }

    public void setAccountHolderName(String accountHolderName) {
        this.accountHolderName = accountHolderName;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getRoutingNumber() {
        return routingNumber;
    }

    public void setRoutingNumber(String routingNumber) {
        this.routingNumber = routingNumber;
    }

    public String getRoutingNumberConfirmation() {
        return routingNumberConfirmation;
    }

    public void setRoutingNumberConfirmation(String routingNumberConfirmation) {
        this.routingNumberConfirmation = routingNumberConfirmation;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getAccountNumberConfirmation() {
        return accountNumberConfirmation;
    }

    public void setAccountNumberConfirmation(String accountNumberConfirmation) {
        this.accountNumberConfirmation = accountNumberConfirmation;
    }



}
