(ns hello-quil.draw
  (:require [quil.core :as q]))

(defn setup_fn []
  (q/background 255)
  (q/stroke 255 0 0)
  (q/stroke-weight 10)
  )

(defn draw_fn []
  (if (q/mouse-pressed?)
    (q/line (q/mouse-x) (q/mouse-y) (q/pmouse-x) (q/pmouse-y)))
  )

(q/defsketch my_draw
    :title "my paint"
    :draw draw_fn
    :setup setup_fn
    :size [640 360]
    )