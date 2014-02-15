(ns kjif.core
  (:require
   [clojure.core.typed :refer [ann check-ns]])
  (:gen-class))

(ann -main [-> nil] )
(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println "Hello, World!"))

(comment
  (check-ns)
)
