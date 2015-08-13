--name: get-page
-- get page from db
SELECT title, type, url, volume
FROM pages
WHERE lower(title) = lower(:title);

--name: list-pages
-- get all pages
SELECT title, type, url, volume
FROM pages
ORDER BY title ASC;

--name: get-random
-- select a random custom page. ORDER BY random()
SELECT title
FROM pages
ORDER BY random()
limit 1;
