package org.cxf_rs.domain;

import com.fasterxml.jackson.annotation.JsonRootName;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlRootElement;

//@XmlRootElement(name = "##default")
//@XmlAccessorType(XmlAccessType.FIELD)
@JsonRootName("getVersionResult")
public class GetVersionResult extends LicenseResult {
    public String sVersion;

}
