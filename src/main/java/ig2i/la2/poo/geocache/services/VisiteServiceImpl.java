package ig2i.la2.poo.geocache.services;

import ig2i.la2.poo.geocache.domain.visite.Visite;
import ig2i.la2.poo.geocache.domain.visite.VisiteRepository;
import ig2i.la2.poo.geocache.domain.visite.VisiteService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class VisiteServiceImpl implements VisiteService {

    private final VisiteRepository visiteRepository;

    @Override
    public Visite findVisiteById(String id) {
        return Optional.ofNullable(visiteRepository.findVisiteById(id))
                .orElseThrow(() -> new RuntimeException(String.format("Visite %s does not exist", id)));
    }

    @Override
    public void save(Visite visite) {
        visiteRepository.save(visite);
    }

    @Override
    public void saveAll(List<Visite> visites) {
        visiteRepository.saveAll(visites);
    }

    @Override
    public List<Visite> findAll() {
        return visiteRepository.findAll();
    }
}
