package org.swchalu.retrofitexample.model;

/**
 * Created by swc12 on 2016/5/16 0016.
 */
public class LoginCallback {
    private String flag;
    private String isAdmin;
    private String username;

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public String getIsAdmin() {
        return isAdmin;
    }

    public void setIsAdmin(String isAdmin) {
        this.isAdmin = isAdmin;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("LoginCallback[ ");
        stringBuffer.append("username=" + getUsername() + "; ");
        stringBuffer.append("isAdmin=" + getIsAdmin() + "; ");
        stringBuffer.append("flag=" + getFlag());
        stringBuffer.append(" ]");
        return stringBuffer.toString();
    }
}
