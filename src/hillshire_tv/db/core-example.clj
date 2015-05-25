;Rename this filename to core.clj

(ns hillshire-tv.db.core
  (:require
    [yesql.core :refer [defqueries]]
    [clojure.java.io :as io]))

;Replace user and password with your postgres login
(def db-spec {:subprotocol "postgresql"
              :subname "//localhost/hillshire-tv"
              :user "USERNAME-HERE"
              :password "PASSWORD-HERE"})

(defqueries "sql/queries.sql")
