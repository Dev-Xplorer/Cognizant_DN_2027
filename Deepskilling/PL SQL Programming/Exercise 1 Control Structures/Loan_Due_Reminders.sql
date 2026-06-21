SELECT 
    'Reminder: ' || c.Name || ' - Your loan is due on ' || TO_CHAR(l.EndDate, 'YYYY-MM-DD') AS ReminderMessage
FROM Loans l
JOIN Customers c ON l.CustomerID = c.CustomerID
WHERE l.EndDate BETWEEN SYSDATE AND (SYSDATE + 30);