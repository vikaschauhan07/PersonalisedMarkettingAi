package PersonalisedMarketting.PersonalisedMarketting.Configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ChatGPTConfig {

    @Value("${chatgpt.api.endpoint}")
    private String chatGPTApiEndpoint;

    @Value("${chatgpt.api.key}")
    private String chatGPTApiKey;

    public String getChatGPTApiEndpoint() {
        return chatGPTApiEndpoint;
    }

    public String getChatGPTApiKey() {
        return chatGPTApiKey;
    }
}
