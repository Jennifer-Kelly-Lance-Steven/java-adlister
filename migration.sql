USE adlister_db;

SET FOREIGN_KEY_CHECKS=0;

DROP TABLE IF EXISTS ads;
DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS ads_cat;
DROP TABLE IF EXISTS categories;
DROP TABLE IF EXISTS ads_cat_p;
DROP TABLE IF EXISTS cat_subcat_p;

CREATE TABLE users (
    id INT UNSIGNED NOT NULL AUTO_INCREMENT,
    username VARCHAR(240) NOT NULL UNIQUE,
    email VARCHAR(240) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE ads (
    id INT UNSIGNED NOT NULL AUTO_INCREMENT,
    user_id INT UNSIGNED NOT NULL,
    ads_cat_p_id INT UNSIGNED NOT NULL,
    title VARCHAR(240) NOT NULL,
    description TEXT NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (user_id) REFERENCES users(id)
        ON DELETE CASCADE,
    FOREIGN KEY (ads_cat_p_id) REFERENCES ads_cat_p(id)
        ON DELETE CASCADE
);


CREATE TABLE categories (
    id INT UNSIGNED NOT NULL AUTO_INCREMENT,
    cat_subcat_p_id INT UNSIGNED NOT NULL,
    category VARCHAR(50) NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (cat_subcat_p_id) REFERENCES ads_cat_p(id)
        ON DELETE CASCADE
);


CREATE TABLE subcat (
    id INT UNSIGNED NOT NULL AUTO_INCREMENT,
    cat_subcat_p_id INT UNSIGNED NOT NULL,
    subcat VARCHAR(50) NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (cat_subcat_p_id) REFERENCES cat_subcat_p(id)
        ON DELETE CASCADE
);

CREATE TABLE ads_cat_p (
    id INT UNSIGNED NOT NULL AUTO_INCREMENT,
    ads_id INT UNSIGNED NOT NULL,
    cat_id INT UNSIGNED NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (ads_id) REFERENCES ads(id)
        ON DELETE CASCADE,
    FOREIGN KEY (cat_id) REFERENCES categories(id)
        ON DELETE CASCADE
);

CREATE TABLE cat_subcat_p (
    id INT UNSIGNED NOT NULL AUTO_INCREMENT,
    cat_id INT UNSIGNED NOT NULL,
    subcat_id INT UNSIGNED NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (subcat_id) REFERENCES subcat(id)
        ON DELETE CASCADE,
    FOREIGN KEY (cat_id) REFERENCES categories(id)
        ON DELETE CASCADE
);
