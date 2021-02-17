package ig2i.la2.poo.geocache.services;

import ig2i.la2.poo.geocache.domain.Request;
import ig2i.la2.poo.geocache.domain.utilisateur.Utilisateur;
import ig2i.la2.poo.geocache.domain.utilisateur.UtilisateurService;
import ig2i.la2.poo.geocache.domain.utilisateur.UtilisateurTestService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
@RequiredArgsConstructor
public class UtilisateurTestServiceImpl implements UtilisateurTestService {

    private final UtilisateurService utilisateurService;

    @Override
    public Request findUtilisateurById(String id) {
        return Request.builder()
                .launchTime(LocalDateTime.now())
                .result(Stream.of(utilisateurService.findUtilisateurById(id)).collect(Collectors.toList()))
                .endTime(LocalDateTime.now())
                .build();
    }

    @Override
    public Request save(Utilisateur utilisateur) {
        return Request.builder()
                .launchTime(LocalDateTime.now())
                .result(Stream.of(String.format("Cache %s successfully created", utilisateur.getId()))
                                .collect(Collectors.toList()))
                .endTime(LocalDateTime.now())
                .build();
    }

    @Override
    public Request saveAll(List<Utilisateur> utilisateurs) {

        LocalDateTime launchTime = LocalDateTime.now();
        utilisateurService.saveAll(utilisateurs);
        LocalDateTime endTime = LocalDateTime.now();

        return Request.builder()
                .launchTime(launchTime)
                .result(Stream.of(String.format(
                        "%d utilisateur successfully created", utilisateurs.size()),
                        utilisateurs.stream().map(Utilisateur::getId).collect(Collectors.joining(", ", "[", "]")))
                        .collect(Collectors.toList()))
                .endTime(endTime)
                .build();
    }

    @Override
    public Request findAll() {
        return Request.builder()
                .launchTime(LocalDateTime.now())
                .result(utilisateurService.findAll())
                .endTime(LocalDateTime.now())
                .build();
    }
}
