(ns clj-trainer.core
  (:require [clj-trainer.read-training-plan :as reader]
            [clj-trainer.parse-traing-plan :as parser]
            [speech-synthesis.say :as say]))


(defn end-of-the-traning []
  (say/say "End of the training."))

(defn say-training-plan [training-plan]
  (future
    (loop [plan training-plan]
      (if (not (seq plan))
        (end-of-the-traning)
        (do
          (let [plan-item (first plan)]
            (when (parser/timer? plan-item)
              (Thread/sleep (parser/timer plan-item)))
            (when (parser/text? plan-item)
              (say/say (parser/text plan-item)))
            (recur (rest plan))))))))

(say-training-plan (reader/read-lines "/home/sgluter/Programming/projects/clj-trainer/src/clj_trainer/test-file.txt"))

