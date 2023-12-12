package org.cxf_rs.domain;
import com.fasterxml.jackson.annotation.JsonRootName;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlRootElement;
//@XmlRootElement(name = "##default")
//@XmlAccessorType(XmlAccessType.FIELD)
@JsonRootName("isUserLicensedParam")
public class IsUserLicensedParam {
    public String wstrUser;
    public String wstrModule;
    public String wstrInstallNo;

    public String getWstrUser() {
        return wstrUser;
    }

    public void setWstrUser(String wstrUser) {
        this.wstrUser = wstrUser;
    }

    public String getWstrModule() {
        return wstrModule;
    }

    public void setWstrModule(String wstrModule) {
        this.wstrModule = wstrModule;
    }

    public String getWstrInstallNo() {
        return wstrInstallNo;
    }

    public void setWstrInstallNo(String wstrInstallNo) {
        this.wstrInstallNo = wstrInstallNo;
    }
}

