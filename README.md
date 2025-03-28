# M295 GraphQL-Starter

## About
This is a Maven- and Springboot-based GraphQL API Demo for study purpose. It features a simple data model, where Authors and their respective Posts can be stored and queried:

```
+---------+             +-----------+
| Author  |             | Post      |
+---------+             +-----------+
| id      |─────────────| id        |
| name    | 1         * | title     |
+---------+             | text      |  
                        | createdAt |
                        | authorId* |  (implicit, handled in resolver logic)
                        +-----------+
```

Details on the data model and the queries can be studied in the schema file under *resources/graphql/schema.graphqls*

**Important:** Data storage is volatile - with no database attached for simplicity. Some demo authors and some posts are aways set up on app start. New authors and posts can be inserted and queried but not persistently stored. 

## To run the project either:

1. run it as regular Springboot project: `mvn spring-boot:run` (assuming you've installed maven already)
2. run it within the IDE that you trust

If you have Insomnia installed on your machine, you can import the *insomnia_queries.json* to see some basic queries.

## Schema Explorer and Query Builder

Once the app is running, you can access the Built-in Graphiql Query Builder online at <http://localhost:8080/graphiql> that helps you to understand the schema and create queries.

![Screenshot graphiql UI](img/graphiql.png)

## Disclaimer

I copied it somewhere I don't remember. But I believe it was open source. Kudos to those who came up with it initially.

Play with it, alter at will - hope you have fun. 