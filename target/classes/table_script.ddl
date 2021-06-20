# CREATE TABLE `address` (
#                            `id` bigint NOT NULL AUTO_INCREMENT,
#                            `city` varchar(255) DEFAULT NULL,
#                            `number` varchar(255) DEFAULT NULL,
#                            `street` varchar(255) DEFAULT NULL,
#                            `company_id` bigint DEFAULT NULL,
#                            PRIMARY KEY (`id`)
# ) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
#
# -- spring_specification.company definition
# CREATE TABLE `company` (
#                            `id` bigint NOT NULL AUTO_INCREMENT,
#                            `full_name` varchar(255) DEFAULT NULL,
#                            `short_name` varchar(255) DEFAULT NULL,
#                            `address_id` bigint DEFAULT NULL,
#                            `contact_person_id` bigint DEFAULT NULL,
#                            PRIMARY KEY (`id`)
# ) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
#
# -- spring_specification.contact_person definition
# CREATE TABLE `contact_person` (
#                                   `id` bigint NOT NULL AUTO_INCREMENT,
#                                   `birth_of_date` date DEFAULT NULL,
#                                   `name` varchar(255) DEFAULT NULL,
#                                   `company_id` bigint DEFAULT NULL,
#                                   PRIMARY KEY (`id`)
# ) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
#
# -- spring_specification.phone definition
# CREATE TABLE `phone` (
#                          `id` bigint NOT NULL AUTO_INCREMENT,
#                          `country_prefix` varchar(255) DEFAULT NULL,
#                          `phone_number` varchar(255) DEFAULT NULL,
#                          `sign` varchar(255) DEFAULT NULL,
#                          `contact_person_id` bigint DEFAULT NULL,
#                          PRIMARY KEY (`id`)
# ) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
#
# -- foreign key
# alter table address add constraint fk_address_company foreign key (company_id) references company(id);
# alter table company add constraint fk_company_address foreign key (address_id) references address(id);
# alter table company add constraint fk_company_contact_person foreign key (contact_person_id) references contact_person(id);
# alter table contact_person add constraint fk_contact_person_company foreign key (company_id) references company(id);
# alter table phone add constraint fk_phone_contact_person foreign key (contact_person_id) references contact_person(id);