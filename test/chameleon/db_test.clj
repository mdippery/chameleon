(ns chameleon.db-test
  (:require [clojure.test :refer :all]
            [chameleon.db :refer :all]))

(deftest test-db-url
  (is (= "mongodb://localhost:27017/chameleon" db-url)))
