package PersonalisedMarketting.PersonalisedMarketting.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import PersonalisedMarketting.PersonalisedMarketting.Model.ResponseEntity;
import PersonalisedMarketting.PersonalisedMarketting.Repository.MarketingStrategyRepository;
import PersonalisedMarketting.PersonalisedMarketting.Repository.ResponseRepository;

@Service
public class ResponseService {
	
    private final ResponseRepository responseRepository;
    
   
    @Autowired
    public ResponseService(ResponseRepository responseRepository) {
        this.responseRepository = responseRepository;
    }

    public ResponseEntity saveResponse(ResponseEntity response) {
        return responseRepository.save(response);
    }
    
}
