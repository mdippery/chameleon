(defproject chameleon "1.0.0"
  :description "Takes samples of Stack Overflow reputation over time"
  :url "https://github.com/mdippery/chameleon"
  :license {:name "3-Clause BSD"
            :url "http://opensource.org/licenses/BSD-3-Clause"}
  :dependencies [[org.clojure/clojure "1.5.1"]
                 [clj-http "0.6.3"]
                 [org.clojure/data.json "0.2.4"]]
  :main ^:skip-aot chameleon.core
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all}})
