(ns kjif.core-test
  (:require [clojure.test :refer :all]
            [kjif.core :refer :all]))

(deftest a-test
  (testing "FIXME, I fail."
    (is (= 1 1))))

(deftest test-do-one-host
  (testing "Empty steps"
    (is (= (do-one-host [] [])
           {}))))

(deftest executor
  (testing "Empty step list"
    (let [hosts ["foo.x.com" "bar.x.com"]
          steps []]
      (is (= (do-all-hosts hosts steps)
          {"foo.x.com" {}
           "bar.x.com" {}
           }))))
  (testing "Empty host list"
    (let [hosts []
          steps [set-dark-feature]]
      (is (= (do-all-hosts hosts steps)
          {})))))
