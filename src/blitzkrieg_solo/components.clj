(ns blitzkrieg-solo.components
  (:require [blitzkrieg-solo.utils :refer :all]))

(def unit-catalog {
                   :one-ship    {:value   1
                                 :terrain #{:sea}
                                 }
                   :two-ship    {:value   2
                                 :terrain #{:sea}
                                 }
                   :three-ship  {:value   3
                                 :terrain #{:sea}
                                 }
                   :one-tank    {:value   1
                                 :terrain #{:land}
                                 }
                   :two-tank    {:value   2
                                 :terrain #{:land}
                                 }
                   :three-tank  {:value   3
                                 :terrain #{:land}
                                 }
                   :blitz-plane {:value   0
                                 :terrain #{:sea :land}
                                 :effect  [:blitz]
                                 }
                   :one-plane   {:value   1
                                 :terrain #{:sea :land}
                                 }
                   :two-plane   {:value   2
                                 :terrain #{:sea :land}
                                 }
                   :admiral     {:terrain #{:sea}
                                 :effect  [:admiral]
                                 }
                   :general     {:terrain #{:land}
                                 :effect  [:general]
                                 }
                   :blitz-ship  {:value   1
                                 :terrain #{:sea}
                                 :effect  [:blitz]
                                 }
                   :bomb-ship   {:value   1
                                 :terrain #{:sea}
                                 :effect  [:bomb]
                                 }
                   :four-ship   {:value   4
                                 :terrain #{:sea}
                                 }
                   :task-ship   {:value   5
                                 :terrain #{:sea}
                                 :effect  [:task]
                                 }
                   :blitz-tank  {:value   1
                                 :terrain #{:land}
                                 :effect  [:blitz]
                                 }
                   :four-tank   {:value   4
                                 :terrain #{:land}
                                 }
                   :task-tank   {:value   5
                                 :terrain #{:land}
                                 :effect  [:task]
                                 }
                   :bomb-plane  {:value   1
                                 :terrain #{:land :sea}
                                 :effect  [:bomb]
                                 }
                   :three-plane {:value   3
                                 :terrain #{:sea :land}
                                 }
                   :task-plane  {:value   4
                                 :terrain #{:sea :land}
                                 :effect  [:task]
                                 }
                   :scientist   {:terrain #{:land}
                                 :effect  [:scientist]
                                 }
                   :spy         {:terrain #{:land}
                                 :effect  [:spy]
                                 }
                   :nuke        {:terrain #{:land}
                                 :effect  [:nuke]
                                 }
                   }
  )

(def research-pile [
                    (assoc (:four-ship unit-catalog) :bag-id :r1)
                    (assoc (:four-ship unit-catalog) :bag-id :r2)
                    (assoc (:task-ship unit-catalog) :bag-id :r3)
                    (assoc (:bomb-ship unit-catalog) :bag-id :r4)
                    (assoc (:blitz-ship unit-catalog) :bag-id :r5)
                    (assoc (:nuke unit-catalog) :bag-id :r6)
                    (assoc (:blitz-tank unit-catalog) :bag-id :r7)
                    (assoc (:four-tank unit-catalog):bag-id :r8)
                    (assoc (:four-tank unit-catalog) :bag-id :r9)
                    (assoc (:task-tank unit-catalog) :bag-id :r10)
                    (assoc (:bomb-plane unit-catalog) :bag-id :r11)
                    (assoc (:three-plane unit-catalog) :bag-id :r12)
                    (assoc (:three-plane unit-catalog) :bag-id :r13)
                    (assoc (:task-plane unit-catalog) :bag-id :r14)
                    (assoc (:spy unit-catalog) :bag-id :r15)
                    (assoc (:scientist unit-catalog) :bag-id :r16)
                    ]
  )

(def starting-bag [
                   (:admiral unit-catalog)
                   (:general unit-catalog)
                   (:blitz-plane unit-catalog)
                   (:one-plane unit-catalog)
                   (:one-plane unit-catalog)
                   (:one-plane unit-catalog)
                   (:two-plane unit-catalog)
                   (:two-plane unit-catalog)
                   (:one-tank unit-catalog)
                   (:one-tank unit-catalog)
                   (:one-tank unit-catalog)
                   (:two-tank unit-catalog)
                   (:two-tank unit-catalog)
                   (:three-tank unit-catalog)
                   (:three-tank unit-catalog)
                   (:one-ship unit-catalog)
                   (:one-ship unit-catalog)
                   (:one-ship unit-catalog)
                   (:two-ship unit-catalog)
                   (:two-ship unit-catalog)
                   (:three-ship unit-catalog)
                   (:three-ship unit-catalog)
                   ]
  )

