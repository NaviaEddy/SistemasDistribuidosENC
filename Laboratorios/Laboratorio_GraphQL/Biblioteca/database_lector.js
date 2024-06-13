const { Sequelize, DataTypes } = require('sequelize');

const sequelize = new Sequelize('bd_sis258_graphql', 'root', '', {
  host: 'localhost',
  dialect: 'mysql'
});

const Lector = sequelize.define('lector', {
    id: {
        type: DataTypes.INTEGER,
        primaryKey: true,
        autoIncrement: true
    },
    nombre: {
        type: DataTypes.STRING,
        allowNull: false
    },
    librosPrestados: {
        type: DataTypes.STRING,
        allowNull: false,
        defaultValue: ''
    }
}, {
    tableName: 'lector',
    timestamps: false
});

sequelize.sync();

module.exports = { sequelize, Lector };

