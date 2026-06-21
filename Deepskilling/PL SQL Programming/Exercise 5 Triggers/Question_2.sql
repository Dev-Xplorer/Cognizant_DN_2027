CREATE OR REPLACE TRIGGER LogTransaction
AFTER INSERT ON Transactions
FOR EACH ROW
BEGIN
    INSERT INTO AuditLog (TransactionID, ActionDate, ActionMessage)
    VALUES (:NEW.TransactionID, SYSDATE, 'A new transaction was successfully processed.');
END;
/