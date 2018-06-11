USE adlister_db;

INSERT INTO users (username, email, password)
VALUES ('Goldfinger', 'goldfinger@goldfinger.com', 'iamgoldfinger'),
  ('Octopussy', 'octopussy@octopussy.com', 'octopussy'),
  ('Spectre', 'spectre@spectre.com', 'spectreme'),
  ('DrNo', 'drno@drno.com', 'drnosaysyes'),
  ('Thunderball', 'thunderball@thunderball.com', 'thunderballit'),
  ('Skyfall', 'skyfall@skyfall.com', 'skyfallin');

INSERT INTO ads (user_id, title, description)
VALUES (1, 'Die James Bond!', 'He doesn\'t really die'),
  (2, 'I will drown you in the ocean', 'James Bond escapes again'),
  (3,'Was James the Spectre?', 'Yes he really was this time.'),
  (4, 'Dr No says Yes', 'But it does not matter'),
  (5, 'How the Playboy Mansion Became Famous', 'It was in my movie.'),
  (6, 'How far can you fall?', 'Pretty fall and I will not die');

INSERT INTO categories(cat_subcat_p_id, category)
    VALUES (), (), (), (), (), (), ()