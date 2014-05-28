(ns chameleon.db-test
  (:require [clojure.test :refer :all]
            [chameleon.db :refer :all]))

(deftest test-db
  (let [db-name (.getName db)]
    (is (instance? com.mongodb.DBApiLayer db))
    (is (= "chameleon" db-name))))
