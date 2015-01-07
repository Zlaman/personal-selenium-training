package com.zlaman.model;

public class User {
    private String emailAddress;
    private String password;
    private String userName;
    /**
     * @return the emailAddress
     */
    public String getEmailAddress() {
        return emailAddress;
    }
    /**
     * @param emailAddress the emailAddress to set
     */
    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }
    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }
    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }
    /**
     * @return the userName
     */
    public String getUserName() {
        return userName;
    }
    /**
     * @param userName the userName to set
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }
    
    /**
     * @param userEmail the userEmail to set
     * @param userPassword the userPassword to set
     * @param userName the userName to set
     */
    public void initUser(String userEmail, String userPassword, String userName) {
        this.emailAddress = userEmail;
        this.password = userPassword;
        this.userName = userName;
    }
    
}
