DROP TABLE IF EXISTS procedure_appointment;
DROP TABLE IF EXISTS employee_procedure;
DROP TABLE IF EXISTS salon_procedure;
DROP TABLE IF EXISTS user_role;
DROP TABLE IF EXISTS customer;
-- DROP TABLE IF EXISTS manager;
DROP TABLE IF EXISTS employee;
DROP TABLE IF EXISTS gender;
DROP TABLE IF EXISTS role;


CREATE TABLE IF NOT EXISTS gender
(
    id    BIGINT      NOT NULL PRIMARY KEY,
    value VARCHAR(15) NOT NULL UNIQUE
);

CREATE TABLE IF NOT EXISTS role
(
    id   BIGINT      NOT NULL PRIMARY KEY,
    name VARCHAR(20) NOT NULL UNIQUE
);


CREATE TABLE IF NOT EXISTS employee
(
    id        BIGINT      NOT NULL PRIMARY KEY AUTO_INCREMENT,
    name      VARCHAR(30) NOT NULL,
    surname   VARCHAR(30) NOT NULL,
    payrate   INTEGER     NOT NULL,
    gender_id BIGINT      NOT NULL,
    --    role_id   BIGINT      NOT NULL,

    FOREIGN KEY (gender_id) REFERENCES gender (id) ON DELETE CASCADE
    --   FOREIGN KEY (role_id) REFERENCES role (id)
);





CREATE TABLE IF NOT EXISTS customer
(
    id                BIGINT       NOT NULL PRIMARY KEY AUTO_INCREMENT,
    login             VARCHAR(20)  NOT NULL UNIQUE,
    customer_email    VARCHAR(50)  NOT NULL UNIQUE,
    customer_password VARCHAR(100) NOT NULL,
    customer_name     VARCHAR(50)  NOT NULL,
    customer_surname  VARCHAR(50)  NOT NULL,
    customer_secname  VARCHAR(50)  NOT NULL,
    customer_idnum    VARCHAR(50)  NOT NULL,
    customer_idfszn   VARCHAR(50)  NOT NULL,
    customer_ipname   VARCHAR(50)  NOT NULL,
    customer_insurance VARCHAR(50)  NOT NULL,
    phone_number      VARCHAR(20),
    active            BOOLEAN      NOT NULL
);


CREATE TABLE IF NOT EXISTS salon_procedure
(
    id          BIGINT      NOT NULL PRIMARY KEY AUTO_INCREMENT,
    cost        DOUBLE      NOT NULL,
    title       VARCHAR(50) NOT NULL,
    duration    INTEGER     NOT NULL,
    description VARCHAR(300)
);

CREATE TABLE IF NOT EXISTS procedure_appointment
(
    id                     BIGINT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    appointment_date       DATE   NOT NULL,
    appointment_time       TIME   NOT NULL,

    customer_id            BIGINT NOT NULL,
    procedure_id           BIGINT NOT NULL,
    performing_employee_id BIGINT NOT NULL,

    FOREIGN KEY (customer_id) REFERENCES customer (id) ON DELETE CASCADE,
    FOREIGN KEY (procedure_id) REFERENCES salon_procedure (id) ON DELETE CASCADE,
    FOREIGN KEY (performing_employee_id) REFERENCES employee (id) ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS employee_procedure
(
    employee_id  BIGINT NOT NULL,
    procedure_id BIGINT NOT NULL,

    FOREIGN KEY (employee_id) REFERENCES employee (id) ON DELETE CASCADE,
    FOREIGN KEY (procedure_id) REFERENCES salon_procedure (id) ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS user_role
(
    user_id BIGINT NOT NULL,
    roles   VARCHAR(20),

    FOREIGN KEY (user_id) REFERENCES customer (id) ON DELETE CASCADE
);


DROP TABLE IF EXISTS py3;
CREATE TABLE IF NOT EXISTS py3(
                                  id BIGINT NOT NULL PRIMARY KEY AUTO_INCREMENT,
                                  name VARCHAR(50) NOT NULL,
                                  reason_code VARCHAR(20) NOT NULL,
                                  sum_money INT NOT NULL,
                                  sum_chil INT NOT NULL,
                                  fear_money_worker INT NOT NULL,
                                  fear_money_pens INT NOT NULL,
                                  fear_money_social INT NOT NULL,
                                  sum_paid_worker INT NOT NULL,
                                  sum_paid_сustom INT NOT NULL,
                                  fear_money_worke_per INT NOT NULL,
                                  fear_money_pens_per INT NOT NULL,
                                  fear_money_socia_per INT NOT NULL,
                                  customer_id BIGINT NOT NULL,
                                  FOREIGN KEY(customer_id) REFERENCES customer(id) ON DELETE CASCADE

);

DROP TABLE IF EXISTS
    dates;
CREATE TABLE IF NOT EXISTS dates(
                                    id BIGINT NOT NULL PRIMARY KEY AUTO_INCREMENT,
                                    date_start DATE NOT NULL,
                                    date_end DATE NOT NULL,
                                    act VARCHAR(50) NOT NULL,
                                    py3_id BIGINT NOT NULL,
                                    FOREIGN KEY(py3_id) REFERENCES py3(id) ON DELETE CASCADE
);
DROP TABLE IF EXISTS money_curse;
CREATE TABLE IF NOT EXISTS money_curse(
                                          id BIGINT NOT NULL PRIMARY KEY AUTO_INCREMENT,
                                          for_fiz_face INT NOT NULL,
                                          for_ip INT NOT NULL,
                                          work_day INT NOT NULL
);
DROP TABLE IF EXISTS py2;
CREATE TABLE IF NOT EXISTS py2(
                                  id BIGINT NOT NULL PRIMARY KEY AUTO_INCREMENT,
                                  name VARCHAR(50) NOT NULL,
                                  reason VARCHAR(20) NOT NULL,
                                  date_start VARCHAR(50) NOT NULL,
                                  date_end VARCHAR(100) NOT NULL,
                                  pr_number VARCHAR(50) NOT NULL,
                                  pr_data VARCHAR(50) NOT NULL,
                                  codd VARCHAR(50) NOT NULL,
                                  customer_id BIGINT NOT NULL,
                                  FOREIGN KEY(customer_id) REFERENCES customer(id) ON DELETE CASCADE

);
DROP TABLE IF EXISTS py1;
CREATE TABLE IF NOT EXISTS py1(
                                  id BIGINT NOT NULL PRIMARY KEY AUTO_INCREMENT,
                                  name VARCHAR(50) NOT NULL,
                                  citizenship VARCHAR(20) NOT NULL,
                                  date_of_birth DATE NOT NULL,
                                  sity_of_birth VARCHAR(100),
                                  area_of_birth VARCHAR(50),
                                  country VARCHAR(50) NOT NULL,
                                  sex VARCHAR(50) NOT NULL,
                                  address VARCHAR(50),
                                  indeks VARCHAR(50),
                                  telephone VARCHAR(50),
                                  telephone_home VARCHAR(50),
                                  series VARCHAR(2),
                                  num VARCHAR(20),
                                  customer_id BIGINT NOT NULL,
                                  FOREIGN KEY(customer_id) REFERENCES customer(id) ON DELETE CASCADE
);