(ns clojure-bank.router.router
  (:require [clojure-bank.entrypoint.home-entrypoint :as home-entrypoint]
            [clojure-bank.entrypoint.about-entrypoint :as about-entrypoint]
            [clojure-bank.entrypoint.account-entrypoint :as account-entrypoint]
            [io.pedestal.http.body-params :as body-params]
            [io.pedestal.http :as http]))

(def common-interceptors [(body-params/body-params) http/json-body])

; Tabular routes
(def routes #{["/" :get (conj common-interceptors `home-entrypoint/home-page)]
              ["/about" :get (conj common-interceptors `about-entrypoint/about-page)]
              ["/account" :post (conj common-interceptors `account-entrypoint/create-account)]
              ["/account" :get (conj common-interceptors `account-entrypoint/get-some-accounts)]
              ["/account/:id" :get (conj common-interceptors `account-entrypoint/get-one-account)]})
