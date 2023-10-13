create table if not exists hike_food.product
(
--     Уникальный идентификатор продукта
    id            uuid                        not null,
--     Версия записи для реализации оптимистичной блокировки
    version       bigint                      not null,
--     Дата создания записи
    creation_date timestamp without time zone not null,
--     Дата последнего внесения изменений
    modify_date   timestamp without time zone not null,
--     Название продукта
    product_name  varchar                     not null,
--     Калорийность продукта на 1 г
    calories      int                         not null,
    protein       float,
    fat           float,
    carbohydrates float,
    CONSTRAINT product_name_unique UNIQUE (product_name),
    CONSTRAINT product_pkey PRIMARY KEY (id)
)