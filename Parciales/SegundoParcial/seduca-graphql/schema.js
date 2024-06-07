const { GraphQLObjectType, GraphQLString, GraphQLBoolean, GraphQLSchema, GraphQLList, GraphQLNonNull } = require('graphql');
const { Qualifications } = require('./database'); // Asegúrate de que el path sea correcto

const QualificationsType = new GraphQLObjectType({
  name: 'Qualifications',
  fields: {
    id: { type: GraphQLString },
    ci: { type: GraphQLString },
    apellidos: { type: GraphQLString },
    nombres: { type: GraphQLString },
    Bachiller: { type: GraphQLBoolean }
  }
});

const RootQuery = new GraphQLObjectType({
  name: 'RootQueryType',
  fields: {
    qualifications: {
      type: new GraphQLList(QualificationsType),
      resolve() {
        return Qualifications.findAll();
      }
    },
    qualification: {
      type: QualificationsType,
      args: { ci: { type: GraphQLString } },
      resolve(parent, args) {
        return Qualifications.findOne({ where: { ci: args.ci } });
      }
    }
  }
});

const Mutation = new GraphQLObjectType({
  name: 'Mutation',
  fields: {
    addQualification: {
      type: QualificationsType,
      args: {
        ci: { type: new GraphQLNonNull(GraphQLString) },
        apellidos: { type: new GraphQLNonNull(GraphQLString) },
        nombres: { type: new GraphQLNonNull(GraphQLString) },
        Bachiller: { type: new GraphQLNonNull(GraphQLBoolean) }
      },
      resolve(parent, args) {
        return Qualifications.create({
          ci: args.ci,
          apellidos: args.apellidos,
          nombres: args.nombres,
          Bachiller: args.Bachiller
        });
      }
    },
    updateQualification: {
      type: QualificationsType,
      args: {
        ci: { type: new GraphQLNonNull(GraphQLString) },
        apellidos: { type: GraphQLString },
        nombres: { type: GraphQLString },
        Bachiller: { type: GraphQLBoolean }
      },
      resolve(parent, args) {
        return Qualifications.findOne({ where: { ci: args.ci } })
          .then(qualification => {
            if (!qualification) {
              throw new Error('Qualification not found');
            }
            return qualification.update({
              apellidos: args.apellidos !== undefined ? args.apellidos : qualification.apellidos,
              nombres: args.nombres !== undefined ? args.nombres : qualification.nombres,
              Bachiller: args.Bachiller !== undefined ? args.Bachiller : qualification.Bachiller
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
