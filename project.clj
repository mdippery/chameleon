(defproject chameleon "1.0.0"
  :description "Takes samples of Stack Overflow reputation over time"
  :url "https://github.com/mdippery/chameleon"
  :license {:name "3-Clause BSD"
            :url "http://opensource.org/licenses/BSD-3-Clause"}
  :dependencies [[org.clojure/clojure "1.6.0"]
                 [clj-http "0.9.1"]
                 [org.clojure/data.json "0.2.4"]
                 [com.novemberain/monger "2.0.0-rc1"]]
  :main ^:skip-aot chameleon.core
  :target-path "target/%s"
  :jar-name "chameleon.jar"
  :uberjar-name "chameleon-standalone.jar"
  :profiles {:uberjar {:aot :all}})
