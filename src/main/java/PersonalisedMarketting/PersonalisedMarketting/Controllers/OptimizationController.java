package PersonalisedMarketting.PersonalisedMarketting.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import PersonalisedMarketting.PersonalisedMarketting.Configuration.ChatGPTConfig;
import PersonalisedMarketting.PersonalisedMarketting.Repository.CustomerRepository;
import PersonalisedMarketting.PersonalisedMarketting.Service.OptimizationService;

@RestController
@RequestMapping("/optimize")
public class OptimizationController {

    @Autowired
    private OptimizationService optimizationService;
    @Autowired
    private CustomerRepository customerService;
     
@Autowired
    private final ChatGPTConfig chatGPTConfig;
    @Autowired
    public OptimizationController(ChatGPTConfig chatGPTConfig) {
        this.chatGPTConfig = chatGPTConfig;
    }
    @PostMapping("/optimizeMarketingStrategy")
    public String optimizeMarketingStrategy(@RequestParam Long projectNameQuery) {
        String latestData = customerService.getByProject(projectNameQuery);
        String latestTrends = getChatGPTResponse("Provide a prompt for trends");
        String latestNews = getChatGPTResponse("Provide a prompt for news");

        return optimizationService.optimizeMarketingStrategy(latestData, latestTrends, latestNews);
    }

    public String getChatGPTResponse(String prompt) {
        try {
            String apiEndpoint = chatGPTConfig.getChatGPTApiEndpoint();
            String apiKey = chatGPTConfig.getChatGPTApiKey();

            String url = apiEndpoint + "/completion";
            String requestBody = "{\"prompt\": \"" + prompt + "\", \"max_tokens\": 100}";

            HttpHeaders headers = new HttpHeaders();
            headers.set(HttpHeaders.AUTHORIZATION, "Bearer " + apiKey);
            headers.setContentType(MediaType.APPLICATION_JSON);

            HttpEntity<String> entity = new HttpEntity<>(requestBody, headers);

            // Use the RestTemplate bean for HTTP request
            ResponseEntity<String> responseEntity = new RestTemplate().postForEntity(url, entity, String.class);

            if (responseEntity.getStatusCode() == HttpStatus.OK) {
                return responseEntity.getBody();
            } else {
                // Log or handle the error appropriately
                return "Failed to get ChatGPT response.";
            }
        } catch (Exception e) {
            e.printStackTrace();
            // Log or handle the exception appropriately
            return "Failed to get ChatGPT response.";
        }
    }
}
