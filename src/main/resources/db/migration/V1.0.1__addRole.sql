CREATE TABLE IF NOT EXISTS "role_master" (
 
    "role_id" int NOT NULL AUTO_INCREMENT PRIMARY KEY,
    "role" varchar(20) NOT NULL,
    "created_on" TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    "updated_on" TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP

);

insert into "role_master" ("role_id", "role") values( 1, 'ADMIN' );
insert into "role_master" ("role_id", "role") values( 2, 'USER' );

ALTER TABLE "user_master" ADD "role_id" int NOT NULL;

ALTER TABLE "user_master"
    ADD FOREIGN KEY ("role_id")
        REFERENCES "role_master"("role_id");