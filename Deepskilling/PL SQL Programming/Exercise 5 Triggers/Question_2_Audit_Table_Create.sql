-- Run this first to create the AuditLog table
CREATE TABLE AuditLog (
    LogID NUMBER GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    TransactionID NUMBER,
    ActionDate DATE,
    ActionMessage VARCHAR2(100)
);