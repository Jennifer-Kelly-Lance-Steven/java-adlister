USE adlister_db;

SET FOREIGN_KEY_CHECKS=0;


INSERT INTO ads (user_id, title, description, ads_cat_p_id)
VALUES (1, 'Die James Bond!', 'He doesn\'t really die', 1),
  (2, 'I will drown you in the ocean', 'James Bond escapes again', 2),
  (3,'Was James the Spectre?', 'Yes he really was this time.', 3),
  (4, 'Dr No says Yes', 'But it does not matter', 4),
  (5, 'How the Playboy Mansion Became Famous', 'It was in my movie.', 5),
  (6, 'How far can you fall?', 'Pretty fall and I will not die', 1);

INSERT INTO categories(cat_subcat_p_id, category)
VALUES (1, 'Community'), (2,'Sale'), (3,'Jobs'), (4,'Housing'), (5,'Services');

INSERT INTO subcat (cat_subcat_p_id, subcat)
    VALUES (6, 'Events'), (7, 'Petitions'),
      (8, 'New'), (9, 'Used'), (10, 'Seeking'),
      (11, 'Posting'), (12, 'Apartments'), (13, 'Houses'), (14, 'Skilled'), (15, 'Tech');

INSERT INTO ads_cat_p (cat_id, ads_id)
    VALUES (1, 3), (2, 5), (3, 2), (4, 1),
      (5, 4), (2, 3), (3, 5), (5, 2), (3, 1), (5, 4);

INSERT INTO cat_subcat_p (cat_id, subcat_id)
    VALUES (1, 6), (2, 7), (3, 8), (4, 9),
      (5, 10), (1, 11), (2, 12), (3, 13), (4, 14), (5, 15);