package PersonalisedMarketting.PersonalisedMarketting.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "marketing_strategy")
public class MarketingStrategy {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public MarketingStrategy() {
		super();
		// TODO Auto-generated constructor stub
	}
	public MarketingStrategy(Long id, String customerResponse, String chatGPTResponse, String marketingStrategy) {
		super();
		this.id = id;
		this.customerResponse = customerResponse;
		this.chatGPTResponse = chatGPTResponse;
		this.marketingStrategy = marketingStrategy;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getCustomerResponse() {
		return customerResponse;
	}
	public void setCustomerResponse(String customerResponse) {
		this.customerResponse = customerResponse;
	}
	public String getChatGPTResponse() {
		return chatGPTResponse;
	}
	public void setChatGPTResponse(String chatGPTResponse) {
		this.chatGPTResponse = chatGPTResponse;
	}
	public String getMarketingStrategy() {
		return marketingStrategy;
	}
	public void setMarketingStrategy(String marketingStrategy) {
		this.marketingStrategy = marketingStrategy;
	}
	
	@Column(name = "customer_response")
	private String customerResponse;

	@Column(name = "chatgpt_response")
    private String chatGPTResponse;

	@Column(name = "marketing_strategy")
    private String marketingStrategy;

   
}
