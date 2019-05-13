create table student
(
   id integer not null,
   name varchar(255) not null,
   passport_number varchar(255) not null,
   primary key(id)
);


create table company(
  companyId varchar(255) not null,
  name  varchar(255) not null,
  ceo varchar(255) not null,
  country varchar(255) not null,
  foundationYear varchar(255) not null,
  noOfEmployee varchar(255) not null,
  primary key(companyId)
);


