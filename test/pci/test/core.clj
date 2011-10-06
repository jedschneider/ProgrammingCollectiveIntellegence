(ns pci.test.core
  (:use [pci.core])
  (:use [clojure.test]))

(deftest test-it-works
  (is (= 
    (first (keys data)) 
    "Lisa Rose")))

(deftest test-same-movies
  (is (=
    (same-movies "Toby" "Lisa Rose")
    #{"Snakes on a Plane" "Superman Returns" "You, Me and Dupree"})))

(deftest test-sim-distance
  (is (=
    (format "%.3f"(sim-distance "Gene Seymour" "Lisa Rose"))
    "0.294")))
    
(deftest test-get-scores
  (is (=
    (get-scores "Lisa Rose" ["Snakes on a Plane" "Superman Returns"])
    [3.5 3.5])))

(deftest test-sim-pearson
  (is (=
    (format "%.3f" (sim-pearson "Lisa Rose" "Gene Seymour"))
    "0.396")))