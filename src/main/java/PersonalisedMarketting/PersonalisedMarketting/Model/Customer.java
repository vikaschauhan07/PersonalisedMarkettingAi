package PersonalisedMarketting.PersonalisedMarketting.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "customer")
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Customer(Long id, String customerId, String name, String gender, String email, String phoneNumber,
			String address, String response) {
		super();
		this.id = id;
		this.customerId = customerId;
		this.name = name;
		this.gender = gender;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.address = address;
		this.response = response;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getResponse() {
		return response;
	}

	public void setResponse(String response) {
		this.response = response;
	}
	@Column(name = "customer_id")
	private String customerId;
	@Column(name = "name")
	private String name;
	@Column(name = "gender")
	private String gender;
	@Column(name = "email")
	private String email;
	@Column(name = "phone_number")
	private String phoneNumber;
	@Column(name = "project_id")
	private Long projectId;

	public Customer(Long id, String customerId, String name, String gender, String email, String phoneNumber,
			Long projectId, String address, String response) {
		super();
		this.id = id;
		this.customerId = customerId;
		this.name = name;
		this.gender = gender;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.projectId = projectId;
		this.address = address;
		this.response = response;
	}

	public Long getProjectId() {
		return projectId;
	}

	public void setProjectId(Long projectId) {
		this.projectId = projectId;
	}
	
	@Column(name = "address")
	private String address;
	@Column(name = "response")
	private String response;

	// Add more fields as needed

	// Constructors, getters, and setters
}
