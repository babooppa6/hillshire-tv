(ns hillshire-tv.routes.home
  (:require [hillshire-tv.layout :as layout]
            [compojure.core :refer [defroutes GET]]
            [ring.util.http-response :refer [ok]]
            [clojure.java.io :as io]
            [hillshire-tv.db.core :as db]
            [clojure.pprint :refer [pprint]]))

(defn list-pages []
  ;Show links to all hillshire.tv pages in a table
  (let [model {:pages (db/list-pages db/db-spec)}]
  (layout/render "pagelist.html" model)))

(defn about-page [] (layout/render "about.html"))

(defn custom-page [page]
  ;Render a page's video or image based on its content type
  (let [model (into {} (db/get-page db/db-spec page))]
  (try (layout/render (str (get model :type) ".html") model)
  (catch Exception e (layout/render "error.html")))))

(defn random-page []
  (layout/render "random.html" (into {} (db/get-random db/db-spec))))

(defroutes home-routes
  (GET "/" [] (list-pages))
  (GET "/about" [] (about-page))
  (GET "/pages" [] (list-pages))
  (GET "/random" [] (random-page))
  (GET "/:page" [page] (custom-page (str page))))
