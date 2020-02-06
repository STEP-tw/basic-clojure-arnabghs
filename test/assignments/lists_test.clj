(ns assignments.lists-test
  (:require [clojure.test :refer :all]
            [assignments.lists :refer :all]))

(deftest map-test
  (testing "identity with single coll"
    (is (= [1 2 3] (map' identity [1 2 3]))))
  (testing "inc with single coll"
    (is (= [2 3 4] (map' inc [1 2 3]))))
  (testing "addition with multiple coll"
    (is (= [11 22 33] (map' + [1 2 3] [10 20 30]))))
  (testing "addition with multiple coll of diff arity"
    (is (= [11] (map' + [1 2 3] [10]))))
  )

(deftest filter-test
  (testing "even with single coll"
    (are [x y] (= x y)
               [2 4] (filter' even? [1 2 3 4])
               [] (filter' even? [1 3])))
  )

(deftest reduce-test
  (testing "without init value"
    (are [x y] (= x y)
               15 (reduce' + [1 2 3 4 5])
               "ABC" (reduce' str ["A" "B" "C"])))
  (testing "with init value"
    (are [x y] (= x y)
               25 (reduce' + 10 [1 2 3 4 5])
               "XABC" (reduce' str "X" ["A" "B" "C"])))
  )

(deftest count-test
  (testing "counting sequential collection"
    (are [x y] (= x y)
               4 (count' [1 2 3 4])
               2 (count' '(1 3))))
  (testing "counting hashed collection"
    (are [x y] (= x y)
               4 (count' #{1 2 3 4})
               2 (count' {:a 1 :b 3}))
    )
  (testing "counting string"
    (is (= 7 (count' "Germany"))))
  )
