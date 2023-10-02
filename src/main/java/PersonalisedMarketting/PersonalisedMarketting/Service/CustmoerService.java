package PersonalisedMarketting.PersonalisedMarketting.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import PersonalisedMarketting.PersonalisedMarketting.Model.Customer;
import PersonalisedMarketting.PersonalisedMarketting.Repository.CustomerRepository;
@Service
public class CustmoerService {
	 @Autowired
	    private CustomerRepository customerRepository;

	    public String getCustomerResponse(Long customerId, String prompt) {
	       
	            Customer customer = (Customer)customerRepository.findById(customerId).get();

	            String customerResponse =  customer.getResponse();
	            return customerResponse;
	       
	    }
}
