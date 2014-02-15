(ns kjif.core
  (:require
   [clojure.core.typed :refer [ann check-ns def-alias Map]])
  (:gen-class))

(def-alias Hostname String)
(def-alias InfoMap '[Map clojure.lang.Keyword Any])
(def-alias PassMap [InfoMap -> InfoMap])

(ann set-dark-feature PassMap)
(defn set-dark-feature
  "Set a dark feature to a particular value"
  [data]
  (println (format "Setting a dark feature value" (:hostname data) data))
  data)

(ann get-dark-feature PassMap)
(defn get-dark-feature
  "Get the value of a dark feature"
  [data]
  (println (format "Getting a dark feature value" (:hostname data) data))
  data)

(ann ^:no-check -main [String * -> nil])
(defn -main
  "Run the provided set of steps"
  [& args]
  (let [hosts [{:hostname "foo.atlassian.net"} {:hostname "bar.atlassian.net"}]]
    (doall (map (fn [host]
            (-> host
                (set-dark-feature)
                (get-dark-feature)
                (println)))
          hosts))))

(comment
  (check-ns)
)
