package com.augmentum.oes.model;

import java.util.Date;

import net.sf.oval.constraint.Email;
import net.sf.oval.constraint.NotEmpty;
import net.sf.oval.constraint.NotNull;

public class User {

    private int id;

    //@NotNull(message = "User Name is required")
    //@NotEmpty(message = "User Name is required")
    private String userName;

    @NotNull(message = "FullName is required")
    @NotEmpty(message = "FullName is required")
    private String fullName;
    private String password;

    @NotNull(message = "Telephone is required")
    @NotEmpty(message = "Telephone is required")
    private String telephone;
    private String gender;
    private Date createTime;
    private Date lastUpdateTime;
    private int isDeleted;
    @Email(message = "Please input correct email")
    private String email;
    private String roleName;

    public User() {
        super();
    }

    public User(int id, String fullName) {
        this.id = id;
        this.fullName = userName;
    }

    public User(int id, String userName, String fullName) {
        this.id = id;
        this.userName = userName;
        this.fullName = fullName;
    }

    public User(int id, String fullName, String telephone, String email, String gender) {
        this.id = id;
        this.fullName = fullName;
        this.telephone = telephone;
        this.email = email;
        this.gender = gender;
    }

    public User(int id, String userName, String password, String fullName, String telephone, String email,
            String gender) {
        super();
        this.id = id;
        this.userName = userName;
        this.fullName = fullName;
        this.password = password;
        this.telephone = telephone;
        this.gender = gender;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getLastUpdateTime() {
        return lastUpdateTime;
    }

    public void setLastUpdateTime(Date lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
    }

    public int getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(int isDeleted) {
        this.isDeleted = isDeleted;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
}
