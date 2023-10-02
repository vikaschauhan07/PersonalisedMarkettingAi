package PersonalisedMarketting.PersonalisedMarketting.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import PersonalisedMarketting.PersonalisedMarketting.Configuration.ChatGPTConfig;
import PersonalisedMarketting.PersonalisedMarketting.Configuration.PersonalizationConfig;

import java.util.List;
import java.util.Map;

@Service
public class PersonalizationService {

    private PersonalizationConfig personalizationConfig;

    
    private final ChatGPTConfig chatGPTConfig;
	
   	private CustmoerService custmoerService;

       @Autowired
       public PersonalizationService(
               ChatGPTConfig chatGPTConfig,CustmoerService custmoerService,PersonalizationConfig personalizationConfig ) {
           this.chatGPTConfig = chatGPTConfig;
           this.personalizationConfig = personalizationConfig;
       }

       public String generatePersonalizedMessage(Long customerId ) {
    	    try {
    	        // Prompt the customer for their product interests
    	        String customerPrompt = "What are your product interests?";
    	        String productInterests = getCustomerResponse(customerId,customerPrompt);

    	        // Check if personalization algorithm is enabled
    	        if (personalizationConfig.isPersonalizationAlgorithmEnabled()) {
    	            // Use ChatGPT to generate personalized message
    	            String personalizedMessage = getChatGPTResponse("Generate personalized message for customer " +
    	                    customerId + " with interests: " + productInterests);
    	            return personalizedMessage;
    	        } else {
    	            return "Hello, " + customerId + "! Check out our latest products!";
    	        }
    	    } catch (Exception e) {
    	        e.printStackTrace();
    	        return "Failed to generate personalized message.";
    	    }
    	}

    	private String getCustomerResponse(Long customerId,String prompt) {
    		return custmoerService.getCustomerResponse(customerId, prompt);
    	    
    	}
 // Your existing method to interact with ChatGPT
    public String getChatGPTResponse(String prompt) {
        String apiEndpoint = chatGPTConfig.getChatGPTApiEndpoint();
        String apiKey = chatGPTConfig.getChatGPTApiKey();

        String url = apiEndpoint + "/completion";
        String requestBody = "{\"prompt\": \"" + prompt + "\", \"max_tokens\": 100}";

        HttpHeaders headers = new HttpHeaders();
        headers.set(HttpHeaders.AUTHORIZATION, "Bearer " + apiKey);
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<String> entity = new HttpEntity<>(requestBody, headers);

       
        ResponseEntity<String> responseEntity = new RestTemplate().postForEntity(url, entity, String.class);

        if (responseEntity.getStatusCode() == HttpStatus.OK) {
            return responseEntity.getBody();
        } else {
            return "Failed to get ChatGPT response.";
        }
    }

}
