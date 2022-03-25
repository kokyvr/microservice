package academy.digitallab.store.shopping.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import academy.digitallab.store.shopping.entity.Invoice;

@Repository
public interface InvoiceRepository extends JpaRepository<Invoice, Long>{

	
	   public List<Invoice> findByCustomerId(Long customerId );
	    public Invoice findByNumberInvoice(String numberInvoice);
}
