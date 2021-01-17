set schema 'xpncs';

create table "user"(
	"user_id" serial unique primary key,
	"fname" text not null,
	"lname" text not null,
	"username" text unique not null,
	"pass" text not null,
	"email" text unique not null
--	constraint primary key media_pk_constraint ("type", "name"); - we could create a pk using this natural composite key
);

select * from "user" u full join user_roles on u.user_id = user_roles.user_id 


create table "user_roles"(
	"user_id" serial unique references "user"("user_id"),
	"user_role_id" serial not null,
	"user_role" text not null
)

create table "reimbursement"(
	"id" serial unique primary key,
	"amount" numeric(10,2) not null,
	"time_submitted" text not null, 
	"time_resolved" text,
	"description" text,
	"author" serial not null references "user"("user_id"),
	"resolver" serial,
	"status" bool not null,
	"type" text not null
)

insert into "user" (fname, lname, username, pass, email)
values ('Rous', 'Epistola', 'rousbepistola', 'password', 'rousbepistola@yahoo.com')

insert into user_roles (user_id, user_role_id, user_role)
values (1, '1', 'employee')

insert into "user" (fname, lname, username, pass, email)
values ('Bill', 'Gates', 'admin', 'admin', 'billgates@freeEmail.com')

insert into user_roles (user_id, user_role_id, user_role)
values (2, '2', 'manager')

insert into "user" (fname, lname, username, pass, email)
values ('Rick', 'Morty', 'user1', 'pass1', 'rick&morty@yeehao.com')

insert into user_roles (user_id, user_role_id, user_role)
values (3, '1', 'employee')

insert into "user" (fname, lname, username, pass, email)
values ('Steve', 'Jobs', 'steve', 'jobs', 'steve_jobs@live.com')

insert into user_roles (user_id, user_role_id, user_role)
values (4, '1', 'employee')

insert into "user" (fname, lname, username, pass, email)
values ('Peter', 'Parker', 'peter', 'parker', 'peter_parker@freeEmail.com')

insert into user_roles (user_id, user_role_id, user_role)
values (5, '2', 'manager')



--INSERT STATEMENTS
insert into reimbursement (amount, time_submitted, description, author, status, "type")
values (100, 'timesss', 'description', 1, false, 'lodging')

insert into reimbursement (amount, time_submitted, description, author, status, "type", resolver)
values (100, 'timesss', 'description', 1, false, 'lodging', 4)


--DELETE STATEMENTS
delete from reimbursement r 
where id > 3




--THIS IS FOR QUESRIES TO BE USED ON PROJECT
select * from "user" u 

select * from "user" u 
where username = 'rousbepistola' and pass = 'password'


select * from "user" u 
inner join user_roles ur 
on u.user_id = ur.user_id 

select * from "user" u 
inner join user_roles ur 
on u.user_id = ur.user_id 
where u.username = 'rousbepistola' and pass = 'password'

select * from reimbursement r 

select * from reimbursement r 
inner join "user" u ON r.author = u.user_id 

select * from reimbursement r 
where author = 1

--FOR PENDING REQUESTS
select * from reimbursement r 
where time_resolved is null 

--FOR REJECTED REQUEST
select * from reimbursement r 
where status is false
and resolver is not null







