package ru.dzhinn.dbdatatoxml.dto.item.licactsubtypes;

import ru.dzhinn.dbdatatoxml.jaxb.AdapterCDATA;

import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

/**
 * Created by A.Dzhioev on 17.02.2017.
 */
public class LicActSubtypes {
    String act;

    public LicActSubtypes() {
    }

    public LicActSubtypes(String act) {
        this.act = act;
    }

    public String getAct() {
        return act;
    }

    @XmlJavaTypeAdapter(AdapterCDATA.class)
    public void setAct(String act) {
        this.act = act;
    }
}
