package PersonalisedMarketting.PersonalisedMarketting.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import PersonalisedMarketting.PersonalisedMarketting.Service.ChatGPTService;
import PersonalisedMarketting.PersonalisedMarketting.Service.ResponseService;

import java.io.IOException;

@RestController
public class ChatGPTController {

    @Autowired
    private ChatGPTService chatGPTService;

    @PostMapping("/chat")
    public String chatWithGPT(@RequestBody String userQuery) throws IOException {
        // Call the ChatGPT service to get a response
        return chatGPTService.getChatGPTResponse(userQuery);
    }
    private final ResponseService responseService;

    @Autowired
    public ChatGPTController(ResponseService responseService) {
        this.responseService = responseService;
    }
    

    @PostMapping("/interact")
    public String interactWithChatGPT(@RequestBody String userQuery) {
        try {
            return chatGPTService.getChatGPTResponse(userQuery);
        } catch (Exception e) {
            e.printStackTrace();
            return "Failed to interact with ChatGPT.";
        }
    }

    @PostMapping("/generateIdeas")
    public String generateProjectIdeas(@RequestBody String customerResponse) {
        return chatGPTService.generateProjectIdeas(customerResponse);
    }
    @PostMapping("/generatePost")
    public String generatePost(@RequestBody String customerResponse) {
        return chatGPTService.generatePostContent(customerResponse);
    }

    @PostMapping("/generateMarketingStrategy")
    public String generateMarketingStrategy(@RequestBody String customerResponse) {
        return chatGPTService.generateMarketingStrategy(customerResponse);
    }

    
}

