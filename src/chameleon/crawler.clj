(ns chameleon.crawler
  (:require [chameleon.client :as client]
            [chameleon.db :as db]
            [chameleon.utils :as utils]
            [monger.collection :as mc]))

(defn create-user-map [user-id]
  ; We're actually making two calls to the Stack Overflow API
  ; here -- should find a way to save the data from one call
  ; and re-use it.
  {:user-id user-id,
   :display-name (client/display-name user-id),
   :rep (client/rep user-id)})

(defn crawl-users [user-ids]
  (map create-user-map user-ids))

(defn create-user-document [user-map]
  {:_id (:user-id user-map), :display_name (:display-name user-map)})

(defn create-sample-document [user-map]
  (let [hours (utils/hours-since-midnight (utils/utcnow))
        stats {(str "reputation." hours) (:rep user-map)}]
    {"$set" stats}))

(defn create-query-document [user-map]
  {:user (:user-id user-map)
   :timestamp (utils/midnight (utils/utcnow))})

(defn update-user! [user-map]
  (mc/update db/db
             "users"
             {:_id (:user-id user-map)}
             {:display_name (:display-name user-map)}))

(defn create-sample! [user-map]
  (mc/upsert db/db
             "samples"
             (create-query-document user-map)
             (create-sample-document user-map)
             {:upsert true}))

(defn update-users! [user-maps]
  (doseq [u user-maps] (update-user! u)))

(defn insert-samples! [user-maps]
  (doseq [u user-maps] (create-sample! u)))
