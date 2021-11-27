(ns blitzkrieg-solo.render
  (:require [clojure.string :require :all]))

(defn get-unit-display-name [unit]
  (let [terrain-name (:terrain unit)]
    (case terrain-name
      #{:land} "Tank"
      #{:sea} "Ship"
      "Plane")))

(defn get-battle-space-terrain [battle-space]
  (let [terrain-name (:terrain battle-space)]
    (case terrain-name
      #{:sea} "Sea"
      #{:land} "Land"
      "Island"
      )))

(defn effect-names-string [battle-space]
  (let [effect (:effect battle-space)
        effect-names (map #(case %
                             :research "Research"
                             :tactical "Tactical"
                             :strategy "Strategy"
                             :bomb "Bomb"
                             :factory "Production"
                             "UNKNOWN EFFECT") effect)]
    (clojure.string/join "/" effect-names)
    ))

(defn print-battle-space [battle-space]
  (print (str "Terrain - " (get-battle-space-terrain battle-space)))
  (print (str "Effect - " (effect-names-string battle-space))))

(defn print-unit [unit]
  (print (str "Unit - " (get-unit-display-name unit)))
  (print (str "; Value - " (:value unit))))

(defn print-campaign [campaign]
  (let [battle-spaces (vals (:battle-spaces campaign))]
    (map #(print-battle-space %) battle-spaces)))

(defn print-theater [theater]
  (let [campaigns (vals (:campaigns theater))]
    (map #(print-campaign %) campaigns)))

(defn print-map [game-state]
  (let [theaters (vals (:theaters game-state))]
    (map (fn [theater]
           (print-theater theater)
           (println))
         theaters)))