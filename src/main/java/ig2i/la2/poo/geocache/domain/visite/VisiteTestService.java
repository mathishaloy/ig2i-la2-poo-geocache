package ig2i.la2.poo.geocache.domain.visite;

import ig2i.la2.poo.geocache.domain.Request;

import java.util.List;

public interface VisiteTestService {

    Request findVisiteById(String id);

    Request save(Visite visite);

    Request saveAll(List<Visite> visites);

    Request findAll();

}
