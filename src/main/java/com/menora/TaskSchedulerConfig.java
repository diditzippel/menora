package com.menora;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Scheduled;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import java.io.File;
// פעם בשעה לקרוא את הקובץ עי XML PARSER

@Configuration
public class TaskSchedulerConfig {

    @Bean
    @Scheduled(cron = "0 0 0/1 * * ?")
    public static void scheduleTaskStart() {

        long now = System.currentTimeMillis() / 1000;

        // 1. Read file and save into hashmap
        // 2. Set hashmap to holder
        // RequestDetails rd = new RequestDetails();
        Holder holder = new Holder();
        try {

            File file = new File("C:\\didi\\RequestDD.xml");
            JAXBContext jaxbContext = JAXBContext.newInstance(Root.class);

            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            Root que= (Root) jaxbUnmarshaller.unmarshal(file);
            System.out.println("");
            // 1. Read file and save into hashmap
            // 2. Set hashmap to holder


        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }


//    private static void printNodeList(NodeList nodeList) {
//        for (int count = 0; count < nodeList.getLength(); count++) {
//            Node elemNode = nodeList.item(count);
//
//            if (elemNode.getNodeType() == Node.ELEMENT_NODE) {
//                // get node name and value
//                System.out.println("\nNode Name =" + elemNode.getNodeName() + " [OPEN]");
//                System.out.println("Node Content =" + elemNode.getTextContent());
//                if (elemNode.hasAttributes()) {
//                    NamedNodeMap nodeMap = elemNode.getAttributes();
//                    for (int i = 0; i < nodeMap.getLength(); i++) {
//                        Node node = nodeMap.item(i);
//                        System.out.println("attr name : " + node.getNodeName());
//                        System.out.println("attr value : " + node.getNodeValue());
//                    }
//                }
//                if (elemNode.hasChildNodes()) {
//                    //recursive call if the node has child nodes
//                    printNodeList(elemNode.getChildNodes());
//                }
//                System.out.println("Node Name =" + elemNode.getNodeName() + " [CLOSE]");
//            }
//        }
//    }
}
