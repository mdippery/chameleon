(ns chameleon.core
  (:require [chameleon.users :as users]
            [chameleon.crawler :as crawler])
  (:gen-class))

(defn -main [& args]
  (let [user-maps (crawler/crawl-users users/subject-ids)]
    (crawler/update-users! user-maps)
    (crawler/insert-samples! user-maps)))
