(ns chameleon.db
  (:require [chameleon.utils :as utils]
            [monger.core :as mg]))


(def db-url (utils/env "CHAMELEON_MONGODB_URL" "mongodb://localhost:27017/chameleon"))

(def db
  (let [conn-and-db (mg/connect-via-uri db-url)]
    (:db conn-and-db)))
