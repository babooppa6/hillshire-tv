--name: get-page
-- get page from db
SELECT title, type, url, volume, views
FROM pages
WHERE lower(title) = lower(:title);

--name: list-pages
-- get all pages
SELECT title, type, url, volume, views
FROM pages
ORDER BY title ASC;

--name: get-random
-- select a random custom page. ORDER BY random()
SELECT title
FROM pages
ORDER BY random()
limit 1;

--name: increment-views!
-- Add 1 to the view count of a page
UPDATE pages 
SET views = views + 1
WHERE title = :title;