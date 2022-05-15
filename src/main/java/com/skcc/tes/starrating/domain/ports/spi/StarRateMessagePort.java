package com.skcc.tes.starrating.domain.ports.spi;

public interface StarRateMessagePort {
    String toJson();

    void publish(String json);

    void publish();

    void publishAfterCommit();

    String getEventType();

    void setEventType(String eventType);

    Long getTimestamp();

    void setTimestamp(Long timestamp);

    boolean validate();
}
