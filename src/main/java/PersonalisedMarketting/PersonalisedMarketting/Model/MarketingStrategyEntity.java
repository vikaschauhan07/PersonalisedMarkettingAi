package PersonalisedMarketting.PersonalisedMarketting.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "optimization_data")
public class MarketingStrategyEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name= "latest_data")
    private String latestData;
    @Column(name= "latest_trends")
    private String latestTrends;

    @Column(name= "latest_news")
    private String latestNews;

    @Column(name= "chatgpt_response")
    private String chatGPTResponse;

    @Column(name= "optimized_strategy")
    private String optimizedStrategy;

    // Constructors, getters, and setters

    // Constructor with fields
    public MarketingStrategyEntity(String latestData, String latestTrends, String latestNews, String chatGPTResponse, String optimizedStrategy) {
        this.latestData = latestData;
        this.latestTrends = latestTrends;
        this.latestNews = latestNews;
        this.chatGPTResponse = chatGPTResponse;
        this.optimizedStrategy = optimizedStrategy;
    }

    // Empty constructor for JPA
    public MarketingStrategyEntity() {
    }

    // Getters and setters for all fields

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLatestData() {
        return latestData;
    }

    public void setLatestData(String latestData) {
        this.latestData = latestData;
    }

    public String getLatestTrends() {
        return latestTrends;
    }

    public void setLatestTrends(String latestTrends) {
        this.latestTrends = latestTrends;
    }

    public String getLatestNews() {
        return latestNews;
    }

    public void setLatestNews(String latestNews) {
        this.latestNews = latestNews;
    }

    public String getChatGPTResponse() {
        return chatGPTResponse;
    }

    public void setChatGPTResponse(String chatGPTResponse) {
        this.chatGPTResponse = chatGPTResponse;
    }

    public String getOptimizedStrategy() {
        return optimizedStrategy;
    }

    public void setOptimizedStrategy(String optimizedStrategy) {
        this.optimizedStrategy = optimizedStrategy;
    }
}

