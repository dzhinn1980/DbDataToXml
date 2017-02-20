package ru.dzhinn.dbdatatoxml.dto;

import ru.dzhinn.dbdatatoxml.dto.input.Input;
import ru.dzhinn.dbdatatoxml.dto.item.Item;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "licenses")
public class Licenses {

    Input input;
    List<Item> items;

    public Input getInput() {
        return input;
    }

    @XmlElement
    public void setInput(Input input) {
        this.input = input;
    }

    public List<Item> getItems() {
        return items;
    }

    @XmlElement
    public void setItems(List<Item> items) {
        this.items = items;
    }
}
