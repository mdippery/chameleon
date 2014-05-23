(ns chameleon.db
  (:use [chameleon.utils :only [env]])
  (:import [java.net URI]))


(def db-url (env "CHAMELEON_MONGODB_URL" "mongodb://localhost:27017/chameleon"))

(defn- db-uri []
  (URI. db-url))

(def db-host (.getHost (db-uri)))
(def db-port (.getPort (db-uri)))
(def db-database (.substring (.getPath (db-uri)) 1))
