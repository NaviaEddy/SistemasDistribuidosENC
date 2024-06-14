const express = require('express');
const { graphqlHTTP } = require('express-graphql');
const { Apollo } = require('apollo-server-express');
const schema_biblioteca = require('./schema_biblioteca');
const { sequelize } = require('./database');

const app = express();

app.use('/graphql', graphqlHTTP({
  schema: schema_biblioteca,
  graphiql: true
}));

sequelize.authenticate()
  .then(() => {
    console.log('Connection to the database has been established successfully.');
    app.listen(4000, () => {
      console.log('Server is running on http://localhost:4000/graphql');
    });
  })
  .catch(err => {
    console.error('Unable to connect to the database:', err);
  });
