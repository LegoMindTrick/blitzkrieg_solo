(ns blitzkrieg-solo.core)

(def game-ending-score 25)

(defn print-game-state [game-state]
  (println)
  (println "Axis Score: " (:axis-score game-state))
  (println "Allies Score: " (:allies-score game-state))
  (println)
  )

(defn print-end-state [game-state]
  (println "Game Over!")
  (print-game-state game-state)
  )

(defn run-game [game-state]
  (print-game-state game-state)
  (if (or (>= (:allies-score game-state) game-ending-score)
          (>= (:axis-score game-state) game-ending-score)
          )
    (print-end-state game-state)
    (run-game (assoc game-state :allies-score (+ 1 (:allies-score game-state))))))
