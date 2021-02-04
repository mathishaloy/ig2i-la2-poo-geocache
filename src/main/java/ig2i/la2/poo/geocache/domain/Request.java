package ig2i.la2.poo.geocache.domain;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
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
        stringBuilder.append(String.format("End at %s \n", endTime));
        stringBuilder.append(String.format("Execution Time : %d ms\n", ChronoUnit.MILLIS.between(launchTime, endTime)));
        stringBuilder.append("Result :\n");
        for(Object o : result){
            stringBuilder.append(String.format("%d - %s \n", (i++), o.toString()));
        }
        stringBuilder.append("========== ========== ========== ==========\n");
        return stringBuilder.toString();
    }
}
