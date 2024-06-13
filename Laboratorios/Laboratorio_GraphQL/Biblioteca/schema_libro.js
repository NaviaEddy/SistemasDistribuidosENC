const { GraphQLObjectType, GraphQLString, GraphQLBoolean, GraphQLSchema, GraphQLList, GraphQLNonNull } = require('graphql');
const { Libro } = require('./database_libro'); // Asegúrate de que el path sea correcto

const libroType = new GraphQLObjectType({
  name: 'Libro',
  fields: {
    id: { type: GraphQLID },
    titulo: { type: GraphQLString },
    autor: { type: GraphQLString },
    disponible: { type: GraphQLBoolean }
  }
});

const RootQuery = new GraphQLObjectType({
  name: 'RootQueryType',
  fields: {
    libros: {
      type: new GraphQLList(libroType),
      resolve() {
        return Libro.findAll();
      }
    },
    libro: {
      type: libroType,
      args: { id: { type: GraphQLID } },
      resolve(parent, args) {
        return Libro.findByPk(args.id);
      }
    }
  }
});

const Mutation = new GraphQLObjectType({
  name: 'Mutation',
  fields: {
    agregarLibro: {
      type: libroType,
      args: {
        titulo: { type: new GraphQLNonNull(GraphQLString) },
        autor: { type: new GraphQLNonNull(GraphQLString) }
      },
      resolve(parent, args) {
        return Libro.create({
          titulo: args.titulo,
          autor: args.autor,
          disponible: true // Por defecto el libro está disponible
        });
      }
    },
    actualizarLibro: {
      type: libroType,
      args: {
        id: { type: new GraphQLNonNull(GraphQLID) },
        titulo: { type: GraphQLString },
        autor: { type: GraphQLString },
        disponible: { type: GraphQLBoolean }
      },
      resolve(parent, args) {
        return Libro.findByPk(args.id)
          .then(libro => {
            if (!libro) {
              throw new Error('Libro no encontrado');
            }
            return libro.update({
              titulo: args.titulo !== undefined ? args.titulo : libro.titulo,
              autor: args.autor !== undefined ? args.autor : libro.autor,
              disponible: args.disponible !== undefined ? args.disponible : libro.disponible
            });
          });
      }
    },
    eliminarLibro: {
      type: GraphQLBoolean,
      args: {
        id: { type: new GraphQLNonNull(GraphQLID) }
      },
      resolve(parent, args) {
        return Libro.findByPk(args.id)
          .then(libro => {
            if (!libro) {
              throw new Error('Libro no encontrado');
            }
            return libro.destroy().then(() => true);
          });
      }
    }
  }
});

module.exports = new GraphQLSchema({
  query: RootQuery,
  mutation: Mutation
});