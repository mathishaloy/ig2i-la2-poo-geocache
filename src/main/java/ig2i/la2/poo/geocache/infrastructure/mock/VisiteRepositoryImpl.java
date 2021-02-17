package ig2i.la2.poo.geocache.infrastructure.mock;

import ig2i.la2.poo.geocache.domain.visite.Visite;
import ig2i.la2.poo.geocache.domain.visite.VisiteRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Repository
@Profile("mockdb")
@Slf4j
public class VisiteRepositoryImpl implements VisiteRepository {
    @Override
    public Visite findVisiteById(String id) {
        log.warn("/!\\ VisiteRepository is mocked /!\\");
        return Visite.builder()
                .id(UUID.randomUUID().toString())
                .build();
    }

    @Override
    public void save(Visite visite) {
        log.warn("/!\\ VisiteRepository is mocked /!\\");
    }

    @Override
    public void saveAll(List<Visite> visites) {
        log.warn("/!\\ VisiteRepository is mocked /!\\");
    }

    @Override
    public List<Visite> findAll() {
        log.warn("/!\\ VisiteRepository is mocked /!\\");
        return Stream.of(Visite.builder().id(UUID.randomUUID().toString()).build())
                .collect(Collectors.toList());
    }
}
