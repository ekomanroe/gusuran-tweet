package com.springboot.model.entity;


import net.karneim.pojobuilder.GeneratePojoBuilder;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by eko.j.manurung on 9/23/2016.
 */
@GeneratePojoBuilder
@Entity
@Table(name = "account")
public class Account extends BaseEntity implements Serializable {

    private static final long serialVersionUID = 2410345910789203723L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer accountId;
    private String username;
    private String password;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "memberId")
    private Member member;

    public Account() {
    }

    public Integer getAccountId() {
        return accountId;
    }

    public void setAccountId(Integer accountId) {
        this.accountId = accountId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Account)) return false;
        if (!super.equals(o)) return false;

        Account account = (Account) o;

        if (getAccountId() != null ? !getAccountId().equals(account.getAccountId()) : account.getAccountId() != null)
            return false;
        if (getUsername() != null ? !getUsername().equals(account.getUsername()) : account.getUsername() != null)
            return false;
        if (getPassword() != null ? !getPassword().equals(account.getPassword()) : account.getPassword() != null)
            return false;
        return getMember() != null ? getMember().equals(account.getMember()) : account.getMember() == null;

    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (getAccountId() != null ? getAccountId().hashCode() : 0);
        result = 31 * result + (getUsername() != null ? getUsername().hashCode() : 0);
        result = 31 * result + (getPassword() != null ? getPassword().hashCode() : 0);
        result = 31 * result + (getMember() != null ? getMember().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Account{");
        sb.append("accountId=").append(accountId);
        sb.append(", username='").append(username).append('\'');
        sb.append(", password='").append(password).append('\'');
        sb.append(", member=").append(member);
        sb.append('}');
        return sb.toString();
    }
}
