(ns blitzkrieg-solo.components)

(def unit-catalog {
                   :one-ship    {:value   1
                                 :terrain [:sea]
                                 }
                   :two-ship    {:value   2
                                 :terrain [:sea]
                                 }
                   :three-ship  {:value   3
                                 :terrain [:sea]
                                 }
                   :one-tank    {:value   1
                                 :terrain [:land]
                                 }
                   :two-tank    {:value   2
                                 :terrain [:land]
                                 }
                   :three-tank  {:value   3
                                 :terrain [:land]
                                 }
                   :blitz-plane {:value   0
                                 :terrain [:sea :land]
                                 :effect  [:blitz]
                                 }
                   :one-plane   {:value   1
                                 :terrain [:sea :land]
                                 }
                   :two-plane   {:value   2
                                 :terrain [:sea :land]
                                 }
                   :admiral     {:terrain [:sea]
                                 :effect  [:admiral]
                                 }
                   :general     {:terrain [:land]
                                 :effect  [:general]
                                 }
                   :blitz-ship  {:value   1
                                 :terrain [:sea]
                                 :effect  [:blitz]
                                 }
                   :bomb-ship   {:value   1
                                 :terrain [:sea]
                                 :effect  [:bomb]
                                 }
                   :four-ship   {:value   4
                                 :terrain [:sea]
                                 }
                   :task-ship   {:value   5
                                 :terrain [:sea]
                                 :effect  [:task]
                                 }
                   :blitz-tank  {:value   1
                                 :terrain [:land]
                                 :effect  [:blitz]
                                 }
                   :four-tank   {:value   4
                                 :terrain [:land]
                                 }
                   :task-tank   {:value   5
                                 :terrain [:land]
                                 :effect  [:task]
                                 }
                   :bomb-plane  {:value   1
                                 :terrain [:land :sea]
                                 :effect  [:bomb]
                                 }
                   :three-plane {:value   3
                                 :terrain [:sea :land]
                                 }
                   :task-plane  {:value   4
                                 :terrain [:sea :land]
                                 :effect  [:task]
                                 }
                   :scientist   {:terrain [:land]
                                 :effect  [:scientist]
                                 }
                   :spy         {:terrain [:land]
                                 :effect  [:spy]
                                 }
                   :nuke        {:terrain [:land]
                                 :effect  [:nuke]
                                 }
                   }
  )
