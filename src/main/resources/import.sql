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
INSERT INTO requests (id,name,mark,email,Dest,status,Uid, text, mail) VALUES (100,'john', 8, 'john@gmail.com','vaggelis', 'Pending', 'john', 'Συστατική επιστολή για δουλειά', 'company4@gmail.com'); --password: papi
INSERT INTO requests (id,name,mark,email,Dest,status,Uid, text, mail) VALUES (200,'john', 7, 'john@gmail.com','vaggelis', 'Pending', 'john','Συστατική επιστολή για μεταπτυχιακό', 'university@gmail.com'); --password: papi
INSERT INTO requests (id,name,mark,email,Dest,status,Uid, text, mail) VALUES (300,'Eleni', 7, 'eleni@gmail.com','vaggelis', 'Pending', 'eleni','Συστατική επιστολή για εταιρεία', 'company5@hotmail.gr'); --password: papi

--Recommendation Letter Hardcoded data
INSERT INTO recommendation_letters(id,rid,text,uid, email, prof_email) VALUES (400,1,'"C:\Users\vaggelis\Documents\Επιστολή1"','vaggelis', 'company1@gmail.com', 'vag@gmail.com'); --password: pass
INSERT INTO recommendation_letters(id,rid,text,uid, email, prof_email) VALUES (500,2,'"C:\Users\vaggelis\Documents\Επιστολή2"','vaggelis', 'company2@gmail.com', 'vag@gmail.com'); --password: pass
INSERT INTO recommendation_letters(id,rid,text,uid, email, prof_email) VALUES (600,3,'"C:\Users\vaggelis\Documents\Επιστολή3"','vaggelis', 'company3@gmail.com', 'vag@gmail.com'); --password: pass
INSERT INTO recommendation_letters(id,rid,text,uid, email, prof_email) VALUES (700,4,'"C:\Users\vaggelis\Documents\Επιστολή4"','vaggelis', 'university1@gmail.com', 'vag@gmail.com'); --password: pass
INSERT INTO recommendation_letters(id,rid,text,uid, email, prof_email) VALUES (800,5,'"C:\Users\vaggelis\Documents\Επιστολή5"','vaggelis', 'university2@gmail.com', 'vag@gmail.com'); --password: pass

