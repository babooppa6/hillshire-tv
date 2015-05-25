(ns hillshire-tv.db.core
  (:require
    [yesql.core :refer [defqueries]]
    [clojure.java.io :as io]))

;;change your database information here
(def db-spec {:subprotocol "postgresql"
              :subname "//localhost:5432/hillshire-tv"
              :user "postgres"
              :password "admin"})

(defqueries "sql/queries.sql")
