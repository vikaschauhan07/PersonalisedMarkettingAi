package PersonalisedMarketting.PersonalisedMarketting.Controllers;

	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.http.ResponseEntity;
	import org.springframework.web.bind.annotation.*;

import PersonalisedMarketting.PersonalisedMarketting.Model.Customer;
import PersonalisedMarketting.PersonalisedMarketting.Model.Project;
import PersonalisedMarketting.PersonalisedMarketting.Repository.CustomerRepository;
import PersonalisedMarketting.PersonalisedMarketting.Repository.ProjectRepository;

import java.util.List;

	@RestController
	@RequestMapping("/api")
	public class CustomerProjectController {

	    @Autowired
	    private CustomerRepository customerRepository;

	    @Autowired
	    private ProjectRepository projectRepository;

	    // Create a new customer
	    @PostMapping("/customers")
	    public ResponseEntity<Customer> createCustomer(@RequestBody Customer customer) {
	        Customer savedCustomer = customerRepository.save(customer);
	        return ResponseEntity.ok(savedCustomer);
	    }

	    // Get all customers
	    @GetMapping("/customers")
	    public ResponseEntity<List<Customer>> getAllCustomers() {
	        List<Customer> customers = (List<Customer>) customerRepository.findAll();
	        return ResponseEntity.ok(customers);
	    }

	    // Get customer by ID
	    @GetMapping("/customers/{customerId}")
	    public ResponseEntity<Customer> getCustomerById(@PathVariable Long customerId) {
	        Customer customer = customerRepository.findById(customerId).orElse(null);
	        if (customer != null) {
	            return ResponseEntity.ok(customer);
	        } else {
	            return ResponseEntity.notFound().build();
	        }
	    }

	    // Update customer by ID
	    @PutMapping("/customers/{customerId}")
	    public ResponseEntity<Customer> updateCustomer(@PathVariable Long customerId, @RequestBody Customer updatedCustomer) {
	        Customer existingCustomer = customerRepository.findById(customerId).orElse(null);

	        if (existingCustomer != null) {
	            existingCustomer.setName(updatedCustomer.getName());
	            // Set other properties as needed

	            Customer savedCustomer = customerRepository.save(existingCustomer);
	            return ResponseEntity.ok(savedCustomer);
	        } else {
	            return ResponseEntity.notFound().build();
	        }
	    }

	    // Delete customer by ID
	    @DeleteMapping("/customers/{customerId}")
	    public ResponseEntity<Void> deleteCustomer(@PathVariable Long customerId) {
	        if (customerRepository.existsById(customerId)) {
	            customerRepository.deleteById(customerId);
	            return ResponseEntity.noContent().build();
	        } else {
	            return ResponseEntity.notFound().build();
	        }
	    }

	    // Create a new project
	    @PostMapping("/projects")
	    public ResponseEntity<Project> createProject(@RequestBody Project project) {
	        Project savedProject = projectRepository.save(project);
	        return ResponseEntity.ok(savedProject);
	    }

	    // Get all projects
	    @GetMapping("/projects")
	    public ResponseEntity<List<Project>> getAllProjects() {
	        List<Project> projects = (List<Project>) projectRepository.findAll();
	        return ResponseEntity.ok(projects);
	    }

	    // Get project by ID
	    @GetMapping("/projects/{projectId}")
	    public ResponseEntity<Project> getProjectById(@PathVariable Long projectId) {
	        Project project = projectRepository.findById(projectId).orElse(null);
	        if (project != null) {
	            return ResponseEntity.ok(project);
	        } else {
	            return ResponseEntity.notFound().build();
	        }
	    }

	    // Update project by ID
	    @PutMapping("/projects/{projectId}")
	    public ResponseEntity<Project> updateProject(@PathVariable Long projectId, @RequestBody Project updatedProject) {
	        Project existingProject = projectRepository.findById(projectId).orElse(null);

	        if (existingProject != null) {
	            existingProject.setProjectName(updatedProject.getProjectName());
	            // Set other properties as needed

	            Project savedProject = projectRepository.save(existingProject);
	            return ResponseEntity.ok(savedProject);
	        } else {
	            return ResponseEntity.notFound().build();
	        }
	    }

	    // Delete project by ID
	    @DeleteMapping("/projects/{projectId}")
	    public ResponseEntity<Void> deleteProject(@PathVariable Long projectId) {
	        if (projectRepository.existsById(projectId)) {
	            projectRepository.deleteById(projectId);
	            return ResponseEntity.noContent().build();
	        } else {
	            return ResponseEntity.notFound().build();
	        }
	    }
	

}
