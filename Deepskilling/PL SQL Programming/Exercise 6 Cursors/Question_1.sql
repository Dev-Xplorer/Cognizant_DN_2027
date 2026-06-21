DECLARE
    CURSOR GenerateMonthlyStatements IS
        SELECT c.Name, a.AccountID, t.TransactionDate, t.Amount, t.TransactionType
        FROM Transactions t
        JOIN Accounts a ON t.AccountID = a.AccountID
        JOIN Customers c ON a.CustomerID = c.CustomerID
        WHERE TRUNC(t.TransactionDate, 'MM') = TRUNC(SYSDATE, 'MM');
        
BEGIN
    DBMS_OUTPUT.PUT_LINE('--- MONTHLY ACCOUNT STATEMENTS ---');
    
    FOR r_statement IN GenerateMonthlyStatements LOOP
        DBMS_OUTPUT.PUT_LINE('Customer: ' || r_statement.Name || 
                             ' | Acct: ' || r_statement.AccountID || 
                             ' | Date: ' || TO_CHAR(r_statement.TransactionDate, 'YYYY-MM-DD') ||
                             ' | ' || r_statement.TransactionType || ': $' || r_statement.Amount);
    END LOOP;
    
    DBMS_OUTPUT.PUT_LINE('----------------------------------');
END;
/