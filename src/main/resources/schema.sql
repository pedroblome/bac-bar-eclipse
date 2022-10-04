drop table if exists BUNDLE;

-- CREATETABLE

CREATE TYPE "enum_status" AS ENUM('confirmed', 'canceled', 'analisys', 'waiting_payment', 'route', 'deleted');

CREATE TABLE bundle (
    "id"   INTEGER  PRIMARY KEY AUTO_INCREMENT,
    "namePackage" varchar not null,
    "zipCodeOrigin" varchar not null,
    "zipCodeDestin" varchar not null,
    "description" varchar not null,
    "status" "enum_status" not null,
    PRIMARY KEY ("id")
);
insert into bundle("namePackage", "zipCodeOrigin", "zipCodeDestin", "description", "status")  values('monitor', '72820200', '72820201', 'used in computer', 'confirmed');
--insert into bundle("namePackage", "zipCodeOrigin", "zipCodeDestin", "description", "status")  values('monitor', '72820200', '72820201', 'used in computer', 'confirmed');
