CREATE TABLE STUDENT
(
    ID      SERIAL PRIMARY KEY,
    NAME    VARCHAR(15),
    SURNAME VARCHAR(15),
    PHONE   NUMERIC,
    EPISODE VARCHAR(20)
);
CREATE

    INDEX IDX_STUDENT_FBI ON STUDENT (ID);

COMMIT;