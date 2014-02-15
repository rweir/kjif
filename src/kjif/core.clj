(ns kjif.core
  (:require
   [clojure.core.typed :refer [ann check-ns]])
  (:gen-class))

(ann set-dark-feature [Hostname -> (IPersistentMap String String)])
(defn set-dark-feature
  "Set a dark feature to a particular value"
  [data]
  (println (format "Setting a dark feature value" (:hostname data) data))
  (assoc data :seen (conj (:seen data) "set-dark-feature")))

(ann get-dark-feature [Hostname -> (IPersistentMap String String)])
(defn get-dark-feature
  "Get the value of a dark feature"
  [data]
  (println (format "Getting a dark feature value" (:hostname data) data))
  (assoc data :seen (conj (:seen data) "get-dark-feature")))

(ann -main [-> nil] )
(defn -main
  "I don't do a whole lot ... yet."
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
