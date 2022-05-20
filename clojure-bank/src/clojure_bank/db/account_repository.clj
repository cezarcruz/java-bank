(ns clojure-bank.db.account-repository)

(def accounts (atom []))

(defn get-account
  ([] @accounts)
  ([id] (filter #(= id (:id %)) @accounts)))

(defn add-account [account]
  (let [account (merge account {:id ( + (count @accounts) 1)})]
    (swap! accounts conj account)
    account))

(defn clear []
  (reset! accounts []))
