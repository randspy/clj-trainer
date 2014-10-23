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


(defn time_sec [plan-item]
  (let [timer-index 7]
    (.substring plan-item timer-index)))

(defn time-to-miliseconds [time]
  (* 1000 (parse-int time)))
