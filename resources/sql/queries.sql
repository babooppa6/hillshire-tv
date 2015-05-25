--name: get-page
-- get page from db
SELECT "id", "type", "url"
FROM "pages"
WHERE lower("id") = lower(?)

--name: list-pages
-- get all pages
SELECT "id", "type", "url"
FROM "pages"
ORDER BY "id" ASC

--name: get-random
-- select a random custom page.
SELECT "id"
FROM "pages"
ORDER BY random()
limit 1
