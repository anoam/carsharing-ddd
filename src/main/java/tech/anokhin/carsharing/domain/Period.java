package tech.anokhin.carsharing.domain;

import java.util.Date;

public interface Period {
    Date getBeginningTime();
    Date getEndingTime();
}
