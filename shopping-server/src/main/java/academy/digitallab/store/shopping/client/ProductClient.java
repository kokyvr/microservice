package academy.digitallab.store.shopping.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import academy.digitallab.store.shopping.model.Product;


@FeignClient(name = "product-service",path = "products")
//@RequestMapping(path = "products")
public interface ProductClient {
	
	@GetMapping(value="/{id}")
	public ResponseEntity<Product> getProduct(@PathVariable("id") Long id);

	
	@GetMapping(value="/{id}/stock")
	public ResponseEntity<Product> updateStockProduct(@PathVariable("id") Long id,@RequestParam(value="quantity",required = true) Double quantity);
	

}
