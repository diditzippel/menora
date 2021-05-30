package com.menora.data;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.io.Serializable;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Product")
@Data
@NoArgsConstructor
public class Product implements Serializable {

    @XmlElement(name = "Type", required = true)
    private String type;

    @XmlElement(name = "Price", required = true)
    private String price;

    @XmlElement(name = "StartDate", required = true)
    private String startDate;

    @XmlElement(name = "EndDate", required = true)
    private String endDate;
}