(def base-game-starting-state {:axis-score    0
                               :allies-score  0
                               :axis-bag      (add-bag-ids starting-bag :axis)
                               :allies-bag    (add-bag-ids starting-bag :allies)
                               :axis-hand     []
                               :allies-hand   []
                               :research-pile research-pile
                               :theaters      {:pacific-ocean
                                               {:name          :pacific-ocean
                                                :pretty-name   "Pacific Ocean"
                                                :closed        false
                                                :max-score     14
                                                :min-score     -14
                                                :current-score 0
                                                :vp-locations  [-10 -5 5 10]
                                                :campaigns     {:0
                                                                {:vp            2
                                                                 :battle-spaces {
                                                                                 :0
                                                                                 {:effect  [:bomb]
                                                                                  :terrain #{:sea}
                                                                                  }
                                                                                 :1
                                                                                 {:effect  [:research]
                                                                                  :terrain #{:sea}
                                                                                  }}

                                                                 }
                                                                :1
                                                                {:vp            3
                                                                 :battle-spaces {:0
                                                                                 {:effect  [:research :research]
                                                                                  :terrain #{:sea}
                                                                                  }
                                                                                 :1
                                                                                 {:effect  [:factory]
                                                                                  :terrain #{:sea}
                                                                                  }
                                                                                 :2
                                                                                 {:effect  [:strategy :strategy]
                                                                                  :terrain #{:sea}
                                                                                  }
                                                                                 :3
                                                                                 {:terrain #{:sea :land}}}

                                                                 }
                                                                :2
                                                                {:vp            5
                                                                 :battle-spaces {
                                                                                 :0
                                                                                 {:effect  [:bomb]
                                                                                  :terrain #{:sea}
                                                                                  }
                                                                                 :1
                                                                                 {:effect  [:vp :vp]
                                                                                  :terrain #{:sea :land}
                                                                                  }
                                                                                 :2
                                                                                 {:terrain #{:sea :land}
                                                                                  }}

                                                                 }}
                                                }
                                               :western-europe
                                               {:name          :western-europe
                                                :pretty-name   "Western Europe"
                                                :closed        false
                                                :max-score     14
                                                :min-score     -14
                                                :current-score 0
                                                :vp-locations  [-10 -5 5 10]
                                                :campaigns     {:0
                                                                {:vp            2
                                                                 :battle-spaces {
                                                                                 :0
                                                                                 {:effect  [:factory]
                                                                                  :terrain #{:sea}
                                                                                  }
                                                                                 :1
                                                                                 {:effect  [:research]
                                                                                  :terrain #{:land}
                                                                                  }
                                                                                 :2
                                                                                 {:effect  [:vp]
                                                                                  :terrain #{:sea :land}
                                                                                  }}

                                                                 }
                                                                :1
                                                                {:vp            3
                                                                 :battle-spaces {
                                                                                 :0
                                                                                 {:effect  [:bomb]
                                                                                  :terrain #{:land}
                                                                                  }
                                                                                 :1
                                                                                 {:effect  [:factory]
                                                                                  :terrain #{:land}
                                                                                  }
                                                                                 :2
                                                                                 {:terrain #{:sea :land}
                                                                                  }}
                                                                 }
                                                                :2
                                                                {:vp            5
                                                                 :battle-spaces {
                                                                                 :0
                                                                                 {:effect  [:factory :research]
                                                                                  :terrain #{:sea :land}
                                                                                  }
                                                                                 :1
                                                                                 {:effect  [:strategy :strategy :strategy]
                                                                                  :terrain #{:sea :land}
                                                                                  }
                                                                                 :2
                                                                                 {:terrain #{:sea :land}
                                                                                  }}

                                                                 }}

                                                }
                                               :eastern-europe
                                               {:name          :eastern-europe
                                                :pretty-name   "Eastern Europe"
                                                :closed        false
                                                :max-score     14
                                                :min-score     -14
                                                :current-score 0
                                                :vp-locations  [-10 -5 5 10]
                                                :campaigns     {
                                                                :0
                                                                {:vp            2
                                                                 :battle-spaces {
                                                                                 :0
                                                                                 {:effect  [:tactical]
                                                                                  :terrain #{:land}
                                                                                  }
                                                                                 :1
                                                                                 {:effect  [:factory]
                                                                                  :terrain #{:land}
                                                                                  }}

                                                                 }
                                                                :1
                                                                {:vp            3
                                                                 :battle-spaces {
                                                                                 :0
                                                                                 {:effect  [:vp]
                                                                                  :terrain #{:land}
                                                                                  }
                                                                                 :1
                                                                                 {:effect  [:research :research]
                                                                                  :terrain #{:land}
                                                                                  }
                                                                                 :2
                                                                                 {:terrain #{:sea :land}
                                                                                  }}

                                                                 }
                                                                :2
                                                                {:vp            6
                                                                 :battle-spaces {
                                                                                 :0
                                                                                 {:effect  [:bomb]
                                                                                  :terrain #{:land}
                                                                                  }
                                                                                 :1
                                                                                 {:effect  [:tactical :tactical]
                                                                                  :terrain #{:land}
                                                                                  }
                                                                                 :2
                                                                                 {:effect  [:strategy :strategy :strategy]
                                                                                  :terrain #{:land}
                                                                                  }
                                                                                 :3
                                                                                 {:effect  [:vp :vp]
                                                                                  :terrain #{:land}
                                                                                  }
                                                                                 :4
                                                                                 {:terrain #{:land}
                                                                                  }}
                                                                 }
                                                                }
                                                :africa-and-middle-east
                                                               {:name          :africa-and-middle-east
                                                                :pretty-name   "Africa and Middle East"
                                                                :closed        false
                                                                :max-score     11
                                                                :min-score     -11
                                                                :current-score 0
                                                                :vp-locations  [-8 -4 4 8]
                                                                :campaigns     {
                                                                                :0
                                                                                {:vp            3
                                                                                 :battle-spaces {
                                                                                                 :0
                                                                                                 {:effect  [:strategy :strategy :strategy]
                                                                                                  :terrain #{:land}
                                                                                                  }
                                                                                                 :1
                                                                                                 {:effect  [:tactical]
                                                                                                  :terrain #{:sea}
                                                                                                  }
                                                                                                 :2
                                                                                                 {:effect  [:research]
                                                                                                  :terrain #{:sea :land}
                                                                                                  }
                                                                                                 :3
                                                                                                 {:effect  [:vp]
                                                                                                  :terrain #{:sea :land}
                                                                                                  }}
                                                                                 }
                                                                                :1
                                                                                {:vp            5
                                                                                 :battle-spaces {
                                                                                                 :0
                                                                                                 {:effect  [:tactical :tactical]
                                                                                                  :terrain #{:land}
                                                                                                  }
                                                                                                 :1
                                                                                                 {:effect  [:factory :factory]
                                                                                                  :terrain #{:sea}
                                                                                                  }
                                                                                                 :2
                                                                                                 {:terrain #{:sea :land}
                                                                                                  }}

                                                                                 }}

                                                                }
                                                }
                                               :south-east-asia
                                               {:name         :south-east-asia
                                                :pretty-name  "South East Asia"
                                                :closed       false
                                                :max-score    11
                                                :min-score    -11
                                                :vp-locations [-8 -4 4 8]
                                                :campaigns    {
                                                               :0
                                                               {:vp            2
                                                                :battle-spaces {
                                                                                :0
                                                                                {:effect  [:vp :vp]
                                                                                 :terrain #{:sea}
                                                                                 }
                                                                                :1
                                                                                {:effect  [:vp]
                                                                                 :terrain #{:sea :land}
                                                                                 }
                                                                                :2
                                                                                {:effect  [:strategy]
                                                                                 :terrain #{:sea :land}
                                                                                 }}
                                                                }
                                                               :1
                                                               {:vp            4
                                                                :battle-spaces {
                                                                                :0
                                                                                {:effect  [:bomb]
                                                                                 :terrain #{:sea}
                                                                                 }
                                                                                :1
                                                                                {:effect  [:vp :vp]
                                                                                 :terrain #{:land}
                                                                                 }
                                                                                :2
                                                                                {:terrain #{:sea :land}
                                                                                 }}

                                                                }}

                                                }
                                               }
                               }
  )