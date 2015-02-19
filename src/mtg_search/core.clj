(ns mtg-search.core
  (:require [clojure.data.json :as json]))

(def sets (json/read-str (slurp "resources/test.json")))