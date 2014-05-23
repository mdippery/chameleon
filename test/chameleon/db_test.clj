(ns chameleon.db-test
  (:require [clojure.test :refer :all]
            [chameleon.db :refer :all]))

(deftest test-db-url
  (is (= "mongodb://localhost:27017/chameleon" db-url)))

(deftest test-db-host
  (is (= "localhost" db-host)))

(deftest test-db-port
  (is (= 27017 db-port)))

(deftest test-db-database
  (is (= "chameleon" db-database)))
