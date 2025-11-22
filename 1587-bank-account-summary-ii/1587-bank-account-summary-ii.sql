# Write your MySQL query statement below
select u.name,
SUM(t.amount) as balance 
from Transactions t 
join Users u ON t.account = u.account
GROUP BY u.account, u.name
HAVING SUM(t.amount) > 10000;