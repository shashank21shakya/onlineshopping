create table category(

id IDENTITY,
name varchar(50),
description varchar(225),
image_url varchar(50),
is_active BOOLEAN,

CONSTANT pk_category_id PRIMARY KEY (id)
);