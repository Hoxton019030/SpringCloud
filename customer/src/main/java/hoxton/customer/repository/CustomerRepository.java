package hoxton.customer.repository;

import hoxton.customer.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.Id;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {
}
