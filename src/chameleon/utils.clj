(ns chameleon.utils)

(defn env [key default]
  (get (System/getenv) key default))
