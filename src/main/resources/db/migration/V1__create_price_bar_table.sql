CREATE TABLE price_bar (
    id        BIGSERIAL PRIMARY KEY,
    date      DATE           NOT NULL,
    open      NUMERIC(19, 8) NOT NULL,
    high      NUMERIC(19, 8) NOT NULL,
    low       NUMERIC(19, 8) NOT NULL,
    close     NUMERIC(19, 8) NOT NULL,
    volume    BIGINT         NOT NULL,
    ticker    VARCHAR(20)    NOT NULL
);