(def base-game-starting-state {:axis-score   0
                               :allies-score 0
                               :axis-bag     [
                                              {:value   1
                                               :terrain [:land]
                                               :faction :axis
                                               }
                                              {:value   0
                                               :terrain [:sea :land]
                                               :faction :axis
                                               :effect  [:blitz]
                                               }
                                              {:value 3
                                               :terrain}
                                              ]
                               :theaters     [
                                              {:name          :pacific-ocean
                                               :pretty-name   "Pacific Ocean"
                                               :closed        false
                                               :max-score     14
                                               :min-score     -14
                                               :current-score 0
                                               :vp-locations  [-10 -5 5 10]
                                               :campaigns     [
                                                               {:vp            2
                                                                :battle-spaces [
                                                                                {:effect  [:bomb]
                                                                                 :terrain [:sea]
                                                                                 }
                                                                                {:effect  [:research]
                                                                                 :terrain [:sea]
                                                                                 }
                                                                                ]
                                                                }
                                                               {:vp            3
                                                                :battle-spaces [
                                                                                {:effect  [:research :research]
                                                                                 :terrain [:sea]
                                                                                 }
                                                                                {:effect  [:factory]
                                                                                 :terrain [:sea]
                                                                                 }
                                                                                {:effect  [:strategy :strategy]
                                                                                 :terrain [:sea]
                                                                                 }
                                                                                {:terrain [:sea :land]}
                                                                                ]
                                                                }
                                                               {:vp            5
                                                                :battle-spaces [
                                                                                {:effect  [:bomb]
                                                                                 :terrain [:sea]
                                                                                 }
                                                                                {:effect  [:vp :vp]
                                                                                 :terrain [:sea :land]
                                                                                 }
                                                                                {:terrain [:sea :land]
                                                                                 }
                                                                                ]
                                                                }
                                                               ]
                                               }
                                              {:name          :western-europe
                                               :pretty-name   "Western Europe"
                                               :closed        false
                                               :max-score     14
                                               :min-score     -14
                                               :current-score 0
                                               :vp-locations  [-10 -5 5 10]
                                               :campaigns     [
                                                               {:vp            2
                                                                :battle-spaces [
                                                                                {:effect  [:factory]
                                                                                 :terrain [:sea]
                                                                                 }
                                                                                {:effect  [:research]
                                                                                 :terrain [:land]
                                                                                 }
                                                                                {:effect  [:vp]
                                                                                 :terrain [:sea :land]
                                                                                 }
                                                                                ]
                                                                }
                                                               {:vp            3
                                                                :battle-spaces [
                                                                                {:effect  [:bomb]
                                                                                 :terrain [:land]
                                                                                 }
                                                                                {:effect  [:factory]
                                                                                 :terrain [:land]
                                                                                 }
                                                                                {:terrain [:sea :land]
                                                                                 }
                                                                                ]
                                                                }
                                                               {:vp            5
                                                                :battle-spaces [
                                                                                {:effect  [:factory :research]
                                                                                 :terrain [:sea :land]
                                                                                 }
                                                                                {:effect  [:strategy :strategy :strategy]
                                                                                 :terrain [:sea :land]
                                                                                 }
                                                                                {:terrain [:sea :land]
                                                                                 }
                                                                                ]
                                                                }
                                                               ]
                                               }
                                              {:name          :eastern-europe
                                               :pretty-name   "Eastern Europe"
                                               :closed        false
                                               :max-score     14
                                               :min-score     -14
                                               :current-score 0
                                               :vp-locations  -10 -5 5 10
                                                              :campaigns [
                                                                          {:vp            2
                                                                           :battle-spaces [
                                                                                           {:effect  [:tactical]
                                                                                            :terrain [:land]
                                                                                            }
                                                                                           {:effect  [:factory]
                                                                                            :terrain [:land]
                                                                                            }
                                                                                           ]
                                                                           }
                                                                          {:vp            3
                                                                           :battle-spaces [
                                                                                           {:effect  [:vp]
                                                                                            :terrain [:land]
                                                                                            }
                                                                                           {:effect  [:research :research]
                                                                                            :terrain [:land]
                                                                                            }
                                                                                           {:terrain [:sea :land]
                                                                                            }
                                                                                           ]
                                                                           }
                                                                          {:vp            6
                                                                           :battle-spaces [

                                                                                           {:effect  [:bomb]
                                                                                            :terrain [:land]
                                                                                            }
                                                                                           {:effect  [:tactical :tactical]
                                                                                            :terrain [:land]
                                                                                            }
                                                                                           {:effect  [:strategy :strategy :strategy]
                                                                                            :terrain [:land]
                                                                                            }
                                                                                           {:effect  [:vp :vp]
                                                                                            :terrain [:land]
                                                                                            }
                                                                                           {:terrain [:land]
                                                                                            }
                                                                                           ]
                                                                           }
                                                                          ]
                                               }
                                              {:name          :africa-and-middle-east
                                               :pretty-name   "Africa and Middle East"
                                               :closed        false
                                               :max-score     11
                                               :min-score     -11
                                               :current-score 0
                                               :vp-locations  -8 -4 4 8
                                                              :campaigns [
                                                                          {:vp            3
                                                                           :battle-spaces [
                                                                                           {:effect  [:strategy :strategy :strategy]
                                                                                            :terrain [:land]
                                                                                            }
                                                                                           {:effect  [:tactical]
                                                                                            :terrain [:sea]
                                                                                            }
                                                                                           {:effect  [:research]
                                                                                            :terrain [:sea :land]
                                                                                            }
                                                                                           {:effect  [:vp]
                                                                                            :terrain [:sea :land]
                                                                                            }]

                                                                           }
                                                                          {:vp            5
                                                                           :battle-spaces [
                                                                                           {:effect  [:tactical :tactical]
                                                                                            :terrain [:land]
                                                                                            }
                                                                                           {:effect  [:factory :factory]
                                                                                            :terrain [:sea]
                                                                                            }
                                                                                           {:terrain [:sea :land]
                                                                                            }
                                                                                           ]
                                                                           }
                                                                          ]
                                               }
                                              {:name         :south-east-asia
                                               :pretty-name  "South East Asia"
                                               :closed       false
                                               :max-score    11
                                               :min-score    -11
                                               :vp-locations -8 -4 4 8
                                                             :campaigns [
                                                                         {:vp            2
                                                                          :battle-spaces [
                                                                                          {:effect  [:vp :vp]
                                                                                           :terrain [:sea]
                                                                                           }
                                                                                          {:effect  [:vp]
                                                                                           :terrain [:sea :land]
                                                                                           }
                                                                                          {:effect  [:strategy]
                                                                                           :terrain [:sea :land]
                                                                                           }]
                                                                          }
                                                                         {:vp            4
                                                                          :battle-spaces [
                                                                                          {:effect  [:bomb]
                                                                                           :terrain [:sea]
                                                                                           }
                                                                                          {:effect  [:vp :vp]
                                                                                           :terrain [:land]
                                                                                           }
                                                                                          {:terrain [:sea :land]
                                                                                           }
                                                                                          ]
                                                                          }
                                                                         ]
                                               }
                                              ]
                               })