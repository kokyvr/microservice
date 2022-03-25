package academy.digitallab.store.product.service;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import academy.digitallab.store.product.entity.Category;
import academy.digitallab.store.product.entity.Product;
import academy.digitallab.store.product.repository.ProductRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

	//@Autowired
	private final ProductRepository productoRepository;
	
	@Override
	public List<Product> listAllProduct() {
		// TODO Auto-generated method stub
		return productoRepository.findAll();
	}

	@Override
	public Product getProduct(Long id) {
		// TODO Auto-generated method stub
		return productoRepository.findById(id).orElse(null);
	}

	@Override
	public Product createProduct(Product product) {
		// TODO Auto-generated method stub
		product.setStatus("CREATED");
		product.setCreateAt(new Date());
		return productoRepository.save(product);
	}

	@Override
	public Product updateProduct(Product product) {
		Product productDB = getProduct(product.getId());
		if(null ==productDB) {
			return null;
		}
		productDB.setName(product.getName());
		productDB.setDescription(product.getDescription());
		productDB.setCategory(product.getCategory());
		productDB.setPrice(product.getPrice());
		
		return productoRepository.save(productDB);
	}

	@Override
	public Product deleteProduct(Long id) {
		Product productDB = getProduct(id);
		if(null ==productDB) {
			return null;
		}
		productDB.setStatus("DELETE");
		
		return productoRepository.save(productDB);
	}

	@Override
	public List<Product> findByCategory(Category category) {
		// TODO Auto-generated method stub
		return productoRepository.findByCategory(category);
	}

	@Override
	public Product updateStock(Long id, Double quantity) {
		Product productDB = getProduct(id);
		if(null ==productDB) {
			return null;
		}
		Double stock = productDB.getStock() + quantity;
		productDB.setStock(stock);
		return productoRepository.save(productDB);
	}

}
