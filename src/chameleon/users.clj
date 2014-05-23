(ns chameleon.users
  (:require [chameleon.db :as db]
            [monger.collection :as mc]))

(def ^{:private true} coll "users")

(def subjects (mc/find-maps db/db coll))

(def subject-ids (map (fn [e] (long (:_id e))) subjects))
