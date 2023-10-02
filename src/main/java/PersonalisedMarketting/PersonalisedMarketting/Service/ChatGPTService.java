package PersonalisedMarketting.PersonalisedMarketting.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import PersonalisedMarketting.PersonalisedMarketting.Configuration.ChatGPTConfig;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import edu.stanford.nlp.simple.Document;
import edu.stanford.nlp.simple.Sentence;

import edu.stanford.nlp.simple.*;

@Service
public class ChatGPTService {
	
     private final ChatGPTConfig chatGPTConfig;
	
	private final ResponseService responseService;
	
	private final MarketingStrategyService marketingStrategyService;

    @Autowired
    public ChatGPTService(
            ChatGPTConfig chatGPTConfig,
            ResponseService responseService,
            MarketingStrategyService marketingStrategyService) {
        this.chatGPTConfig = chatGPTConfig;
        this.responseService = responseService;
        this.marketingStrategyService = marketingStrategyService;
    }

	public String generateProjectIdeas(String customerResponse) {
		String chatGPTApiUrl = "https://api.openai.com/v1/engines/davinci-codex/completions";
		String requestBody = "{ \"prompt\": \"" + customerResponse + "\", \"max_tokens\": 100 }";

		HttpHeaders headers = new HttpHeaders();
		headers.set("Content-Type", "application/json");
		headers.set("Authorization", "Bearer " + chatGPTConfig.getChatGPTApiKey());

		HttpEntity<String> entity = new HttpEntity<>(requestBody, headers);

		// Use RestTemplate for HTTP request
		ResponseEntity<String> responseEntity = new RestTemplate().postForEntity(chatGPTApiUrl, entity, String.class);

		if (responseEntity.getStatusCode() == HttpStatus.OK) {
			return responseEntity.getBody();
		} else {
			return "Failed to retrieve project ideas from ChatGPT.";
		}
	}
	 public String generatePostContent(String customerResponse) {
	        // Use ChatGPT to generate additional content based on customer response
	        String chatGPTResponse = getChatGPTResponse(customerResponse);

	       
	        String projectLogic = "";
	        if (customerResponse.contains("urgent")) {
	            projectLogic = "This project is marked as urgent. ";
	        } else {
	            projectLogic = "This project is not marked as urgent. ";
	        }

	        // Combine customer response, ChatGPT content, and project logic
	        String postContent = "Customer Response: " + customerResponse + "\n"
	                + "ChatGPT Generated Content: " + chatGPTResponse + "\n"
	                + "Project Logic: " + projectLogic;

	        return postContent;
	    }
	 public String generateMarketingStrategy(String customerResponse) {
		    try {
		        // Use ChatGPT to generate insights based on customer response
		        String chatGPTResponse = getChatGPTResponse(customerResponse);

		        // Your logic to analyze customer response and generate marketing strategy
		        String marketingStrategy = analyzeCustomerResponse(customerResponse, chatGPTResponse);

		        // Save the marketing strategy to the database
		        marketingStrategyService.save(customerResponse, chatGPTResponse, marketingStrategy);

		        return marketingStrategy;
		    } catch (Exception e) {
		        e.printStackTrace();
		        return "Failed to generate marketing strategy.";
		    }
		}

private String extractInformationFromCustomerResponse(String customerResponse) {
    // Use Stanford CoreNLP to extract named entities from the customer response
    Document doc = new Document(customerResponse);
    List<String> namedEntities = new ArrayList();
    for (Sentence sentence : doc.sentences()) {
        namedEntities.addAll(sentence.mentions());
    }

    return "Named entities extracted from customer response: " + namedEntities;
}

private String extractInsightsFromChatGPTResponse(String chatGPTResponse) {
    Document doc = new Document(chatGPTResponse);
    int numPositiveSentences = 0;
    int numNegativeSentences = 0;

    for (Sentence sentence : doc.sentences()) {
        if (sentence.sentiment().equals("Positive")) {
            numPositiveSentences++;
        } else if (sentence.sentiment().equals("Negative")) {
            numNegativeSentences++;
        }
    }

    return "Sentiment analysis insights from ChatGPT response: " +
            "Positive Sentences: " + numPositiveSentences + ", " +
            "Negative Sentences: " + numNegativeSentences;
}
public String analyzeCustomerResponse(String customerResponse, String chatGPTResponse) {
    // Use ChatGPT to extract relevant information from the customer response
    String extractedInfoFromCustomer = getChatGPTResponse("Extract information from: " + customerResponse);

    // Use ChatGPT to identify customer requirements
    String customerRequirements = getChatGPTResponse("Identify requirements in: " + customerResponse);

    // Use ChatGPT to analyze identified customer requirements
    String analysisResult = getChatGPTResponse("Analyze requirements: " + customerRequirements);

    // Use ChatGPT to analyze the ChatGPT response itself
    String analysisOfChatGPTResponse = getChatGPTResponse("Analyze ChatGPT Response: " + chatGPTResponse);

    // Combine the information, requirements, analysis, ChatGPT response, and analysis of ChatGPT response
    String result = "Result based on ChatGPT:\n"
            + "Customer Response: " + customerResponse + "\n"
            + "ChatGPT Response: " + chatGPTResponse + "\n"
            + "Extracted Information: " + extractedInfoFromCustomer + "\n"
            + "Identified Requirements: " + customerRequirements + "\n"
            + "Analysis Result: " + analysisResult + "\n"
            + "Analysis of ChatGPT Response: " + analysisOfChatGPTResponse;

    return result;
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

    // Use RestTemplate for HTTP request
    ResponseEntity<String> responseEntity = new RestTemplate().postForEntity(url, entity, String.class);

    if (responseEntity.getStatusCode() == HttpStatus.OK) {
        return responseEntity.getBody();
    } else {
        return "Failed to get ChatGPT response.";
    }
}

}
