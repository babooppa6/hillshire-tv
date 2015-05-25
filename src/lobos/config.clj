(ns lobos.config
  (:use lobos.connectivity))

(def db
  {:classname "org.postgresql.Driver"
   :subprotocol "postgresql"
   :user "postgres"
   :password "admin"
   :subname "//localhost:5432/hillshire-tv"})

(open-global db)
