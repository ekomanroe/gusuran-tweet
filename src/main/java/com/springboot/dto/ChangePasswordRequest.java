package com.springboot.dto;

import net.karneim.pojobuilder.GeneratePojoBuilder;
import org.hibernate.validator.constraints.NotEmpty;

import java.io.Serializable;

/**
 * Created by eko.j.manurung on 11/11/2016.
 */
@GeneratePojoBuilder
public class ChangePasswordRequest implements Serializable {

    private static final long serialVersionUID = 2414975910783043723L;

    @NotEmpty
    private String newPassword;

    @NotEmpty
    private String oldPassword;

    public String getOldPassword() {
        return oldPassword;
    }

    public void setOldPassword(String oldPassword) {
        this.oldPassword = oldPassword;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ChangePasswordRequest)) return false;

        ChangePasswordRequest that = (ChangePasswordRequest) o;

        if (getNewPassword() != null ? !getNewPassword().equals(that.getNewPassword()) : that.getNewPassword() != null)
            return false;
        return getOldPassword() != null ? getOldPassword().equals(that.getOldPassword()) : that.getOldPassword() == null;

    }

    @Override
    public int hashCode() {
        int result = getNewPassword() != null ? getNewPassword().hashCode() : 0;
        result = 31 * result + (getOldPassword() != null ? getOldPassword().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("ChangePasswordRequest{");
        sb.append("newPassword='").append(newPassword).append('\'');
        sb.append(", oldPassword='").append(oldPassword).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
