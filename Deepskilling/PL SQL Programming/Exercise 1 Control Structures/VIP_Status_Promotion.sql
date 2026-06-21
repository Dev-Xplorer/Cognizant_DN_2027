-- Make people status VIPs if there balance is more than $10,000
UPDATE Customers
SET IsVIP = 'TRUE'
WHERE Balance > 10000;

-- making VIP status to false if there balance is $10,000 or less
UPDATE Customers
SET IsVIP = 'FALSE'
WHERE Balance <= 10000;