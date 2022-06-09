CREATE DATABASE MatchResults;

create table match
(
    id  serial primary key,
    description varchar(50) not null,
    match_date date not null,
    match_time time not null,
    team_a varchar(50) not null,
    team_b varchar(50) not null,
    sport int not null,
    FOREIGN KEY(sport)
        REFERENCES sports(id)
);




create table matchOdds
(
    id  serial primary key,
    match_id int not null,
    specifier varchar(1) not null,
    odd int not null,
    FOREIGN KEY(match_id)
        REFERENCES match(id)
);


create table sports
(
    id  serial primary key,
    description varchar(50) unique not null
);


