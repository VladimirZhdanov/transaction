# Transaction
transaction demo with spring boot and Postgresql

Run docker contaner with Postgresql:
```
docker run --name postgres -e POSTGRES_PASSWORD=password -d -p 5432:5432 postgres
```

# Выводы

У нас есть N кол потоков, которые хотят обновить данные в базе:

============= 

Сценарий 1-й
Мы не используем блокировки на базе, @Transactional(isolation = Isolation.READ_COMMITTED)
Результат: мы теряем апдейты

Сценарий 2-й
Мы не используем блокировки на базе, @Transactional(isolation = Isolation.SERIALIZABLE/REPEATABLE_READ)
Результат: падаем с ошибкой: could not serialize access due to concurrent update и теряем апдейты

======Retry=======

Сценарий 3-й
Мы не используем блокировки на базе, @Transactional(isolation = Isolation.READ_COMMITTED), используем Retry
Результат: если количество ретраев хватает, то апдейты не теряем все ок

Сценарий 4-й
Мы не используем блокировки на базе, @Transactional(isolation = Isolation.SERIALIZABLE/REPEATABLE_READ), используем Retry
Результат: если количество ретраев хватает, то апдейты не теряем все ок, но видим ошибки в логе (которые не влияют на работу)

======PESSIMISTIC_WRITE=======

Сценарий 5-й
@Transactional(isolation = Isolation.READ_COMMITTED), @Lock(LockModeType.PESSIMISTIC_WRITE)
Результат: апдейтим последовательно, все ок (может работать с @Version, ничего не ломает)

Сценарий 6-й
@Transactional(isolation = Isolation.SERIALIZABLE/REPEATABLE_READ), @Lock(LockModeType.PESSIMISTIC_WRITE)
Результат: падаем с ошибкой: could not serialize access due to concurrent update и теряем апдейты