--Student Hardcoded data
INSERT INTO users (id,active,password,roles,user_name) VALUES (1,true,'$2a$12$G58.q0KVfATzsD.foNJTD.KlFJYjVOOJQ8ubsfoIKqYuF2cYM/BSm','ROLE_STUDENT','john'); --password : papi
INSERT INTO users (id,active,password,roles,user_name) VALUES (3,true,'$2a$12$G58.q0KVfATzsD.foNJTD.KlFJYjVOOJQ8ubsfoIKqYuF2cYM/BSm','ROLE_STUDENT','xristos'); --password : papi
INSERT INTO users (id,active,password,roles,user_name) VALUES (4,true,'$2a$12$G58.q0KVfATzsD.foNJTD.KlFJYjVOOJQ8ubsfoIKqYuF2cYM/BSm','ROLE_STUDENT','nikos'); --password : papi
INSERT INTO users (id,active,password,roles,user_name) VALUES (5,true,'$2a$12$G58.q0KVfATzsD.foNJTD.KlFJYjVOOJQ8ubsfoIKqYuF2cYM/BSm','ROLE_STUDENT','dimitra'); --password : papi
INSERT INTO users (id,active,password,roles,user_name) VALUES (6,true,'$2a$12$G58.q0KVfATzsD.foNJTD.KlFJYjVOOJQ8ubsfoIKqYuF2cYM/BSm','ROLE_STUDENT','maria'); --password : papi
INSERT INTO users (id,active,password,roles,user_name) VALUES (2,true,'$2a$12$OJJ1z4bx5ArPZvEBi1RdE.htMf7.zEEk9YXl9Pf99.i8jbex7GtfO','ROLE_STUDENT','kostas'); --password : papaki
INSERT INTO users (id,active,password,roles,user_name) VALUES (10,true,'$2a$12$OJJ1z4bx5ArPZvEBi1RdE.htMf7.zEEk9YXl9Pf99.i8jbex7GtfO','ROLE_STUDENT','eleni'); --password : papi
--Teacher Hardcoded data
INSERT INTO users (id,active,password,roles,user_name) VALUES (7,true,'$2a$12$a9UeVEbTJoETWLd3LCBRHeC1ep6AMRWZP0NX/qwd/meWnIskLMKiC','ROLE_PROFESSOR','vaggelis'); --password : pass
INSERT INTO users (id,active,password,roles,user_name) VALUES (8,true,'$2a$12$a9UeVEbTJoETWLd3LCBRHeC1ep6AMRWZP0NX/qwd/meWnIskLMKiC','ROLE_PROFESSOR','xristina'); --password : pass
INSERT INTO users (id,active,password,roles,user_name) VALUES (9,true,'$2a$12$a9UeVEbTJoETWLd3LCBRHeC1ep6AMRWZP0NX/qwd/meWnIskLMKiC','ROLE_PROFESSOR','adonis'); --password : pass

--Request Hardcoded data
INSERT INTO requests (id,name,mark,Dest,status,Uid) VALUES (1,'john', 8, 'vaggelis', '0', 'john') --password: papi
INSERT INTO requests (id,name,mark,Dest,status,Uid) VALUES (2,'john', 5, 'xristina', '0', 'john') --password: papi