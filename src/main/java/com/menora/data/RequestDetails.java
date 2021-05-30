package com.menora.data;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.io.Serializable;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RequestDetails")
@NoArgsConstructor
@Data
public class RequestDetails implements Serializable {

    @XmlElement(name = "Id", required = true)
    private String id;
    @XmlElement(name = "AcceptDate", required = true)
    private String acceptDate;
    @XmlElement(name = "SourceCompany", required = true)
    private String sourceCompany;
}
