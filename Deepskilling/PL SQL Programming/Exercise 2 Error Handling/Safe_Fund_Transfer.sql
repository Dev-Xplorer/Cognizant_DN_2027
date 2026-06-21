CREATE OR REPLACE PROCEDURE SafeTransferFunds(
    p_from_account IN NUMBER,
    p_to_account IN NUMBER,
    p_amount IN NUMBER
) IS
    v_balance NUMBER;
    e_insufficient_funds EXCEPTION;
BEGIN

    SELECT Balance INTO v_balance 
    FROM Accounts 
    WHERE AccountID = p_from_account;

    IF v_balance < p_amount THEN
        RAISE e_insufficient_funds;
    END IF;

    UPDATE Accounts 
    SET Balance = Balance - p_amount 
    WHERE AccountID = p_from_account;

    UPDATE Accounts 
    SET Balance = Balance + p_amount 
    WHERE AccountID = p_to_account;

    COMMIT;
    DBMS_OUTPUT.PUT_LINE('Transfer successful!');

EXCEPTION
    WHEN e_insufficient_funds THEN
        ROLLBACK;
        DBMS_OUTPUT.PUT_LINE('Error: Insufficient funds in account ' || p_from_account);
    WHEN NO_DATA_FOUND THEN
        ROLLBACK;
        DBMS_OUTPUT.PUT_LINE('Error: One or both of the account numbers do not exist.');
    WHEN OTHERS THEN
        ROLLBACK;
        DBMS_OUTPUT.PUT_LINE('An unexpected error occurred: ' || SQLERRM);
END;
/