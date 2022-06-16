(ns clojure-bank.integration.account-it-test
  (:require [clojure.test :refer :all]
            [io.pedestal.test :refer :all]
            [io.pedestal.http :as bootstrap]
            [clojure-bank.service :as service]
            [cheshire.core :as json]))

(def service
  (::bootstrap/service-fn (bootstrap/create-servlet service/service)))

(def account-in {:agency "001"})

(deftest home-page-test
  (is (= (:body (response-for service :get "/")
           "Hello World! XXX"))))

(deftest create-an-account
  (is (= (:body (response-for service
                                :post "/account"
                                :headers {"Content-Type" "application/json"}
                                :body (json/encode account-in))) 201)))
