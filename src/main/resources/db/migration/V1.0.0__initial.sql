CREATE TABLE IF NOT EXISTS "user_master" (
 
    "user_id" int NOT NULL AUTO_INCREMENT PRIMARY KEY,
    "first_name" varchar(20) not null,
    "last_name" varchar(20) not null,
    "user_name" varchar(20) not null,
    "password" varchar(20) not null,
    "is_deleted" BOOLEAN NOT NULL DEFAULT false,
    "created_on" TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    "updated_on" TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP

);
