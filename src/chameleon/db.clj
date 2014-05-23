(ns chameleon.db
  (:require [chameleon.utils :as utils]
            [monger.core :as mg])
  (:import [java.net URI]))


(def db-url (utils/env "CHAMELEON_MONGODB_URL" "mongodb://localhost:27017/chameleon"))

(defn- db-uri []
  (URI. db-url))

(def db-host     (.getHost (db-uri)))
(def db-port     (.getPort (db-uri)))
(def db-database (.substring (.getPath (db-uri)) 1))

(def db
  (let [conn (mg/connect {:host db-host :port db-port})]
    (mg/get-db conn db-database)))
