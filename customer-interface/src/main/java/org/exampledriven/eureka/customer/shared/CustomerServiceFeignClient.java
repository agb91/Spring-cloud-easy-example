package org.exampledriven.eureka.customer.shared;

import org.springframework.cloud.netflix.feign.FeignClient;

//THIS IS THE INTERFACE of the FEIGNE OBJECT ABLE TO call the server

@FeignClient(value = "customer-service")
public interface CustomerServiceFeignClient extends CustomerService {

}
