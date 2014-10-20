(ns clj-trainer.parse-traing-plan)

(defn text? [plan-item]
  (.startsWith plan-item "text"))

(defn text [plan-item]
  (let [text-index 6]
    (.substring plan-item text-index)))

(defn timer? [plan-item]
  (.startsWith plan-item "timer"))

(defn parse-int [s]
  (Integer. (re-find  #"\d+" s )))

(defn timer [plan-item]
  (let [timer-index 7]
    (* 1000 (parse-int (.substring plan-item timer-index)))))