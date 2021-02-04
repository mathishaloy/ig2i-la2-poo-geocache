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

    public String toString() {
        int i = 0;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("========== ========== ========== ==========\n");
        stringBuilder.append(String.format("Launch at %s \n", launchTime));
        for(Object o : result){
            stringBuilder.append(String.format("%d - %s", (i++), o.toString()));
        }
        stringBuilder.append(String.format("End at %s \n", endTime));
        stringBuilder.append("========== ========== ========== ==========\n");
        return stringBuilder.toString();
    }
}
