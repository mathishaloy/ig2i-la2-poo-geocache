package ig2i.la2.poo.geocache.infrastructure.mysql.utilisateur;

import ig2i.la2.poo.geocache.domain.utilisateur.Utilisateur;
import ig2i.la2.poo.geocache.domain.utilisateur.UtilisateurRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
@RequiredArgsConstructor
@Profile("mariadb")
public class UtilisateurRepositoryImpl implements UtilisateurRepository {

    private final UtilisateurJpaRepository utilisateurJpaRepository;

    @Override
    public Utilisateur findUtilisateurById(String id) {
        return Optional.ofNullable(utilisateurJpaRepository.getUtilisateurEntityById(id))
                .map(UtilisateurMapper::toDomain)
                .orElse(null);
    }

    @Override
    public void save(Utilisateur utilisateur) {
        utilisateurJpaRepository.save(UtilisateurMapper.toEntity(utilisateur));
    }

    @Override
    public List<Utilisateur> findAll() {
        return utilisateurJpaRepository.findAll().stream()
                .map(UtilisateurMapper::toDomain)
                .collect(Collectors.toList());
    }
}
