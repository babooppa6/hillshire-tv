(defproject hillshire-tv "0.1.0-SNAPSHOT"

  :description "A companion website for the destiny.gg community"
  :url "http://hillshire.tv"

  :dependencies [[org.clojure/clojure "1.7.0-RC1"]
                 [selmer "0.8.2"]
                 [com.taoensso/timbre "3.4.0"]
                 [com.taoensso/tower "3.0.2"]
                 [markdown-clj "0.9.66"]
                 [environ "1.0.0"]
                 [compojure "1.3.4"]
                 [ring/ring-defaults "0.1.5"]
                 [ring/ring-session-timeout "0.1.0"]
                 [metosin/ring-middleware-format "0.6.0"]
                 [metosin/ring-http-response "0.6.2"]
                 [bouncer "0.3.2"]
                 [prone "0.8.2"]
                 [org.clojure/tools.nrepl "0.2.10"]
                 [ring-server "0.4.0"]
                 [yesql "0.4.2"]
                 [org.postgresql/postgresql "9.4-1201-jdbc41"]
                 [org.clojure/tools.logging "0.3.1"]
                 [lobos "1.0.0-beta3"]]

  :min-lein-version "2.0.0"
  :uberjar-name "hillshire-tv.jar"
  :jvm-opts ["-server"]

;;enable to start the nREPL server when the application launches
;:env {:repl-port 7001}

  :main hillshire-tv.core

  :plugins [[lein-ring "0.9.1"]
            [lein-environ "1.0.0"]
            [lein-ancient "0.6.5"]]



  :ring {:handler hillshire-tv.handler/app
         :init    hillshire-tv.handler/init
         :destroy hillshire-tv.handler/destroy
         :uberwar-name "hillshire-tv.war"}




  :profiles
  {:uberjar {:omit-source true
             :env {:production true}

             :aot :all}
   :dev {:dependencies [[ring-mock "0.1.5"]
                        [ring/ring-devel "1.3.2"]
                        [pjstadig/humane-test-output "0.7.0"]
                        ]
         :source-paths ["env/dev/clj"]



         :repl-options {:init-ns hillshire-tv.core}
         :injections [(require 'pjstadig.humane-test-output)
                      (pjstadig.humane-test-output/activate!)]
         :env {:dev true}}})
