(ns hello-quil.middleware
  (:require [quil.core :as q]))

(defn setup_fn []
 ; (q/smooth)
  (q/frame-rate 30)
  (q/fill 255 0 0))

(defn draw_fn []
  (q/background 0 255 0)
  (q/rect 50 50 150 100))

(defn rotate-me [sketch_map]
  (let [old-draw (:draw sketch_map (fn []))
       period (:period sketch_map 200)
       angle (fn[](q/map-range (mod (q/frame-count) period);winkel
                0 period
                0 q/TWO-PI))
       new-draw (fn []
                (q/with-rotation [(angle)] (old-draw)))
        ]
   (assoc sketch_map :draw new-draw)))

(defn show_framerate [sketch_map]
  (let [old_draw (:draw sketch_map (fn []))
        new_draw (fn []
                 (let [cur_fill (q/current-fill)]
                     (old_draw)
                     (q/fill 0 0 255)
                     (q/text-num (q/current-frame-rate) 10 10)
                     (q/fill cur_fill)
                     ))
        ]
    (assoc sketch_map :draw new_draw)))

(q/defsketch example
  :title "Middleware"              ;Set the title of the sketch
  :setup setup_fn                           ;Specify the setup fn
  :draw draw_fn                             ;Specify the draw fn
  :size [300 200]                           ;Specify the size
  :middleware [show_framerate rotate-me]    ;Specify middlewares
  :period 100)                              ;custome parameter

