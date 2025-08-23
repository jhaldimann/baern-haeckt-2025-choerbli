create table if not exists choerbli (
    id uuid not null,
    state int not null,
    name varchar(255),
    description varchar(255),
    end_date date,
    start_date date,
    primary key (id)
);

create table if not exists ch_user (
    id uuid not null,
    email varchar(255),
    name varchar(255),
    primary key (id)
);

create table if not exists category (
    id uuid not null,
    name varchar(255),
    primary key (id)
);

create table if not exists item_description (
    id uuid not null,
    category_id uuid,
    name varchar(255),
    primary key (id)
);

create table if not exists consequences (
    id uuid not null,
    choerbli_id uuid,
    description varchar(255),
    primary key (id)
);

create table if not exists item (
    id uuid not null,
    choerbli_id uuid,
    user_id uuid,
    points int,
    price float,
    primary key (id)
);

create table if not exists user_rank (
    id uuid not null,
    user_id uuid,
    choerbli_id uuid,
    points int,
    primary key (id)
);

create table if not exists vote (
    id uuid not null,
    factor int,
    item_description_id uuid,
    user_id uuid,
    choerbli_id uuid,
    primary key (id)
);

alter table if exists vote
    add constraint fk_user_id foreign key (user_id) references ch_user;

alter table if exists vote
    add constraint fk_choerbli_id foreign key (choerbli_id) references choerbli;

alter table if exists user_rank
    add constraint fk_choerbli_id foreign key (choerbli_id) references choerbli;

alter table if exists item
    add constraint fk_choerbli_id foreign key (choerbli_id) references choerbli;

alter table if exists item
    add constraint fk_user_id foreign key (user_id) references ch_user;

alter table if exists consequences
    add constraint fk_choerbli_id foreign key (choerbli_id) references choerbli;

alter table if exists item_description
    add constraint fk_category_id foreign key (category_id) references category;