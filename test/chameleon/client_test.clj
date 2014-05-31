(ns chameleon.client-test
  (:require [clojure.test :refer :all]
            [clj-http.client :as client]
            [chameleon.client :refer :all]))

(defn stub-resp [user-id]
  (let [data-file (str "test/data/" user-id ".json")]
    {:body (slurp data-file)}))

(deftest test-url
  (is (= "http://api.stackexchange.com/2.2/users/28804?site=stackoverflow" (url 28804))))

(deftest test-resp
  (with-redefs [resp stub-resp]
    (contains? (resp 28804) :body)))

(deftest test-body
  (with-redefs [resp stub-resp]
    (let [b (body 28804)]
      (contains? b :items))))

(deftest test-items
  (with-redefs [resp stub-resp]
    (let [i (items 28804)]
      (is (= 1 (count i))))))

(deftest test-user-data
  (with-redefs [resp stub-resp]
    (let [d (user-data 28804)]
      (is (= 21 (count d))))))

(deftest test-user-key
  (with-redefs [resp stub-resp]
    (is (= 28804 (user-key 28804 "user_id")))
    (is (= "San Francisco, CA" (user-key 28804 "location")))))

(deftest test-display-name
  (with-redefs [resp stub-resp]
    (is (= "mipadi" (display-name 28804)))))

(deftest test-reputation
  (with-redefs [resp stub-resp]
    (is (instance? Long (rep 28804)))))
