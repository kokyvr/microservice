package academy.digitallab.store.shopping.client;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import academy.digitallab.store.shopping.model.Customer;

@Component
public class CustomerHsytrixFallBackFactory implements CustomerClient {

	@Override
	public ResponseEntity<Customer> getCustomer(long id) {
		Customer customer = Customer.builder()
				.firstName("none")
				.lastName("none")
				.email("none")
				.photoUrl("none")
				.build();
		// TODO Auto-generated method stub
		return ResponseEntity.ok(customer);
	}

}
