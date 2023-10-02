package PersonalisedMarketting.PersonalisedMarketting.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import PersonalisedMarketting.PersonalisedMarketting.Model.MarketingStrategyEntity;

@Repository
public interface MarketingStrategyEntityRepository extends JpaRepository<MarketingStrategyEntity, Long>{
}
