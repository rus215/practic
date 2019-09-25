INSERT INTO Country (code, name) VALUES (643, 'Российская Федерация');
INSERT INTO Country (code, name) VALUES (124, 'Канада');
INSERT INTO Country (code, name) VALUES (276, 'Германия');

INSERT INTO Doc_Type (code, name) VALUES (3, 'Свидетельство о рождении');
INSERT INTO Doc_Type (code, name) VALUES (21, 'Паспорт гражданина РФ');
INSERT INTO Doc_Type (code, name) VALUES (10, 'Паспорт иностранного гражданина');

INSERT INTO Organization (name, full_name, inn, kpp, address, phone, is_active) VALUES ('IT', 'ООО IT', '1234905319', '123463893', 'ул. Цурюпы 6', '83479875643', TRUE);
INSERT INTO Organization (name, full_name, inn, kpp, address, phone, is_active) VALUES ('DarkInt', 'ООО DarkInt', '5656904538', '565692457', 'ул. Актеров 12', '83473452133', FALSE);
INSERT INTO Organization (name, full_name, inn, kpp, address, phone, is_active) VALUES ('ГенСтрой', 'ООО ГенСтрой', '4312457991', '431268944', 'ул. Сочинская 23', '89563221455', TRUE);

INSERT INTO Office (name, address, phone, is_active, org_id) VALUES ('ЦентрОфис', 'ул. Цурюпы 6', '89874563245', TRUE, 1);
INSERT INTO Office (name, address, phone, is_active, org_id) VALUES ('ВторойОфис', 'ул. Цурюпы 34', '89874563542', TRUE, 1);
INSERT INTO Office (name, address, phone, is_active, org_id) VALUES ('ЦентрОфис', 'ул. Актеров 12', '89874563245', FALSE, 2);

INSERT INTO User (first_name, second_name, middle_name, position, phone, office_id, citizenship_code) VALUES ('Денис', 'Подлинов', 'Алексеевич', 'менеджер по проектам', '89177754322', 1, 643);
INSERT INTO User (first_name, second_name, middle_name, position, phone, office_id, citizenship_code) VALUES ('Иван', 'Сухоруков', 'Андреевич', 'аналитик', '89177754322', 1, 643);
INSERT INTO User (first_name, second_name, middle_name, position, phone, office_id, citizenship_code) VALUES ('Денис', 'Подлинов', 'Алексеевич', 'менеджер по проектам', '89177754322', 1, 643);

INSERT INTO Doc (id, doc_date, doc_number, doc_code, is_identified) VALUES (1,'1992-04-21', '8012694822', 21, 'true');
INSERT INTO Doc (id, doc_date, doc_number, doc_code, is_identified) VALUES (2,'1996-10-10', '4326795424', 21, TRUE);
INSERT INTO Doc (id, doc_date, doc_number, doc_code, is_identified) VALUES (3,'1989-06-01', '432654', 3, FALSE);