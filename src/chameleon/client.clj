(ns chameleon.client
  (:require [clj-http.client :as client])
  (:require [clojure.data.json :as json]))

(defn url [user-id]
  (str "http://api.stackexchange.com/2.2/users/" user-id "?site=stackoverflow"))

(defn resp [user-id]
  (client/get (url user-id)))

(defn body [user-id]
  (json/read-str (:body (resp user-id))))

(defn items [user-id]
  ((body user-id) "items"))

(defn user-data [user-id]
  ((items user-id) 0))

(defn user-key [user-id data-key]
  ((user-data user-id) data-key))

(defn display-name [user-id]
  (user-key user-id "display_name"))

(defn rep [user-id]
  (user-key user-id "reputation"))
