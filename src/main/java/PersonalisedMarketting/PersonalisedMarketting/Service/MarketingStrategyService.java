package PersonalisedMarketting.PersonalisedMarketting.Service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import PersonalisedMarketting.PersonalisedMarketting.Model.MarketingStrategy;
import PersonalisedMarketting.PersonalisedMarketting.Repository.MarketingStrategyRepository;

@Service
public class MarketingStrategyService {

	@Autowired
	private MarketingStrategyRepository marketingStrategyRepository;
	@Autowired
	public MarketingStrategyService(MarketingStrategyRepository marketingStrategyRepository) {
		this.marketingStrategyRepository= marketingStrategyRepository;
	}

	public void save(String customerResponse, String chatGPTResponse, String marketingStrategy) {
		// Create a MarketingStrategy entity
		MarketingStrategy strategy = new MarketingStrategy();
		strategy.setCustomerResponse(customerResponse);
		strategy.setChatGPTResponse(chatGPTResponse);
		strategy.setMarketingStrategy(marketingStrategy);

		// Save the entity to the database
		marketingStrategyRepository.save(strategy);
	}
}
