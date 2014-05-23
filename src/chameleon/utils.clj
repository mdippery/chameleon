(ns chameleon.utils
  (:import [java.util Date]))

(defn env [key default]
  (get (System/getenv) key default))

(defn utcnow []
  (Date.))
