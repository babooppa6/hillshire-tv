(ns hillshire-tv.routes.home
  (:require [hillshire-tv.layout :as layout]
            [compojure.core :refer [defroutes GET]]
            [ring.util.http-response :refer [ok]]
            [clojure.java.io :as io]
            [hillshire-tv.db.core :as db]
            [clojure.pprint :refer [pprint]]))

(defn home-page []
  (layout/render
    "home.html" {:docs (-> "docs/docs.md" io/resource slurp)}))

(defn about-page [] (layout/render "about.html"))

(defn custom-page [page]
  (let [model (into {} (db/get-page db/db-spec page))]
  (try (layout/render (str (get model :type) ".html") model)
  (catch Exception e (layout/render "error.html")))))

(defn list-pages []
  (let [model {:pages (db/list-pages db/db-spec)}]
  (layout/render "pagelist.html" model)))

(defn random-page []
  (layout/render "random.html" (into {} (db/get-random db/db-spec))))

(defroutes home-routes
  (GET "/" [] (list-pages))
  (GET "/about" [] (about-page))
  (GET "/pages" [] (list-pages))
  (GET "/random" [] (random-page))
  (GET "/:page" [page] (custom-page (str page))))
