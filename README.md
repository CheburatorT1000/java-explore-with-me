[pull request](https://github.com/CheburatorT1000/java-explore-with-me/pull/3)

Возможность подписываться на других пользователей и получать список актуальных событий, опубликованных этими пользователями.
*** 
PrivateSubscription API

    [GET] "/users/{userId}/subscriptions" - получение активных подписок
    [POST] "/users/{userId}/subscriptions" - создание подписки
    [PATCH] "/users/{userId}/subscriptions/{subscriptionId}/cancel" - удаление подписки

***
PrivateEvent API

    [GET] "/users/{userId}/events/subscriptions" - получение событий по подписке