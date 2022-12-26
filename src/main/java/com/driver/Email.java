package com.driver;

import com.google.common.base.Ascii;

public class Email {

    private String emailId;
    private String password;

    public Email(String emailId){
        this.emailId = emailId;
        this.password = "Accio@123";
    }

    public String getEmailId() {
        return emailId;
    }

    public String getPassword() {
        return password;
    }

    public void changePassword(String oldPassword, String newPassword){
        //Change password only if the oldPassword is equal to current password and the new password meets all of the following:
        // 1. It contains at least 8 characters
        // 2. It contains at least one uppercase letter
        // 3. It contains at least one lowercase letter
        // 4. It contains at least one digit
        // 5. It contains at least one special character. Any character apart from alphabets and digits is a special character
        if(this.password.equals(oldPassword)){
            boolean Upper = false;
            boolean lower = false;
            boolean digit = false;
            boolean special = false;
            if(newPassword.length()<8){
                return;
            }
            for(int i = 0;i<newPassword.length();i++){

                if(Character.isUpperCase(newPassword.charAt(i))){
                    Upper = true;
                }
                else if(Character.isLowerCase(newPassword.charAt(i))){
                    lower = true;
                }
                else if(Character.isDigit(newPassword.charAt(i))){
                    digit = true;
                }
                else if(!Character.isAlphabetic(newPassword.charAt(i)) && !Character.isDigit(newPassword.charAt(i))){
                    special = true;
                }
            }
            if(Upper && lower && digit && special){
                this.password = newPassword;
            }
        }
    }
}
