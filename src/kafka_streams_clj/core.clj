(ns kafka-streams-clj.core
  (:gen-class)
  (:import (org.apache.kafka.streams.kstream KeyValueMapper Predicate KStream)
           (org.apache.kafka.streams KeyValue StreamsBuilder)))

(defn ^StreamsBuilder builder []
  (StreamsBuilder.))

(defn stream
  ([builder ^String topic]
   (.stream builder topic)))

(defn get-keyval-mapper [map-func]
  (reify KeyValueMapper
    (apply [_ key value]
      (let [res (map-func key value)]
        (KeyValue/pair (:key res) (:value res))))))

(defn get-predicate [predicate-func]
  (reify Predicate
    (test [_ key value] (predicate-func key value))))

(defn flatmap [^KStream stream ^KeyValueMapper mapper]
  (.flatMap stream mapper))

(defn branch [^KStream stream & ^Predicate predicates]
  (.branch stream
           (into-array Predicate predicates)))