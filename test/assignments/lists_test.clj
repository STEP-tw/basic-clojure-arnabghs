(ns assignments.lists-test
  (:require [clojure.test :refer :all]
            [assignments.lists :refer :all]))

(deftest lists
  (testing "map"
    (testing "identity with single coll"
      (is (= [1 2 3] (map' identity [1 2 3]))))
    (testing "inc with single coll"
      (is (= [2 3 4] (map' inc [1 2 3]))))
    ;(testing "addition with multiple coll"
    ;  (is (= [11 22 33] (map' + [1 2 3] [10 20 30]))))
    ;(testing "addition with multiple coll of diff arity"
    ;  (is (= [11] (map' + [1 2 3] [10])))))
    )

  (testing "filter"
    (testing "even with single coll"
      (are [x y] (= x y)
                 [2 4] (filter' even? [1 2 3 4])
                 [] (filter' even? [1 3])))
    )
  )
