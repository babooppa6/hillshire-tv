(ns lobos.migrations
  (:refer-clojure :exclude [alter drop
                            bigint boolean char double float time])
  (:use (lobos [migration :only [defmigration]] core schema
               config helpers)))

(defmigration add-pages-table
 (up [] (create
         (tbl :pages
           (integer :id :unique)
           (varchar :title 20 :unique)
           (varchar :type 20)
           (varchar :url 100)
           (varchar :volume 5)
           (integer :views))))
 (down [] (drop (table :pages))))
