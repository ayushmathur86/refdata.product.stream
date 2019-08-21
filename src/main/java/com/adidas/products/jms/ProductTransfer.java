package com.adidas.products.jms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

import com.adidas.products.model.Product;

@Component
public class ProductTransfer {

    @Autowired
    private JmsTemplate template;

    @Value("${product.stream.target.queue}")
    private String targetQueue;

    /**
     * Method to receive object from inbound JMS queue.
     * @param product Product object to be transferred for persistence.
     */
    @JmsListener(destination = "${product.stream.source.queue}", containerFactory = "productFactory")
    public void receiveMessage(final Product product) {
        sendMessage(product);
    }

    /**
     * Method to send object to target queue for persistence.
     * @param product Product object to persist.
     */
    public void sendMessage(Product product) {
        template.convertAndSend(targetQueue, product);
    }
}
