# CRUD-with-GraphQL-in-Spring-Boot
In this project, I have worked on Spring boot to create CRUD APIs using GraphQL.

# How to run this project :

1- Request Body for query : (example)

query {
    findAllBooks {
        id
        title
        description
        author {
            id
            name
            age
        }
    }
    findAllAuthors {
        id
        name
        age
    }
}

2- Request Body for mutation : (example)

mutation {
    createAuthor(name: "Adi", age: 25) {
        id
        name
        age
    }
}
