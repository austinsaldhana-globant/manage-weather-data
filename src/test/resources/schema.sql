create table weather (id integer not null auto_increment, description varchar(255), icon varchar(255), main varchar(255), wi_id integer, primary key (id));

create table weather_detail (id integer not null auto_increment, feels_like float(53), grnd_level integer, humidity integer, pressure integer, sea_level integer, temp float(53), temp_max float(53), temp_min float(53), wi_id integer, primary key (id));


create table weather_info (id integer not null auto_increment, created_date datetime(6), city varchar(255), wd_id integer, primary key (id));

alter table weather_detail drop index UKok43233m7hdw7oa6jmpd1kq68;
alter table weather_detail add constraint UKok43233m7hdw7oa6jmpd1kq68 unique (wi_id);
alter table weather_info drop index UKnp8mwaun13jpdkncvnlnscpry;
alter table weather_info add constraint UKnp8mwaun13jpdkncvnlnscpry unique (wd_id);
alter table weather add constraint FK7y88d9a2s6rkb400eqycc632k foreign key (wi_id) references weather_info (id);
alter table weather_detail add constraint FKgcug9t6dtrleie0ppkpmt677p foreign key (wi_id) references weather_info (id);
alter table weather_info add constraint FK17c7thtinkraxkvc0j5srmlk2 foreign key (wd_id) references weather_detail (id);