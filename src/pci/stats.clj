(ns pci.stats)

(defn euclidian
  [seq1 seq2]
  (let [ diff (map - seq1 seq2)]
  (reduce + (for [x diff] (Math/pow x 2)))))

(defn pearson-coeffcient
  [seq1 seq2]
  (let [ sum1 (reduce + seq1)
         sum2 (reduce + seq2)
         length (count seq1)
         sum1sq (reduce + (for [x seq1] (Math/pow x 2)))
         sum2sq (reduce + (for [x seq2] (Math/pow x 2)))
         numerator 
           (- 
             (reduce + (map * seq1 seq2)) 
             (* sum1 (/ sum2 length)))
         denominator 
           (Math/sqrt 
             (* 
               (- sum1sq (/ (Math/pow sum1 2) length)) 
               (- sum2sq (/ (Math/pow sum2 2) length))))]
      (if (= denominator 0) 
        0
        (/ numerator denominator))))