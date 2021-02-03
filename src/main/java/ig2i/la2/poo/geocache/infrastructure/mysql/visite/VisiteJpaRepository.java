package ig2i.la2.poo.geocache.infrastructure.mysql.visite;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VisiteJpaRepository extends JpaRepository<VisiteEntity, String> {

    VisiteEntity getVisiteEntityById(String id);

}
