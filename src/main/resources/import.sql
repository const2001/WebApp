--Student Hardcoded data
INSERT INTO users (
    id, active, password, roles, user_name
)
VALUES
    (             --password : papi
        1, true, '$2a$12$G58.q0KVfATzsD.foNJTD.KlFJYjVOOJQ8ubsfoIKqYuF2cYM/BSm',
        'ROLE_STUDENT', 'john'
    );

INSERT INTO users (
    id, active, password, roles, user_name
)
VALUES
    (             --password : papi
        3, true, '$2a$12$G58.q0KVfATzsD.foNJTD.KlFJYjVOOJQ8ubsfoIKqYuF2cYM/BSm',
        'ROLE_STUDENT', 'xristos'
    );

INSERT INTO users (
    id, active, password, roles, user_name
)
VALUES
    (             --password : papi
        4, true, '$2a$12$G58.q0KVfATzsD.foNJTD.KlFJYjVOOJQ8ubsfoIKqYuF2cYM/BSm',
        'ROLE_STUDENT', 'nikos'
    );

INSERT INTO users (
    id, active, password, roles, user_name
)
VALUES
    (             --password : papaki
        2, true, '$2a$12$OJJ1z4bx5ArPZvEBi1RdE.htMf7.zEEk9YXl9Pf99.i8jbex7GtfO',
        'ROLE_STUDENT', 'kostas'
    );

--Teacher Hardcoded data
INSERT INTO users (
    id, active, password, roles, user_name
)
VALUES
    (             --password : pass
        7, true, '$2a$12$a9UeVEbTJoETWLd3LCBRHeC1ep6AMRWZP0NX/qwd/meWnIskLMKiC',
        'ROLE_PROFESSOR', 'vaggelis'
    );

INSERT INTO users (
    id, active, password, roles, user_name
)
VALUES
    (             --password : pass
        8, true, '$2a$12$a9UeVEbTJoETWLd3LCBRHeC1ep6AMRWZP0NX/qwd/meWnIskLMKiC',
        'ROLE_PROFESSOR', 'xristina'
    );

INSERT INTO users (
    id, active, password, roles, user_name
)
VALUES
    (
        9, true, '$2a$12$a9UeVEbTJoETWLd3LCBRHeC1ep6AMRWZP0NX/qwd/meWnIskLMKiC',
        'ROLE_PROFESSOR', 'adonis'
    );
