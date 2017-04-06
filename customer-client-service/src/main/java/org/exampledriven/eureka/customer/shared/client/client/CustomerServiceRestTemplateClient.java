package org.exampledriven.eureka.customer.shared.client.client;

import org.exampledriven.eureka.customer.shared.Customer;
import org.exampledriven.eureka.customer.shared.client.controller.MessageWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class CustomerServiceRestTemplateClient {
	
	// here is the client, it means that this
	// service as job calls the server who know the clients, and asks it "gimme a customer!". all the 
	// things related on json and similar and ajax are not our deal.
	// C'è UNA CLASSE GEMELLA, CHE LAVORA USANDO FEIGN, QUESTA USA REST TEMPLATE

    @Autowired
    private RestTemplate restTemplate;

    public MessageWrapper<Customer> getCustomer(int id) {

        Customer customer = restTemplate.exchange(
                "http://customer-service/customer/{id}",
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<Customer>() {
                },
                id).getBody();

        return new MessageWrapper<>(customer, "server called using eureka with rest template");

    }

}