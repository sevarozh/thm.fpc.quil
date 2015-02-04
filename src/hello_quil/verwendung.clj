(ns hello-quil.verwendung
  (:require [quil.core :as q]))

(defn setup_fn []
  (q/frame-rate 30)
  (q/fill 0 255 0))

(defn draw_fn []
  (q/background   0 255 0)
  (q/rect 50 50 150 100)
  (q/ellipse 50 50 100 70)
  )

(q/defsketch example
  :title "Verwendung von Quil"              ;Set the title of the sketch
  :setup setup_fn                           ;Specify the setup fn
  :draw draw_fn                             ;Specify the draw fn
  :size [300 200])                          ;Specify the size


