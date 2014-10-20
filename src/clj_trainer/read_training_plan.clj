(ns clj-trainer.read-training-plan
  (:require [clojure.java.io :as io]))

(defn read-lines [filename]
  (let [reader-handlar (io/reader filename)]
    (defn read-next-line []
      (if-let [line (.readLine reader-handlar)]
        (cons line (lazy-seq (read-next-line)))
        (.close reader-handlar)))
    (lazy-seq (read-next-line))))
