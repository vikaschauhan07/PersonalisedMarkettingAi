package PersonalisedMarketting.PersonalisedMarketting.Service;

import org.springframework.stereotype.Service;

@Service
public class ChatbotService {

    // Simulate chatbot responses based on user queries
    public String getChatbotResponse(String userQuery) {
        // Add your chatbot logic here
        return "Chatbot: Thanks for your inquiry about " + userQuery + "! We recommend checking out our latest offers.";
    }
}
