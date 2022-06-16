(ns clojure-bank.diplomat.http-in.account
  (:require [clojure-bank.adapters.account :as adapters.account]))

(defn create-account!
  [{body :json-params}]
  (if-let [result (some-> body
                          adapters.account/account-creation-request->account
                          ;(do something here, what?)
                          adapters.account/account->wire-account)]
    {:status 201
     :body   result}
    {:status 400}))
