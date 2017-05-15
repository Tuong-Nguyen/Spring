package spitter.web.models;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;

/**
 * Created by nttao on 5/5/2017.
 */
@XmlRootElement(name="user")
public class AccountModel {
    private String strID;
    private String strPass;
    private String strName;
    private String strEmail;
    private Date dBirthDay;
    private String strSex;

    public String getStrSex() { return strSex; }

    public void setStrSex(String strSex) {  this.strSex = strSex; }

    public String getStrID() {
        return strID;
    }

    public void setStrID(String strID) {
        this.strID = strID;
    }

    public String getStrPass() {
        return strPass;
    }

    public void setStrPass(String strPass) {
        this.strPass = strPass;
    }

    public String getStrName() {
        return strName;
    }

    public void setStrName(String strName) {
        this.strName = strName;
    }

    public String getStrEmail() {
        return strEmail;
    }

    public void setStrEmail(String strEmail) {
        this.strEmail = strEmail;
    }

    public Date getdBirthDay() {
        return dBirthDay;
    }

    public void setdBirthDay(Date dBirthDay) {
        this.dBirthDay = dBirthDay;
    }
}
