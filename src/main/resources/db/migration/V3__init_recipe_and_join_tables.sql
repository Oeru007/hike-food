create table if not exists hike_food.recipe
(
--     Уникальный идентификатор рецепта
    id            uuid                        not null,
--     Версия записи для реализации оптимистичной блокировки
    version       bigint                      not null,
--     Дата создания записи
    creation_date timestamp without time zone not null,
--     Дата последнего внесения изменений
    modify_date   timestamp without time zone not null,
--     Название рецепта
    recipe_name   varchar                     not null,
    CONSTRAINT recipe_name_unique UNIQUE (recipe_name),
    CONSTRAINT recipe_pkey PRIMARY KEY (id)
);
-- Таблица соотнесения рецепта и продуктов входящих в них
create table if not exists hike_food.product_weight
(
--     Уникальный идентификатор
    id         uuid  not null,
--     Масса продукта на одну порцию
    weight     float not null,
--     Id продукта
    product_id uuid  not null,
--     id рецепта
    recipe_id  uuid  not null,
    CONSTRAINT product_weight_pkey PRIMARY KEY (id),
    CONSTRAINT recipe_fkey foreign key (recipe_id) references hike_food.recipe (id) on delete cascade,
    CONSTRAINT product_fkey foreign key (product_id) references hike_food.product (id)
)
