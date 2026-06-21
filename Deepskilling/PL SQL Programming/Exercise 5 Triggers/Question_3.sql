CREATE OR REPLACE TRIGGER CheckTransactionRules
BEFORE INSERT ON Transactions
FOR EACH ROW
DECLARE
    v_current_balance NUMBER;
BEGIN
    -- Rule 1: Deposits must be greater than zero
    IF :NEW.TransactionType = 'Deposit' AND :NEW.Amount <= 0 THEN
        RAISE_APPLICATION_ERROR(-20001, 'Error: Deposit amount must be strictly greater than zero.');
    END IF;

    -- Rule 2: Withdrawals cannot exceed the account balance
    IF :NEW.TransactionType = 'Withdrawal' THEN
        -- Go find out how much money is currently in the account
        SELECT Balance INTO v_current_balance
        FROM Accounts
        WHERE AccountID = :NEW.AccountID;

        -- Check if they are trying to take out more than they have
        IF :NEW.Amount > v_current_balance THEN
            RAISE_APPLICATION_ERROR(-20002, 'Error: Insufficient funds for this withdrawal.');
        END IF;
    END IF;
END;
/