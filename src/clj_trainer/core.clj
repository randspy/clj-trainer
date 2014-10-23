(ns clj-trainer.core
  (:require [clj-trainer.read-training-plan :as reader]
            [clj-trainer.parse-traing-plan :as parser]
            [speech-synthesis.say :as say])
  (:gen-class))

(defn display [training-plan]
  (do (println training-plan)
      training-plan))

(defn end-of-the-traning []
  (say/say (display "End of the training.")))

(defn exit []
  (end-of-the-traning)
  (shutdown-agents))

(defn training-step [plan]
  (let [plan-item (first plan)]
    (when (parser/timer? plan-item)
      (Thread/sleep (parser/time-to-miliseconds (display (parser/time_sec plan-item)))))
    (when (parser/text? plan-item)
      (say/say (display (parser/text plan-item))))))

(defn say-training-plan [training-plan]
  (future
    (loop [plan training-plan]
      (if (not (seq plan))
        (exit)
        (do
          (training-step plan)
          (recur (rest plan)))))))

(defn -main [& args]
  (println (say-training-plan (reader/read-lines (first args)))))
