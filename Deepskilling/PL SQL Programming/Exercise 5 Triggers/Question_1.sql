CREATE OR REPLACE TRIGGER UpdateCustomerLastModified
BEFORE UPDATE ON Customers
FOR EACH ROW
BEGIN
    -- Overwrite whatever date was provided with the exact current time
    :NEW.LastModified := SYSDATE;
END;
/