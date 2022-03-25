package academy.digitallab.store.product.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import academy.digitallab.store.product.entity.Category;
import academy.digitallab.store.product.entity.Product;
import academy.digitallab.store.product.service.ProductService;


@RestController
@RequestMapping(path = "products")
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	@GetMapping
	public ResponseEntity<List<Product>> listProduct(@RequestParam(value ="categoryID",required = false) Long categoryID){
		List<Product> products =new ArrayList<>();
		if(null ==categoryID) {
			products = productService.listAllProduct();
			if(products.isEmpty()) {
				return ResponseEntity.noContent().build();
			}
		}else {
			products = productService.findByCategory(Category.builder().id(categoryID).build());
			if(products.isEmpty()) {
				return ResponseEntity.noContent().build();
			}
		}
		
		

		
		return ResponseEntity.ok(products);
		
	}
	
	@GetMapping(value="/{id}")
	public ResponseEntity<Product> getProduct(@PathVariable("id") Long id) {
		Product producto = productService.getProduct(id);
		if(null ==producto) {
			return ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.ok(producto);
	}
	
	@PostMapping
	public ResponseEntity<Product> createProducto(@Valid @RequestBody Product producto,BindingResult result){
		if(result.hasErrors()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,this.formatMessage(result));
		}
		Product productCreate = productService.createProduct(producto);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(productCreate);
	}
	
	@PutMapping(value="/{id}")
	public ResponseEntity<Product> updateProduct(@PathVariable("id") Long id,@RequestBody Product product){
		product.setId(id);
		Product productDb= productService.updateProduct(product);
		if(productDb == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(productDb);
	}
	
	@DeleteMapping(value="/{id}")
	public ResponseEntity<Product> deleteProduct(@PathVariable("id")Long id){
		Product productDelete = productService.deleteProduct(id);
		if(productDelete == null) {
			return ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.ok(productDelete);
	}
	@GetMapping(value="/{id}/stock")
	public ResponseEntity<Product> updateStockProduct(@PathVariable("id") Long id,@RequestParam(value="quantity",required = true) Double quantity){
		Product product = productService.updateStock(id, quantity);
		if(product == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(product);
	}
	
	private String formatMessage(BindingResult result) {
		List<Map<String,String>> errors = result.getFieldErrors().stream()
				.map(err->{
					Map<String,String> error = new HashMap<>();
					error.put(err.getField(),err.getDefaultMessage());
					return error;
				}).collect(Collectors.toList());
		ErrorMessage errorMEssage = ErrorMessage.builder()
				.code("01")
				.messages(errors).build();
		ObjectMapper mapper = new ObjectMapper();
		String jsonString="";
		try {
			jsonString = mapper.writeValueAsString(errorMEssage);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return jsonString;
		
	}
	
}
