(ns assignments.conditions-test
  (:require [clojure.test :refer :all]
            [assignments.conditions :refer :all]))

(deftest safe-division
  (testing "non zero denominator"
    (is (= 2 (safe-divide 4 2))))
  (testing "zero denominator"
    (is (nil? (safe-divide 3 0)))))


(deftest informative-division
  (testing "non zero denominator"
    (is (= 2 (informative-divide 4 2))))
  (testing "zero denominator"
    (is (= :infinte (informative-divide 3 0)))))

(deftest harishchandra-test
  (testing "for boolean truthy value"
    (is (true? (harishchandra true))))
  (testing "for integer truthy value"
    (is (= 6 (harishchandra 6))))
  (testing "for boolean falsy value"
    (is (nil? (harishchandra false))))
  (testing "for nil falsy value"
    (is (nil? (harishchandra nil)))))

(deftest yudishtira-test
  (testing "for truthy value (boolean)"
    (is (true? (yudishtira true))))
  (testing "for truthy value (coll)"
    (is (= [1 2] (yudishtira [1 2]))))
  (testing "for false"
    (is (= :ashwathama (yudishtira false))))
  (testing "for nil"
    (is (= :ashwathama (yudishtira nil))))
  )

(deftest duplicate-first-test
  (testing "for non-empty coll"
    (is (= [1 1 2] (duplicate-first [1 2]))))
  (testing "for empty coll"
    (is (nil? (duplicate-first []))))
  )

(deftest five-point-someone-test
  (testing "Returns :chetan-bhagat if y is 5"
    (is (= :chetan-bhagat (five-point-someone 10 5))))
  (testing "If x is 5 is returns :satan-bhagat"
    (is (= :satan-bhagat (five-point-someone 5 10))))
  (testing "If x is greater than y it returns :greece"
    (is (= :greece (five-point-someone 10 4))))
  (testing "returns :universe if no condition satisfies"
    (is (= :universe (five-point-someone 0 4))))
  )

;(deftest conditions-apply-test
;  (testing "single occurrence of 1 and 3 in that order"
;    (is (= :wonder-woman (conditions-apply [1 3]))))
;  (testing "collection has a single occurrence of :a :b and :c in that order"
;    (is (= :durga (conditions-apply [:a :b :c]))))
;  (testing "collection has a single occurrence of [2 3] and [4 5] in that order"
;    (is (= :cleopatra (conditions-apply [[2 3] [4 5]]))))
;  (testing "order is wrong"
;    (is (= :tuntun (conditions-apply [3 1]))))
;  (testing "multiple occurance"
;    (is (= :tuntun (conditions-apply [1 3 2 1 3]))))
;  )

(deftest repeat-and-truncate-test
  (testing "repeat and truncate true"
    (is (= '(0 1 2 3 0 1) (repeat-and-truncate (range 4) true true 6))))
  (testing "repeat true truncate false"
    (is (= '(0 1 2 3 0 1 2 3) (repeat-and-truncate (range 4) true false 6))))
  (testing "repeat false truncate true"
    (is (= '(0 1) (repeat-and-truncate (range 4) false true 2))))
  (testing "repeat and truncate false"
    (is (= '(0 1 2 3) (repeat-and-truncate (range 4) false false 6))))
  )

(deftest order-in-words-test
  (testing "x > y > z"
    (is (= [:x-greater-than-y :y-greater-than-z] (order-in-words 4 3 2))))
  (testing "x > y and z > x"
    (is (= [:x-greater-than-y :z-greater-than-x] (order-in-words 4 3 5))))
  (testing "z > x"
    (is (= [:z-greater-than-x] (order-in-words 2 3 4))))
  )

(deftest zero-aliases-test
  (testing "for 0"
    (is (= :zero (zero-aliases 0))))
  (testing "for []"
    (is (= :empty (zero-aliases []))))
  (testing "for '()"
    (is (= :empty (zero-aliases '()))))
  (testing "for #{}"
    (is (= :empty-set (zero-aliases #{}))))
  (testing "for {}"
    (is (= :empty-map (zero-aliases {}))))
  (testing "for \"\" "
    (is (= :empty-string (zero-aliases ""))))
  (testing "for not zero"
    (is (= :not-zero (zero-aliases "as"))))
  (testing "for not zero"
    (is (= :not-zero (zero-aliases [1 2]))))
  )

(deftest zero-separated-palindrome-test
  (testing "given coll"
    (is (= '(4 3 2 0 2 3 4) (zero-separated-palindrome [1 2 3]))))
  )
