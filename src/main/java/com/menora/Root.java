package com.menora;


import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.*;
import java.util.List;

@XmlRootElement(name = "Root")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Root")
@NoArgsConstructor
@Data
public class Root {
    @XmlElement(name = "RequestDetails", required = true)
    private RequestDetails requestDetails;
    @XmlElement(name = "Event", required = true)
    private List<Event> events;
}
