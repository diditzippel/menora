package com.menora;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.io.Serializable;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Event")
@NoArgsConstructor
@Data
public class Event implements Serializable {

    @XmlElement(name = "Id", required = true)
    private String id;
    @XmlElement(name = "Type", required = true)
    private String type;
    @XmlElement(name = "InsuredId", required = true)
    private String insuredId;
    @XmlElement(name = "Product", required = true)
    private List<Product> products;
}
