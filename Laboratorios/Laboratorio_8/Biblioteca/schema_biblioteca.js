const {
  GraphQLID,
  GraphQLObjectType,
  GraphQLString,
  GraphQLBoolean,
  GraphQLSchema,
  GraphQLList,
  GraphQLNonNull,
} = require("graphql");
const { Libro, Lector } = require("./database"); // Asegúrate de que el path sea correcto

const libroType = new GraphQLObjectType({
  name: "Libro",
  fields: {
    idLibro: { type: GraphQLID },
    titulo: { type: GraphQLString },
    autor: { type: GraphQLString },
    disponible: { type: GraphQLBoolean },
  },
});

const LectorType = new GraphQLObjectType({
  name: "Lector",
  fields: {
    idLector: { type: GraphQLID },
    nombre: { type: GraphQLString },
    librosPrestados: { type: GraphQLString },
  },
});

const RootQuery = new GraphQLObjectType({
  name: "RootQueryType",
  fields: {
    libros: {
      type: new GraphQLList(libroType),
      resolve() {
        return Libro.findAll();
      },
    },
    lectores: {
      type: new GraphQLList(LectorType),
      resolve() {
        return Lector.findAll();
      },
    },
    libro: {
      type: libroType,
      args: { idLibro: { type: GraphQLID } },
      resolve(parent, args) {
        return Libro.findByPk(args.idLibro);
      },
    },
    lector: {
      type: LectorType,
      args: { idLector: { type: GraphQLID } },
      resolve(parent, args) {
        return Lector.findByPk(args.idLector);
      },
    },
  },
});

const Mutation = new GraphQLObjectType({
  name: "Mutation",
  fields: {
    agregarLibro: {
      type: libroType,
      args: {
        titulo: { type: new GraphQLNonNull(GraphQLString) },
        autor: { type: new GraphQLNonNull(GraphQLString) },
      },
      resolve(parent, args) {
        return Libro.create({
          titulo: args.titulo,
          autor: args.autor,
          disponible: true,
        });
      },
    },
    agregarLector: {
      type: LectorType,
      args: {
        nombre: { type: new GraphQLNonNull(GraphQLString) },
      },
      resolve(parent, args) {
        return Lector.create({
          nombre: args.nombre,
        });
      },
    },
    prestarLibro: {
      type: LectorType,
      args: {
        idLector: { type: new GraphQLNonNull(GraphQLID) },
        idLibro: { type: new GraphQLNonNull(GraphQLID) },
      },
      resolve(parent, args) {
        return Lector.findByPk(args.idLector).then((lector) => {
          if (!lector) {
            throw new Error("Lector no encontrado");
          }
          return Libro.findByPk(args.idLibro).then((libro) => {
            if (!libro) {
              throw new Error("Libro no encontrado");
            }
            if (!libro.disponible) {
              throw new Error("Libro no disponible");
            }
            return libro.update({ disponible: false }).then(() => {
              Lector.update({ librosPrestados: args.idLibro }, { where: { idLector: args.idLector } });
              return lector.save().then(() => lector);
            });
          });
        });
      },
    },
    devolverLibro: {
      type: LectorType,
      args: {
        idLector: { type: new GraphQLNonNull(GraphQLID) },
        idLibro: { type: new GraphQLNonNull(GraphQLID) },
      },
      resolve(parent, args) {
        return Lector.findByPk(args.idLector).then((lector) => {
          if (!lector) {
            throw new Error("Lector no encontrado");
          }
          return Libro.findByPk(args.idLibro).then((libro) => {
            if (!libro) {
              throw new Error("Libro no encontrado");
            }
            return libro.update({ disponible: true }).then(() => {
              Lector.update({ librosPrestados: "" }, { where: { idLector: args.idLector } });
              return lector.save().then(() => lector);
            });
          });
        });
      },
    },
  },
});

module.exports = new GraphQLSchema({
  query: RootQuery,
  mutation: Mutation,
});
