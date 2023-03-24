DROP TABLE IF EXISTS operators;

CREATE TABLE operators (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  name VARCHAR(250) NOT NULL,
  available VARCHAR(5) NOT NULL,
  incidentid VARCHAR(5),
  hospitalid VARCHAR(5)
);

INSERT INTO operators (name, available, incidentid, hospitalid) VALUES
  ('Operator 1', 'true', 'n/a', 'n/a'),
  ('Operator 2', 'true', 'n/a', 'n/a'),
  ('Operator 3', 'true', 'n/a', 'n/a'),
  ('Operator 4', 'true', 'n/a', 'n/a');