package com.wpi.generic.storage;

import javax.xml.bind.annotation.XmlElement;

/**
 * Created by Wiesław Piasecki on 2014-09-29.
 */
public class PhoneNumber {
    @XmlElement
    private String type;
    @XmlElement
    private String number;

    PhoneNumber(String type, String number) {
        this.type = type;
        this.number = number;
    }

     PhoneNumber() {
    }

    public static PhoneNumber of(String type, String number) {
        return new PhoneNumber(type, number);
    }
}
