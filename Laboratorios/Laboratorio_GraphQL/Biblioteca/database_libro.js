const { Sequelize, DataTypes } = require('sequelize');

const sequelize = new Sequelize('bd_sis258_graphql', 'root', '', {
  host: 'localhost',
  dialect: 'mysql'
});

const Libro = sequelize.define('libro', {
    id: {
        type: DataTypes.INTEGER,
        primaryKey: true,
        autoIncrement: true
    },
    titulo: {
        type: DataTypes.STRING,
        allowNull: false
    },
    autor: {
        type: DataTypes.STRING,
        allowNull: false
    },
    disponible: {
        type: DataTypes.BOOLEAN,
        allowNull: false,
        defaultValue: true
    }
}, {
    tableName: 'libro',
    timestamps: false
});

sequelize.sync();

module.exports = { sequelize, Libro };

