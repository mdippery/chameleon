(ns chameleon.users
  (:require [chameleon.db :as db]
            [monger.collection :as mc]))

(def ^{:private true} coll "users")

(def users (mc/find-maps db/db coll))

(def user-ids (map (fn [e] (long (:_id e))) users))
