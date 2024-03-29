(ns hillshire-tv.test.handler
  (:use clojure.test
        ring.mock.request
        hillshire-tv.handler))

(deftest test-app
  (testing "main route"
    (let [response (app (request :get "/"))]
      (is (= 200 (:status response)))))

  (testing "custom route"
    (let [response (app (request :get "/YEE"))]
      (is (= 200 (:status response)))))

  (testing "custom route case insensitive"
        (let [response (app (request :get "/momo"))
              response2 (app (request :get "/MoMo"))]
          (is (= 200 (:status response)))
          (is (= 200 (:status response2)))
          (is (= (:body response) (:body response2)))))

  (testing "not-found route"
    (let [response (app (request :get "/invalid"))]
      (is (= 404 (:status response))))))
