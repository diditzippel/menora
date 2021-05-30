package com.menora.bl;


import com.menora.data.Event;
import com.menora.data.Product;
import com.menora.data.Request;
import lombok.Data;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.util.*;


@Component
@Data
public class ProductsManager {

    // Request cache
    Map<String, Request> requests = new HashMap<>();

    private final ApplicationPropertyService applicationPropertyService;
    private final String FILE_NAME = "Request.xml";
    private Date lastDate = new Date();
    private boolean isInitialized = false;

    @Scheduled(initialDelay = 10 * 1000, fixedDelay = 1 * 1000)
    public void executeTask() {
        try {

            if (durationIsPassed() || !isInitialized) {
                String vaultLocation = applicationPropertyService.getVaultLocation();
                File file = new File(vaultLocation + "\\" + FILE_NAME);
                JAXBContext jaxbContext = JAXBContext.newInstance(Request.class);

                Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
                Request request = (Request) jaxbUnmarshaller.unmarshal(file);

                requests.put(request.getRequestDetails().getId(), request);

                lastDate = new Date();
                isInitialized = true;
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private boolean durationIsPassed() {
        Date current = new Date();
        long intervalLast = current.getTime() - lastDate.getTime();
        long durationInMillis = applicationPropertyService.getDurationTimeInMinutes() * 60 * 1000;
        return durationInMillis < intervalLast;
    }

    public Map<String, List<Product>> getProductsOfInsure(String insureId) {

        // sourceCompany with list of products
        Map<String, List<Product>> productsToSystem = new HashMap<>();

        for (Request request : requests.values()) {
            String sourceCompany = request.getRequestDetails().getSourceCompany();

            for (Event event : request.getEvents()) {
                List<Product> products = new ArrayList<>();

                if (event.getInsuredId().equals(insureId)) {
                    products.addAll(event.getProducts());
                }

                if (!products.isEmpty()) {

                    if (!productsToSystem.containsKey(sourceCompany)) {
                        productsToSystem.put(sourceCompany, new ArrayList<>());
                    }
                    productsToSystem.get(sourceCompany).addAll(products);
                }
            }
        }

        return productsToSystem;
    }
}
