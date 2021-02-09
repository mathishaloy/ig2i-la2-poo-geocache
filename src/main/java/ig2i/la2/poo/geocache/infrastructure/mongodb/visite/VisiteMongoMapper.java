package ig2i.la2.poo.geocache.infrastructure.mongodb.visite;

import ig2i.la2.poo.geocache.domain.visite.Visite;

public abstract class VisiteMongoMapper {
    public static Visite toDomain(VisiteMongo mongo){
        return Visite.builder()
                .commentaire(mongo.getCommentaire())
                .date(mongo.getDate())
                .photo(mongo.getPhoto())
                .build();
    }

    public static VisiteMongo toMongo(Visite visite){
        return VisiteMongo.builder()
                .commentaire(visite.getCommentaire())
                .date(visite.getDate())
                .photo(visite.getPhoto())
                .build();
    }
}
