package PersonalisedMarketting.PersonalisedMarketting.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import PersonalisedMarketting.PersonalisedMarketting.Service.ChatbotService;

@RestController
@RequestMapping("/chatbot")
public class ChatbotController {

    @Autowired
    private ChatbotService chatbotService;

    @PostMapping("/interact")
    public String interactWithChatbot(@RequestBody String userQuery) {
        // Call the chatbot service to get a response
        return chatbotService.getChatbotResponse(userQuery);
    }
}
