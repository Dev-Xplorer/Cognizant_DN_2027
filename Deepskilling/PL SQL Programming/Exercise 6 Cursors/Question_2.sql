DECLARE
    v_fee NUMBER := 50; -- Set the annual maintenance fee here

    CURSOR ApplyAnnualFee IS
        SELECT AccountID 
        FROM Accounts;
        
BEGIN
    FOR r_account IN ApplyAnnualFee LOOP
        
        UPDATE Accounts
        SET Balance = Balance - v_fee
        WHERE AccountID = r_account.AccountID;
        
    END LOOP;
    
    COMMIT;
    DBMS_OUTPUT.PUT_LINE('Annual fee of $' || v_fee || ' applied to all accounts.');
END;
/