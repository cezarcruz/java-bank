(ns clojure-bank.diplomat.http-in.account
  (:require [clojure-bank.adapters.account :as adapters.account]
            [clojure-bank.db.memory.account-repository :as db.account]))

(defn create-account!
  [{body :json-params}]
  (if-let [result (some-> body
                          adapters.account/account-creation-request->account
                          db.account/save
                          adapters.account/account->wire-account)]
    {:status 201
     :body   result}
    {:status 400}))

(defn get-account [request]
  (let [account-id (get-in request [:path-params :account-id])]
    (if-let [result (some-> (db.account/get-by account-id)
                            adapters.account/account->wire-account)]
      {:status  200
       :body    result}
      {:status  404})))

(defn get-balance [request]
  (let [account-id  (get-in request [:path-params :account])
        agency-id   (get-in request [:path-params :agency])]
    {:status 200
     :body {:account  account-id
            :agency   agency-id}}))
