package ig2i.la2.poo.geocache.infrastructure.mysql.visite;

import ig2i.la2.poo.geocache.domain.visite.Visite;
import ig2i.la2.poo.geocache.domain.visite.VisiteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
@RequiredArgsConstructor
@Profile("mariadb")
public class VisiteRepositoryImpl implements VisiteRepository {

    private final VisiteJpaRepository visiteJpaRepository;

    @Override
    public Visite findVisiteById(String id) {
        return visiteJpaRepository.findById(id)
                .map(VisiteMapper::toDomain)
                .orElse(null);
    }

    @Override
    public void save(Visite visite) {
        Optional.ofNullable(visite).ifPresent(v -> visiteJpaRepository.save(VisiteMapper.toEntity(v)));
    }

    @Override
    public void saveAll(List<Visite> visites) {
        visiteJpaRepository.saveAll(visites.stream().map(VisiteMapper::toEntity).collect(Collectors.toList()));
    }

    @Override
    public List<Visite> findAll() {
        return visiteJpaRepository.findAll().stream()
                .map(VisiteMapper::toDomain)
                .collect(Collectors.toList());
    }
}
