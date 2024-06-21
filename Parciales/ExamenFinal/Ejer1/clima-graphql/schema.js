const { GraphQLObjectType, GraphQLString, GraphQLBoolean, GraphQLSchema, GraphQLList, GraphQLNonNull, GraphQLInt, GraphQLID, GraphQLFloat } = require('graphql');
const { Wheater } = require('./database'); // Asegúrate de que el path sea correcto

const WheaterType = new GraphQLObjectType({
  name: 'Wheathers',
  fields: {
    id: { type: GraphQLID },
    fecha: { type: GraphQLString },
    temperatura: { type: GraphQLInt },
  }
});

const RootQuery = new GraphQLObjectType({
  name: 'RootQueryType',
  fields: {
    wheaters: {
      type: new GraphQLList(WheaterType),
      resolve() {
        return Wheater.findAll();
      }
    },
    wheater: {
      type: WheaterType,
      args: { id: { type: GraphQLID } },
      resolve(parent, args) {
        return Wheater.findOne({ where: { id: args.id } });
      }
    }
  }
});

const Mutation = new GraphQLObjectType({
  name: 'Mutation',
  fields: {
    addWheater: {
      type: WheaterType,
      args: {
        fecha: { type: new GraphQLNonNull(GraphQLString) },
        temperatura: { type: new GraphQLNonNull(GraphQLInt) }
      },
      resolve(parent, args) {
        return Wheater.create({
          fecha: args.fecha,
          temperatura: args.temperatura
        });
      }
    },
    updateWheater: {
      type: WheaterType,
      args: {
        id: { type: new GraphQLNonNull(GraphQLID) },
        fecha: { type: new GraphQLNonNull(GraphQLString) },
        temperatura: { type: new GraphQLNonNull(GraphQLInt) }
      },
      resolve(parent, args) {
        return Wheater.findOne({ where: { id: args.id } })
          .then(wheater => {
            if (!wheater) {
              throw new Error('wheater not found');
            }
            return wheater.update({
              fecha: args.fecha !== undefined ? args.fecha : wheater.fecha,
              temperatura: args.temperatura !== undefined ? args.temperatura : wheater.temperatura,
            });
          });
      }
    }
  }
});

module.exports = new GraphQLSchema({
  query: RootQuery,
  mutation: Mutation
});
