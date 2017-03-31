package com.springboot.model.entity;

import com.springboot.dto.MemberResponse;
import com.springboot.dto.MemberResponseBuilder;
import com.springboot.model.Enum.Gender;
import com.springboot.model.Enum.MaritalStatus;
import net.karneim.pojobuilder.GeneratePojoBuilder;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by eko.j.manurung on 9/23/2016.
 */
@GeneratePojoBuilder
@Entity
@Table(name = "member")
public class Member extends BaseEntity implements Serializable {

    private static final long serialVersionUID = 2410345920783043723L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer memberId;
    private String firstName;
    private String lastName;
    private Date dateOfBirth;
    @Enumerated(EnumType.STRING)
    private MaritalStatus maritalStatus;
    @Enumerated(EnumType.STRING)
    private Gender gender;
    private String phoneNumber;
    private String emailAddress;
    private String address;

    public MemberResponse toMemberResponse() {
        return new MemberResponseBuilder()
                .withGender(getGender())
                .withDateOfBirth(getDateOfBirth())
                .withFirstName(getFirstName())
                .withLastName(getLastName())
                .withAddress(getAddress())
                .withEmailAddress(getEmailAddress())
                .withMaritalStatus(getMaritalStatus())
                .withPhoneNumber(getPhoneNumber())
                .withCreatedDate(getCreatedDate())
                .withUpdatedDate(getUpdatedDate())
                .build();
    }

    public Integer getMemberId() {
        return memberId;
    }

    public void setMemberId(Integer memberId) {
        this.memberId = memberId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public MaritalStatus getMaritalStatus() {
        return maritalStatus;
    }

    public void setMaritalStatus(MaritalStatus maritalStatus) {
        this.maritalStatus = maritalStatus;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Member)) return false;
        if (!super.equals(o)) return false;

        Member member = (Member) o;

        if (getMemberId() != null ? !getMemberId().equals(member.getMemberId()) : member.getMemberId() != null)
            return false;
        if (getFirstName() != null ? !getFirstName().equals(member.getFirstName()) : member.getFirstName() != null)
            return false;
        if (getLastName() != null ? !getLastName().equals(member.getLastName()) : member.getLastName() != null)
            return false;
        if (getDateOfBirth() != null ? !getDateOfBirth().equals(member.getDateOfBirth()) : member.getDateOfBirth() != null)
            return false;
        if (getMaritalStatus() != member.getMaritalStatus()) return false;
        if (getGender() != member.getGender()) return false;
        if (getPhoneNumber() != null ? !getPhoneNumber().equals(member.getPhoneNumber()) : member.getPhoneNumber() != null)
            return false;
        if (getEmailAddress() != null ? !getEmailAddress().equals(member.getEmailAddress()) : member.getEmailAddress() != null)
            return false;
        return getAddress() != null ? getAddress().equals(member.getAddress()) : member.getAddress() == null;

    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (getMemberId() != null ? getMemberId().hashCode() : 0);
        result = 31 * result + (getFirstName() != null ? getFirstName().hashCode() : 0);
        result = 31 * result + (getLastName() != null ? getLastName().hashCode() : 0);
        result = 31 * result + (getDateOfBirth() != null ? getDateOfBirth().hashCode() : 0);
        result = 31 * result + (getMaritalStatus() != null ? getMaritalStatus().hashCode() : 0);
        result = 31 * result + (getGender() != null ? getGender().hashCode() : 0);
        result = 31 * result + (getPhoneNumber() != null ? getPhoneNumber().hashCode() : 0);
        result = 31 * result + (getEmailAddress() != null ? getEmailAddress().hashCode() : 0);
        result = 31 * result + (getAddress() != null ? getAddress().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Member{");
        sb.append("memberId=").append(memberId);
        sb.append(", firstName='").append(firstName).append('\'');
        sb.append(", lastName='").append(lastName).append('\'');
        sb.append(", dateOfBirth=").append(dateOfBirth);
        sb.append(", maritalStatus=").append(maritalStatus);
        sb.append(", gender=").append(gender);
        sb.append(", phoneNumber='").append(phoneNumber).append('\'');
        sb.append(", emailAddress='").append(emailAddress).append('\'');
        sb.append(", address='").append(address).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
