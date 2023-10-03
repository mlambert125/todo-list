drop table if exists lists, list_items;

create table lists (
    id serial primary key,
    name varchar(255) not null,
    userId varchar(255) not null,
    createdAt timestamp not null default now()
);

create table list_items (
    id serial primary key,
    listId integer not null references lists(id),
    name varchar(255) not null,
    createdAt timestamp not null default now(),
    completed boolean not null default false,
    completedAt timestamp null default null
);

insert into lists (name, userId) values ('Groceries', 'mlambert@dolbey.com');
insert into list_items(listId, name) values (1, 'Milk');
insert into list_items(listId, name) values (1, 'Eggs');
insert into list_items(listId, name) values (1, 'Bread');


insert into lists (name, userId) values ('Todo List', 'hobbit125@gmail.com');
insert into list_items(listId, name) values (2, 'Fix cabinets');
insert into list_items(listId, name) values (2, 'Fix tablet that lea broke');
insert into list_items(listId, name) values (2, 'Fix the car');


insert into lists (name, userId) values ('Shopping List', 'mlambert@dolbey.com');
insert into list_items(listId, name) values (3, 'New Laptop Computer');
insert into list_items(listId, name) values (3, 'Airpods');
insert into list_items(listId, name) values (3, 'Mouse');
