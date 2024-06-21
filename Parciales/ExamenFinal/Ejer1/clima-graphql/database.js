const { Sequelize, DataTypes } = require('sequelize');

const sequelize = new Sequelize('bd_clima', 'root', '', {
  host: 'localhost',
  dialect: 'mysql'
});

const Wheater = sequelize.define('wheaters', {
    id: {
        type: DataTypes.INTEGER,
        primaryKey: true,
        autoIncrement: true
    },
    fecha: {
        type: DataTypes.STRING,
        allowNull: false
    },
    temperatura: {
        type: DataTypes.INTEGER,
        allowNull: false
    },
    
}, {
    tableName: 'wheaters',
    timestamps: false
});

sequelize.sync();

module.exports = { sequelize, Wheater };

