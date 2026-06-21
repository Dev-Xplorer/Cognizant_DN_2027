CREATE OR REPLACE TRIGGER LogTransaction
AFTER INSERT ON Transactions
FOR EACH ROW
BEGIN
    -- Insert a record into the AuditLog using the newly generated Transaction ID
    INSERT INTO AuditLog (TransactionID, ActionDate, ActionMessage)
    VALUES (:NEW.TransactionID, SYSDATE, 'A new transaction was successfully processed.');
END;
/