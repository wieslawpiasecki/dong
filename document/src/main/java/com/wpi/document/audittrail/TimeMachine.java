package com.wpi.document.audittrail;

import org.joda.time.LocalDateTime;

/**
 * Created by Wiesław Piasecki on 18.02.14.
 */
public class TimeMachine {
    public LocalDateTime getCurrentLocalDateTime() {
        return new LocalDateTime();
    }
}
