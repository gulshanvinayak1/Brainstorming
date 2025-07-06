//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.ghanshyam.Brainstroming.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Index;
import jakarta.persistence.Table;

@Entity
@Table(
        name = "users",
        indexes = {@Index(
                name = "idx_gmail_id",
                columnList = "gmail_id"
        )}
)
public class User {
    @Column(
            name = "gmail_id",
            nullable = false
    )
    private String gmailId;
    @Column(
            name = "password",
            nullable = false
    )
    private String password;
    @Id
    @Column(
            name = "user_id",
            nullable = false,
            unique = true
    )
    private String userId;

    public User(String gmailId, String password, String userId) {
        this.gmailId = gmailId;
        this.password = password;
        this.userId = userId;
    }

    public User() {
    }

    public String getGmailId() {
        return this.gmailId;
    }

    public void setGmailId(String gmailId) {
        this.gmailId = gmailId;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserId() {
        return this.userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
