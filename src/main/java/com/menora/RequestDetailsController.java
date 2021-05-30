package com.menora;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.logging.Logger;

@RestController
@RequestMapping(value = "/request")
public class RequestDetailsController {
    private final static Logger logger = Logger.getLogger(RequestDetailsController.class.getSimpleName());

    @Autowired
    Holder holder;

    @GetMapping("/requestdetails/{id}")
    RequestDetails findByInsuredId(@PathVariable Long id) {

        return holder.getHolderMap().get(id);

    }
}
