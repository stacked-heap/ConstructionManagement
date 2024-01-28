create table entry (
        id varchar(255) not null,
        date timestamp(6),
        overtime boolean,
        labour_id varchar(255),
        site_id varchar(255),
        primary key (id)
    );

create table labour (
        id varchar(255) not null,
        location varchar(255),
        name varchar(255),
        rate integer,
        primary key (id)
    );

create table material (
        id varchar(255) not null,
        name varchar(255),
        rate integer,
        specification varchar(255),
        primary key (id)
    );

create table site (
        id varchar(255) not null,
        account_no integer,
        bank_name varchar(255),
        client_name varchar(255),
        location varchar(255),
        primary key (id)
    );

create table supplier (
        id varchar(255) not null,
        location varchar(255),
        name varchar(255),
        primary key (id)
    );
create table supplier_entry (
        id varchar(255) not null,
        date timestamp(6),
        units integer,
        material_id varchar(255),
        site_id varchar(255),
        supplier_id varchar(255),
        primary key (id)
    );
alter table if exists entry
       add constraint FKekcedy5g4f6cryk8aelyvpeas
       foreign key (labour_id)
       references labour;

alter table if exists entry
       add constraint FK1mi0dbiye4atqysxwmpv1jdeg
       foreign key (site_id)
       references site;

alter table if exists supplier_entry
       add constraint FK2hf9x3jipnt5ska6t3oui4hdt
       foreign key (material_id)
       references material;

alter table if exists supplier_entry
       add constraint FKlkxd0w0n4lsbf20vuewebijss
       foreign key (site_id)
       references site;

alter table if exists supplier_entry
       add constraint FKnxf56esii8urtfk9g3jwmot2n
       foreign key (supplier_id)
       references supplier;