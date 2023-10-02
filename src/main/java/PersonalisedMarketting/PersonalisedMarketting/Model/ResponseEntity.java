package PersonalisedMarketting.PersonalisedMarketting.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "responses")
public class ResponseEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	public Long getId() {
		return id;
	}

	public ResponseEntity() {
		// TODO Auto-generated constructor stub
	}

	public ResponseEntity(Long id, Long projectId, String responseText) {
		super();
		this.id = id;
		this.projectId = projectId;
		this.responseText = responseText;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getProjectId() {
		return projectId;
	}

	public void setProjectId(Long projectId) {
		this.projectId = projectId;
	}

	public String getResponseText() {
		return responseText;
	}

	public void setResponseText(String responseText) {
		this.responseText = responseText;
	}

	@Column(name = "project_id")
	private Long projectId;

	@Column(name = "response_text")
	private String responseText;

}