drop table if exists BUNDLE;

-- CREATETABLE

CREATE TYPE "enum_status" AS ENUM('confirmed', 'canceled', 'analisys', 'waiting_payment', 'route');

CREATE TABLE bundle (
    "id"   INTEGER  PRIMARY KEY AUTO_INCREMENT,
    "namePackage" varchar not null,
    "zipCodeOrigin" varchar not null,
    "zipCodeDestin" varchar not null,
    "description" varchar not null,
    "status" "enum_status" not null,
    PRIMARY KEY ("id")
);
insert into bundle("namePackage", "zipCodeOrigin", "zipCodeDestin", "description", "status")  values('escova de dente', '72668400', '74968080', 'higiene bucal', 'confirmed');
insert into bundle("namePackage", "zipCodeOrigin", "zipCodeDestin", "description", "status")  values('creme dental', '72668400', '74968080', 'higiene bucal', 'confirmed');
insert into bundle("namePackage", "zipCodeOrigin", "zipCodeDestin", "description", "status")  values('fio dental', '72668400', '74968080', 'higiene bucal', 'confirmed');
insert into bundle("namePackage", "zipCodeOrigin", "zipCodeDestin", "description", "status")  values('toalha de banho', '72668400', '74968080', 'roupa de banho', 'confirmed');
insert into bundle("namePackage", "zipCodeOrigin", "zipCodeDestin", "description", "status")  values('cortina', '72668400', '74968080', 'acessório para casa', 'waiting_payment');
