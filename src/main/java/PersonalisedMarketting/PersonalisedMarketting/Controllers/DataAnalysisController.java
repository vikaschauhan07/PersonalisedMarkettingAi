package PersonalisedMarketting.PersonalisedMarketting.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import PersonalisedMarketting.PersonalisedMarketting.Model.Customer;
import PersonalisedMarketting.PersonalisedMarketting.Service.DataAnalysisService;

@RestController
@RequestMapping("/data")
public class DataAnalysisController {

    @Autowired
    private DataAnalysisService dataAnalysisService;

    @PostMapping("/addCustomer")
    public void addCustomerData(@RequestBody Customer customer) {
        // Call the data analysis service to add customer data
        dataAnalysisService.addCustomerData(customer);
    }

    @PostMapping("/performAnalytics")
    public String performAnalytics() {
      
        return dataAnalysisService.performAnalytics();
    }
}
