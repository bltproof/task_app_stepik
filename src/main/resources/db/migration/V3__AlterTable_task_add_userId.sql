alter table task
    add user_id int;

alter table task drop constraint task_pkey;

alter table task
    add constraint task_users_id_fk
        foreign key (user_id) references users
            on delete cascade;