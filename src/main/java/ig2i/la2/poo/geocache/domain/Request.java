package ig2i.la2.poo.geocache.domain;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Collection;

@Data
@Builder
public class Request {

    private LocalDateTime launchTime;
    private LocalDateTime endTime;

    private Collection<?> result;

}
