package ru.job4j.serialization.xml;

import ru.job4j.io.Config;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Contact")
public class Contact {

    @XmlAttribute
    private String phone;

    public Contact() { }

    public Contact(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Contact{"
                + "phone='" + phone + '\''
                + '}';
    }
}