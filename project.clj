(defproject kjif "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.5.1"]
                 [http-kit "2.1.16"]
                 [org.clojure/core.async "0.1.267.0-0d7780-alpha"]
                 [org.clojure/core.typed "0.2.30"]]
  :plugins [[lein-typed "0.3.1"]]
  :core.typed {:check [kjif.core]}
  :main ^:skip-aot kjif.core
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all}})
