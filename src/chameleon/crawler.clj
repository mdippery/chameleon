(ns chameleon.crawler
  (:require [chameleon.client :as client]
            [chameleon.db :as db]
            [chameleon.utils :as utils]
            [monger.collection :as mc]))

(defn crawl-users [user-ids]
  (map (fn [uid] {:user-id uid,
                  :display-name (client/display-name uid),
                  :rep (client/rep uid)})
       user-ids))

(defn create-user-document [user-map]
  {:_id (:user-id user-map), :display_name (:display-name user-map)})

(defn create-sample-document [user-map]
  {:user (:user-id user-map),
   :timestamp (utils/utcnow),
   :reputation (:rep user-map)})

(defn update-user! [user-map]
  (mc/update db/db
             "users"
             {:_id (:user-id user-map)}
             {:display_name (:display-name user-map)}))

(defn create-sample! [user-map]
  (mc/insert db/db "samples" (create-sample-document user-map)))

(defn update-users! [user-maps]
  (dorun (map update-user! user-maps)))

(defn insert-samples! [user-maps]
  (dorun (map create-sample! user-maps)))
