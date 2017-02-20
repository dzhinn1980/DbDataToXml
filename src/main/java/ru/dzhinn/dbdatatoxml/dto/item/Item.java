package ru.dzhinn.dbdatatoxml.dto.item;

import ru.dzhinn.dbdatatoxml.jaxb.AdapterCDATA;
import ru.dzhinn.dbdatatoxml.dto.item.licactsubtypes.LicActSubtypes;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.util.Date;

@XmlType(propOrder = {
        "licenserDate",
        "govtName",
        "organizationOpf",
        "organizationFullName",
        "organizationName",
        "orgFirmName",
        "addrU",
        "ogrn",
        "inn",
        "licActivity",
        "licActSubtypes",
        "licObjAddr",
        "licNum",
        "licSD",
        "licED",
        "ordNum",
        "ordDate"
}
)
public class Item {
    Date licenserDate;
    String govtName;
    String organizationOpf;
    String organizationFullName;
    String organizationName;
    String orgFirmName;
    String addrU;
    String ogrn;
    String inn;
    String licActivity;
    LicActSubtypes licActSubtypes;
    String licObjAddr = "";
    String licNum;
    Date licSD;
    Date licED;
    String ordNum;
    Date ordDate;

    public Item() {
    }

    public Item(Date licenserDate, String govtName) {
        this.licenserDate = licenserDate;
        this.govtName = govtName;
    }

    public Date getLicenserDate() {
        return licenserDate;
    }

    @XmlElement
    public void setLicenserDate(Date licenserDate) {
        this.licenserDate = licenserDate;
    }

    public String getGovtName() {
        return govtName;
    }

    @XmlJavaTypeAdapter(AdapterCDATA.class)
    public void setGovtName(String govtName) {
        this.govtName = govtName;
    }

    public String getOrganizationOpf() {
        return organizationOpf;
    }

    @XmlJavaTypeAdapter(AdapterCDATA.class)
    public void setOrganizationOpf(String organizationOpf) {
        this.organizationOpf = organizationOpf;
    }

    public String getOrganizationFullName() {
        return organizationFullName;
    }

    @XmlJavaTypeAdapter(AdapterCDATA.class)
    public void setOrganizationFullName(String organizationFullName) {
        this.organizationFullName = organizationFullName;
    }

    public String getOrganizationName() {
        return organizationName;
    }

    @XmlJavaTypeAdapter(AdapterCDATA.class)
    public void setOrganizationName(String organizationName) {
        this.organizationName = organizationName;
    }

    public String getOrgFirmName() {
        return orgFirmName;
    }

    @XmlJavaTypeAdapter(AdapterCDATA.class)
    public void setOrgFirmName(String orgFirmName) {
        this.orgFirmName = orgFirmName;
    }

    public String getAddrU() {
        return addrU;
    }

    @XmlJavaTypeAdapter(AdapterCDATA.class)
    public void setAddrU(String addrU) {
        this.addrU = addrU;
    }

    public String getOgrn() {
        return ogrn;
    }

    @XmlJavaTypeAdapter(AdapterCDATA.class)
    public void setOgrn(String ogrn) {
        this.ogrn = ogrn;
    }

    public String getInn() {
        return inn;
    }

    @XmlJavaTypeAdapter(AdapterCDATA.class)
    public void setInn(String inn) {
        this.inn = inn;
    }

    public String getLicActivity() {
        return licActivity;
    }

    @XmlJavaTypeAdapter(AdapterCDATA.class)
    public void setLicActivity(String licActivity) {
        this.licActivity = licActivity;
    }

    public LicActSubtypes getLicActSubtypes() {
        return licActSubtypes;
    }

    @XmlElement
    public void setLicActSubtypes(LicActSubtypes licActSubtypes) {
        this.licActSubtypes = licActSubtypes;
    }

    @XmlJavaTypeAdapter(AdapterCDATA.class)
    public void setLicObjAddr(String licObjAddr) {
        this.licObjAddr = licObjAddr;
    }

    @XmlJavaTypeAdapter(AdapterCDATA.class)
    public void setLicNum(String licNum) {
        this.licNum = licNum;
    }

    @XmlElement
    public void setLicSD(Date licSD) {
        this.licSD = licSD;
    }

    @XmlElement
    public void setLicED(Date licED) {
        this.licED = licED;
    }

    @XmlJavaTypeAdapter(AdapterCDATA.class)
    public void setOrdNum(String ordNum) {
        this.ordNum = ordNum;
    }

    @XmlElement
    public void setOrdDate(Date ordDate) {
        this.ordDate = ordDate;
    }


    public String getLicObjAddr() {
        return licObjAddr;
    }

    public String getLicNum() {
        return licNum;
    }

    public Date getLicSD() {
        return licSD;
    }

    public Date getLicED() {
        return licED;
    }

    public String getOrdNum() {
        return ordNum;
    }

    public Date getOrdDate() {
        return ordDate;
    }
}
