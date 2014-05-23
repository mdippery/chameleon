(ns chameleon.client-test

  (:require [clojure.test :refer :all]
            [chameleon.client :refer :all]))

(deftest test-url
  (is (= "http://api.stackexchange.com/2.2/users/28804?site=stackoverflow" (url 28804))))

(deftest test-resp
  (is (instance? clojure.lang.PersistentArrayMap (resp 28804))))

(deftest test-body
  (is (instance? clojure.lang.PersistentArrayMap (body 28804))))

(deftest test-items
  (is (instance? clojure.lang.PersistentVector (items 28804))))

(deftest test-user-data
  (is (instance? clojure.lang.PersistentHashMap (user-data 28804))))

(deftest test-user-key
  (is (= 28804 (user-key 28804 "user_id"))))

(deftest test-display-name
  (is (= "mipadi" (display-name 28804))))

(deftest test-reputation
  (is (instance? Long (rep 28804))))
