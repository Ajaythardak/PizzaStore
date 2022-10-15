package com.niit.pizzaDetails.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import java.util.List;

@Document
public class UserDetails {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int userId;
    private String userName;
    private String userEmail;
    private String password;
    private long phoneNo;
    private String address;
    private List<Pizza> pizzaList;

    public UserDetails() {
    }

    public UserDetails(int userId, String userName, String userEmail, String password, long phoneNo, String address, List<Pizza> pizzaList) {
        this.userId = userId;
        this.userName = userName;
        this.userEmail = userEmail;
        this.password = password;
        this.phoneNo = phoneNo;
        this.address = address;
        this.pizzaList = pizzaList;
    }



    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public long getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(long phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public List<Pizza> getPizzaList() {
        return pizzaList;
    }

    public void setPizzaList(List<Pizza> pizzaList) {
        this.pizzaList = pizzaList;
    }

    @Override
    public String toString() {
        return "UserDetails{" +
                "userId='" + userId + '\'' +
                ", userName='" + userName + '\'' +
                ", pizza=" + pizzaList +
                '}';
    }
}
