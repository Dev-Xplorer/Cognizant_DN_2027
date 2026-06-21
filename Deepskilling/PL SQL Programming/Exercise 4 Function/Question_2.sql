CREATE OR REPLACE FUNCTION CalculateMonthlyInstallment(
    p_loan_amount IN NUMBER,
    p_interest_rate IN NUMBER,
    p_duration_years IN NUMBER
) RETURN NUMBER IS
    v_monthly_rate NUMBER;
    v_total_months NUMBER;
    v_emi NUMBER;
BEGIN
    IF p_interest_rate = 0 THEN
        RETURN ROUND(p_loan_amount / (p_duration_years * 12), 2);
    END IF;

    v_monthly_rate := p_interest_rate / 12 / 100;
    v_total_months := p_duration_years * 12;

    v_emi := (p_loan_amount * v_monthly_rate * POWER(1 + v_monthly_rate, v_total_months)) / 
             (POWER(1 + v_monthly_rate, v_total_months) - 1);

    RETURN ROUND(v_emi, 2);
END;
/