package ru.dzhinn.dbdatatoxml.dto.input;

import ru.dzhinn.dbdatatoxml.jaxb.AdapterCDATA;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

//@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(propOrder={"govtName", "licSd", "licEd", "licStatuses"})
public class Input {

    String govtName;
    String licStatuses;
    String licSd;
    String licEd;


    public String getGovtName() {
        return govtName;
    }

//    @XmlCDATA
    @XmlJavaTypeAdapter(AdapterCDATA.class)

    public void setGovtName(String govtName) {
        this.govtName = govtName;
    }

    public String getLicStatuses() {
        return licStatuses;
    }

    @XmlElement
    public void setLicStatuses(String licStatuses) {
        this.licStatuses = licStatuses;
    }

    public String getLicSd() {
        return licSd;
    }

    @XmlElement
    public void setLicSd(String licSd) {
        this.licSd = licSd;
    }

    public String getLicEd() {
        return licEd;
    }

    @XmlElement
    public void setLicEd(String licEd) {
        this.licEd = licEd;
    }
}
