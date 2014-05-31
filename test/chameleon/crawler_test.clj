(ns chameleon.crawler-test
  (:require [clojure.test :refer :all]
            [chameleon.crawler :refer :all]
            [chameleon.utils :as utils]
            [monger.collection :as mc])
  (:import [java.util Date]))

(def ^{:private true} user-map {:user-id 28804,
                                :display-name "mipadi",
                                :rep 100000})

(defn stub-utcnow []
  (Date. 0))

(deftest test-create-user-map
  (let [user-map (create-user-map 28804)]
    (is (= 28804 (:user-id user-map)))
    (is (= "mipadi" (:display-name user-map)))))

(deftest test-create-user-document
  (is (= {:_id 28804, :display_name "mipadi"}
         (create-user-document user-map))))

(deftest test-create-sample-document
  (with-redefs [utils/utcnow stub-utcnow]
    (is (= {:user 28804, :timestamp (Date. 0), :reputation 100000}
           (create-sample-document user-map)))))

;; TODO: test update-user!

;; TODO: test create-sample!

;; TODO: test update-users!

;; TODO: test insert-samples!
