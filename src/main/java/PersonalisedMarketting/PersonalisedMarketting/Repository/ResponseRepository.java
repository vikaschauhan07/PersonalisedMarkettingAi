package PersonalisedMarketting.PersonalisedMarketting.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import PersonalisedMarketting.PersonalisedMarketting.Model.ResponseEntity;

public interface ResponseRepository extends JpaRepository<ResponseEntity, Long> {
}
