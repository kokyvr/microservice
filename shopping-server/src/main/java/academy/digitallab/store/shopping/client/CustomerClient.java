package academy.digitallab.store.shopping.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name = "customer-service",path = "customers" ,fallback = CustomerHsytrixFallBackFactory.class)
//@RequestMapping("/customers")
public interface CustomerClient {
	
	  @GetMapping(value = "/{id}")
	    public ResponseEntity<academy.digitallab.store.shopping.model.Customer> getCustomer(@PathVariable("id") long id);

}
