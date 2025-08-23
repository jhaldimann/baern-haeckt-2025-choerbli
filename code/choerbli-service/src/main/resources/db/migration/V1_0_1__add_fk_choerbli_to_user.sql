alter table if exists ch_user
    add choerbli_id uuid not null;

alter table if exists ch_user
    add points int;

alter table if exists ch_user
    add constraint fk_choerbli_id foreign key (choerbli_id) references choerbli;

drop table if exists user_rank;

alter table if exists item
    add item_description_id uuid not null;

alter table if exists item
    add constraint fk_item_description_id foreign key (item_description_id) references item_description;