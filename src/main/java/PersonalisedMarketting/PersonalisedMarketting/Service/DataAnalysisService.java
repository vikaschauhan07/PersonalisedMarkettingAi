package PersonalisedMarketting.PersonalisedMarketting.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import PersonalisedMarketting.PersonalisedMarketting.Model.Customer;
import PersonalisedMarketting.PersonalisedMarketting.Repository.CustomerRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class DataAnalysisService {

    private Map<String, Customer> customerData = new HashMap<>();
   
    @Autowired
    private CustomerRepository customerRepository;

    public void addCustomerData(Customer customer) {
    	 customerRepository.save(customer);
    	customerData.put(customer.getCustomerId(), customer);
        
    }
    @Autowired
    private ChatGPTService chatGPTService; 


    public List<Customer> getAllCustomers() {
        return (List<Customer>) customerRepository.findAll();
    }
    
        public String performAnalytics() {
            List<Customer> customers = getAllCustomers();
            StringBuilder insights = new StringBuilder("Advanced analytics performed on customer data. Insights extracted:\n");

            for (Customer customer : customers) {
                insights.append("Customer: ").append(customer.getName()).append("\n");
                insights.append("Response: ").append(customer.getResponse()).append("\n");
 
                if (containsKeyword(customer.getAddress(), "premium")) {
                    insights.append("- Premium customer\n");
                }

                if (containsKeyword(customer.getEmail(), "discount")) {
                    insights.append("- Interested in discounts\n");
                }
 
                String chatGPTResponse = chatGPTService.generateProjectIdeas(customer.getResponse());
                insights.append("ChatGPT Ideas: ").append(chatGPTResponse).append("\n");
                	insights.append("\n");
            }

            return insights.toString();
        }

        private boolean containsKeyword(String text, String keyword) {
            // Case-insensitive check for the presence of the keyword in the text
            return text != null && text.toLowerCase().contains(keyword.toLowerCase());
        }
    

    
}
