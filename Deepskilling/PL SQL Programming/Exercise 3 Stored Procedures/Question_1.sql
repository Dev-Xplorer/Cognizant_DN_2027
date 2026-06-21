CREATE OR REPLACE PROCEDURE ProcessMonthlyInterest IS
BEGIN
    -- Update all savings accounts by adding 1% to the balance
    UPDATE Accounts
    SET Balance = Balance *1.01
    WHERE AccountType = 'Savings';

    -- Save the changes permanently
    COMMIT;
    DBMS_OUTPUT.PUT_LINE('Monthly interest applied to all Savings accounts.');
END;
/