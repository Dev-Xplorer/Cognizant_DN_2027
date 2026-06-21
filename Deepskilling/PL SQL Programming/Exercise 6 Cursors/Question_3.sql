DECLARE
    CURSOR UpdateLoanInterestRates IS
        SELECT LoanID, InterestRate 
        FROM Loans;
        
BEGIN
    FOR r_loan IN UpdateLoanInterestRates LOOP
        
        UPDATE Loans
        SET InterestRate = InterestRate + 0.5
        WHERE LoanID = r_loan.LoanID;
        
    END LOOP;

    COMMIT;
    DBMS_OUTPUT.PUT_LINE('All loan interest rates have been updated to the new policy.');
END;
/