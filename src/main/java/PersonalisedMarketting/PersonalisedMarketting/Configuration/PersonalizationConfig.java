package PersonalisedMarketting.PersonalisedMarketting.Configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PersonalizationConfig {

    @Value("${personalization.algorithm.enabled}")
    private boolean personalizationAlgorithmEnabled;

    public boolean isPersonalizationAlgorithmEnabled() {
        return personalizationAlgorithmEnabled;
    }
}
