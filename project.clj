(defproject kafka-streams-clj "0.1.0-SNAPSHOT"
  :description "Wrapper library around kafka streams"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.9.0"]
                 [org.apache.kafka/kafka-streams "1.1.0"]]
  :main ^:skip-aot kafka-streams-clj.core
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all}})
