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

(comment
  (defn create-affiliation!
    [{data :data {:keys [datomic]} :components}]
    (if-let [result (some-> data
                            adapters.affiliation/affiliation-creation-request->affiliation
                            (controllers.affiliation/create-affiliation! datomic)
                            adapters.affiliation/affiliation->wire-affiliation)]
      {:status 201
       :body   result}
      {:status 400})))