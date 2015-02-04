(ns hello-quil.fun-mode
  (:require [quil.core :as q]
            [quil.middleware :as m]))

(defn setup []
  (q/fill 255 0 0)
  {:x (/ (q/width) 2) :y (/ (q/height) 2) :r 30})


(defn draw [state]
  (q/background 255)
  (q/ellipse (:x state) (:y state) (:r state) (:r state)))


(defn mouse-moved [state event]
  (assoc state :x (:x event) :y (:y event)))

(q/defsketch example
   :title "fun-mode"
   :setup setup
   :draw draw
   :mouse-moved mouse-moved
   :middleware [m/fun-mode]
   )

