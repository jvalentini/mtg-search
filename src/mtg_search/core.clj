(ns mtg-search.core
  (:require [clojurewerkz.elastisch.rest :as esr]
            [clojurewerkz.elastisch.rest.index :as esi]
            [clojurewerkz.elastisch.rest.document :as esd]
            [clojurewerkz.elastisch.query         :as q]
            [clojurewerkz.elastisch.rest.response :as esrsp]
            [clojure.data.json :as json]
            [clojure.pprint :refer [pprint]]))

(def sets (json/read-str (slurp "resources/test.json")))

(def conn (esr/connect "https://p60kwkn5be:gm92hykkfm@mtg-3464019877.us-east-1.bonsai.io"))

(defn index [card]
  (esd/create conn "mtg" "card" card))

(doall (map index sets))

(let [res  (esd/search conn "mtg" "card" :query (q/wildcard :imageName "*"))
      n    (esrsp/total-hits res)
      hits (esrsp/hits-from res)]
  (println (format "Total hits: %d" n))
  (pprint hits))