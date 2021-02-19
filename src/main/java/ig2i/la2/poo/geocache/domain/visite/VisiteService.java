package ig2i.la2.poo.geocache.domain.visite;

import java.util.List;

public interface VisiteService {

    Visite findVisiteById(String id);

    void save(Visite visite);

    void saveAll(List<Visite> visites);

    List<Visite> findAll();

}
