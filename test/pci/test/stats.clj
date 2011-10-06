(ns pci.test.stats
  (:use [clojure.test])
  (:use [pci.stats]))

  (deftest test-pearson-coefficent
    (is (=
      (format "%.3f" (pearson-coeffcient [100 250 250 670] [100 450 570 800]))
      "0.890")))