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

@Service
public class OptimizationService {


	 	private final ChatGPTConfig chatGPTConfig;
	    private final MarketingStrategyService marketingStrategyService;
	    private final MarketingStrategyEntityService marketingStrategyEntityService;
	    @Autowired
	    public OptimizationService(
	            ChatGPTConfig chatGPTConfig,
	            MarketingStrategyService marketingStrategyService,
	            MarketingStrategyEntityService marketingStrategyEntityService) {
	        this.chatGPTConfig = chatGPTConfig;
	        this.marketingStrategyService = marketingStrategyService;
	        this.marketingStrategyEntityService = marketingStrategyEntityService;
	    }
    public String optimizeMarketingStrategy(String latestData, String latestTrends, String latestNews) {
        try {
            String chatGPTResponse = getChatGPTResponse("Optimize marketing strategy based on:\n"
                    + "Latest Data: " + latestData + "\n"
                    + "Latest Trends: " + latestTrends + "\n"
                    + "Latest News: " + latestNews);

            String optimizedStrategy = analyzeAndOptimize(chatGPTResponse);

            marketingStrategyEntityService.saveOptimizedStrategy(latestData, latestTrends, latestNews, chatGPTResponse, optimizedStrategy);

            return optimizedStrategy;
        } catch (Exception e) {
            e.printStackTrace();
            return "Failed to optimize marketing strategy.";
        }
    }
    private String analyzeAndOptimize(String chatGPTResponse) {
        try {
            String optimizationInsights = getChatGPTResponse("Analyze insights and optimize:\n" + chatGPTResponse);

            String keyInsights = extractKeyInsights(optimizationInsights);
            String optimizedContent = generateOptimizedContent(keyInsights);

            return "Optimized marketing strategy based on insights:\n" + optimizedContent;
        } catch (Exception e) {
            e.printStackTrace();
            return "Failed to analyze and optimize marketing strategy.";
        }
    }
    private String extractKeyInsights(String optimizationInsights) {
        String refinedInsights = getChatGPTResponse("Refine insights:\n" + optimizationInsights);

        return "Key insights extracted from optimization:\n" + refinedInsights.length() + " characters.";
    }

    private String generateOptimizedContent(String keyInsights) {
        String optimizedContent = getChatGPTResponse("Generate optimized content based on insights:\n" + keyInsights);

        return "Optimized content based on key insights:\n" + optimizedContent;
    }

    public String getChatGPTResponse(String prompt) {
        String apiEndpoint = chatGPTConfig.getChatGPTApiEndpoint();
        String apiKey = chatGPTConfig.getChatGPTApiKey();

        String url = apiEndpoint + "/completion";
        String requestBody = "{\"prompt\": \"" + prompt + "\", \"max_tokens\": 100}";

        HttpHeaders headers = new HttpHeaders();
        headers.set(HttpHeaders.AUTHORIZATION, "Bearer " + apiKey);
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<String> entity = new HttpEntity<>(requestBody, headers);

        // Use RestTemplate for HTTP request
        ResponseEntity<String> responseEntity = new RestTemplate().postForEntity(url, entity, String.class);

        if (responseEntity.getStatusCode() == HttpStatus.OK) {
            return responseEntity.getBody();
        } else {
            return "Failed to get ChatGPT response.";
        }
    }


}
