package com.adidas.products.jms;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.jms.ConnectionFactory;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.jms.DefaultJmsListenerContainerFactoryConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.config.JmsListenerContainerFactory;
import org.springframework.jms.support.converter.MappingJackson2MessageConverter;
import org.springframework.jms.support.converter.MessageConverter;
import org.springframework.jms.support.converter.MessageType;
import org.springframework.util.ErrorHandler;

public class JmsConfigurator {

    private static final Logger LOGGER = Logger.getLogger("Adidas");

    @Value("${spring.activemq.broker-url}")
    private String mqUrl;

    @Value("${spring.activemq.user}")
    private String mqUser;

    @Value("${spring.activemq.password}")
    private String mqPassword;

    /**
     * Method to initialize ConnectionFactory for queue connectivity.
     * @return instance of ConnectionFactory.
     */
    @Bean
    public ConnectionFactory connectionFactory() {
        ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory();
        connectionFactory.setBrokerURL(mqUrl);
        connectionFactory.setUserName(mqUser);
        connectionFactory.setPassword(mqPassword);
        return connectionFactory;
    }

    /**
     * Method to initialize JMSListener factory.
     * @param connFactory ConnectionFactory object.
     * @param configurer DefaultJmsListenerContainerFactoryConfigurer object.
     * @return JMSListener factory.
     */
    @Bean
    public JmsListenerContainerFactory<?> productFactory(ConnectionFactory connFactory,
            DefaultJmsListenerContainerFactoryConfigurer configurer) {
        DefaultJmsListenerContainerFactory factory = new DefaultJmsListenerContainerFactory();
        factory.setErrorHandler(new ErrorHandler() {

            @Override
            public void handleError(Throwable t) {
                LOGGER.log(Level.SEVERE, "Error occurred during transaction");
            }
        });
        factory.setErrorHandler(t -> LOGGER.log(Level.SEVERE, "Error occurred during transaction"));
        configurer.configure(factory, connFactory);
        return factory;
    }

    /**
     * Method to convert message type of objects read from the queue.
     * @return instance of MessageConverter.
     */
    @Bean
    public MessageConverter jmsMessageConverter() {
        MappingJackson2MessageConverter converter = new MappingJackson2MessageConverter();
        converter.setTargetType(MessageType.TEXT);
        converter.setTypeIdPropertyName("_type");
        return converter;
    }
}
