package PersonalisedMarketting.PersonalisedMarketting.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import PersonalisedMarketting.PersonalisedMarketting.Model.MarketingStrategyEntity;
import PersonalisedMarketting.PersonalisedMarketting.Repository.MarketingStrategyEntityRepository;
import PersonalisedMarketting.PersonalisedMarketting.Repository.MarketingStrategyRepository;

@Service
public class MarketingStrategyEntityService {
	@Autowired
	private MarketingStrategyEntityRepository marketingStrategyRepository; 
	public void saveOptimizedStrategy(String latestData, String latestTrends, String latestNews, String chatGPTResponse, String optimizedStrategy) {
	
	    MarketingStrategyEntity strategyEntity = new MarketingStrategyEntity();
	    strategyEntity.setLatestData(latestData);
	    strategyEntity.setLatestTrends(latestTrends);
	    strategyEntity.setLatestNews(latestNews);
	    strategyEntity.setChatGPTResponse(chatGPTResponse);
	    strategyEntity.setOptimizedStrategy(optimizedStrategy);

	    
	    marketingStrategyRepository.save(strategyEntity);
	}
}
