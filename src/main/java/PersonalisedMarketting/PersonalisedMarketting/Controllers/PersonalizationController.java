package PersonalisedMarketting.PersonalisedMarketting.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import PersonalisedMarketting.PersonalisedMarketting.Service.PersonalizationService;

import java.util.Arrays;
import java.util.List;

@RestController
public class PersonalizationController {

    @Autowired
    private PersonalizationService personalizationService;

    @GetMapping("/personalize/{customerId}")
    public String personalizeContent(@PathVariable Long customerId) {
        // Simulate product interests based on customer history or preferences
        List<String> productInterests = Arrays.asList("Tech", "Fashion", "Travel");

        // Call the personalization service to generate a personalized message
//        return personalizationService.generatePersonalizedMessage(customerId, productInterests);

        return personalizationService.generatePersonalizedMessage(customerId);
    }
    
    
}
