(ns blitzkrieg-solo.utils)

(defn unit-battle-space-terrain-match? [unit battle-space]
  (not (empty? (clojure.set/intersection (:terrain unit) (:terrain battle-space)))))

(defn calculate-effect [effect])

(defn place-unit-in-campaign [game-state theater-key campaign-pos battle-space-pos unit]
  (let [theaters (:theaters game-state)
        theater (theater-key theaters)
        campaigns (:campaigns theater)
        campaign-pos-key (keyword (str campaign-pos))
        campaign (campaign-pos-key campaigns)
        battle-spaces (:battle-spaces campaign)
        battle-space-pos-key (keyword (str battle-space-pos))
        battle-space (battle-space-pos-key battle-spaces)
        updated-battle-space (assoc battle-space :unit unit)
        updated-battle-spaces (assoc battle-spaces battle-space-pos-key updated-battle-space)
        updated-campaign (assoc campaign :battle-spaces updated-battle-spaces)
        updated-campaigns (assoc campaigns campaign-pos-key updated-campaign)
        updated-theater (assoc theater :campaigns updated-campaigns)
        updated-theaters (assoc theaters theater-key updated-theater)
        updated-game-state (assoc game-state :theaters updated-theaters)]

    updated-game-state
    )
  )

(defn calculate-score [game-state]
  )

(defn make-player-move [game-state combatant unit theater campaign position]
  )

(defn add-bag-ids [bag combatant]
  (let [bag-label (if (= :axis combatant) "axis-bag" "allies-bag")]
    (map-indexed (fn [idx itm]
           (assoc itm :bag-id
             (keyword (str bag-label "-" idx))))
         bag)))

