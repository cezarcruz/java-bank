(ns clojure-bank.entrypoint.account-entrypoint
  (:require [ring.util.response :as ring-resp]
            [clojure-bank.db.account-repository :refer [add-account get-account]])
  (:import (java.util UUID)))

(defn generate-uuid [account]
  {:agency (:agency account)
   :account (UUID/randomUUID)})

(defn create-account
  [{:keys [json-params]}]
  (-> (generate-uuid json-params)
      (add-account)
      (ring-resp/response); I can use the /created, but it needs an url
      (merge {:status 201}))) ;this code replaces http status, thinking about your location

(defn get-some-accounts [_]
  "get some accounts controller"
  (ring-resp/response (get-account)))

(defn get-one-account [request]
  (let [id (get-in request [:path-params :id])]
    (ring-resp/response (get-account (Integer/parseInt id)))))
