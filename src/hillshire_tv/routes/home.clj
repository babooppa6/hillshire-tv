(ns hillshire-tv.routes.home
  (:require [hillshire-tv.layout :as layout]
            [compojure.core :refer [defroutes GET]]
            [compojure.route :as route]
            [ring.util.http-response :refer [ok]]
            [ring.util.response :refer [redirect]]
            [clojure.java.io :as io]
            [hillshire-tv.db.core :as db]))

(defn list-pages []
  ;Show links to all hillshire.tv pages in a table
  (let [model {:pages (db/list-pages db/db-spec)}]
  (layout/render "pagelist.html" model)))

(defn about-page [] (layout/render "about.html"))

(defn error-page [] (layout/render "error.html"))

(defn say-page [] (layout/render "say.html"))

(defn say-page-redirect [msg] (redirect
  (str "http://translate.google.com/translate_tts?tl=en&q=" msg)))

(defn custom-page [page]
  ;Render a page's video or image based on its content type
  (let [model (into {} (db/get-page db/db-spec page))]
  (try (layout/render (str (:type model) ".html") model)
  (catch Exception e (route/not-found (error-page))))))

(defn random-page []
  (layout/render "random.html" (into {} (db/get-random db/db-spec))))

(defroutes home-routes
  (GET "/" [] (list-pages))
  (GET "/about" [] (about-page))
  (GET "/pages" [] (list-pages))
  (GET "/random" [] (random-page))
  (GET "/say" [] (say-page))
  (GET "/say/:msg" [msg] (say-page-redirect (str msg)))
  (GET "/robotlady" [] (say-page))
  (GET "/say/:msg" [msg] (say-page-redirect (str msg)))
  (GET "/:page" [page] (custom-page (str page)))
  (route/not-found (error-page)))
