package com.menora.data;


import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.*;
import java.util.List;

@XmlRootElement(name = "Root")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Request")
@NoArgsConstructor
@Data
public class Request {

    @XmlElement(name = "RequestDetails", required = true)
    private RequestDetails requestDetails;

    @XmlElement(name = "Event", required = true)
    private List<Event> events;
}
