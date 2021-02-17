package ig2i.la2.poo.geocache.infrastructure.mock;

import ig2i.la2.poo.geocache.domain.utilisateur.Utilisateur;
import ig2i.la2.poo.geocache.domain.utilisateur.UtilisateurRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import java.util.Collections;
import java.util.List;
import java.util.UUID;

@Repository
@Profile("mockdb")
@Slf4j
public class UtilisateurRepositoryImplMock implements UtilisateurRepository {
    @Override
    public Utilisateur findUtilisateurById(String id) {
        log.warn("/!\\ UtilisateurRepository is mocked /!\\");
        return Utilisateur.builder()
                .id(UUID.randomUUID().toString())
                .build();
    }

    @Override
    public void save(Utilisateur utilisateur) {
        log.warn("/!\\ UtilisateurRepository is mocked /!\\");
    }

    @Override
    public void saveAll(List<Utilisateur> utilisateurs) {
        log.warn("/!\\ UtilisateurRepository is mocked /!\\");
    }

    @Override
    public List<Utilisateur> findAll() {
        log.warn("/!\\ UtilisateurRepository is mocked /!\\");
        return Collections.emptyList();
    }
}
