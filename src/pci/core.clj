(ns pci.core
  (:require [clojure.data.json :as json])
  (:require [clojure.set :as set])
  (:require [pci.stats :as stats]))

  (def data (json/read-json (slurp "critics.json") false))

  (defn same-movies
    [x y]
    (let [person1 (-> x data keys set)
          person2 (-> y data keys set)]
      (set/intersection person1 person2)))

  (defn get-scores
    [person movies]
    (let [seen-movies (data person)]
      (map seen-movies movies)))

  (defn sim-distance
    [x y]
    (let [ movies (same-movies x y)
           coefficient (stats/euclidian (get-scores x movies) (get-scores y movies))]
      (/ 1 (+ 1 (Math/sqrt coefficient)))))

   (defn sim-pearson
     [x y]
     (let[movies (same-movies x y)]
         (stats/pearson-coeffcient (get-scores x movies) (get-scores y movies))))

   (defn compare-person
     "compares a person with the other critics and returns the scores for the comparison strategy"
     [f person]
     (into {}
       (for [ critic (keys data) :when (not= critic person) ] 
         {critic (f person critic)} )))


