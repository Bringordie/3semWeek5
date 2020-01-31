package dto;

import entities.BankCustomer;


public class CustomerDTO {

    int customerID;
    //Long customerID;
    String fullName;
    String accountNumber;
    double balance;

    public CustomerDTO() {
    }
    
    public CustomerDTO(BankCustomer bankc) {
        this.customerID = bankc.getId().intValue();
        //this.customerID = bankc.getId();
        this.fullName = bankc.getFirstName()+" "+bankc.getLastName();
        this.accountNumber = bankc.getAccountNumber();
        this.balance = bankc.getBalance();
    }

    public int getCustomerID() {
        return customerID;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

//    public Long getCustomerID() {
//        return customerID;
//    }
//
//    public void setCustomerID(Long customerID) {
//        this.customerID = customerID;
//    }
    
    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "CustomerDTO{" + "customerID=" + customerID + ", fullName=" + fullName + ", accountNumber=" + accountNumber + ", balance=" + balance + '}';
    }

    
    
}
