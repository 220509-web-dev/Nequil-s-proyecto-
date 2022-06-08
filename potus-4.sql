


CREATE SCHEMA potus; 
SET search_path TO potus; 




create table prezzies(
account_id serial primary key, 
press_fname varchar(100),
pres_lname varchar(100), 
birthyear varchar not null,
city varchar(100), 
state varchar(100)

); 

drop  table prezzies;

select * from prezzies; 

insert into prezzies values (default, 'George','Washington', '1732','Westmoreland County','Virginia'); 
insert into prezzies values (default, 'John', 'Adams', '1735', 'Braintree', 'Massachusetts'); 

insert into prezzies values (default, 'Thomas','Jefferson', '1743','Shadwell','Virginia'); 
insert into prezzies values (default, 'James', 'Madison', '1751', 'Port Conway','Virginia');

insert into prezzies values (default, 'James','Monroe', '1758','Monroe Hall','Virginia'); 
insert into prezzies values (default, 'John Q.','Adams', '1767','Westmoreland County','Virginia'); 

insert into prezzies values (default, 'Andrew', 'Jackson','1767', 'Waxhows Rgion', 'South Carolina');
insert into prezzies values (default, 'John', 'Adams','1735', 'Braintree', 'Massachusetts');

insert into prezzies values (default, 'Martin Van','Buren', '1782','Kinderhook','New York'); 
insert into prezzies values (default, 'William Henry','Harrison','1773', 'Charles City County','Virginia');

insert into prezzies values (default, 'John','Tyler', '1790','Charles City County','Virginia'); 
insert into prezzies values (default, 'James K.','Polk','1795', 'Pineville','North Carolina'); 

insert into prezzies values (default, 'Zachary','Taylor', '1784','Barboursville','Virginia'); 
insert into prezzies values (default, 'Millard', 'Fillmore','1800', 'Summerhill','New York');

insert into prezzies values (default, 'Franklin','Pierce', '1804','Hillsborough','Virginia'); 
insert into prezzies values (default, 'James', 'Buchanan','1791', 'Cove Gap','Pennsylvania');

insert into prezzies values (default, 'Abraham','Lincoln', '1809','hodgenville','Kentucky'); 
insert into prezzies values (default, 'Andrew', 'Johnson','1808', 'Raleigh','North Carolina');

insert into prezzies values (default, 'Ulysses S.','Grant', '1822','Point Pleasant','Ohio'); 
insert into prezzies values (default, 'Rutherford B.','Hayes','1822', 'Delaware', 'Ohio');

insert into prezzies values (default, 'James','Garfield', '1831','Moreland Hills','Ohio'); 
insert into prezzies values (default, 'Chester','Arthur','1829', 'Fairland', 'Vermont'); 

insert into prezzies values (default, 'Grover','Cleveland', '1837','Caldwell','New Jersey'); 
insert into prezzies values (default, 'Benjamin', 'Harrison','1833', 'North Bend', 'Ohio');

insert into prezzies values (default, 'William','Mckinley', '1843','Niles','Ohio'); 
insert into prezzies values (default, 'Theodore','Roosevelt', '1857','Manhattan','New York'); 

insert into prezzies values (default, 'William Howard', 'Taft','1857', 'Cincinnati', 'Ohio');
insert into prezzies values (default, 'Woodrow', 'Wilson','1856' , 'Staunton', 'Virginia');


insert into prezzies values (default, 'Warren G.','Harding', '1865','Blooming Grove', 'Ohio'); 
insert into prezzies values (default, 'Calvin', 'Coolidge','1872', 'Plymouth', 'Vermont');

insert into prezzies values (default, 'Herbet','Hoover', '1874','West Branch', 'Iowa'); 
insert into prezzies values (default, 'Franklin D.', 'Roosevelt','1882', 'Hyde Park', 'N'); 

insert into prezzies values (default, 'Harry S.','Truman', '1884','Lamar', 'Missouri'); 
insert into prezzies values (default, 'Dwight D.','Eisenhower','1890', 'Denison', 'Texas');

insert into prezzies values (default, 'John F.','Kennedy', '1917','Brookline', 'Massachusetts'); 
insert into prezzies values (default, 'Lyndon B.', 'Johnson','1908', 'Stonewell', 'Texas');

insert into prezzies values (default, 'Richard','Nixon','1913','Yorba Linda', 'California'); 
insert into prezzies values (default, 'Gerald', 'Ford','1913', 'Omaha', 'Nebraska');

insert into prezzies values (default, 'Jimmy','Carter', '1924','Plains', 'Georgia'); 
insert into prezzies values (default, 'Ronald', 'Reagan','1911', 'Tampico', 'Illinois');

insert into prezzies values (default, 'George H. W.','Bush', '1924','Milton', 'Massachusetts'); 
insert into prezzies values (default, 'Bill', 'Clinton','1946', 'Hope', 'Arkansas');

insert into prezzies values (default, 'George W.','Bush', '1946','New Haven', 'Connecticut'); 
insert into prezzies values (default, 'Barrack', 'Obama','1911', 'Honolulu', 'Hawaii');
 




