(ns chameleon.db
  (:require [chameleon.utils :as utils]
            [monger.core :as mg]))


(def db
  (let [default-db-url "mongodb://localhost:27017/chameleon"
        db-url (utils/env "CHAMELEON_MONGODB_URL" default-db-url)
        conn-and-db (mg/connect-via-uri db-url)]
    (:db conn-and-db)))
