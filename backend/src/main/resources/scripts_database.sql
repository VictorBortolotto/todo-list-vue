create table tasks(
	id serial primary key,
	name varchar(500) not null,
	description varchar(500),
	is_finished boolean default false,
	deadline date
);

create table task_task_list (
	id_task int,
	id_task_list int
);

create table task_list(
	id serial primary key,
	name varchar(400) not null
);

create table frame_task_list(
	id_frame int,
	id_task_list int
);

create table frame(
	id serial primary key,
	name varchar(500) not null,
	description varchar(700)
);

alter table task_task_list add constraint fk_task_task_list_tasks foreign key (id_task) references tasks(id);
alter table task_task_list add constraint fk_task_task_list_task_list foreign key (id_task_list) references task_list(id);

alter table frame_task_list add constraint fk_frame_task_list_frame foreign key (id_frame) references frame(id);
alter table frame_task_list add constraint fk_frame_task_list_task_list foreign key (id_task_list) references task_list(id);