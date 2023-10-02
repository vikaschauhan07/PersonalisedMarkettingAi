package PersonalisedMarketting.PersonalisedMarketting.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import PersonalisedMarketting.PersonalisedMarketting.Service.OptimizationService;
import PersonalisedMarketting.PersonalisedMarketting.Service.TriggerService;

@RestController
@RequestMapping("/trigger")
public class TriggerController {

//    @Autowired
//    private TriggerService triggerService;
//    @Autowired
//    public TriggerController(TriggerService triggerService) {
//        this.triggerService = triggerService;
//    }
//    @PostMapping("/checkAndTrigger")
//    public String checkAndTriggerBehavioralMessage(@RequestBody Long customerId) {
//        
//        return triggerService.checkAndTriggerBehavioralMessage(customerId);
//    }
}
