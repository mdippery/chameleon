(ns chameleon.crawler-test
  (:require [clojure.test :refer :all]
            [chameleon.crawler :refer :all]))

(def ^{:private true} user-map {:user-id 28804,
                                :display-name "mipadi",
                                :rep 100000})

(deftest test-create-user-document
  (is (= {:_id 28804, :display_name "mipadi"}
         (create-user-document user-map))))
