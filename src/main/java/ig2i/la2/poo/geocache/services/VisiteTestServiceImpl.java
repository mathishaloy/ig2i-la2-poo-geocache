package ig2i.la2.poo.geocache.services;

import ig2i.la2.poo.geocache.domain.Request;
import ig2i.la2.poo.geocache.domain.visite.Visite;
import ig2i.la2.poo.geocache.domain.visite.VisiteService;
import ig2i.la2.poo.geocache.domain.visite.VisiteTestService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
@RequiredArgsConstructor
public class VisiteTestServiceImpl implements VisiteTestService {

    private final VisiteService visiteService;

    @Override
    public Request findVisiteById(String id) {
        return Request.builder()
                .launchTime(LocalDateTime.now())
                .result(Stream.of(visiteService.findVisiteById(id)).collect(Collectors.toList()))
                .endTime(LocalDateTime.now())
                .build();
    }

    @Override
    public Request save(Visite visite) {
        return Request.builder()
                .launchTime(LocalDateTime.now())
                .result(Stream.of(String.format("Cache %s successfully created", visite.getId()))
                                .collect(Collectors.toList()))
                .endTime(LocalDateTime.now())
                .build();
    }

    @Override
    public Request saveAll(List<Visite> visites) {

        LocalDateTime launchTime = LocalDateTime.now();
        visiteService.saveAll(visites);
        LocalDateTime endTime = LocalDateTime.now();

        return Request.builder()
                .launchTime(launchTime)
                .result(Stream.of(String.format(
                        "%d visites successfully created", visites.size()),
                        visites.stream().map(Visite::getId).collect(Collectors.joining(", ", "[", "]")))
                        .collect(Collectors.toList()))
                .endTime(endTime)
                .build();
    }

    @Override
    public Request findAll() {
        return Request.builder()
                .launchTime(LocalDateTime.now())
                .result(visiteService.findAll())
                .endTime(LocalDateTime.now())
                .build();
    }
}
