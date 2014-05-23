(ns chameleon.utils-test
  (:require [clojure.test :refer :all]
            [chameleon.utils :refer :all]))

(deftest test-env
  (is (instance? String (env "HOME" "/Users/mdippery"))))
