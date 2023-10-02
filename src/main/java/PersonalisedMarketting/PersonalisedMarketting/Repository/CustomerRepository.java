package PersonalisedMarketting.PersonalisedMarketting.Repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import PersonalisedMarketting.PersonalisedMarketting.Model.Customer;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, Long> {
	
	@Query("SELECT c.response FROM Customer c WHERE c.projectId = :projectId")
	String getByProject(Long projectId);
}
