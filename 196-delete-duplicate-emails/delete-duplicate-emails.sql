delete
from person
where id not in 
(
    select * from (select min(id) from Person group by email) as first_mail
)  