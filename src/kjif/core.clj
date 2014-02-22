(ns kjif.core
  (:require
   [clojure.core.typed :refer [ann check-ns def-alias Map]]
   [clojure.pprint :refer [pprint]])
  (:gen-class))

(def-alias Hostname String)
(def-alias InfoMap '[Map clojure.lang.Keyword Any])
(def-alias PassMap [InfoMap -> InfoMap])

(ann set-dark-feature PassMap)
(defn set-dark-feature
  "Set a dark feature to a particular value"
  [data]
  (println (format "Setting a dark feature value" (:hostname data) data))
  (assoc-in data [:set-dark-feature "feature"] "XXX")
  (assoc data :set-d true))

(ann get-dark-feature PassMap)
(defn get-dark-feature
  "Get the value of a dark feature"
  [data]
  (println (format "Getting a dark feature value" (:hostname data) data))
  (assoc data :get-d true))

(defn exec-step
  [data step]
  (let [result (step data)]
    (println (format "Exec'ing step: %s with data: %s and result: %s" step data result))
    (assoc data :saw (conj (:saw data) step))
    result))

(defn do-one-host
  "Run the steps over one host"
  [host steps]
  (reduce exec-step {:hostname host} steps))

(defn do-all-hosts
  "Run the steps over the hosts"
  [hosts steps]
  (let [result {}]
    (merge (map #(do-one-host % steps) hosts))))

(def-alias doit do-all-hosts)

(ann ^:no-check -main [String * -> nil])
(defn -main
  "Run the provided set of steps"
  [& args]
  (let [hosts [{:hostname "foo.example.net"} {:hostname "bar.example.net"}]]
    (let [steps [set-dark-feature get-dark-feature]
          results (doit hosts steps)]
      (pprint results))))

(comment
  (check-ns)
  )
